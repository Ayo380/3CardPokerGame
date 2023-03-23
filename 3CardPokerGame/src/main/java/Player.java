import java.util.ArrayList;
public class Player {
	ArrayList<Card> hand;
	int anteBet;
	int playBet;
	int pairPlusBet;
	int totalBet; 
	int totalWinnings;
	
	Player(){
		hand = new ArrayList<Card>();
		totalBet = 0; 
		anteBet = 0;
		playBet = 0;
		pairPlusBet = 0;
	    totalWinnings = 0;
		
	}
	// setter for anteBet
	void set_anteBet(int bet) {
		anteBet = bet;
		totalBet += bet;
	}
	// setter for playBet
	void set_playBet(int bet) {
		playBet = bet;
		totalBet += bet;
	}
	// setter for pairPlusBet
	void set_pairPlusBet(int bet) {
		pairPlusBet = bet;
	}
	// setter for players hand
	void set_hand(ArrayList<Card> h) {
		hand = h;
	}
	//getter for anteBet
	int get_anteBet() {
		return anteBet;
	}
	//getter for playBet
	int get_playBet() {
		return playBet;
	}
	// getter for pairPlusBet
	int get_pairPlusBet() {
		return pairPlusBet;
	}
	// getter for player hand
	ArrayList<Card> get_hand(){
		return hand;
	}
	
	
	//getter for totalWinnings
	int get_totalWinning() {
	
		return totalWinnings;
	}
	
	//setter for totalWinnings
	void set_totalWinning(int winnings) {
		
		totalWinnings += winnings;
	}
	

}
