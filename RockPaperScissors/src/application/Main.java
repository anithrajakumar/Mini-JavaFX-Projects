package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.paint.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Random;


public class Main extends Application 
{ 
	int compScoreNum = 0;
	int userScoreNum = 0;

	@Override
	public void start(Stage primaryStage) {

		Random random = new Random();

		Image logoIMG = new Image("C:\\Users\\User\\Desktop\\RPS\\Logo.png");

		Label userPick = new Label("");
		userPick.setTranslateX(120);
		userPick.setTranslateY(-55);
		userPick.setFont(Font.font("Times New Roman", 16));

		Label compPick = new Label("");
		compPick.setTranslateX(120);
		compPick.setTranslateY(-50);
		compPick.setFont(Font.font("Times New Roman", 16));

		Label outCome = new Label("You Win!"); 
		outCome.setTranslateX(120);
		outCome.setTranslateY(-73);
		outCome.setFont(Font.font("Times New Roman", 16));
		outCome.setVisible(false);

		Label userScore = new Label("User: " + userScoreNum);
		userScore.setTranslateX(0);
		userScore.setTranslateY(-90);
		userScore.setFont(Font.font("Times New Roman", 16));

		Label compScore = new Label("Computer: " + compScoreNum);
		compScore.setTranslateX(0);
		compScore.setTranslateY(-89);
		compScore.setFont(Font.font("Times New Roman", 16));


		Label welcomeMessage = new Label("Welcome to RPS!!!");
		welcomeMessage.setTranslateX(105);
		welcomeMessage.setTranslateY(-242);
		welcomeMessage.setFont(Font.font("Times New Roman", 24));

		Button rockButton = new Button(""); 
		Button paperButton = new Button("");
		Button scissorsButton = new Button(""); 

		Button resetButton = new Button("Reset");
		resetButton.setTranslateX(300);
		resetButton.setTranslateY(-60);
		resetButton.setPrefSize(75, 30);

		Button contiuneButton = new Button("Contiune"); 
		contiuneButton.setTranslateX(140);
		contiuneButton.setTranslateY(-50);
		contiuneButton.setPrefSize(120, 30);
		contiuneButton.setVisible(false);

		contiuneButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				rockButton.setVisible(true);
				paperButton.setVisible(true);
				scissorsButton.setVisible(true);
				contiuneButton.setVisible(false);
				userPick.setVisible(false);
				compPick.setVisible(false);
				outCome.setVisible(false);

			}
		});


		VBox vbox;
		Scene scene;

		String[] compAnswer = {"rock", "paper", "scissors"};

		Image rockIMG = new Image("C:\\Users\\User\\Desktop\\RPS\\rock.jpg");
		ImageView rockPNG = new ImageView(rockIMG);
		rockPNG.setFitHeight(60);
		rockPNG.setPreserveRatio(true); 

		rockButton.setTranslateX(50);
		rockButton.setTranslateY(-97);
		rockButton.setPrefSize(75, 75);
		rockButton.setGraphic(rockPNG);

		rockButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				rockButton.setVisible(false);
				paperButton.setVisible(false);
				scissorsButton.setVisible(false);
				userPick.setVisible(true);
				compPick.setVisible(true);
				outCome.setVisible(true);

				String userMove = "rock";

				contiuneButton.setVisible(true);
				int randomGuess = random.nextInt(0, compAnswer.length);
				String compMove = compAnswer[randomGuess];

				userPick.setText("Your pick: " + userMove);
				compPick.setText("Computer's pick: "+ compMove);

				compPick.setAlignment(Pos.CENTER);

				if(compMove.equals("rock")) {
					outCome.setText("Draw, good luck! ;)");
				} else if(compMove.equals("paper")){
					outCome.setText("Unfortunately, you lose :(");
					compScoreNum++;
					compScore.setText("Computer: " + compScoreNum);
				} else if(compMove.equals("scissors")) {
					outCome.setText("Congratulations, you win! :)");
					userScoreNum++;
					userScore.setText("User: " + userScoreNum);
				}
			}
		});

		Image paperIMG = new Image("C:\\Users\\User\\Desktop\\RPS\\paper.png");
		ImageView paperPNG = new ImageView(paperIMG);
		paperPNG.setFitHeight(60);
		paperPNG.setPreserveRatio(true);

		paperButton.setTranslateX(162);
		paperButton.setTranslateY(43);
		paperButton.setPrefSize(75, 75);
		paperButton.setGraphic(paperPNG);

		paperButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				rockButton.setVisible(false);
				paperButton.setVisible(false);
				scissorsButton.setVisible(false);
				userPick.setVisible(true);
				compPick.setVisible(true);
				outCome.setVisible(true);

				String userMove = "paper";

				contiuneButton.setVisible(true);
				int randomGuess = random.nextInt(0, compAnswer.length);
				String compMove = compAnswer[randomGuess];

				userPick.setText("Your pick: " + userMove);
				compPick.setText("Computer's pick: "+ compMove);

				compPick.setAlignment(Pos.CENTER);

				if(compMove.equals("rock")) {
					outCome.setText("Congratulations, you win! :)");
					userScoreNum++;
					userScore.setText("User: " + userScoreNum);
				} else if(compMove.equals("paper")){
					outCome.setText("Draw, good luck! ;)");
				} else if(compMove.equals("scissors")) {
					outCome.setText("Unfortunately, you lose :(");
					compScoreNum++;
					compScore.setText("Computer: " + compScoreNum);
				}
			}
		});

		Image scissorsIMG = new Image("C:\\Users\\User\\Desktop\\RPS\\scissors.png");
		ImageView scissorsPNG = new ImageView(scissorsIMG);
		scissorsPNG.setFitHeight(60);
		scissorsPNG.setPreserveRatio(true);

		scissorsButton.setTranslateX(275);
		scissorsButton.setTranslateY(-25);
		scissorsButton.setPrefSize(75, 75);
		scissorsButton.setGraphic(scissorsPNG);
		scissorsButton.setMinSize(65, 70);
		scissorsButton.setMaxSize(75, 70);

		scissorsButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				rockButton.setVisible(false);
				paperButton.setVisible(false);
				scissorsButton.setVisible(false);
				userPick.setVisible(true);
				compPick.setVisible(true);
				outCome.setVisible(true);

				String userMove = "scissors";

				contiuneButton.setVisible(true);
				int randomGuess = random.nextInt(0, compAnswer.length);
				String compMove = compAnswer[randomGuess];

				userPick.setText("Your pick: " + userMove);
				compPick.setText("Computer's pick: "+ compMove);

				compPick.setAlignment(Pos.CENTER);

				if(compMove.equals("rock")) {
					outCome.setText("Unfortunately, you lose :(");
					compScoreNum++;
					compScore.setText("Computer: " + compScoreNum);
				} else if(compMove.equals("paper")){
					outCome.setText("Congratulations, you win! :)");
					userScoreNum++;
					userScore.setText("User: " + userScoreNum);
				} else if(compMove.equals("scissors")) {
					outCome.setText("Draw, good luck! ;)");
				}
			}
		});

		resetButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				rockButton.setVisible(true);
				paperButton.setVisible(true);
				scissorsButton.setVisible(true);
				userPick.setVisible(false);
				compPick.setVisible(false);
				outCome.setVisible(false);
				contiuneButton.setVisible(false);

				compScoreNum = 0;
				compScore.setText("Computer: " + compScoreNum);

				userScoreNum = 0;
				userScore.setText("User: " + userScoreNum);

				compPick.setAlignment(Pos.CENTER);
			}
		});


		vbox = new VBox(paperButton, scissorsButton, rockButton, userPick, compPick, welcomeMessage, outCome, contiuneButton, resetButton, userScore, compScore);

		BackgroundFill background_fill = new       
				BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new     
				Background(background_fill);
		// set background
		vbox.setBackground(background);

		scene = new Scene(vbox, 400, 300);

		primaryStage.setTitle("Rock, Paper, Scissors!");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.getIcons().add(logoIMG);
		primaryStage.setResizable(false);

	} 

	public static void main(String[] args) {
		launch(args);
	}
} 
