package com.trello.service;

import com.trello.model.Board;
import com.trello.model.Column;

import java.util.*;

public class BoardService {

    Set<Long> activeBoards;
    Set<Long> deletedBoards;
    Map<Long, Board> boardMap;

    public BoardService(){
       this.activeBoards = new HashSet<>();
       this.deletedBoards = new HashSet<>();
       this.boardMap = new HashMap<>();
    }

    public boolean createBoard(Long id, String name, Long createdBy) {
        return createBoardWithColumns(id, name, null, createdBy);
    }

    public boolean createBoardWithColumns(Long id, String name, Set<Column> columns, Long createdBy) {
        if(id == null || name.isEmpty()){
            return  false;
        }

        if(activeBoards.contains(id) || deletedBoards.contains(id)){
            return false;
        }

        Board board = new Board(id, name, columns, createdBy);
        activeBoards.add(id);
        boardMap.put(id, board);
        return true;
    }

    public boolean deleteBoard(Long id, boolean isSoftDelete){
        if(id == null || !activeBoards.contains(id)){
            return false;
        }
        activeBoards.remove(id);
        deletedBoards.add(id);
        if(!isSoftDelete){
          boardMap.remove(id);
        }
        return true;
    }



}
