package Poker;

/**
 * Created by thoma on 10/04/2017.
 */
public abstract class Player {
    protected HandOfCards hand;
    public int chips;

    Player(DeckOfCards deck, int startingChips){
        hand = new HandOfCards(deck);
        chips = startingChips;
    }

    public abstract int discard();

    public HandOfCards getHand() {
        return hand;
    }

    public int getChips(){
        return chips;
    }

}
