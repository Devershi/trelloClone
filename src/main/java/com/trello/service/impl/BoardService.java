package com.trello.service.impl;

import com.trello.model.Board;
import com.trello.model.Column;
import com.trello.service.IBoardService;
import com.trello.utils.ObjectToJson;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BoardService implements IBoardService {

    Set<Long> activeBoards;
    Set<Long> deletedBoards;
    Map<Long, Board> boardMap;

    // returns active boards
    public Set<Long> getActiveBoards() {
        return activeBoards;
    }

    //set active boards
    public void setActiveBoards(Set<Long> activeBoards) {
        this.activeBoards = activeBoards;
    }

    // returns list of deleted boards
    public Set<Long> getDeletedBoards() {
        return deletedBoards;
    }

    public void setDeletedBoards(Set<Long> deletedBoards) {
        this.deletedBoards = deletedBoards;
    }

    // returns the board map
    public Map<Long, Board> getBoardMap() {
        return boardMap;
    }

    public void setBoardMap(Map<Long, Board> boardMap) {
        this.boardMap = boardMap;
    }

    public BoardService() {
        this.activeBoards = new HashSet<>();
        this.deletedBoards = new HashSet<>();
        this.boardMap = new HashMap<>();
    }

    // create board
    public boolean createBoard(Long id, String name, Long createdBy) {
        return createBoardWithColumns(id, name, null, createdBy);
    }

    // overloaded create board with columns
    public boolean createBoardWithColumns(Long id, String name, Set<Column> columns, Long createdBy) {
        if (id == null || name.isEmpty()) {
            return false;
        }

        if (activeBoards.contains(id) || deletedBoards.contains(id)) {
            return false;
        }

        Board board = new Board(id, name, columns, createdBy);
        activeBoards.add(id);
        boardMap.put(id, board);
        return true;
    }

    // deletes board
    public boolean deleteBoard(Long id, boolean isSoftDelete) {
        if (id == null || !activeBoards.contains(id)) {
            return false;
        }
        activeBoards.remove(id);
        deletedBoards.add(id);
        if (!isSoftDelete) {
            boardMap.remove(id);
        }
        return true;
    }

    @Override
    public String printBoardAsJSON(Long id) {
        String jsonResponse = ObjectToJson.convertObjectToJson(this.boardMap.get(id));
        System.out.println(jsonResponse);
        return jsonResponse;
    }

    @Override
    public String toString() {
        return "BoardService{" +
                "activeBoards=" + activeBoards +
                ", deletedBoards=" + deletedBoards +
                ", boardMap=" + boardMap +
                '}';
    }

}
