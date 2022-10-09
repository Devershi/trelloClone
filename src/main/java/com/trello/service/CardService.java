package com.trello.service;

import com.trello.model.Card;
import com.trello.model.Column;

import java.util.*;

public class CardService implements ICardService{
    Map<Long, Long> cardToColumnMapping;
    Map<String, Set<Long>> tagVsCardMapping;
    SortedMap<Long, Long> timestampCardMapping;
    Map<Long, Card> cardMap;
    Set<Long> activeCards;
    Set<Long> deletedCards;

    public CardService(){
       this.activeCards = new HashSet<>();
       this.deletedCards = new HashSet<>();
       this.cardMap = new HashMap<>();
       this.timestampCardMapping = new TreeMap<>();
       this.cardToColumnMapping = new HashMap<>();
       this.tagVsCardMapping = new HashMap<>();
    }

    public boolean createCard(Long id, String name, String description, Column column, Set<String> labels, Long createdBy) {
        if(id == null || name.isEmpty() || column == null){
            return  false;
        }
        if(activeCards.contains(id) || deletedCards.contains(id)){
            return false;
        }
        Card c = new Card(id, name, description, labels, createdBy);
        activeCards.add(id);
        cardMap.put(id, c);
        cardToColumnMapping.put(id, column.getId());
        timestampCardMapping.put(System.currentTimeMillis(), id);
        if(labels != null) {
            for (String label : labels) {
                Set<Long> cardsWithTag = tagVsCardMapping.get(label);
                if (cardsWithTag == null) {
                    cardsWithTag = new HashSet<>();
                }
                cardsWithTag.add(id);
                tagVsCardMapping.put(label, cardsWithTag);
            }
        }

        return true;
    }

    @Override
    public List<Card> getAllCardsAfterTime(Long timestamp) {
        if(timestamp == null)
            return Collections.emptyList();
        SortedMap<Long, Long> tailMap = this.timestampCardMapping.tailMap(timestamp);
        List<Card> res = new ArrayList<>();
        for(Long id: tailMap.values()){
            res.add(cardMap.get(id));
        }
        return  res;
    }

    // Map<String, Set<Card>> tagVsCardIgnoreCaseMapping;
}
