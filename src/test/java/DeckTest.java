import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DeckTest {

    Deck deck;
    Card card;

    @Before
    public void setUp() {
        deck = new Deck();
        card = new Card(Suit.CLUBS, Rank.ACE);
    }


    @Test
    public void canAddCard() {
        deck.addCard(card);
        assertEquals(53, deck.countCards());
    }

        @Test
    public void canPopulateDeck() {
        assertEquals(52, deck.countCards());
    }

    @Test
    public void canDealCard() {
        assertNotNull(deck.dealCard());
        assertEquals(51, deck.countCards());
    }

}
