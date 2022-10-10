import com.trello.model.Board;
import com.trello.model.Card;
import com.trello.model.Column;
import com.trello.service.BoardService;
import com.trello.service.CardService;
import com.trello.service.ColumnService;
import com.trello.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserServiceTest {
    static BoardService bs;
    static CardService cardService;
    static ColumnService columnService;
    static UserService us;
    @BeforeAll
    public static void setup(){
        bs = new BoardService();
        columnService = new ColumnService();
        cardService = new CardService();
        us = new UserService(bs, cardService);
    }

    @Test
    public void testNewCardsCountForBoard(){
        us.updateUserLastLoginTime(1L, System.currentTimeMillis()-1);
        bs.createBoard(1L, "Abc2", 1L);
        Board b1 = bs.getBoardMap().get(1L);
        columnService.createColumn(1L, "col1", b1,  "desc",1L);
        Column c1 = columnService.getColumnMap().get(1L);
        cardService.createCard(1L, "card1", "des", c1, null, 2L);
        bs.createBoard(2L, "Abc2", 1L);

        try{
            Thread.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Use a logger to log the error.");
        }
        Board b2 = bs.getBoardMap().get(2L);
        columnService.createColumn(2L, "col2", b2,  "desc",1L);
        Column c2 = columnService.getColumnMap().get(2L);
        cardService.createCard(2L, "card2", "des", c2, null, 2L);
        
        List<Card> firstBoardCards =us.highlightCardsForUser(1L, 1L);
        Assertions.assertEquals(firstBoardCards.size(), 1L);
    }
}
