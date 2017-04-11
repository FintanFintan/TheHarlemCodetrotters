package Poker;

import java.util.ArrayList;

public class PokerRound {
	ArrayList<Player> players;

	public PokerRound(ArrayList<Player> players) {
		this.players = players;
	}

	public void playRound(){
		for(Player p: players)
			p.makeBet();

		for(Player p: players)
			p.discard();

		for(Player p: players)
			p.makeBet();

		for(Player p: players){
			//players win round and chips distributed, we're gonna have to deal with the output eventually too...
		}
	}

}
