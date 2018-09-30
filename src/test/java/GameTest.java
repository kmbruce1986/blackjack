import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class GameTest {

    Game game;
    Dealer dealer;
    Player player1;
    Player player2;
    Deck deck;

    @Before
    public void setUp() {
        player1 = new Player("Marvin", true);
        player2 = new Player("John", false);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        deck = new Deck();
        dealer = new Dealer();
        game = new Game(deck, dealer, players);
    }

        @Test
        public void testCanDealEachPlayerACard() {
        game.dealEachPlayerTwoCards();
        assertEquals(2, player1.countCardsInHand());
        assertEquals(2, player2.countCardsInHand());
        assertEquals(48, deck.countCards());
    }

        @Test
        public void checksNumberOfPlayers() {
        assertEquals(2, game.countPlayers());
    }

        @Test
        public void canRemoveAllPlayers() {
        game.removeAllPlayers();
        assertEquals(0, game.countPlayers());
    }

        @Test
        public void checkPlayer1Wins() {
        player1.addCard(new Card(Suit.HEARTS, Rank.EIGHT));
        player2.addCard(new Card(Suit.HEARTS, Rank.FIVE));
        assertEquals(player1, game.checkWinner());
    }


    @Test
    public void drawReturnsNull(){
        player1.addCard(new Card(Suit.HEARTS, Rank.EIGHT));
        player2.addCard(new Card(Suit.HEARTS, Rank.EIGHT));
        assertNull(game.checkWinner());
    }

    @Test
    public void testsEachPlayerGetsTwoCards() {
        game.play();
        Card card1 = dealer.deal(deck);
        Card card2 = dealer.deal(deck);
        assertNotNull(card1);
        assertNotNull(card2);
        assertEquals(2, player1.countCardsInHand());
        assertEquals(2, player2.countCardsInHand());
        assertEquals(46, deck.countCards());
    }
}
