import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;
    private boolean isDealer;

    public Player(String name, boolean isDealer){
        this.name = name;
        this.hand = new ArrayList<>();
        this.isDealer = isDealer;
    }

    public String getName() {
        return name;
    }

    public boolean isDealer() {
        return isDealer;
    }

    public int countCardsInHand() {
        return this.hand.size();
    }

//  this will need to be amended if you make a game requiring each player to have more than one card
    public void addCard(Card card) {
        this.hand.add(card);
    }

    public void removeCard(Card card) {
        this.hand.clear();
    }

//    for loop if more than one card, then you'd need to return just the highest value.
    public int getHandValue() {
//        int total = 0;
//        for (Card card : this.hand){
//            total += card.getValue();
//        }
        return this.hand.get(0).getValue();
    }
}
