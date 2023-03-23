
public class Card {
	char suit;
	int value;
	// constructor
	// made into a constructor so it can be called from deck
	public Card(char suit, int value){
		this.suit = suit;
		this.value = value;
	}
	public int getValue() {
		return this.value; 
	}
	public char getSuit() {
		return this.suit; 
	}
}