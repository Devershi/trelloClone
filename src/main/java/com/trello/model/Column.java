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
}
