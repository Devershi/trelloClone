package com.trello.service;

import com.trello.model.Board;
import com.trello.model.Card;
import com.trello.model.Column;
import com.trello.model.User;

import java.util.*;
import java.util.stream.Collectors;

public class UserService implements IUserService{
    BoardService boardService;
    CardService cardService;
    Map<Long, Long> usersLastAccessTimes;
    public UserService(BoardService bs, CardService cs){
        this.boardService = bs;
        this.cardService = cs;
        this.usersLastAccessTimes = new HashMap<>();
    }

    public void updateUserLastLoginTime(Long userId, Long timeInMillis){
        usersLastAccessTimes.put(userId, timeInMillis);
    }

    @Override
    public List<Card> highlightCardsForUser(Long userId, Long boardId) {
        if(userId == null || boardId == null || !boardService.activeBoards.contains(boardId)){
            return Collections.emptyList();
        }
        // fetch only cards newly created for this board
        Board b = boardService.getBoardMap().get(boardId);
        Set<Column> boardColumns = b.getColumns();
        List<Card> boardCards  = new ArrayList<>();
        for(Column c : boardColumns) {
            boardCards.addAll(c.getCardsAdded());
        }
        List<Card> allCardsNewlyCreated = cardService.getAllCardsAfterTime(usersLastAccessTimes.containsKey(userId) ? usersLastAccessTimes.get(userId) : System.currentTimeMillis());
        //return intersection of these 2 lists
        return boardCards.stream()
                .distinct()
                .filter(allCardsNewlyCreated::contains)
                .collect(Collectors.toList());
    }
}
