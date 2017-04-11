package Poker;

import java.util.ArrayList;

public class GameOfPoker {
	private ArrayList<Player> players = new ArrayList<>();
	private DeckOfCards deck;
	private int numPlayers = 5;
	private int startingChips = 10;

	public GameOfPoker(int startingChips, int numPlayers) {
		this.deck = new DeckOfCards();
		this.startingChips = startingChips;
		this.numPlayers = numPlayers;
	}

	private void createPlayers(){
		Player player = new HumanPlayer(deck, startingChips);
		players.add(player);
		for(int i = 0; i < numPlayers; i++) {
			player = new AIPlayer(deck, startingChips);
			players.add(player);
		}
	}
	
	public void gameLoop(){
		createPlayers();
		PokerRound roundOfPoker = new PokerRound(players);

		while(players.size() > 1) {
			deck.reset();
			System.out.println(players);
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
