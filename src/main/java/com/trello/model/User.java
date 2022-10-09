package com.trello.model;

import java.util.List;

public class User {
    private Long id;
    private String name;
    private Long lastLoggedIn;
    private List<Board> createdBoards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(Long lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public List<Board> getCreatedBoards() {
        return createdBoards;
    }

    public void setCreatedBoards(List<Board> createdBoards) {
        this.createdBoards = createdBoards;
    }
}
