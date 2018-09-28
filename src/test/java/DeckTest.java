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
    public void deckStartsEmpty() {
        assertEquals(0, deck.countCards());
    }

    @Test
    public void canAddCard() {
        deck.addCard(card);
        assertEquals(1, deck.countCards());
    }

        @Test
    public void canPopulateDeck() {
        deck.populateDeck();
        assertEquals(52, deck.countCards());
    }

    @Test
    public void canDealCard() {
        deck.populateDeck();
        assertNotNull(deck.dealCard());
        assertEquals(51, deck.countCards());
    }

}
