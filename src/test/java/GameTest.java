import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GameTest {

    Game game;
    Dealer dealer;
    Player player1;
    Player player2;
    Deck deck;

    @Before
    public void setUp() {
        player1 = new Player("Marvin");
        player2 = new Player("John");
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        deck = new Deck();
        dealer = new Dealer();
        game = new Game(deck, dealer, players);
    }

        @Test
        public void testCanDealEachPlayerACard() {
        game.dealEachPlayerACard();
        assertEquals(1, player1.countCardsInHand());
        assertEquals(1, player2.countCardsInHand());
        assertEquals(50, deck.countCards());
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
}
