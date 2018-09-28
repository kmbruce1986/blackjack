public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
//        getSuits();
    }

    public Suit getSuit(){
        return this.suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getValue() {
        return this.rank.getValue();
//        this is an alternative if the index is a relevant value
//        return this.rank.ordinal()+1;
    }
//  brings a list of all values within the suit enum
//    public void getSuits(){
//        for (Suit suit : suit.values()){
//            System.out.println(suit);
//        }
//    }
}