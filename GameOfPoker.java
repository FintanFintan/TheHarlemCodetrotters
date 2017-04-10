package Poker;

import java.util.ArrayList;

public class GameOfPoker {
	private ArrayList<Player> players = new ArrayList<>;
	private DeckOfCards deck = new DeckOfCards();
	private int numPlayers = 5;
	private int startingChips = 56;
	
	private void createPlayers() {
		HumanPlayer player = new HumanPlayer(deck, startingChips);
		players.add(player);
		for(int i = 0; i < numPlayers; i++) {
			AIPlayer botPlayers = new AIPlayer(deck, startingChips);
			players.add(botPlayers);
		}
	}
	
	public void gameLoop() {
		HandOfPoker handOfPoker = new HandOfPoker();
		while(numPlayers != 1 || players.get(0).getChips() != 0) {
		    handOfPoker.initiate();
		}
		
		for(Player p: players) {
			p.getHand().emptyHand();
		}
		deck.reset();
	
		for(Player p: players) {
			p.getHand().dealNewHand();
		}
	}
}
