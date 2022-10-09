package com.trello.service;

import com.trello.model.Card;

import java.util.List;

public interface IUserService {
    List<Card> highlightCardsForUser(Long userId);
}
