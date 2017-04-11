package Poker;

/**
 * Created by thoma on 10/04/2017.
 */
public class HumanPlayer extends Player {
    HumanPlayer(DeckOfCards deck, int startingChips){
        super(deck, startingChips);
    }


    @Override
    public int makeBet() {
        return 0;
    }

    @Override
    public int discard() {
        return 0;
    }
}
