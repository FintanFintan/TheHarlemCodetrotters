package Poker;

/**
 * Created by thoma on 10/04/2017.
 */
public abstract class Player {
    String name;
    HandOfCards hand;
    int chips;

    Player(DeckOfCards deck, int startingChips){
        hand = new HandOfCards(deck);
        chips = startingChips;
    }


    //returns a value of 0 for fold, 1 for call, 2 for raise
    public abstract int makeBet();

    public abstract int discard();

    public int winChips(int winnings){
        chips += winnings;
        return winnings;
    }

    public HandOfCards getHand() {
        return hand;
    }

    public int getChips(){
        return chips;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
//                ", hand=" + hand +
                ", chips=" + chips +
                '}';
    }
}
