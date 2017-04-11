package Poker;

import java.util.Random;

/**
 * Created by thoma on 07/03/2017.
 */
public class AIPlayer extends Player{
    Random random = new Random();
    int boldnessModifier = 0;

    AIPlayer(DeckOfCards deck, int startingChips){
        super(deck, startingChips);
        boldnessModifier = -10 + random.nextInt(21);
    }


    @Override
    public int makeBet(){
        int bet = generateBet();
        chips = chips - bet;
        return bet;
    }


    private int generateBet() {
        int value = hand.getGameValue();
        int howLikely = 0;
        Random r = new Random();
        howLikely = r.nextInt(100) + boldnessModifier;
        if(value > HandOfCards.PAIR_DEFAULT) {

            if (value > HandOfCards.THREE_OF_A_KIND_DEFAULT) {

                if (value > HandOfCards.STRAIGHT_DEFAULT) {
                    if (howLikely > 35) {
                        return 2;
                    } else if (howLikely > 2) {
                        return 1;
                    }
                    return 0;
                }
                if (howLikely > 60) {
                    return 2;
                } else if (howLikely > 10){
                    return 1;
                }
                return 0;
            }
            //TODO deal with one pair modifier
            //pairs ofter affect 5draw poker so modifier is important
            if(howLikely > 95){
                return 2;
            } else if(howLikely > 20){
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
