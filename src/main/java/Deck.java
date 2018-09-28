import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;

    public Deck (){
        this.cards = new ArrayList<>();
//        can populate deck in the constructor and then make the populate deck
//         method private so it cannot be done twice in any other class, then shuffleDeck
//      and take that out of the populate

        populateDeck();
//        shuffleDeck();
    }

    public int countCards() {
        return this.cards.size();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void populateDeck() {
//        use a nested loop to populate the deck with 52 individual cards
        //        the loop should loop through each suit with each rank
        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()){
//                then make a card and add this to the cards ArrayList
                Card card = new Card(suit, rank);
                addCard(card);
            }
        }shuffleDeck();
    }

    public void shuffleDeck(){
        Collections.shuffle(this.cards);
    }

    public Card dealCard(){
        Card card =  this.cards.get(0);
        this.cards.remove(0);
        return card;
    }
}
