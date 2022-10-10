package com.trello.service.impl;

import com.trello.model.Card;
import com.trello.model.Column;
import com.trello.service.ISearchService;

import java.util.Collections;
import java.util.List;

public class SearchService implements ISearchService {
    BoardService boardService;
    ColumnService columnService;
    CardService cardService;

    public SearchService(BoardService boardService, ColumnService columnService, CardService cardService){
        this.boardService = boardService;
        this.columnService = columnService;
        this.cardService = cardService;
    }

    // returns all cards for a column id
    public List<Card> getAllCardsInColumnId(Long columnId){
        if (columnId == null || !columnService.hasColumnWithId(columnId)){
            return Collections.emptyList();
        }
        return columnService.getCardsForColumn(columnId);
    }

    // returns column based cards
    public List<Card> getAllCardsInColumn(Column c) {
        if (c == null){
            return Collections.emptyList();
        }
        return getAllCardsInColumnId(c.getId());
    }


}
