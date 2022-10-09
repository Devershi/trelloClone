package com.trello.service;

import com.trello.model.Board;
import com.trello.model.Card;
import com.trello.model.Column;

import java.util.*;

public class ColumnService implements IColumnService {
    Map<Long, Long> columnToBoardMapping;
    Map<Long, Column> columnMap;
    Set<Long> activeColumns;
    Set<Long> deletedColumns;

    public ColumnService(){
        this.activeColumns = new HashSet<>();
        this.deletedColumns = new HashSet<>();
        this.columnMap = new HashMap<>();
        this.columnToBoardMapping = new HashMap<>();
    }

    public boolean createColumn(Long id, String name,Board board, String description, Long createdBy) {

        return createColumnWithCards(id, name, board, description, null, createdBy);
    }

    public boolean createColumnWithCards(Long id, String name, Board board, String description, List<Card> cards, Long createdBy) {
        if(id == null || name.isEmpty() || board == null){
            return  false;
        }

        if(activeColumns.contains(id) || deletedColumns.contains(id)){
            return false;
        }

        Column column = new Column(id, name, description, cards, createdBy);
        activeColumns.add(id);
        columnMap.put(id, column);
        columnToBoardMapping.put(id, board.getId());
        return true;
    }

    public boolean hasColumnWithId(Long id) {
        return activeColumns.contains(id);
    }

    public List<Card> getCardsForColumn(Long columnId){
        return (columnId == null || !activeColumns.contains(columnId)) ?
                Collections.emptyList() : columnMap.get(columnId).getCardsAdded();
    }
}
