import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;

class MyTest {

	@Test
	void test_deck() {
		Deck thedeck = new Deck();
		ArrayList<Card> card = new ArrayList<Card>();
		ArrayList<Card> new_card = new ArrayList<Card>();
		card = thedeck.Deck_Card();// sets the first deck
		assertEquals(card, thedeck.Deck_Card(), "wrong deck ");
		assertEquals(52,thedeck.Deck_Card().size(),"size of the new deck");
		System.out.println(card);
		thedeck.newDeck();// sets the new deck
		new_card = thedeck.Deck_Card();
		System.out.println(new_card);
		assertEquals(new_card, thedeck.Deck_Card(), "wrong new_deck ");
		assertEquals(card, thedeck.Deck_Card(), "wrong new_deck ");
		assertEquals(52,new_card.size(),"size of the new deck");
		
	}
	
	@Test
	void test_Dealer() {
		Dealer thedealer = new Dealer();
		assertEquals(52,thedealer.thedeck().size(),"size of the deck is wrong");
		for (int i = 0; i < 4; i++) {
			assertEquals(3,thedealer.dealHand().size(),"dealer is not dealing 3 cards");
		}
		assertEquals(40,thedealer.thedeck().size(),"dealer is not dealing 3 cards");
		// check the deck after you deal the dealers hand
		thedealer.deal_dealer();
		assertEquals(37,thedealer.thedeck().size(),"dealer is not dealing 3 cards");
		//check start game method while the deck is greater than 34
		thedealer.check_size();
		assertEquals(37,thedealer.thedeck().size(),"size of the deck is wrong");
		for (int i = 0; i < 4; i++) {
			assertEquals(3,thedealer.dealHand().size(),"dealer is not dealing 3 cards");
		}
		// check start game method when the deck is less than 34
		assertEquals(25,thedealer.thedeck().size(),"size of the deck is wrong");
		thedealer.check_size();
		assertEquals(52,thedealer.thedeck().size(),"size of the deck is wrong");
	}

	@Test
	void test_player() {
		Dealer thedealer = new Dealer();
		Player player1 = new Player();
		Player player2 = new Player();
		ArrayList<Card> player1_hand = new ArrayList<Card>();
		ArrayList<Card> player2_hand = new ArrayList<Card>();
		// tests for player1
		player1.set_anteBet(25);
		player1_hand = thedealer.dealHand();
		player1.set_hand(player1_hand);
		player1.set_pairPlusBet(10);
		player1.set_playBet(5);
		assertEquals(25,player1.get_anteBet(),"ante bet wrong for player1");
		assertEquals(player1_hand,player1.get_hand(),"hand wrong for player1");
		assertEquals(10,player1.get_pairPlusBet(),"pairplusbet wrong for player1");
		assertEquals(5,player1.get_playBet(),"playbet wrong for player1");
		assertEquals(52-3,thedealer.thedeck().size(),"size of the deck is wrong");
		// tests for player2
		player2.set_anteBet(5);
		player2_hand = thedealer.dealHand();
		player2.set_hand(player2_hand);
		player2.set_pairPlusBet(12);
		player2.set_playBet(13);
		assertEquals(5,player2.get_anteBet(),"ante bet wrong for player2");
		assertEquals(player2_hand,player2.get_hand(),"hand wrong for player2");
		assertEquals(12,player2.get_pairPlusBet(),"pairplusbet wrong for player2");
		assertEquals(13,player2.get_playBet(),"playbet wrong for player2");
		
		// check the size of the deck again
		assertEquals(52-(3*2),thedealer.thedeck().size(),"size of the deck is wrong");		
	}
	
