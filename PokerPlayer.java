package Poker;

import java.util.Random;

/**
 * Created by thoma on 07/03/2017.
 */
public class PokerPlayer {
    private HandOfCards hand;

    PokerPlayer(DeckOfCards deck){
        hand = new HandOfCards(deck);
    }


    public int discard(){
        Random r = new Random();
        int probability = 0;
        int[] discardCards = new int[3];
        int count = 0;
        int random = 0;
        for(int i = 0; i < HandOfCards.SIZE_OF_HAND; i++){
            probability = hand.getDiscardProbability(i);
            random = r.nextInt(100);

            if(random < probability){
                discardCards[count] = i;
                count++;
            }
        }

        hand.replaceCards(discardCards, count);
        return count;
    }

    public HandOfCards getHand() {
        return hand;
    }
}
