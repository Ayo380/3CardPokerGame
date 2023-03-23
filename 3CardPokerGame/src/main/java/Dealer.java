import java.util.ArrayList;

public class Dealer {
	Deck theDeck ;
	ArrayList<Card> dealersHand;
	ArrayList<Card> deck;// hold the deck
	
	public Dealer() {
		theDeck = new Deck();
		dealersHand = new ArrayList<Card>();
		deck = new ArrayList<Card>();
		deck = theDeck.Deck_Card();// deck holds the shufdeck from deck class
	}
	// method to deal hand
	public ArrayList<Card> dealHand(){
		ArrayList<Card> Hand = new ArrayList<Card>();
		// get 3 cards from deck and return it
		for(int i = 0; i < 3; i++) {
			Hand.add(deck.remove(i));
		}
		return Hand;
	}
	// method to checks if the deck size is greater than 34
	public void check_size() {
		if(deck.size() <= 34) {
			theDeck.newDeck();
		}
	}
	// method to access thedeck
	public ArrayList<Card> thedeck(){
		return deck;
	}
	// method to deal the dealer
	public void deal_dealer() {
		dealersHand = dealHand();
	}
	// getter for dealer hand
	public ArrayList<Card> get_hand(){
		return dealersHand;
	}
}
