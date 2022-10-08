package com.trello.model;

import java.util.List;

public class User {
    private Long id;
    private String name;
    private Long lastLoggedIn;
    private List<Board> createdBoards;
}
