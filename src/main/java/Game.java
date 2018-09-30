import java.util.ArrayList;

public class Game {

    private Deck deck;
    private Dealer dealer;
    private ArrayList<Player> players;

    public Game(Deck deck, Dealer dealer, ArrayList<Player> players){
        this.players = players;
        this.dealer = dealer;
        this.deck = deck;
    }

    public void dealEachPlayerTwoCards() {
        for (Player player : this.players) {
            Card card1 = dealer.deal(deck);
            player.addCard(card1);
            Card card2 = dealer.deal(deck);
            player.addCard(card2);
        }
    }

    public int countPlayers(){
        return this.players.size();
    }


    public void removeAllPlayers() {
        this.players.clear();
    }

    public Player checkWinner() {
        Player winner = this.players.get(0);
        for (Player player : this.players){
            if (player.getHandValue() > winner.getHandValue()){
                winner = player;
            }
        }
        if (checkDraw()){
            return null;
        }
        return winner;
    }

    public boolean checkDraw(){
        boolean draw = false;
        for (Player player : this.players){
            if (player.getHandValue() == players.get(0).getHandValue()){
                draw = true;
            } else {
                draw = false;
            }
        }
        return draw;
    }

    public void play(){
        dealEachPlayerTwoCards();
    }

}
