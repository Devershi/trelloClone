package com.trello.service;

import com.trello.model.Board;
import com.trello.model.Card;

import java.util.List;

public interface IColumnService {
    List<Card> getCardsForColumn(Long columnId);
    boolean hasColumnWithId(Long id);
    boolean createColumnWithCards(Long id, String name, Board board, String description, List<Card> cards, Long createdBy);
}
