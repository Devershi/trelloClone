package com.trello.service;

import com.trello.model.Card;

import java.util.*;

public class CardService implements ICardService{
    Map<Long, Long> cardToColumnMapping;
    Map<String, Set<Long>> tagVsCardMapping;
    Map<Long, Set<Long>> timestampCardMapping;
    Map<Long, Card> cardMap;
    Set<Long> activeCards;
    Set<Long> deletedCards;

    public CardService(){
this.activeCards = new HashSet<>();
this.deletedCards = new HashSet<>();
this.cardMap = new HashMap<>();
this.timestampCardMapping = new LinkedHashMap<>();
this.cardToColumnMapping = new HashMap<>();
this.tagVsCardMapping = new HashMap<>();
    }

    @Override
    public List<Card> getAllCardsAfterTime(Long timestamp) {
        return null;
    }

    // Map<String, Set<Card>> tagVsCardIgnoreCaseMapping;
}
