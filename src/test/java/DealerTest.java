import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    Dealer dealer;
    Card card;
    Player player1;
    Player player2;
    Deck deck;

    @Before
    public void setUp() {
        player1 = new Player("Marvin");
        player2 = new Player("John");
        deck = new Deck();
        deck.populateDeck();
        dealer = new Dealer(deck);
    }

    @Test
    public void checksNumberOfPlayers() {
        assertEquals(0, dealer.countPlayers());
    }

    @Test
    public void startsWithNoPlayers() {
        assertEquals(0, dealer.countPlayers());
    }

    @Test
    public void canAddPlayer() {
        dealer.addPlayer(player1);
        assertEquals(1, dealer.countPlayers());
    }

    @Test
    public void canRemoveAllPlayers() {
        dealer.addPlayer(player1);
        dealer.addPlayer(player2);
        dealer.removePlayers();
        assertEquals(0, dealer.countPlayers());
    }

        @Test
    public void canDealEachPlayerACard() {
        dealer.addPlayer(player1);
        dealer.addPlayer(player2);
        dealer.dealEachPlayerACard();
        assertEquals(50, deck.countCards());
        assertEquals(1, player1.countCardsInHand());
        assertEquals(1, player2.countCardsInHand());
    }

    @Test
    public void canPlay() {
        dealer.dealEachPlayerACard();
        assertEquals(1, player1.countCardsInHand());
        assertEquals(1, player2.countCardsInHand());
        assertEquals(50, deck.countCards());
    }

    @Test
    public void checkPlayer1Wins() {
        player1.addCard(new Card(Suit.HEARTS, Rank.EIGHT));
        player2.addCard(new Card(Suit.HEARTS, Rank.FIVE));
        assertEquals(player1, dealer.checkWinner());
    }

    //    this may be better handled in the player class.
//    @Test
//    public void checkHighestCard() {
//        Card card1 = new Card(Suit.HEARTS, Rank.FOUR);
//        Card card2 = new Card(Suit.SPADES, Rank.EIGHT)
//        int result  = dealer.checkCards(card1, card2);
//        assertEquals(card2, result);
//    }
}
