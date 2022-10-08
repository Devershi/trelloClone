import com.trello.model.Board;
import com.trello.model.Column;
import com.trello.service.BoardService;
import com.trello.service.ColumnService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

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
    public void testBoardAddWithExistingId(){
        Board b = new Board(10L, "b10", 10L);
        boolean created = cs.createColumn(8L, "col1", b,  "desc",1L);
        Assertions.assertEquals(created, true);

        boolean created1 = cs.createColumn(8L, "col1", b,  "desc",1L);
        Assertions.assertEquals(created1, false);

    }

}
