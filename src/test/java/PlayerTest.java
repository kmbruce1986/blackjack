import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class PlayerTest {

    Player player;
    Card card;

    @Before
    public void setUp() {
        card = new Card(Suit.CLUBS, Rank.ACE);
        player = new Player("Marvin", true);
    }

    @Test
    public void canGetName() {
        assertEquals("Marvin", player.getName());
    }

    @Test
    public void countCardsInHand() {
        assertEquals(0, player.countCardsInHand());
    }

    @Test
    public void checkStartsWithNoCardsInHand() {
        assertEquals(0, player.countCardsInHand());
    }

    @Test
    public void canAddCard() {
        player.addCard(card);
        assertEquals(1, player.countCardsInHand());
    }


    @Test
    public void canRemoveCard() {
        player.addCard(card);
        player.removeCard(card);
        assertEquals(0, player.countCardsInHand());
    }

    @Test
    public void hadHandValue() {
        player.addCard(card);
        assertEquals(1, player.getHandValue());
    }

    @Test
    public void checksIfPlayerIsDealer() {
        assertEquals(true, player.isDealer());
    }
}
