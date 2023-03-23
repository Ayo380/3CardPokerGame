import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import java.awt.*;
import java.util.ArrayList;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;



public class JavaFXTemplate extends Application {
	int P1pp = 0;
	static int action = 0,confirm = 0, play_or_fold = 0;
	static int P1AB= 5;
	static int play1_play = 0,play2_play = 0;
	int P2pp = 0;
	static int P2AB= 5;
	int P1PB=0;
	int P2PB=0;
	int P1TW = 0;
	int P2TW = 0;
	static boolean player1_play,player1_fold;
	static boolean player2_play,player2_fold;
	private Stage stage;  // main stage
	private Scene scene1; // first scene
	private Button start;
	String prompt_text2,prompt_text = "";
	private Scene scene2;
	Button PairPlus; 
   //TextField prompt;
//	private Button Ante; 
//	private Button Confirm;
//	private Button Fold; 
//	private Button Play;
	
	private Scene scene3;
	private HBox h1;
	
	private Scene scene4;
	
	// players and dealers eval hands 
	int play1_dealer;
	int play2_dealer;
	
	Button DealerCard1;
	Button DealerCard2;
	Button DealerCard3;
	
	Button Player1Card1;
	Button Player1Card2;
	Button Player1Card3;

	Button Player2Card1;
	Button Player2Card2;
	Button Player2Card3;
	
