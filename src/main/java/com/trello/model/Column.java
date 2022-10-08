package com.trello.model;

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
}
