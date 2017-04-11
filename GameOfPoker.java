package Poker;

import java.util.ArrayList;

public class GameOfPoker {
	private ArrayList<Player> players = new ArrayList<>();
	private DeckOfCards deck = new DeckOfCards();
	private int numPlayers = 5;
	private int startingChips = 10;
	
	private void createPlayers() {
		HumanPlayer player = new HumanPlayer(deck, startingChips);
		players.add(player);
		for(int i = 0; i < numPlayers; i++) {
			AIPlayer botPlayers = new AIPlayer(deck, startingChips);
			players.add(botPlayers);
		}
	}
	
	public void gameLoop() {
		PokerRound roundOfPoker = new PokerRound(players);

		while(players.size() > 1) {
			deck.reset();
			for(Player player: players){
				if(player.getChips() == 0){
					players.remove(player);
				} else {
					player.getHand().dealNewHand();
				}
			}
			roundOfPoker.playRound();
		}
	}
}