	@Test
	void test_threeCardLogic() {
		ArrayList<Card> straightFlush1 = new ArrayList<Card> (); 
		//straight flush ace king queen spades highest order
		straightFlush1.add(new Card('S',14)); 
		straightFlush1.add(new Card('S',13));
		straightFlush1.add(new Card('S',12));
		
		ArrayList<Card> straightFlush2 = new ArrayList<Card> (); 
		//straight flush king queen jack spades
		straightFlush2.add(new Card('S',13)); 
		straightFlush2.add(new Card('S',12));
		straightFlush2.add(new Card('S',11));
		
		ArrayList<Card> threeOfKind1 = new ArrayList<Card>();
		//three 9's heart club diamond higher TOK
		threeOfKind1.add(new Card('H',9)); 
		threeOfKind1.add(new Card('C',9));
		threeOfKind1.add(new Card('D',9));
		
		ArrayList<Card> threeOfKind2 = new ArrayList<Card>();
		//three 4's heart club diamond
		threeOfKind2.add(new Card('H',4)); 
		threeOfKind2.add(new Card('C',4));
		threeOfKind2.add(new Card('D',4));
		
		ArrayList<Card> stright1 = new ArrayList<Card>();
		//straight 7 9 8 spade club diamond
		stright1.add(new Card('S',7)); 
		stright1.add(new Card('C',9));
		stright1.add(new Card('D',8));
		
		ArrayList<Card> stright2 = new ArrayList<Card>();
		//straight queen jack 10 spade club heart higher straight
		stright2.add(new Card('S',12)); 
		stright2.add(new Card('C',10));
		stright2.add(new Card('H',11));
		
		ArrayList<Card> flush1 = new ArrayList<Card>();
		//flush spades 4 10 king higher flush
		flush1.add(new Card('S',4)); 
		flush1.add(new Card('S',10));
		flush1.add(new Card('S',13));
		
		ArrayList<Card> flush2 = new ArrayList<Card>();
		//flush hearts 7 3 jack
		flush2.add(new Card('H',7)); 
		flush2.add(new Card('H',3));
		flush2.add(new Card('H',11));
		
		ArrayList<Card> pair1 = new ArrayList<Card>();
		//pocket aces spade heart 3 club higher pair
		pair1.add(new Card('S',14)); 
		pair1.add(new Card('H',14));
		pair1.add(new Card('C',3));
		
		ArrayList<Card> pair2 = new ArrayList<Card>();
		//pocket 10's club heart king spade
		pair2.add(new Card('C',10)); 
		pair2.add(new Card('S',13));
		pair2.add(new Card('H',10));
		
		ArrayList<Card> pair4 = new ArrayList<Card>();
		//pocket 10 diamonds spade and queen
		pair4.add(new Card('D',10)); 
		pair4.add(new Card('S',12));
		pair4.add(new Card('S',10));
		
		ArrayList<Card> highCard = new ArrayList<Card>();
		//high card ace diamond 10 heart 3 club higher high card
		highCard.add(new Card('D',14)); 
		highCard.add(new Card('H',10));
		highCard.add(new Card('C',3));
		
		ArrayList<Card> highCard2 = new ArrayList<Card>();
		//high card 10 spade, 4 club 2 heart
		highCard2.add(new Card('H',2)); 
		highCard2.add(new Card('S',10));
		highCard2.add(new Card('C',4));
		
		//straight flush vs all other hands
		//testing compareHands(ArrayList<Card> dealer, ArrayList<Card>player)
		assertEquals( 1, ThreeCardLogic.compareHands(straightFlush1 , straightFlush2), "incorrect output: dealer should've won straight flush vs straight flush");
		assertEquals( 2, ThreeCardLogic.compareHands(straightFlush2 , straightFlush1), "incorrect output: player should've won straight flush vs straight flush");
		//straight flush vs TOK
		assertEquals( 1, ThreeCardLogic.compareHands(straightFlush1 , threeOfKind1), "incorrect output: dealer should've won straight flush vs TOK");
		assertEquals( 2, ThreeCardLogic.compareHands(threeOfKind1 , straightFlush1), "incorrect output: player should've won straight flush vs TOK");
		//straight flush vs straight
		assertEquals( 1, ThreeCardLogic.compareHands(straightFlush2 , stright1), "incorrect output: dealer should've won straight flush vs straight");
		assertEquals( 2, ThreeCardLogic.compareHands(stright1 , straightFlush2), "incorrect output: player should've won straight flush vs straight");
		//straight flush vs flush
		assertEquals( 1, ThreeCardLogic.compareHands(straightFlush1 , flush1), "incorrect output: dealer should've won straight flush vs flush");
		assertEquals( 2, ThreeCardLogic.compareHands(flush1 , straightFlush1), "incorrect output: player should've won straight flush vs flush");
		//straight flush vs pair
		assertEquals( 1, ThreeCardLogic.compareHands(straightFlush2 , pair1), "incorrect output: dealer should've won straight flush vs pair");
		assertEquals( 2, ThreeCardLogic.compareHands(pair1 , straightFlush2), "incorrect output: player should've won straight flush vs pair");
		//straight flush vs high card
		assertEquals( 1, ThreeCardLogic.compareHands(straightFlush1 , highCard), "incorrect output: dealer should've won straight flush vs high card");
		assertEquals( 2, ThreeCardLogic.compareHands(highCard , straightFlush1), "incorrect output: player should've won straight flush vs high card");
		
		
		//three of a kind vs all other untested
		assertEquals( 1, ThreeCardLogic.compareHands(threeOfKind1 , threeOfKind2), "incorrect output: dealer should've won TOK vs TOK");
		assertEquals( 2, ThreeCardLogic.compareHands(threeOfKind2 , threeOfKind1), "incorrect output: player should've won TOK vs TOK");
		//three of a kind vs straight
		assertEquals( 1, ThreeCardLogic.compareHands(threeOfKind1 , stright1), "incorrect output: dealer should've won TOK vs straight");
		assertEquals( 2, ThreeCardLogic.compareHands(stright1 , threeOfKind1), "incorrect output: player should've won TOK vs straight");
		//three of a kind vs flush
		assertEquals( 1, ThreeCardLogic.compareHands(threeOfKind2 , flush1), "incorrect output: dealer should've won TOK vs flush");
		assertEquals( 2, ThreeCardLogic.compareHands(flush1 , threeOfKind2), "incorrect output: player should've won TOK vs flush");
		//three of a kind vs pair
		assertEquals( 1, ThreeCardLogic.compareHands(threeOfKind1 , pair1), "incorrect output: dealer should've won TOK vs pair");
		assertEquals( 2, ThreeCardLogic.compareHands(pair1 , threeOfKind1), "incorrect output: player should've won TOK vs pair");
		//three of a kind vs high card
		assertEquals( 1, ThreeCardLogic.compareHands(threeOfKind2 , highCard), "incorrect output: dealer should've won TOK vs high card");
		assertEquals( 2, ThreeCardLogic.compareHands(highCard , threeOfKind2), "incorrect output: player should've won TOK vs high card");
		
		//straight vs all other untested
		//straight vs straight
		assertEquals( 1, ThreeCardLogic.compareHands(stright2 , stright1), "incorrect output: dealer should've won straight vs straight");
		assertEquals( 2, ThreeCardLogic.compareHands(stright1 , stright2), "incorrect output: player should've won straight vs straight");
		//straight vs flush
		assertEquals( 1, ThreeCardLogic.compareHands(stright2 , flush1), "incorrect output: dealer should've won straight vs flush");
		assertEquals( 2, ThreeCardLogic.compareHands(flush1 , stright2), "incorrect output: player should've won straight vs flush");
		//straight vs pair
		assertEquals( 1, ThreeCardLogic.compareHands(stright1 , pair1), "incorrect output: dealer should've won straight vs pair");
		assertEquals( 2, ThreeCardLogic.compareHands(pair1 , stright1), "incorrect output: player should've won straight vs pair");
		//straight vs high card
		assertEquals( 1, ThreeCardLogic.compareHands(stright2 , highCard), "incorrect output: dealer should've won straight vs high card");
		assertEquals( 2, ThreeCardLogic.compareHands(highCard , stright2), "incorrect output: player should've won straight vs high card");
		
		//flush vs all other untested
		//flush vs flush
		assertEquals( 1, ThreeCardLogic.compareHands(flush1 , flush2), "incorrect output: dealer should've won straight vs flush");
		assertEquals( 2, ThreeCardLogic.compareHands(flush2 , flush1), "incorrect output: player should've won straight vs flush");
		//flush vs pair
		assertEquals( 1, ThreeCardLogic.compareHands(flush1 , pair1), "incorrect output: dealer should've won straight vs pair");
		assertEquals( 2, ThreeCardLogic.compareHands(pair1 , flush1), "incorrect output: player should've won straight vs pair");
		//flush vs high card
		assertEquals( 1, ThreeCardLogic.compareHands(flush2 , highCard), "incorrect output: dealer should've won straight vs high card");
		assertEquals( 2, ThreeCardLogic.compareHands(highCard , flush2), "incorrect output: player should've won straight vs high card");
	
		//pair vs all other untested
		//pair vs pair
		assertEquals( 1, ThreeCardLogic.compareHands(pair1 , pair2), "incorrect output: dealer should've won pair vs pair");
		System.out.println(pair1.get(0).getValue());
		System.out.println(pair1.get(1).getValue());
		System.out.println(pair1.get(2).getValue());
		System.out.println(pair2.get(0).getValue());
		System.out.println(pair2.get(1).getValue());
		System.out.println(pair2.get(2).getValue());

		assertEquals( 2, ThreeCardLogic.compareHands(pair2 ,  pair1), "incorrect output: player should've won pair vs pair");
		//flush vs high card
		assertEquals( 1, ThreeCardLogic.compareHands( pair2 , highCard), "incorrect output: dealer should've won pair vs high card");
		assertEquals( 2, ThreeCardLogic.compareHands(highCard ,  pair2), "incorrect output: player should've won pair vs high card");
		
		//high card vs all other untested
		//high card vs high card
		assertEquals( 1, ThreeCardLogic.compareHands(highCard , highCard2), "incorrect output: dealer should've won high card vs high card");
		assertEquals( 2, ThreeCardLogic.compareHands(highCard2 , highCard), "incorrect output: player should've won high card vs high card");
		
	}
	
