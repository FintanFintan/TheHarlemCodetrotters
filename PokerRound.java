package Poker;

import java.util.ArrayList;

public class PokerRound {
    ArrayList<Player> players = new ArrayList<>();
    int pot = 0;

    public PokerRound(ArrayList<Player> players) {
        this.players.addAll(players);
    }

    public void playRound() {
        //players make initial bet, if bet zero they fold and are removed from round
        if(players.size() > 1){
            takeBets();
        }

        System.out.println("after 1 round of betting :\n" + players);
        System.out.println("POT CONTAINS :" + pot);

        //remaining players can discard cards
        if(players.size() > 1) {
            for (Player player : players)
                player.discard();
        }

        //players make second round of bets
        if(players.size() > 1) {
            takeBets();
        }


        System.out.println("after 2 round of betting :\n" + players);
        System.out.println("POT CONTAINS :" + pot);


        //winner found and chips allocated
        if(players.size() > 0) {
            Player winner = players.get(0);
            for (Player player : players) {
                if (player.getHand().getGameValue() > winner.getHand().getGameValue()) {
                    winner = player;
                }
                //players win round and chips distributed, we're gonna have to deal with the output eventually too...


            }
            winner.winChips(pot);
            pot = 0;


            System.out.println("*********winner of round : " + winner);
        }
    }

    private void takeBets(){
        int bet = 0;
        System.out.println("number of players in round " + players.size());
        for (int i = 0; i < players.size();) {
            bet = players.get(i).makeBet();
            if (bet > 0) {
                pot += bet;
                i++;
            } else {
                if(players.size() == 1){
                    i++;
                } else {
                    System.out.println(players.get(i) + " folded from the round.");
                    players.remove(i);
                }
            }
        }
    }

}
