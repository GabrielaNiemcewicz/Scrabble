package Jabba;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Scrabble extends Application implements EventHandler<ActionEvent> {

    Stage window;
    Button play, help;
    TextField playerName1, playerName2;
    Label player1, player2;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Scrabble");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(10);
        grid.setVgap(8);

        // Player's names:
        player1 = new Label("Player 1: Name: ");
        GridPane.setConstraints(player1, 1, 5);
        //Player's input
        playerName1 = new TextField();
        GridPane.setConstraints(playerName1, 1, 6);
        // Player's names:
        player2 = new Label("Player 2: Name: ");
        GridPane.setConstraints(player2, 3, 5);
        //Player's input
        playerName2 = new TextField();
        GridPane.setConstraints(playerName2, 3, 6);
        //button
        play = new Button("Lets Play");
        GridPane.setConstraints(play, 2, 9 );
        play.setOnAction(this);
        help = new Button("Help");
        GridPane.setConstraints(help, 1, 9 );
        help.setOnAction(this);
        grid.getChildren().addAll(player1, playerName1, player2, playerName2, play, help);
        Scene scene = new Scene(grid, 500, 200);
        window.setScene(scene);
        window.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(actionEvent.getSource() == play) {
            Player one = new Player(playerName1.getText());
            Player two = new Player(playerName2.getText());
            UI ui = new UI();
            Player players = new Player[]{one,two};
            int whoFirst = ui.random_first_Rounds(players);
            players[0+whoFirst] = one;
            players[1-whoFirst] = two;
        }
        else if(actionEvent.getSource() == help){
            System.out.println("HELP"); //extra functionality- a text, typed command 'help' required in specification
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}