	@Test
	void test_threeCardLogic2() {
		ArrayList<Card> pair1 = new ArrayList<Card>();
		//pocket aces spade heart 3 club higher pair
		pair1.add(new Card('S',14)); 
		pair1.add(new Card('H',14));
		pair1.add(new Card('C',3));
		
		ArrayList<Card> threeOfKind1 = new ArrayList<Card>();
		//three 9's heart club diamond higher TOK
		threeOfKind1.add(new Card('H',9)); 
		threeOfKind1.add(new Card('C',9));
		threeOfKind1.add(new Card('D',9));
		
		ArrayList<Card> straightFlush1 = new ArrayList<Card> (); 
		//straight flush ace king queen spades highest order
		straightFlush1.add(new Card('S',14)); 
		straightFlush1.add(new Card('S',13));
		straightFlush1.add(new Card('S',12));
		
		//testing evalPPWinnings(ArrayList<Card>hand, int bet)
		assertEquals( 20, ThreeCardLogic.evalPPWinnings(pair1, 10), "incorrect output: evalHand() should return 1");
		assertEquals( 0, ThreeCardLogic.evalPPWinnings(pair1, 0), "incorrect output: evalHand() should return 2");
		assertEquals( 20, ThreeCardLogic.evalPPWinnings(threeOfKind1, 10), "incorrect output: evalHand() should return 3");
		assertEquals( 0, ThreeCardLogic.evalPPWinnings(threeOfKind1, 0), "incorrect output: evalHand() should return 4");
		assertEquals( 0, ThreeCardLogic.evalPPWinnings(straightFlush1, 10), "incorrect output: evalHand() should return 3");
		assertEquals( 0, ThreeCardLogic.evalPPWinnings(straightFlush1, 0), "incorrect output: evalHand() should return 4");
	}
	
