import java.util.ArrayList;

public class ThreeCardLogic {
	// sorts hand in ascending order
	// determine hand type 
	public static int evalHand(ArrayList<Card>hand) {

		sortHand(hand);
		boolean threeKind = false;
		boolean straight = false;
		boolean flush = false; 
		boolean pair = false; 
		
		if(hand.get(0).getValue()== hand.get(1).getValue() &&  
			hand.get(0).getValue()== hand.get(2).getValue()) {
			threeKind = true;}
		else if(hand.get(0).getValue()== hand.get(1).getValue() |  
				hand.get(1).getValue()== hand.get(2).getValue()) {
				pair = true;}
		else if(hand.get(1).getValue() == (hand.get(0).getValue()+1) &&
			hand.get(2).getValue() == (hand.get(1).getValue()+1)) {
			straight = true;}
		 
		if(hand.get(0).getSuit()== hand.get(1).getSuit() &&  
			hand.get(0).getSuit()== hand.get(2).getSuit()) {
			flush = true;}

		if(straight && flush) {return 1; }
		else if(threeKind) {return 2;}
		else if(straight) {return 3;}
		else if(flush) {return 4;}
		else if(pair) {return 5;}
		else {return 0;}
		
	}
	public static int evalPPWinnings(ArrayList<Card>hand, int bet) {
		int pairPlus = evalHand(hand);
		if(pairPlus == 5 | pairPlus == 2) {
			return bet * 2;
		}
		return 0;
	}
	public static int compareHands(ArrayList<Card> dealer, ArrayList<Card>player) {
		int house = evalHand(dealer);
		int sucker = evalHand(player);
		int sendVal = -1; // if i get this value something is wrong
		
		if(house == 0 && sucker > 0){return 2;}
		else if (sucker == 0 && house > 0 ) {return 1;} 
		else if(house < sucker) {return 1;}
		else if (sucker < house) {return 2;}
		else if(house == sucker) {
			if(house == 0) {return generalTie(dealer,player);}
			else if(house == 1){return generalTie(dealer,player);}
			else if(house == 2){return generalTie(dealer,player);}
			else if(house == 3){return generalTie(dealer,player);}
			else if(house == 4){return generalTie(dealer,player);}
			else if(house == 5){return pairTie(dealer,player);}
		}
		return sendVal;
	}
	
	//sorts hand low to high
	private static void sortHand(ArrayList<Card>hand){
		int minV;
		int minInd;
		for(int j = 0; j < hand.size(); j++) {
			minV=hand.get(j).getValue();
			minInd=j; 
			for(int i = j+1; i < hand.size(); i++) {
				if (hand.get(i).getValue()<minV) {
					minV = hand.get(i).getValue();
					minInd = i; 
				}
			}
			Card tempCard = new Card(hand.get(j).getSuit(), hand.get(j).getValue());
			hand.set(j,hand.get(minInd));
			hand.set(minInd,tempCard);
		}
	}
	
	
	private static int generalTie(ArrayList<Card> dealer, ArrayList<Card>player) {
		
		if(dealer.get(0).getValue()>player.get(0).getValue()) {return 1;}
		else if(dealer.get(0).getValue()<player.get(0).getValue()) {return 2;}
		
		else if(dealer.get(1).getValue()>player.get(1).getValue()) {return 1;}
		else if(dealer.get(1).getValue()<player.get(1).getValue()) {return 2;}
		
		else if(dealer.get(2).getValue()>player.get(2).getValue()) {return 1;}
		else if(dealer.get(2).getValue()<player.get(2).getValue()) {return 2;}
		return 0;
		}
	
	private static int pairTie(ArrayList<Card> dealer, ArrayList<Card>player) {
		 
		int dealerPariPos =0;
		int dealeroffPair =0;	
		int playerPairPos =0;
		int playeroffPair =0;
		int sendVal = -1; // if i get this value something is wrong
		
		if(dealer.get(1).getValue()== dealer.get(0).getValue()) {
			dealerPariPos =0;
			dealeroffPair =2;
		}
		else if(dealer.get(1).getValue()== dealer.get(2).getValue()) {
			dealerPariPos =1;
			dealeroffPair =0;
		}
		
		if(player.get(1).getValue()== player.get(0).getValue()) {
			playerPairPos =0;
			playeroffPair =2;
		}
		else if(player.get(1).getValue()== player.get(2).getValue()) {
			playerPairPos =1;
			playeroffPair =0;
		}
		
		//if tie pair go to off card for final winner 
		if(dealer.get(dealerPariPos).getValue()>player.get(playerPairPos).getValue()) {return 1;}
		else if(dealer.get(dealerPariPos).getValue()<player.get(playerPairPos).getValue()) {return 2;}
		else if (dealer.get(dealerPariPos).getValue()==player.get(playerPairPos).getValue()) {
			if(dealer.get(dealeroffPair).getValue() > player.get(playeroffPair).getValue()){return 1;}
			else if (dealer.get(dealeroffPair).getValue() < player.get(playeroffPair).getValue()) {return 2;}
			else if (dealer.get(dealeroffPair).getValue() == player.get(playeroffPair).getValue()) {return 0;}
		}
		
		return sendVal; // if i get this value something is wrong
	}
}
