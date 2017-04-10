package Poker;

import java.util.Random;

/**
 * Created by thoma on 07/03/2017.
 */
public class AIPlayer extends Player{

    AIPlayer(DeckOfCards deck, int startingChips){
        super(deck, startingChips);
    }

    @Override
    public int makeBet() {
        int value = hand.getGameValue();
        int random = 0;
        Random r = new Random();
        random = r.nextInt(100);
        if(value > HandOfCards.PAIR_DEFAULT) {

            if (value > HandOfCards.THREE_OF_A_KIND_DEFAULT) {

                if (value > HandOfCards.STRAIGHT_DEFAULT) {
                    if (random < 65) {
                        return 2;
                    } else if (random < 98) {
                        return 1;
                    }
                    return 0;
                }
                if (random < 40) {
                    return 2;
                } else if (random < 90){
                    return 1;
                }
                return 0;
            }

            if(random < 5){
                return 2;
            } else if(random < 90){
                return 1;
            }
            return 0;
        }
        return 0;
    }

    @Override
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

}