	@Test 
	void test_threeCardLogic3() {
		ArrayList<Card> highCard = new ArrayList<Card>();
		//high card ace diamond 10 heart 3 club higher high card
		highCard.add(new Card('D',14)); 
		highCard.add(new Card('H',10));
		highCard.add(new Card('C',3));
		
		ArrayList<Card> stright1 = new ArrayList<Card>();
		//straight 7 9 8 spade club diamond
		stright1.add(new Card('S',7)); 
		stright1.add(new Card('C',9));
		stright1.add(new Card('D',8));
		
		ArrayList<Card> flush1 = new ArrayList<Card>();
		//flush spades 4 10 king higher flush
		flush1.add(new Card('S',4)); 
		flush1.add(new Card('S',10));
		flush1.add(new Card('S',13));
		
		ArrayList<Card> pair1 = new ArrayList<Card>();
		//pocket aces spade heart 3 club higher pair
		pair1.add(new Card('S',14)); 
		pair1.add(new Card('H',14));
		pair1.add(new Card('C',3));
		
		ArrayList<Card> pair2 = new ArrayList<Card>();
		//pocket 10's club heart king spade
		pair2.add(new Card('C',10)); 
		pair2.add(new Card('S',13));
		pair2.add(new Card('H',10));
		
		ArrayList<Card> pair4 = new ArrayList<Card>();
		//pocket 10 diamonds spade and queen
		pair4.add(new Card('D',10)); 
		pair4.add(new Card('S',12));
		pair4.add(new Card('S',10));
		
		ArrayList<Card> threeOfKind1 = new ArrayList<Card>();
		//three 9's heart club diamond higher TOK
		threeOfKind1.add(new Card('H',9)); 
		threeOfKind1.add(new Card('C',9));
		threeOfKind1.add(new Card('D',9));
		
		ArrayList<Card> straightFlush1 = new ArrayList<Card> (); 
		//straight flush ace king queen spades highest order
		straightFlush1.add(new Card('S',14)); 
		straightFlush1.add(new Card('S',13));
		straightFlush1.add(new Card('S',12));
		//tie hands
		assertEquals( 0, ThreeCardLogic.compareHands(straightFlush1 , straightFlush1), "incorrect output: hands should result in tie straight flush");
		assertEquals( 0, ThreeCardLogic.compareHands(threeOfKind1 , threeOfKind1), "incorrect output: hands should result in tie  TOK");
		assertEquals( 0, ThreeCardLogic.compareHands(stright1 , stright1), "incorrect output: hands should result in tie  straight");
		assertEquals( 0, ThreeCardLogic.compareHands(flush1 , flush1), "incorrect output: hands should result in tie  flush");
		assertEquals( 0, ThreeCardLogic.compareHands(pair1 , pair1), "incorrect output: hands should result in tie  pair");
		assertEquals( 1, ThreeCardLogic.compareHands(pair2 , pair4), "incorrect output: hands should result in tie  pair");
		assertEquals( 2, ThreeCardLogic.compareHands(pair4 , pair2), "incorrect output: hands should result in tie  pair");
		assertEquals( 0, ThreeCardLogic.compareHands(highCard , highCard), "incorrect output: hands should result in tie high card");

	}
	
