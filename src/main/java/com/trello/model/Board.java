package com.trello.model;

import java.util.HashSet;
import java.util.Set;

public class Board {
    private Long id;
    private String name;
    private Set<Column> columns;
    private Set<Long> usersAllowedToEdit;
    private Set<Long> usersAllowedToDelete;
    private Set<Long> usersAllowedToRead;


    public Board(Long id, String name, Long createdBy){
        this.id = id;
        this.name = name;
        this.usersAllowedToDelete = new HashSet<>();
        this.usersAllowedToRead = new HashSet<>();
        this.usersAllowedToEdit = new HashSet<>();
        this.usersAllowedToEdit.add(createdBy);
        this.usersAllowedToDelete.add(createdBy);
        this.usersAllowedToRead.add(createdBy);
        this.columns = new HashSet<>();
    }



}
