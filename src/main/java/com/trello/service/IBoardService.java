package com.trello.service;

import com.trello.model.Column;

import java.util.Set;

public interface IBoardService {
    boolean createBoardWithColumns(Long id, String name, Set<Column> columns, Long createdBy);
    boolean deleteBoard(Long id, boolean isSoftDelete);

    void printBoardAsJSON(Long id);
}
