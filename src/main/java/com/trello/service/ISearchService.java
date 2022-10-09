package com.trello.service;

import com.trello.model.Card;
import com.trello.model.Column;

import java.util.List;

public interface ISearchService {
    List<Card> getAllCardsInColumn(Column c);
}
