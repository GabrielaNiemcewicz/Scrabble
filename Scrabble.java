
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Scrabble extends Application implements EventHandler<ActionEvent> {

    Stage window;
    Button play, help;
    TextField p1, p2;
    Label player1, player2;
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        // Player's names:
        player1 = new Label("Player 1: Name: ");
        //Player's input
        p1 = new TextField();

        // Player's names:
        player2 = new Label("Player 2: Name: ");
        //Player's input
        p2 = new TextField();
        //button
        play = new Button();
        play.setText("Lets Play");
        play.setOnAction(this);
        help = new Button();
        help.setText("Help");

        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 300, 200);
        window.setScene(scene);

        window.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(actionEvent.getSource() == play) {
            Player one = new Player(p1.getText());
            Player two = new Player(p2.getText());
            UI.launch();
        }
        else if(actionEvent.getSource() == help){
            System.out.println("HELP");
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
