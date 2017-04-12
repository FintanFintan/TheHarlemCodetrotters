package Poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GameOfPoker {
	private ArrayList<Player> players = new ArrayList<>();
	private DeckOfCards deck;
	private int numPlayers = 5;
	private int startingChips = 10;
	private ArrayList<String> names = new ArrayList<String>(Arrays.asList("Thomas", "Jamie", "Fintan", "Stan"));

	public GameOfPoker(int startingChips, int numPlayers) {
		this.deck = new DeckOfCards();
		this.startingChips = startingChips;
		this.numPlayers = numPlayers;
	}

	private void createPlayers(){
		Player player = new HumanPlayer(deck, startingChips);
		players.add(player);
		Collections.shuffle(names);
		for(int i = 0; i < numPlayers - 1; i++) {
			player = new AIPlayer(names.get(i), deck, startingChips);
			players.add(player);
		}
	}

	private void removeBrokePlayers(){
		ArrayList<Integer> brokePlayers = new ArrayList<>();

		for(int i = 0; i < players.size();){
			if(players.get(i).getChips() > 0){
				i++;
			} else {
				players.remove(i);
			}
		}
	}
	
	public void gameLoop(){
		createPlayers();
		PokerRound roundOfPoker = new PokerRound(players);
		int roundNumber = 0;

		//TODO
		//deal with human betting
		System.out.println("Initial Players:" + players);
		players.remove(0);

		while(players.size() > 1) {
			deck.reset();
			System.out.println("\n\n\nRound " + roundNumber + ": \n" + players);
			int sum = 0;
			for(Player palayer: players){
				sum += palayer.getChips();
			}
			if(sum < 40){
				System.out.println("*******************************************");
			}
			roundNumber++;




			removeBrokePlayers();
			for(Player player: players){
				player.getHand().dealNewHand();
			}

			if(players.size() > 1) {
				System.out.println(players.size());
				roundOfPoker = new PokerRound(players);
				roundOfPoker.playRound();
			}
		}
		System.out.println("\n\n" + players.get(0) + " won the game ");
	}
}
