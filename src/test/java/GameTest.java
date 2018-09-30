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
    Player player3;
    Deck deck;

    @Before
    public void setUp() {
        player1 = new Player("Marvin", false);
        player2 = new Player("John", false);
        player3 = new Player("Kathleen", true);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        deck = new Deck();
        dealer = new Dealer();
        game = new Game(deck, dealer, players);
    }

        @Test
        public void testCanDealEachPlayerACard() {
        game.dealEachPlayerTwoCards();
        assertEquals(2, player1.countCardsInHand());
        assertEquals(2, player2.countCardsInHand());
        assertEquals(2, player3.countCardsInHand());
        assertEquals(46, deck.countCards());
    }

        @Test
        public void checksNumberOfPlayers() {
        assertEquals(3, game.countPlayers());
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
        player3.addCard(new Card(Suit.HEARTS, Rank.FOUR));
        assertEquals(player1, game.checkWinner());
    }


        @Test
        public void drawReturnsNull(){
        player1.addCard(new Card(Suit.HEARTS, Rank.EIGHT));
        player2.addCard(new Card(Suit.HEARTS, Rank.EIGHT));
        player3.addCard(new Card(Suit.HEARTS, Rank.EIGHT));
        assertNull(game.checkWinner());
    }

        @Test
        public void testsEachPlayerGetsTwoCards() {
        game.play();


        assertEquals(2, player1.countCardsInHand());
        assertEquals(2, player2.countCardsInHand());
        assertEquals(2, player3.countCardsInHand());
        assertEquals(46, deck.countCards());
    }
}
