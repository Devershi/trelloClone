package com.trello.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Column {
    private Long id;
    private Long createdBy;
    private String name;
    private String description;
    private boolean isDeleted;
    private Long createdAt;
    private Long lastUpdated;
    private List<Card> cardsAdded;
    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public void setLastUpdated(Long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setCardsAdded(List<Card> cardsAdded) {
        this.cardsAdded = cardsAdded;
    }

    public Long getId() {
        return id;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getLastUpdated() {
        return lastUpdated;
    }

    public List<Card> getCardsAdded() {
        return cardsAdded;
    }


    public Column(Long id, String name, String description, Long createdBy){
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdBy = createdBy;
        this.createdAt = System.currentTimeMillis();
        this.cardsAdded = new ArrayList<>();
    }

    public Column(Long id, String name, String description, List<Card> cards, Long createdBy){
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdBy = createdBy;
        this.createdAt = System.currentTimeMillis();
        this.cardsAdded = cards == null ? new ArrayList<>() : cards;
    }
    public boolean addCard(Card card){
        if (card == null)
            return false;
        this.cardsAdded.add(card);
        return true;
    }

    public boolean removeLabel(Card card) {
        if (card == null)
            return false;
        this.cardsAdded.remove(card);
        return true;
    }
}
