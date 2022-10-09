package com.trello.service;

import com.trello.model.Card;

import java.util.List;

public interface ICardService {
    List<Card> getAllCardsAfterTime(Long timestamp);
    List<Card> getAllCardsWithTag(String tag);
}
