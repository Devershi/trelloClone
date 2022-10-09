import com.trello.model.Board;
import com.trello.model.Card;
import com.trello.service.ColumnService;
import com.trello.service.SearchService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SearchServiceTest {

    static ColumnService cs;
    static SearchService ss;
    @BeforeAll
    public static void setup(){
        cs = new ColumnService();
        ss = new SearchService(null, cs, null);
    }

    @Test
    public void testGetCardsWithInvalidColumnId(){

        List<Card> cards = ss.getAllCardsInColumnId(1L);
        Assertions.assertEquals(cards.size(), 0L);
    }

    @Test
    public void testGetCardsWithInvalidColumn(){
        List<Card> cards = ss.getAllCardsInColumn(null);
        Assertions.assertEquals(cards.size(), 0L);
    }
}
