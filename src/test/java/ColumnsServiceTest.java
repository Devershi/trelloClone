import com.trello.model.Board;
import com.trello.model.Card;
import com.trello.model.Column;
import com.trello.service.BoardService;
import com.trello.service.ColumnService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

public class ColumnsServiceTest {
    static ColumnService cs;
    @BeforeAll
    public static void setup(){
        cs = new ColumnService();
    }

    @Test
    public void testColumnAddWithoutId(){
        Board b = new Board(10L, "b10", 10L);
        boolean created = cs.createColumn(null, "col1", b, "desc",1L);
        Assertions.assertEquals(created, false);
    }

    @Test
    public void testColumnAddWithoutName(){
        Board b = new Board(10L, "b10", 10L);
        boolean created = cs.createColumn(1L, "", b,  "desc",1L);
        Assertions.assertEquals(created, false);
    }

    @Test
    public void testColumnAddWithExistingId(){
        Board b = new Board(10L, "b10", 10L);
        boolean created = cs.createColumn(1L, "col1", b,  "desc",1L);
        Assertions.assertEquals(created, true);

        boolean created1 = cs.createColumn(1L, "col1", b,  "desc",1L);
        Assertions.assertEquals(created1, false);

    }

    @Test
    public void testGetCardsWithoutId(){
        List<Card> cards = cs.getCardsForColumn(null);
        Assertions.assertEquals(cards.size(), 0L);
    }

    @Test
    public void testHasColumn(){

        Assertions.assertEquals(cs.hasColumnWithId(2L), false);
        Board b = new Board(3L, "b10", 3L);
        boolean created = cs.createColumn(3L, "col3", b,  "desc",3L);
        Assertions.assertEquals(created, true);
        Assertions.assertEquals(cs.hasColumnWithId(3L), true);
    }
}
