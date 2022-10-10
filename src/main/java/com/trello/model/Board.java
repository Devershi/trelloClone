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

    public Board(Long id, String name, Long createdBy) {
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

    public Board(Long id, String name, Set<Column> columns, Long createdBy) {
        this.id = id;
        this.name = name;
        this.usersAllowedToDelete = new HashSet<>();
        this.usersAllowedToRead = new HashSet<>();
        this.usersAllowedToEdit = new HashSet<>();
        this.usersAllowedToEdit.add(createdBy);
        this.usersAllowedToDelete.add(createdBy);
        this.usersAllowedToRead.add(createdBy);
        this.columns = columns == null ? new HashSet<>() : columns;

    }

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

    public Set<Column> getColumns() {
        return columns;
    }

    public void setColumns(Set<Column> columns) {
        this.columns = columns;
    }

    public Set<Long> getUsersAllowedToEdit() {
        return usersAllowedToEdit;
    }

    public void setUsersAllowedToEdit(Set<Long> usersAllowedToEdit) {
        this.usersAllowedToEdit = usersAllowedToEdit;
    }

    public Set<Long> getUsersAllowedToDelete() {
        return usersAllowedToDelete;
    }

    public void setUsersAllowedToDelete(Set<Long> usersAllowedToDelete) {
        this.usersAllowedToDelete = usersAllowedToDelete;
    }

    public Set<Long> getUsersAllowedToRead() {
        return usersAllowedToRead;
    }

    public void setUsersAllowedToRead(Set<Long> usersAllowedToRead) {
        this.usersAllowedToRead = usersAllowedToRead;
    }

    public boolean addColumn(Column column) {
        if (column == null) {
            return false;
        }
        this.columns.add(column);
        return true;
    }

    public boolean removeColumn(Column column) {
        if (column == null){
            return false;
        }
        this.columns.remove(column);
        return true;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", columns=" + columns +
                ", usersAllowedToEdit=" + usersAllowedToEdit +
                ", usersAllowedToDelete=" + usersAllowedToDelete +
                ", usersAllowedToRead=" + usersAllowedToRead +
                '}';
    }
}
