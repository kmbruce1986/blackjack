import java.util.ArrayList;

public class Dealer {

    private ArrayList<Player> players;
    private Deck deck;

    public Dealer(Deck deck){
        this.players = new ArrayList<>();
        this.deck = deck;
    }

    public int countPlayers(){
        return this.players.size();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayers() {
        this.players.clear();
    }

    public void dealEachPlayerACard() {
        for (Player player : this.players) {
            Card card = deck.dealCard();
            player.addCard(card);
        }
    }


    public Player checkWinner() {
        Player winner = this.players.get(0);
        for (Player player : this.players){
            if (player.getHandValue() > winner.getHandValue()){
                winner = player;
            }
        }
        return winner;
    }
//
//    public int checkCards(Card card1, Card card2) {
//        int total = 0;
//        for (Card card : this.hand){
//            total += card.getValue();
//        }
//    }
}