	Player playerOne;
	Player PlayerTwo;
	Dealer theDealer;
	private EventHandler<ActionEvent> myHandler;
	private BorderPane borderP;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
	}
	
	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		stage = primaryStage; 
		playerOne = new Player();
		PlayerTwo = new Player();
		theDealer = new Dealer();
		stage.setTitle("Welcome to Project #2");
		
		scene1= createStartScene();
		scene2= createBetScreen();
		scene3 = createEndScreen();
		//scene4  //createNewLookScreen();

		stage.setScene(scene1);

		stage.show();
	}
	
	private Scene createStartScene() {
			// button and textfield for the start page
			start = new Button("Start");
			start.setPrefHeight(50.0);
			start.setPrefWidth(100.0);
			start.setStyle("-fx-background-color: red");
			start.setOnAction(e->switchScene(scene2));
			
			//start_field text box details
			TextField start_field1 = new TextField("THREE CARD POKER");
			start_field1.setEditable(false);
			start_field1.setStyle("-fx-background-color: green");
			start_field1.setPrefWidth(200.0);
			start_field1.setAlignment(Pos.CENTER);
			
			TextField start_field2 = new TextField("You will be dealt 3 cards.");
			start_field2.setEditable(false);
			start_field2.setStyle("-fx-background-color: green");
			start_field2.setPrefWidth(200.0);
			start_field2.setAlignment(Pos.CENTER);
			
			TextField start_field3 = new TextField("Each player plays against the dealer individually");
			start_field3.setEditable(false);
			start_field3.setStyle("-fx-background-color: green");
			start_field3.setPrefWidth(200.0);
			start_field3.setAlignment(Pos.CENTER);
			
			TextField start_field4 = new TextField("You can place 3 bets: Ante, Pair Plus, Play");
			start_field4.setEditable(false);
			start_field4.setStyle("-fx-background-color: green");
			start_field4.setPrefWidth(200.0);
			start_field4.setAlignment(Pos.CENTER);
			
			TextField start_field5 = new TextField("Precard bets: Pair Plus, Ante");
			start_field5.setEditable(false);
			start_field5.setStyle("-fx-background-color: green");
			start_field5.setPrefWidth(200.0);
			start_field5.setAlignment(Pos.CENTER);
			
			TextField start_field6 = new TextField("Post Card Bet: Play");
			start_field6.setEditable(false);
			start_field6.setStyle("-fx-background-color: green");
			start_field6.setPrefWidth(200.0);
			start_field6.setAlignment(Pos.CENTER);
			
			TextField start_field7 = new TextField("Payouts: Straight Flush 40:1");
			start_field7.setEditable(false);
			start_field7.setStyle("-fx-background-color: green");
			start_field7.setPrefWidth(200.0);
			start_field7.setAlignment(Pos.CENTER);
			
			TextField start_field8 = new TextField("Three of a Kind 30:1");
			start_field8.setEditable(false);
			start_field8.setStyle("-fx-background-color: green");
			start_field8.setPrefWidth(200.0);
			start_field8.setAlignment(Pos.CENTER);
			
			TextField start_field9 = new TextField( "Straight 6:1");
			start_field9.setEditable(false);
			start_field9.setStyle("-fx-background-color: green");
			start_field9.setPrefWidth(200.0);
			start_field9.setAlignment(Pos.CENTER);
			
			TextField start_field10 = new TextField("Flush 3:1");
			start_field10.setEditable(false);
			start_field10.setStyle("-fx-background-color: green");
			start_field10.setPrefWidth(200.0);
			start_field10.setAlignment(Pos.CENTER);
			
			TextField start_field11 = new TextField("Pair 1:1");
			start_field11.setEditable(false);
			start_field11.setStyle("-fx-background-color: green");
			start_field11.setPrefWidth(200.0);
			start_field11.setAlignment(Pos.CENTER);
			
			VBox rules = new VBox(start_field1,start_field2,start_field3,
					start_field4,start_field5,start_field6,start_field7,
					start_field8,start_field9,start_field10,start_field11,start);
			
		rules.setAlignment(Pos.CENTER);
		borderP = new BorderPane();
		borderP.setStyle("-fx-background-color: green");
		borderP.setCenter(rules);
		scene1= new Scene(borderP,1200,700);
		//scene1= new Scene(borderP);
		return scene1;
	}
	
	private Scene createBetScreen() {
		BorderPane bp = new BorderPane();
		GridPane gameTable = new GridPane();
		gameTable.setHgap(20);
		gameTable.setVgap(20);
		bp.setCenter(gameTable);
		bp.setStyle("-fx-background-color: green");
		
		//dealer cards
		DealerCard1 = new Button("DC");
		DealerCard1.setPrefHeight(100.0);
		DealerCard1.setPrefWidth(60.0);
		
		DealerCard2 = new Button("DC");
		DealerCard2.setPrefHeight(100.0);
		DealerCard2.setPrefWidth(60.0);
		
		DealerCard3 = new Button("DC");
		DealerCard3.setPrefHeight(100.0);
		DealerCard3.setPrefWidth(60.0);
		
		HBox dealerHand = new HBox(DealerCard1,DealerCard2,DealerCard3);
		
		//player1 cards
		Player1Card1 = new Button("P1C");
		Player1Card1.setPrefHeight(100.0);
		Player1Card1.setPrefWidth(60.0);

		Player1Card2 = new Button("P1C");
		Player1Card2.setPrefHeight(100.0);
		Player1Card2.setPrefWidth(60.0);

		Player1Card3 = new Button("P1C");
		Player1Card3.setPrefHeight(100.0);
		Player1Card3.setPrefWidth(60.0);
		
		HBox Player1Hand = new HBox(Player1Card1,Player1Card2,Player1Card3);

		//player2 cards
		Player2Card1 = new Button("P2C");
		Player2Card1.setPrefHeight(100.0);
		Player2Card1.setPrefWidth(60.0);

		Player2Card2 = new Button("P2C");
		Player2Card2.setPrefHeight(100.0);
		Player2Card2.setPrefWidth(60.0);
		
		Player2Card3 = new Button("P2C");
		Player2Card3.setPrefHeight(100.0);
		Player2Card3.setPrefWidth(60.0);
		
		HBox Player2Hand = new HBox(Player2Card1,Player2Card2,Player2Card3);
		
		Button PlayAgain = new Button("Play Again");
		PlayAgain.setPrefHeight(50.0);
		PlayAgain.setPrefWidth(180.0);
		
		//bet buttons
		Button PairPlus = new Button("PairPlus");
		PairPlus.setPrefHeight(50.0);
		PairPlus.setPrefWidth(180.0);
		
		Button Ante = new Button("Ante");
		Ante.setPrefHeight(50.0);
		Ante.setPrefWidth(180.0);
		
		Button Confirm = new Button("Confirm");
		Confirm.setPrefHeight(50.0);
		Confirm.setPrefWidth(180.0);
		
		Button Fold = new Button("Fold");
		Fold.setPrefHeight(50.0);
		Fold.setPrefWidth(180.0);
		
		Button Play = new Button("Play");
		Play.setPrefHeight(50.0);
		Play.setPrefWidth(180.0);
		
		//make this in each scene so the message can change
        prompt_text = "Player1: Bet PairPlus, Ante";
        TextField prompt = new TextField(prompt_text);
        prompt.setPrefHeight(50.0);
        prompt.setPrefWidth(180.0);
        prompt.setEditable(false);

        TextField prompt2 = new TextField();
        prompt2.setPrefHeight(50.0);
        prompt2.setPrefWidth(180.0);
        prompt2.setEditable(false);

        TextField prompt3 = new TextField();
        prompt3.setPrefHeight(50.0);
        prompt3.setPrefWidth(180.0);
        prompt3.setEditable(false);

        TextField prompt4 = new TextField();
        prompt4.setPrefHeight(50.0);
        prompt4.setPrefWidth(180.0);
        prompt4.setEditable(false);

        TextField prompt5 = new TextField();
        prompt5.setPrefHeight(50.0);
        prompt5.setPrefWidth(180.0);
        prompt5.setEditable(false);
        VBox promptText = new VBox(prompt,prompt2,prompt3,prompt4,prompt5);
		
		TextField dealerName = new TextField("Dealer: Casino");
		dealerName.setPrefWidth(170.0);
		dealerName.setAlignment(Pos.CENTER);
		dealerName.setEditable(false);
		
		//text for player 1 money 
//		int P1pp = 0;
		TextField player1PP = new TextField("Pair Plus: " + P1pp);
		player1PP.setPrefWidth(170.0);
		player1PP.setAlignment(Pos.CENTER);
		player1PP.setEditable(false);
		 
		
		TextField player1AB = new TextField("Ante: " + P1AB );
		player1AB.setPrefWidth(170.0);
		player1AB.setAlignment(Pos.CENTER);
		player1AB.setEditable(false);
		
		
		TextField player1PB = new TextField("Play Bet: " + P1PB);
		player1PB.setPrefWidth(170.0);
		player1PB.setAlignment(Pos.CENTER);
		player1PB.setEditable(false);
		
		TextField player1TW = new TextField("Total Winnings: " +P1TW);
		player1TW.setPrefWidth(170.0);
		player1TW.setAlignment(Pos.CENTER);
		player1TW.setEditable(false);
		
		VBox player1Text = new VBox(player1PP,player1AB,player1PB,player1TW);
		
		//text for player 2 money 
		
		TextField player2PP = new TextField("Pair Plus: " + P2pp);
		player2PP.setPrefWidth(170.0);
		player2PP.setAlignment(Pos.CENTER);
		player2PP.setEditable(false);
		 
		
		TextField player2AB = new TextField("Ante: " + P2AB );
		player2AB.setPrefWidth(170.0);
		player2AB.setAlignment(Pos.CENTER);
		player2AB.setEditable(false);
		
		
		TextField player2PB = new TextField("Play Bet: " + P2PB);
		player2PB.setPrefWidth(170.0);
		player2PB.setAlignment(Pos.CENTER);
		player2PB.setEditable(false);
		
		
		TextField player2TW = new TextField("Total Winnings: " +P2TW);
		player2TW.setPrefWidth(170.0);
		player2TW.setAlignment(Pos.CENTER);
		player2TW.setEditable(false);
		
		VBox player2Text = new VBox(player2PP,player2AB,player2PB,player2TW);
		
		TextField playerName1 = new TextField("Player1");
		playerName1.setPrefWidth(170.0);
		playerName1.setAlignment(Pos.CENTER);
		playerName1.setEditable(false);
		
		TextField playerName2 = new TextField("Player2");
		playerName2.setPrefWidth(170.0);
		playerName2.setAlignment(Pos.CENTER);
		playerName2.setEditable(false);
		
		MenuBar option = new MenuBar(); //a menu bar takes menus as children
		Menu menu = new Menu("Menu"); //a menu goes inside a menu bar
		MenuItem Fresh_start = new MenuItem("Fresh Start");
		MenuItem mTwo = new MenuItem("NewLook");
		MenuItem Exit = new MenuItem("Exit");
		
		Exit.setOnAction(e->switchScene(scene3));
		//Fresh_start.setOnAction(e->switchScene(scene1));
		Fresh_start.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent actionEvent) {
	        	Play.setDisable(true);
				Fold.setDisable(true);
				PlayAgain.setDisable(true);
				action = 0;
				confirm = 0;
				play_or_fold = 0;
				PairPlus.setDisable(false);
				Ante.setDisable(false);
				Confirm.setDisable(false);
				Player1Card1.setText("P1C");
				Player1Card2.setText("P1C");
				Player1Card3.setText("P1C");
				Player2Card1.setText("P2C");
				Player2Card2.setText("P2C");
				Player2Card3.setText("P2C");
				theDealer.check_size();
				DealerCard1.setText("DC");
				DealerCard2.setText("DC");
				DealerCard3.setText("DC");
				player1PP.setText("Pair Plus: " + (0));
				player2PP.setText("Pair Plus: " + (0));
				player1AB.setText("Ante: " + 5 );
				player2AB.setText("Ante: " + 5 );	
				player1PB.setText("Play Bet: " + 0);
				player2PB.setText("Play Bet: " + 0);
				player1TW.setText("Total Winnings: " +0);
				player2TW.setText("Total Winnings: " +0);
				prompt.setText("Player1: Bet PairPlus, Ante");
				prompt2.clear();
				prompt3.clear();
				prompt4.clear();
				playerOne.set_pairPlusBet(0);
				PlayerTwo.set_pairPlusBet(0);
				switchScene(scene1);
	        }});
		mTwo.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent actionEvent) {
	            bp.setStyle("-fx-background-color: CORAL");
	            PairPlus.setStyle("-fx-background-color: HOTPINK");
	            promptText.setStyle("-fx-background-color: HOTPINK");
	            Ante.setStyle("-fx-background-color: HOTPINK");
	            Confirm.setStyle("-fx-background-color: HOTPINK");
	            Fold.setStyle("-fx-background-color: HOTPINK");
	            Play.setStyle("-fx-background-color: HOTPINK");
	            dealerHand.setStyle("-fx-background-color: HOTPINK");
	            Player1Hand.setStyle("-fx-background-color: HOTPINK");
	            Player2Hand.setStyle("-fx-background-color: HOTPINK");
	            dealerName.setStyle("-fx-background-color: HOTPINK");
	            playerName1.setStyle("-fx-background-color: HOTPINK");
	            playerName2.setStyle("-fx-background-color: HOTPINK");
	            player1Text.setStyle("-fx-background-color: HOTPINK");
	            player2Text.setStyle("-fx-background-color: HOTPINK");
	            PlayAgain.setStyle("-fx-background-color: HOTPINK");
	        }});
		//mTwo.setOnAction(e->switchScene(scene4));
		//eventHandler for New look scene yet to be created
		option.getMenus().addAll(menu); 
		menu.getItems().addAll(Fresh_start,mTwo,Exit); //add menu item to menu
		VBox v1 = new VBox(20,option);
		bp.setTop(v1);
		PlayAgain.setDisable(true);
		Play.setDisable(true);
		Fold.setDisable(true);
		PlayAgain.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				Play.setDisable(true);
				Fold.setDisable(true);
				PlayAgain.setDisable(true);
				action = 0;
				confirm = 0;
				play_or_fold = 0;
				PairPlus.setDisable(false);
				Ante.setDisable(false);
				Confirm.setDisable(false);
				Player1Card1.setText("P1C");
				Player1Card2.setText("P1C");
				Player1Card3.setText("P1C");
				Player2Card1.setText("P2C");
				Player2Card2.setText("P2C");
				Player2Card3.setText("P2C");
				theDealer.check_size();
				DealerCard1.setText("DC");
				DealerCard2.setText("DC");
				DealerCard3.setText("DC");
				player1PP.setText("Pair Plus: " + (0));
				player2PP.setText("Pair Plus: " + (0));
				player1AB.setText("Ante: " + 5 );
				player2AB.setText("Ante: " + 5 );	
				player1PB.setText("Play Bet: " + 0);
				player2PB.setText("Play Bet: " + 0);
				prompt.setText("Player1: Bet PairPlus, Ante");
				prompt2.clear();
				prompt3.clear();
				prompt4.clear();
				playerOne.set_pairPlusBet(0);
				PlayerTwo.set_pairPlusBet(0);
				
			}});
		PairPlus.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				Confirm.setDisable(false);
				System.out.print(PairPlus.isDisable());
			if(action == 0) {
				player1PP.clear();
				P1pp += 5;
				if(P1pp > 25) {
					P1pp = 0;
				}
				player1PP.setText("Pair Plus: " + (P1pp));
				}
			else if(action == 1) {
				player2PP.clear();
				P2pp +=5;
				if(P2pp > 25) {
					P2pp = 0;
				}
				confirm = 1;
				player2PP.setText("Pair Plus: " + (P2pp));
			}
			}});
		Ante.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				Confirm.setDisable(false);
				if(action == 0) {
				player1AB.clear();
				P1AB += 5;
				if(P1AB > 25) {
					P1AB = 0;
				}
				player1AB.setText("Ante: " + P1AB );
				}
				
			else if(action == 1) {
				player2AB.clear();
				P2AB += 5;
				if(P2AB > 25) {
					P2AB = 0;
				}
				confirm = 1;
				player2AB.setText("Ante: " + P2AB );	
			}
			}});
		System.out.println(P1AB);System.out.println(P2AB);
		
		Confirm.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				if(confirm == 0) {
				action = 1;
				confirm = 1;
				prompt.clear();
				prompt_text = "Player2: Bet PairPlus, Ante";
				prompt.setText(prompt_text);
				playerOne.set_hand(theDealer.dealHand());
				
				playerOne.set_anteBet(P1AB);
				playerOne.set_pairPlusBet(P1pp);
				
				playerOne.get_hand();
				playerOne.get_hand().get(0).getValue();
				
				if( playerOne.get_hand().get(0).getValue() == 14) {
					Player1Card1.setText("A" + " " + playerOne.get_hand().get(0).getSuit());
				}
				else if(playerOne.get_hand().get(0).getValue() == 13) {
					Player1Card1.setText("K" + " " + playerOne.get_hand().get(0).getSuit());
				}
				else if(playerOne.get_hand().get(0).getValue() == 12) {
					Player1Card1.setText("Q" + " " + playerOne.get_hand().get(0).getSuit());
				}
				else if(playerOne.get_hand().get(0).getValue() == 11) {
					Player1Card1.setText("J" + " " + playerOne.get_hand().get(0).getSuit());
				}
				else {
					Player1Card1.setText(playerOne.get_hand().get(0).getValue() 
						+ " " + playerOne.get_hand().get(0).getSuit());	}
				
				
				if( playerOne.get_hand().get(1).getValue() == 14) {
					Player1Card2.setText("A" + " " + playerOne.get_hand().get(1).getSuit());
				}
				else if(playerOne.get_hand().get(1).getValue() == 14) {
					Player1Card2.setText("K" + " " + playerOne.get_hand().get(1).getSuit());
				}
				else if(playerOne.get_hand().get(1).getValue() == 12) {
					Player1Card2.setText("Q" + " " + playerOne.get_hand().get(1).getSuit());
				}
				else if(playerOne.get_hand().get(1).getValue() == 11) {
					Player1Card2.setText("J" + " " + playerOne.get_hand().get(1).getSuit());
				}
				else {
					Player1Card2.setText(playerOne.get_hand().get(1).getValue() 
						+ " " + playerOne.get_hand().get(1).getSuit());	}
				
				
				if( playerOne.get_hand().get(2).getValue() == 14) {
					Player1Card3.setText("A" + " " + playerOne.get_hand().get(2).getSuit());
				}
				else if(playerOne.get_hand().get(2).getValue() == 14) {
					Player1Card3.setText("K" + " " + playerOne.get_hand().get(2).getSuit());
				}
				else if(playerOne.get_hand().get(2).getValue() == 12) {
					Player1Card3.setText("Q" + " " + playerOne.get_hand().get(2).getSuit());
				}
				else if(playerOne.get_hand().get(2).getValue() == 11) {
					Player1Card3.setText("J" + " " + playerOne.get_hand().get(2).getSuit());
				}
				else {
					Player1Card3.setText(playerOne.get_hand().get(2).getValue() 
						+ " " + playerOne.get_hand().get(2).getSuit());	}

				}
				else if(confirm == 1) {
					
					prompt.clear();
					prompt_text = "Player1: Play or Fold";
					prompt.setText(prompt_text);
					Play.setDisable(false);
					Fold.setDisable(false);
					Confirm.setDisable(true);
					Ante.setDisable(true);
					PairPlus.setDisable(true);
					
					PlayerTwo.set_anteBet(P2AB);
					PlayerTwo.set_pairPlusBet(P2pp);

					// deal out the cards
					//wait(6000);
					theDealer.deal_dealer();
					playerOne.set_hand(theDealer.dealHand());
					PlayerTwo.set_hand(theDealer.dealHand());
					
					if( PlayerTwo.get_hand().get(0).getValue() == 14) {
						Player2Card1.setText("A" + " " + PlayerTwo.get_hand().get(0).getSuit());
					}
					else if(PlayerTwo.get_hand().get(0).getValue() == 13) {
						Player2Card1.setText("K" + " " + PlayerTwo.get_hand().get(0).getSuit());
					}
					else if(PlayerTwo.get_hand().get(0).getValue() == 12) {
						Player2Card1.setText("Q" + " " + PlayerTwo.get_hand().get(0).getSuit());
					}
					else if(PlayerTwo.get_hand().get(0).getValue() == 11) {
						Player2Card1.setText("J" + " " + PlayerTwo.get_hand().get(0).getSuit());
					}
					else {
						Player2Card1.setText(PlayerTwo.get_hand().get(0).getValue() 
							+ " " + PlayerTwo.get_hand().get(0).getSuit());	}
					
					
					if( PlayerTwo.get_hand().get(1).getValue() == 14) {
						Player2Card2.setText("A" + " " + PlayerTwo.get_hand().get(1).getSuit());
					}
					else if(PlayerTwo.get_hand().get(1).getValue() == 14) {
						Player2Card2.setText("K" + " " + PlayerTwo.get_hand().get(1).getSuit());
					}
					else if(PlayerTwo.get_hand().get(1).getValue() == 12) {
						Player2Card2.setText("Q" + " " + PlayerTwo.get_hand().get(1).getSuit());
					}
					else if(PlayerTwo.get_hand().get(1).getValue() == 11) {
						Player2Card2.setText("J" + " " + PlayerTwo.get_hand().get(1).getSuit());
					}
					else {
						Player2Card2.setText(PlayerTwo.get_hand().get(1).getValue() 
							+ " " + PlayerTwo.get_hand().get(1).getSuit());	}
					
					
					if( PlayerTwo.get_hand().get(2).getValue() == 14) {
						Player2Card3.setText("A" + " " + PlayerTwo.get_hand().get(2).getSuit());
					}
					else if(PlayerTwo.get_hand().get(2).getValue() == 14) {
						Player2Card3.setText("K" + " " + PlayerTwo.get_hand().get(2).getSuit());
					}
					else if(PlayerTwo.get_hand().get(2).getValue() == 12) {
						Player2Card3.setText("Q" + " " + PlayerTwo.get_hand().get(2).getSuit());
					}
					else if(PlayerTwo.get_hand().get(2).getValue() == 11) {
						Player2Card3.setText("J" + " " + PlayerTwo.get_hand().get(2).getSuit());
					}
					else {
						Player2Card3.setText(PlayerTwo.get_hand().get(2).getValue() 
							+ " " + PlayerTwo.get_hand().get(2).getSuit());	}
				}
			}});
		Play.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				Confirm.setDisable(true);
				//player1 play
				if(play_or_fold == 0) {
					prompt.clear();
					play_or_fold = 1;
					playerOne.set_playBet(P1AB);
					play1_play = 1;
					System.out.println(P1AB);
					player1PB.setText("Play Bet: " + P1AB);
					prompt_text = "Player2: Play or Fold";
					prompt.setText(prompt_text);
				//player2 play
				}else if (play_or_fold == 1) {
					prompt.clear();
					Play.setDisable(true);
					Fold.setDisable(true);
					PlayAgain.setDisable(false);
					play2_play = 1;
					PlayerTwo.set_playBet(P2AB);
					System.out.println(P2AB);
					player2PB.setText("Play Bet: " + P2AB);
					prompt_text = "GoodLuck";
					prompt.setText(prompt_text);
					if(play1_play == 1 || play2_play == 1) {
						if( theDealer.get_hand().get(0).getValue() == 14) {
							DealerCard1.setText("A" + " " + theDealer.get_hand().get(0).getSuit());
						}
						else if(theDealer.get_hand().get(0).getValue() == 13) {
							DealerCard1.setText("K" + " " + theDealer.get_hand().get(0).getSuit());
						}
						else if(theDealer.get_hand().get(0).getValue() == 12) {
							DealerCard1.setText("Q" + " " + theDealer.get_hand().get(0).getSuit());
						}
						else if(theDealer.get_hand().get(0).getValue() == 11) {
							DealerCard1.setText("J" + " " + theDealer.get_hand().get(0).getSuit());
						}
						else {
							DealerCard1.setText(theDealer.get_hand().get(0).getValue() 
								+ " " + theDealer.get_hand().get(0).getSuit());	}
						
						
						if( theDealer.get_hand().get(1).getValue() == 14) {
							DealerCard2.setText("A" + " " + theDealer.get_hand().get(1).getSuit());
						}
						else if(theDealer.get_hand().get(1).getValue() == 13) {
							DealerCard2.setText("K" + " " + theDealer.get_hand().get(1).getSuit());
						}
						else if(theDealer.get_hand().get(1).getValue() == 12) {
							DealerCard2.setText("Q" + " " + theDealer.get_hand().get(1).getSuit());
						}
						else if(theDealer.get_hand().get(1).getValue() == 11) {
							DealerCard2.setText("J" + " " + theDealer.get_hand().get(1).getSuit());
						}
						else {
							DealerCard2.setText(theDealer.get_hand().get(1).getValue() 
								+ " " + theDealer.get_hand().get(1).getSuit());	}
						
						
						if( theDealer.get_hand().get(2).getValue() == 14) {
							DealerCard3.setText("A" + " " + theDealer.get_hand().get(2).getSuit());
						}
						else if(theDealer.get_hand().get(2).getValue() == 13) {
							DealerCard3.setText("K" + " " + theDealer.get_hand().get(2).getSuit());
						}
						else if(theDealer.get_hand().get(2).getValue() == 12) {
							DealerCard3.setText("Q" + " " + theDealer.get_hand().get(2).getSuit());
						}
						else if(theDealer.get_hand().get(2).getValue() == 11) {
							DealerCard3.setText("J" + " " + theDealer.get_hand().get(2).getSuit());
						}
						else {
							DealerCard3.setText(theDealer.get_hand().get(2).getValue() 
								+ " " + theDealer.get_hand().get(2).getSuit());	}
						//both play
						if(play1_play == 1 && play2_play == 1) {
							prompt.clear();
							prompt_text  = "";
							//int play1_dealer;
							//int play2_dealer;
							play2_dealer = ThreeCardLogic.compareHands(theDealer.get_hand(),PlayerTwo.get_hand());
							play1_dealer = ThreeCardLogic.compareHands( theDealer.get_hand(),playerOne.get_hand());
								if(play2_dealer == 0) {
									prompt_text2 = "PLAYER2 TIED DEALER";
									PlayerTwo.set_totalWinning(PlayerTwo.get_playBet());
								}else if(play2_dealer == 1) {
									prompt_text2 = "DEALER BEAT PLAYER2";
									
									PlayerTwo.set_totalWinning(PlayerTwo.get_totalWinning()-PlayerTwo.get_playBet()-PlayerTwo.get_anteBet());
								}else if(play2_dealer == 2) {
									prompt_text2 = "PLAYER2 BEAT DEALER";
									if(ThreeCardLogic.evalHand(PlayerTwo.get_hand())== 1) {
										PlayerTwo.set_totalWinning((PlayerTwo.get_anteBet()+PlayerTwo.get_playBet())*40);// times 40
									}else if(ThreeCardLogic.evalHand(PlayerTwo.get_hand())== 2) {
										PlayerTwo.set_totalWinning((PlayerTwo.get_anteBet()+PlayerTwo.get_playBet())*30); //times 30
									}else if(ThreeCardLogic.evalHand(PlayerTwo.get_hand())== 3) {
										PlayerTwo.set_totalWinning((PlayerTwo.get_anteBet()+PlayerTwo.get_playBet())*6);; //times 6
									}else if(ThreeCardLogic.evalHand(PlayerTwo.get_hand())==4) {
										PlayerTwo.set_totalWinning((PlayerTwo.get_anteBet()+PlayerTwo.get_playBet())*3);; //times 3
									}else if(ThreeCardLogic.evalHand(PlayerTwo.get_hand())== 5) {
										PlayerTwo.set_totalWinning((PlayerTwo.get_anteBet()+PlayerTwo.get_playBet())*1);; //times 1
									}
								}
								if(play1_dealer == 0) {
									prompt_text = "PLAYER1 TIED DEALER";
									playerOne.set_totalWinning(playerOne.get_playBet());
								}else if(play1_dealer == 1) {
									prompt_text = "DEALER BEAT PLAYER1";
									playerOne.set_totalWinning(playerOne.get_totalWinning()-playerOne.get_playBet()-playerOne.get_anteBet());
								}else if(play1_dealer == 2) {
									prompt_text = "PLAYER1 BEAT DEALER";
									if(ThreeCardLogic.evalHand(playerOne.get_hand())== 1) {
										playerOne.set_totalWinning((playerOne.get_anteBet()+playerOne.get_playBet())*40);// times 40
									}else if(ThreeCardLogic.evalHand(playerOne.get_hand())== 2) {
										playerOne.set_totalWinning((playerOne.get_anteBet()+playerOne.get_playBet())*30); //times 30
									}else if(ThreeCardLogic.evalHand(playerOne.get_hand())== 3) {
										playerOne.set_totalWinning((playerOne.get_anteBet()+playerOne.get_playBet())*6);; //times 6
									}else if(ThreeCardLogic.evalHand(playerOne.get_hand())==4) {
										playerOne.set_totalWinning((playerOne.get_anteBet()+playerOne.get_playBet())*3);; //times 3
									}else if(ThreeCardLogic.evalHand(playerOne.get_hand())== 5) {
										playerOne.set_totalWinning((playerOne.get_anteBet()+playerOne.get_playBet())*1);; //times 1
									}
								}
							//prompt.clear();
							prompt.setText(prompt_text);
							prompt2.setText(prompt_text2);
							if (playerOne.get_pairPlusBet() > 0) {
								if(ThreeCardLogic.evalPPWinnings(playerOne.get_hand(), playerOne.get_pairPlusBet())==0) {
								prompt4.setText("PLAYER1 LOST PAIR PLUS");
								}
								else {
								prompt4.setText("PLAYER1 WON PAIR PLUS");}
							}
							else {
								prompt4.setText("");
							}
							if (PlayerTwo.get_pairPlusBet() > 0) {
								if(ThreeCardLogic.evalPPWinnings(PlayerTwo.get_hand(), PlayerTwo.get_pairPlusBet())==0) {
									prompt3.setText("PLAYER2 LOST PAIR PLUS");
									}
								else {
									prompt3.setText("PLAYER2 WON PAIR PLUS");}
							}
							else {
								prompt3.setText("");
							}
							//update the winnings for player1
							
							// update the winnings for player2
						}else if (play1_play == 0 && play2_play == 1) {
							prompt.clear();
							prompt_text  = "";
							play2_dealer = ThreeCardLogic.compareHands( theDealer.get_hand(),PlayerTwo.get_hand());
							if(play2_dealer == 0) {
								prompt_text = "PLAYER2 TIED DEALER";
								PlayerTwo.set_totalWinning(PlayerTwo.get_playBet());
							}else if(play2_dealer == 1) {
								prompt_text = "DEALER BEAT PLAYER2";
								PlayerTwo.set_totalWinning(PlayerTwo.get_totalWinning()-PlayerTwo.get_playBet()-PlayerTwo.get_anteBet());
							}else if(play2_dealer == 2) {
								prompt_text = "PLAYER2 BEAT DEALER";
								if(ThreeCardLogic.evalHand(PlayerTwo.get_hand())== 1) {
									PlayerTwo.set_totalWinning((PlayerTwo.get_anteBet()+PlayerTwo.get_playBet())*40);// times 40
								}else if(ThreeCardLogic.evalHand(PlayerTwo.get_hand())== 2) {
									PlayerTwo.set_totalWinning((PlayerTwo.get_anteBet()+PlayerTwo.get_playBet())*30); //times 30
								}else if(ThreeCardLogic.evalHand(PlayerTwo.get_hand())== 3) {
									PlayerTwo.set_totalWinning((PlayerTwo.get_anteBet()+PlayerTwo.get_playBet())*6);; //times 6
								}else if(ThreeCardLogic.evalHand(PlayerTwo.get_hand())==4) {
									PlayerTwo.set_totalWinning((PlayerTwo.get_anteBet()+PlayerTwo.get_playBet())*3);; //times 3
								}else if(ThreeCardLogic.evalHand(PlayerTwo.get_hand())== 5) {
									PlayerTwo.set_totalWinning((PlayerTwo.get_anteBet()+PlayerTwo.get_playBet())*1);; //times 1
								}
							}
							prompt2.setText(prompt_text);
							if (PlayerTwo.get_pairPlusBet() > 0) {
								if(ThreeCardLogic.evalPPWinnings(PlayerTwo.get_hand(), PlayerTwo.get_pairPlusBet())==0) {
									prompt3.setText("PLAYER2 LOST PAIR PLUS");
									PlayerTwo.set_totalWinning(PlayerTwo.get_totalWinning()-PlayerTwo.get_pairPlusBet());
									}
								else {
									prompt3.setText("PLAYER2 WON PAIR PLUS");
									PlayerTwo.set_totalWinning(PlayerTwo.get_totalWinning()+PlayerTwo.get_pairPlusBet());}
							}
							else {
								prompt3.setText("");
							}
						}
						else if(play1_play == 1 && play2_play == 0) {
							prompt.clear();
							prompt_text  = "";
							play1_dealer = ThreeCardLogic.compareHands(theDealer.get_hand(),playerOne.get_hand());
							if(play1_dealer == 0) {
								prompt_text = "PLAYER1 TIED DEALER";
								playerOne.set_totalWinning(playerOne.get_playBet());
							}else if(play1_dealer == 1) {
								prompt_text = "DEALER BEAT PLAYER1";
								playerOne.set_totalWinning(playerOne.get_totalWinning()-playerOne.get_playBet()-playerOne.get_anteBet());
							}else if(play1_dealer == 2) {
								prompt_text = "PLAYER1 BEAT DEALER";
								if(ThreeCardLogic.evalHand(playerOne.get_hand())== 1) {
									playerOne.set_totalWinning((playerOne.get_anteBet()+playerOne.get_playBet())*40);// times 40
								}else if(ThreeCardLogic.evalHand(playerOne.get_hand())== 2) {
									playerOne.set_totalWinning((playerOne.get_anteBet()+playerOne.get_playBet())*30); //times 30
								}else if(ThreeCardLogic.evalHand(playerOne.get_hand())== 3) {
									playerOne.set_totalWinning((playerOne.get_anteBet()+playerOne.get_playBet())*6);; //times 6
								}else if(ThreeCardLogic.evalHand(playerOne.get_hand())==4) {
									playerOne.set_totalWinning((playerOne.get_anteBet()+playerOne.get_playBet())*3);; //times 3
								}else if(ThreeCardLogic.evalHand(playerOne.get_hand())== 5) {
									playerOne.set_totalWinning((playerOne.get_anteBet()+playerOne.get_playBet())*1);; //times 1
								}
							}
							prompt.setText(prompt_text);
							if (playerOne.get_pairPlusBet() > 0) {
								if(ThreeCardLogic.evalPPWinnings(playerOne.get_hand(), playerOne.get_pairPlusBet())==0) {
								prompt4.setText("PLAYER1 LOST PAIR PLUS");
								playerOne.set_totalWinning(playerOne.get_totalWinning()-playerOne.get_pairPlusBet());
								}
								else {
								prompt4.setText("PLAYER1 WON PAIR PLUS");
								playerOne.set_totalWinning(playerOne.get_totalWinning()+playerOne.get_pairPlusBet());}
							}
							else {
								prompt4.setText("");
							}
						}
						else {
							prompt_text  = "";
							prompt.clear();
						}
						}
					player1TW.setText("Total Winnings: " +playerOne.get_totalWinning());
					player2TW.setText("Total Winnings: " +PlayerTwo.get_totalWinning());
				}
				
			}});
		
		Fold.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				Confirm.setDisable(true);
				// player1 fold
				if(play_or_fold == 0) {
					prompt.clear();
					play_or_fold = 1;
					prompt_text = "Player2: Play or Fold";
					prompt.setText(prompt_text);
					Player1Card1.setText("P1C");
					Player1Card2.setText("P1C");
					Player1Card3.setText("P1C");
				// player2 fold 
				}else if (play_or_fold == 1) {
					prompt.clear();
					Play.setDisable(true);
					PlayAgain.setDisable(false);
					Fold.setDisable(true);
					prompt_text = "BOTH FOLDED";
					prompt.setText(prompt_text);
					Player2Card1.setText("P2C");
					Player2Card2.setText("P2C");
					Player2Card3.setText("P2C");
				}	
				if(play1_play == 1 || play2_play == 1  ) {	
				if( theDealer.get_hand().get(0).getValue() == 14) {
					DealerCard1.setText("A" + " " + theDealer.get_hand().get(0).getSuit());
				}
				else if(theDealer.get_hand().get(0).getValue() == 13) {
					DealerCard1.setText("K" + " " + theDealer.get_hand().get(0).getSuit());
				}
				else if(theDealer.get_hand().get(0).getValue() == 12) {
					DealerCard1.setText("Q" + " " + theDealer.get_hand().get(0).getSuit());
				}
				else if(theDealer.get_hand().get(0).getValue() == 11) {
					DealerCard1.setText("J" + " " + theDealer.get_hand().get(0).getSuit());
				}
				else {
					DealerCard1.setText(theDealer.get_hand().get(0).getValue() 
						+ " " + theDealer.get_hand().get(0).getSuit());	}
				
				
				if( theDealer.get_hand().get(1).getValue() == 14) {
					DealerCard2.setText("A" + " " + theDealer.get_hand().get(1).getSuit());
				}
				else if(theDealer.get_hand().get(1).getValue() == 13) {
					DealerCard2.setText("K" + " " + theDealer.get_hand().get(1).getSuit());
				}
				else if(theDealer.get_hand().get(1).getValue() == 12) {
					DealerCard2.setText("Q" + " " + theDealer.get_hand().get(1).getSuit());
				}
				else if(theDealer.get_hand().get(1).getValue() == 11) {
					DealerCard2.setText("J" + " " + theDealer.get_hand().get(1).getSuit());
				}
				else {
					DealerCard2.setText(theDealer.get_hand().get(1).getValue() 
						+ " " + theDealer.get_hand().get(1).getSuit());	}
				
				
				if( theDealer.get_hand().get(2).getValue() == 14) {
					DealerCard3.setText("A" + " " + theDealer.get_hand().get(2).getSuit());
				}
				else if(theDealer.get_hand().get(2).getValue() == 13) {
					DealerCard3.setText("K" + " " + theDealer.get_hand().get(2).getSuit());
				}
				else if(theDealer.get_hand().get(2).getValue() == 12) {
					DealerCard3.setText("Q" + " " + theDealer.get_hand().get(2).getSuit());
				}
				else if(theDealer.get_hand().get(2).getValue() == 11) {
					DealerCard3.setText("J" + " " + theDealer.get_hand().get(2).getSuit());
				}
				else {
					DealerCard3.setText(theDealer.get_hand().get(2).getValue() 
						+ " " + theDealer.get_hand().get(2).getSuit());	}
				//both play
				if(play1_play == 1 && play2_play == 1) {
					prompt.clear();
					prompt_text  = "";
					//int play1_dealer;
					//int play2_dealer;
					play2_dealer = ThreeCardLogic.compareHands(theDealer.get_hand(),PlayerTwo.get_hand());
					play1_dealer = ThreeCardLogic.compareHands( theDealer.get_hand(),playerOne.get_hand());
						if(play2_dealer == 0) {
							prompt_text2 = "PLAYER2 TIED DEALER";
							PlayerTwo.set_totalWinning(PlayerTwo.get_playBet());
						}else if(play2_dealer == 1) {
							prompt_text2 = "DEALER BEAT PLAYER2";
							
							PlayerTwo.set_totalWinning(PlayerTwo.get_totalWinning()-PlayerTwo.get_playBet()-PlayerTwo.get_anteBet());
						}else if(play2_dealer == 2) {
							prompt_text2 = "PLAYER2 BEAT DEALER";
							if(ThreeCardLogic.evalHand(PlayerTwo.get_hand())== 1) {
								PlayerTwo.set_totalWinning((PlayerTwo.get_anteBet()+PlayerTwo.get_playBet())*40);// times 40
							}else if(ThreeCardLogic.evalHand(PlayerTwo.get_hand())== 2) {
								PlayerTwo.set_totalWinning((PlayerTwo.get_anteBet()+PlayerTwo.get_playBet())*30); //times 30
							}else if(ThreeCardLogic.evalHand(PlayerTwo.get_hand())== 3) {
								PlayerTwo.set_totalWinning((PlayerTwo.get_anteBet()+PlayerTwo.get_playBet())*6);; //times 6
							}else if(ThreeCardLogic.evalHand(PlayerTwo.get_hand())==4) {
								PlayerTwo.set_totalWinning((PlayerTwo.get_anteBet()+PlayerTwo.get_playBet())*3);; //times 3
							}else if(ThreeCardLogic.evalHand(PlayerTwo.get_hand())== 5) {
								PlayerTwo.set_totalWinning((PlayerTwo.get_anteBet()+PlayerTwo.get_playBet())*1);; //times 1
							}
						}
						if(play1_dealer == 0) {
							prompt_text = "PLAYER1 TIED DEALER";
							playerOne.set_totalWinning(playerOne.get_playBet());
						}else if(play1_dealer == 1) {
							prompt_text = "DEALER BEAT PLAYER1";
							playerOne.set_totalWinning(playerOne.get_totalWinning()-playerOne.get_playBet()-playerOne.get_anteBet());
						}else if(play1_dealer == 2) {
							prompt_text = "PLAYER1 BEAT DEALER";
							if(ThreeCardLogic.evalHand(playerOne.get_hand())== 1) {
								playerOne.set_totalWinning((playerOne.get_anteBet()+playerOne.get_playBet())*40);// times 40
							}else if(ThreeCardLogic.evalHand(playerOne.get_hand())== 2) {
								playerOne.set_totalWinning((playerOne.get_anteBet()+playerOne.get_playBet())*30); //times 30
							}else if(ThreeCardLogic.evalHand(playerOne.get_hand())== 3) {
								playerOne.set_totalWinning((playerOne.get_anteBet()+playerOne.get_playBet())*6);; //times 6
							}else if(ThreeCardLogic.evalHand(playerOne.get_hand())==4) {
								playerOne.set_totalWinning((playerOne.get_anteBet()+playerOne.get_playBet())*3);; //times 3
							}else if(ThreeCardLogic.evalHand(playerOne.get_hand())== 5) {
								playerOne.set_totalWinning((playerOne.get_anteBet()+playerOne.get_playBet())*1);; //times 1
							}
						}
					//prompt.clear();
					prompt.setText(prompt_text);
					prompt2.setText(prompt_text2);
					if (playerOne.get_pairPlusBet() > 0) {
						if(ThreeCardLogic.evalPPWinnings(playerOne.get_hand(), playerOne.get_pairPlusBet())==0) {
						prompt4.setText("PLAYER1 LOST PAIR PLUS");
						}
						else {
						prompt4.setText("PLAYER1 WON PAIR PLUS");}
					}
					else {
						prompt4.setText("");
					}
					if (PlayerTwo.get_pairPlusBet() > 0) {
						if(ThreeCardLogic.evalPPWinnings(PlayerTwo.get_hand(), PlayerTwo.get_pairPlusBet())==0) {
							prompt3.setText("PLAYER2 LOST PAIR PLUS");
							}
						else {
							prompt3.setText("PLAYER2 WON PAIR PLUS");}
					}
					else {
						prompt3.setText("");
					}
					//update the winnings for player1
					
					// update the winnings for player2
				}else if (play1_play == 0 && play2_play == 1) {
					prompt.clear();
					prompt_text  = "";
					play2_dealer = ThreeCardLogic.compareHands( theDealer.get_hand(),PlayerTwo.get_hand());
					if(play2_dealer == 0) {
						prompt_text = "PLAYER2 TIED DEALER";
						PlayerTwo.set_totalWinning(PlayerTwo.get_playBet());
					}else if(play2_dealer == 1) {
						prompt_text = "DEALER BEAT PLAYER2";
						PlayerTwo.set_totalWinning(PlayerTwo.get_totalWinning()-PlayerTwo.get_playBet()-PlayerTwo.get_anteBet());
					}else if(play2_dealer == 2) {
						prompt_text = "PLAYER2 BEAT DEALER";
						if(ThreeCardLogic.evalHand(PlayerTwo.get_hand())== 1) {
							PlayerTwo.set_totalWinning((PlayerTwo.get_anteBet()+PlayerTwo.get_playBet())*40);// times 40
						}else if(ThreeCardLogic.evalHand(PlayerTwo.get_hand())== 2) {
							PlayerTwo.set_totalWinning((PlayerTwo.get_anteBet()+PlayerTwo.get_playBet())*30); //times 30
						}else if(ThreeCardLogic.evalHand(PlayerTwo.get_hand())== 3) {
							PlayerTwo.set_totalWinning((PlayerTwo.get_anteBet()+PlayerTwo.get_playBet())*6);; //times 6
						}else if(ThreeCardLogic.evalHand(PlayerTwo.get_hand())==4) {
							PlayerTwo.set_totalWinning((PlayerTwo.get_anteBet()+PlayerTwo.get_playBet())*3);; //times 3
						}else if(ThreeCardLogic.evalHand(PlayerTwo.get_hand())== 5) {
							PlayerTwo.set_totalWinning((PlayerTwo.get_anteBet()+PlayerTwo.get_playBet())*1);; //times 1
						}
					}
					prompt2.setText(prompt_text);
					if (PlayerTwo.get_pairPlusBet() > 0) {
						if(ThreeCardLogic.evalPPWinnings(PlayerTwo.get_hand(), PlayerTwo.get_pairPlusBet())==0) {
							prompt3.setText("PLAYER2 LOST PAIR PLUS");
							PlayerTwo.set_totalWinning(PlayerTwo.get_totalWinning()-PlayerTwo.get_pairPlusBet());
							}
						else {
							prompt3.setText("PLAYER2 WON PAIR PLUS");
							PlayerTwo.set_totalWinning(PlayerTwo.get_totalWinning()+PlayerTwo.get_pairPlusBet());}
					}
					else {
						prompt3.setText("");
					}
				}
				else if(play1_play == 1 && play2_play == 0) {
					prompt.clear();
					prompt_text  = "";
					play1_dealer = ThreeCardLogic.compareHands(theDealer.get_hand(),playerOne.get_hand());
					if(play1_dealer == 0) {
						prompt_text = "PLAYER1 TIED DEALER";
						playerOne.set_totalWinning(playerOne.get_playBet());
					}else if(play1_dealer == 1) {
						prompt_text = "DEALER BEAT PLAYER1";
						playerOne.set_totalWinning(playerOne.get_totalWinning()-playerOne.get_playBet()-playerOne.get_anteBet());
					}else if(play1_dealer == 2) {
						prompt_text = "PLAYER1 BEAT DEALER";
						if(ThreeCardLogic.evalHand(playerOne.get_hand())== 1) {
							playerOne.set_totalWinning((playerOne.get_anteBet()+playerOne.get_playBet())*40);// times 40
						}else if(ThreeCardLogic.evalHand(playerOne.get_hand())== 2) {
							playerOne.set_totalWinning((playerOne.get_anteBet()+playerOne.get_playBet())*30); //times 30
						}else if(ThreeCardLogic.evalHand(playerOne.get_hand())== 3) {
							playerOne.set_totalWinning((playerOne.get_anteBet()+playerOne.get_playBet())*6);; //times 6
						}else if(ThreeCardLogic.evalHand(playerOne.get_hand())==4) {
							playerOne.set_totalWinning((playerOne.get_anteBet()+playerOne.get_playBet())*3);; //times 3
						}else if(ThreeCardLogic.evalHand(playerOne.get_hand())== 5) {
							playerOne.set_totalWinning((playerOne.get_anteBet()+playerOne.get_playBet())*1);; //times 1
						}
					}
					prompt.setText(prompt_text);
					if (playerOne.get_pairPlusBet() > 0) {
						if(ThreeCardLogic.evalPPWinnings(playerOne.get_hand(), playerOne.get_pairPlusBet())==0) {
						prompt4.setText("PLAYER1 LOST PAIR PLUS");
						playerOne.set_totalWinning(playerOne.get_totalWinning()-playerOne.get_pairPlusBet());
						}
						else {
						prompt4.setText("PLAYER1 WON PAIR PLUS");
						playerOne.set_totalWinning(playerOne.get_totalWinning()+playerOne.get_pairPlusBet());}
					}
					else {
						prompt4.setText("");
					}
				}
				else {
					prompt_text  = "";
					prompt.clear();
				}
				player1TW.setText("Total Winnings: " +playerOne.get_totalWinning());
				player2TW.setText("Total Winnings: " +PlayerTwo.get_totalWinning());
				
				}
				
			}});
		gameTable.setAlignment(Pos.CENTER);
		gameTable.add(PairPlus, 4, 5);
		gameTable.add(promptText, 5,7);
		gameTable.add(Ante, 6, 5);
		gameTable.add(Confirm, 4, 6);
		gameTable.add(Fold, 5, 6);
		gameTable.add(Play, 6, 6);
		
		gameTable.add(dealerHand,5,2);
		gameTable.add(Player1Hand,2,5);
		gameTable.add(Player2Hand,8,5);
		
		gameTable.add(dealerName,5,3);
		gameTable.add(playerName1,2,6);
		gameTable.add(playerName2,8,6);
		
		gameTable.add(player1Text,2,7);
		gameTable.add(player2Text,8,7);
		gameTable.add(PlayAgain, 5, 5);
		scene2= new Scene(bp,1200,700);
		//scene2= new Scene(borderP);
		return scene2;
	}
	
	
	private Scene createEndScreen() {
        start = new Button("Close");
        start.setPrefHeight(50.0);
        start.setPrefWidth(100.0);
        start.setStyle("-fx-background-color: red");
        String end_statement = "Thank you for playing \n GoodBye ";
        TextField end_field = new TextField(end_statement);
        // style for start textField
        end_field.setEditable(false);
        end_field.setPrefHeight(300);
        end_field.setMaxWidth(500);
        end_field.setMinWidth(500);
        end_field.setAlignment(Pos.CENTER);
        end_field.setStyle("-fx-background-color: green");

        h1 = new HBox(50,end_field,start);
        borderP = new BorderPane();
        borderP.setStyle("-fx-background-color: green");
        borderP.setCenter(end_field);
        borderP.setTop(null);
        borderP.setTop(start);
        borderP.setAlignment(start, Pos.TOP_LEFT);

        start.setOnAction(e->stage.close());
        Scene scene3 = new Scene(borderP,1200,700);      
        return scene3;
    }
		
	// helper function to switch scene inside lamda expression
	public void switchScene(Scene scene) {
		stage.setScene(scene);
	}
		
}