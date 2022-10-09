package com.trello.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Card {
    private Long id;
    private Long createdBy;
    private String name;
    private String description;
    private boolean isDeleted;
    private Long createdAt;
    private Long lastUpdated;
    private Set<String> labels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Set<String> getLabels() {
        return labels;
    }

    public void setLabels(Set<String> labels) {
        this.labels = labels;
    }

    public Card(){
        this.labels = new HashSet<>();
    }
    public Card(Long id, String name, String description, Long createdBy){
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdBy = createdBy;
        this.createdAt = System.currentTimeMillis();
        this.labels = new HashSet<>();
    }

    public Card(Long id, String name, String description, Set<String> labels, Long createdBy){
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdBy = createdBy;
        this.createdAt = System.currentTimeMillis();
        this.labels = labels == null ? new HashSet<>() : labels;
    }

    public boolean addLabel(String label){
        if(label == null || label.isEmpty())
            return false;
        this.labels.add(label);
        return true;
    }

    public boolean removeLabel(String label) {
        if(label == null || label.isEmpty())
            return false;
        this.labels.remove(label);
        return true;
    }
}
