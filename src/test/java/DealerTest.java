import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DealerTest {

    Dealer dealer;
    Deck deck;
    Player player1;
    Player player2;

    @Before
    public void setUp() {
        dealer = new Dealer();
        deck = new Deck();

    }

    @Test
    public void dealerCanDealCards() {
        Card card = dealer.deal(deck);
        assertNotNull(card);
        assertEquals(51, deck.countCards());
    }



}
