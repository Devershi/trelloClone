import com.trello.model.Card;
import com.trello.model.Column;
import com.trello.service.BoardService;
import com.trello.service.CardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CardServiceTest {
    static CardService cs;
    @BeforeAll
    public static void setup(){
        cs = new CardService();
    }

    @Test
    public void testCardAddWithoutId(){
        boolean created = cs.createCard(null, "card1", "des", null, null, 1L);
        Assertions.assertEquals(created, false);
    }
    @Test
    public void testCardAddWithoutName(){
        boolean created = cs.createCard(1L, "", "des", null, null, 1L);
        Assertions.assertEquals(created, false);
    }
    @Test
    public void testCardAddWithoutColumnName(){
        boolean created = cs.createCard(1L, "card1", "des", null, null, 1L);
        Assertions.assertEquals(created, false);
    }

    @Test
    public void testCardAdd(){
        Column c = new Column(1L,"c1","c1",1L);
        boolean created = cs.createCard(1L, "card1", "des", c, null, 1L);
        Assertions.assertEquals(created, true);
    }

    @Test
    public void testCardEmptyForCurrentTime(){
        Column c = new Column(1L,"c1","c1",1L);
        boolean created = cs.createCard(2L, "card2", "des", c, null, 2L);
        Assertions.assertEquals(created, true);
        List<Card> cardsNow = cs.getAllCardsAfterTime(System.currentTimeMillis()+1);
        Assertions.assertEquals(cardsNow.size(), 0);
    }

    @Test
    public void testCardForPastTime(){
        Column c = new Column(1L,"c1","c1",1L);
        boolean created = cs.createCard(3L, "card3", "des", c, null, 2L);
        Assertions.assertEquals(created, true);
        List<Card> cardsNow = cs.getAllCardsAfterTime(System.currentTimeMillis() - 2000);
        Assertions.assertTrue(cardsNow.size() > 0);
    }

    @Test
    public void testCardForTag(){
        Column c = new Column(1L,"c1","c1",1L);
        Set<String> labels = new HashSet<>();
        labels.add("tag1");
        boolean created = cs.createCard(4L, "card4", "des", c,labels, 2L);
        Assertions.assertEquals(created, true);
        List<Card> cardsNow = cs.getAllCardsWithTag("tag1");
        Assertions.assertTrue(cardsNow.size() > 0);
        cardsNow = cs.getAllCardsWithTag("tag2");
        Assertions.assertTrue(cardsNow.size() == 0);
    }
}