	@Test
	void test_threeCardLogic4(){
		ArrayList<Card> highCard = new ArrayList<Card>();
		//high card ace diamond 10 heart 3 club higher high card
		highCard.add(new Card('D',14)); 
		highCard.add(new Card('H',10));
		highCard.add(new Card('C',3));
		
		ArrayList<Card> stright1 = new ArrayList<Card>();
		//straight 7 9 8 spade club diamond
		stright1.add(new Card('S',7)); 
		stright1.add(new Card('C',9));
		stright1.add(new Card('D',8));
		
		ArrayList<Card> flush1 = new ArrayList<Card>();
		//flush spades 4 10 king higher flush
		flush1.add(new Card('S',4)); 
		flush1.add(new Card('S',10));
		flush1.add(new Card('S',13));
		
		ArrayList<Card> pair1 = new ArrayList<Card>();
		//pocket aces spade heart 3 club higher pair
		pair1.add(new Card('S',14)); 
		pair1.add(new Card('H',14));
		pair1.add(new Card('C',3));
		
		ArrayList<Card> threeOfKind1 = new ArrayList<Card>();
		//three 9's heart club diamond higher TOK
		threeOfKind1.add(new Card('H',9)); 
		threeOfKind1.add(new Card('C',9));
		threeOfKind1.add(new Card('D',9));
		
		ArrayList<Card> straightFlush1 = new ArrayList<Card> (); 
		//straight flush ace king queen spades highest order
		straightFlush1.add(new Card('S',14)); 
		straightFlush1.add(new Card('S',13));
		straightFlush1.add(new Card('S',12));

		//testing evalHand(ArrayList<Card>hand)
		assertEquals( 1, ThreeCardLogic.evalHand(straightFlush1), "incorrect output: evalHand() should return 1");
		assertEquals( 2, ThreeCardLogic.evalHand(threeOfKind1), "incorrect output: evalHand() should return 2");
		assertEquals( 3, ThreeCardLogic.evalHand(stright1), "incorrect output: evalHand() should return 3");
		assertEquals( 4, ThreeCardLogic.evalHand(flush1), "incorrect output: evalHand() should return 4");
		assertEquals( 5, ThreeCardLogic.evalHand(pair1), "incorrect output: evalHand() should return 5");
		assertEquals( 0, ThreeCardLogic.evalHand(highCard), "incorrect output: evalHand() should return 0");
	}
	
}
