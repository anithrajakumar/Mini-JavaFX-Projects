package application;
	
// Created by: Anith Rajakumar

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.Random;
import java.util.Random.*;

public class Main extends Application 
{ 
  
  @Override
  public void start(Stage primaryStage) {
    
	String[] answers = {"yes", "no", "maybe","likely", "unlikely", 
						"It is certain!", " Concentrate and ask again.",
						"Very doubtful", "Outlook not so good.", "My sources say no.",
						" My reply is no.", "Don't count on it.", "Reply hazy, try again.",
						"Better not tell you now.", "Signs point to yes.", "Yes definitely",
						"It is decidedly so.", "Most likely."};
	Random random = new Random();
	 
	
    Label title = new Label("Ask the Magic 8 Ball Anything!");
    Label question = new Label("");
    Label answer = new Label("");
    TextField tf = new TextField("");
    Button button;
    VBox layout;
    Scene scene;
    
   
    
    tf.setMaxWidth(200);
    
    button = new Button("Click"); 

    button.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
    	  if(tf.getText() == "") {
    		  answer.setText("Please enter something above!");
    	  }else {
    		  int randomNum = random.nextInt(0, answers.length);
        	  question.setText("Question: " + tf.getText());
        	  answer.setText("Answer: " + answers[randomNum]);
        	  tf.setText(""); 
    	  }
    	  
      }
    });

    // Creating the boxes
    VBox topBox = new VBox(15, title, tf, button);
    VBox bottomBox = new VBox(5, question, answer);
    
    layout = new VBox(40, topBox, bottomBox);
    
    // Setting center Alignment
    topBox.setAlignment(Pos.CENTER);
    bottomBox.setAlignment(Pos.CENTER);
    layout.setAlignment(Pos.CENTER);
    
    // Creating the scene
    scene = new Scene(layout, 400, 300);
    
    primaryStage.setTitle("Welcome to the Magic 8 Ball");
    primaryStage.getIcons();
    primaryStage.setScene(scene);
    primaryStage.show();
  } 
    
  public static void main(String[] args) {
    launch(args);
  }
} 
