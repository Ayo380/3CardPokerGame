import java.util.ArrayList;

public class Deck extends ArrayList<Card> {
	
	ArrayList<Card> deck;
	ArrayList<Card> shufDeck;
	char[] suit = {'C','D','S','H'};
	
	int val;
	Deck(){
		int ind; 
		deck = new ArrayList<Card>();
		shufDeck = new ArrayList<Card>();
		// populate the deck with 52 cards in order
		for(int i = 0; i < 4; i++) {
			for(int j = 2; j <= 14; j++) {
				deck.add(new Card(suit[i], j));
			}
		}
		// shuffles the cards 
		while(deck.size()>0) {
			ind = (int) ((Math.random() * (deck.size() - 0)) + 0);;
			shufDeck .add(deck.remove(ind));
		}
		
	};
	
	void newDeck() {
		int ind;
		deck.removeAll(deck);
		shufDeck.removeAll(shufDeck);
		for(int i = 0; i < 4; i++) {
			for(int j = 2; j <= 14; j++) {
				deck.add(new Card(suit[i], j));
			}
		}
		// shuffles the cards 
		while(deck.size()>0) {
			ind = (int) ((Math.random() * (deck.size() - 0)) + 0);;
			shufDeck .add(deck.remove(ind));
		}
		
		};
	
	//Lets make a getter of the sufDeck
	ArrayList<Card> Deck_Card(){
		return shufDeck;
	}
}
