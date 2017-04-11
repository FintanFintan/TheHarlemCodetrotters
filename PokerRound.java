package Poker;

import java.util.ArrayList;

public class PokerRound {
	ArrayList<Player> players;
	int pot = 0;

	public PokerRound(ArrayList<Player> players) {
		this.players = players;
	}

	public void playRound(){
		int bet = 0;

		//players make initial bet, if bet zero they fold and are removed from round
		for(Player player: players) {
			bet = player.makeBet();
			if(bet > 0){
				pot += bet;
			} else {
				players.remove(player);
			}
		}

		//remaining players can discard cards
		for(Player player: players)
			player.discard();

		//players make second round of bets
		for(Player player: players) {
			bet = player.makeBet();
			if (bet > 0) {
				pot += bet;
			} else {
				players.remove(player);
			}
		}

		//winner found and chips allocated
		Player winner = players.get(0);
		for(Player player: players){
			if(player.getHand().getGameValue() > winner.getHand().getGameValue()){
				winner = player;
			}
			//players win round and chips distributed, we're gonna have to deal with the output eventually too...

			winner.winChips(pot);
			pot = 0;
		}
	}

}
