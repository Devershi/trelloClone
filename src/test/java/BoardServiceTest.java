import com.trello.service.BoardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runners.Suite;


public class BoardServiceTest {
    static BoardService bs;
    @BeforeAll
    public static void setup(){
        bs = new BoardService();
    }

    @Test
    public void testBoardAddWithoutId(){
       boolean created = bs.createBoard(null, "board1", 1L);
        Assertions.assertEquals(created, false);
    }

    @Test
    public void testBoardAddWithoutName(){
        boolean created = bs.createBoard(1L, "", 1L);
        Assertions.assertEquals(created, false);
    }

    @Test
    public void testBoardAddWithExistingId(){
        boolean created = bs.createBoard(1L, "Abc", 1L);
        Assertions.assertEquals(created, true);

        boolean created1 = bs.createBoard(1L, "Abc2", 1L);
        Assertions.assertEquals(created1, false);
    }

}
