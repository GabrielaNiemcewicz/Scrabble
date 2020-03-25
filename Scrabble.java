package Jabba;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Scrabble extends Application{

    UI ui = new UI();

    Player player1, player2;
    int turns = 0;

    Scrabble(Pool pool, String name1, String name2){
        player1 = new Player(name1);
        player1.getFrame().refill(pool);

        player2 = new Player(name2);
        player2.getFrame().refill(pool);
    }

    public Player getPlayer(Pool pool){
        Player player;
        if(turns%2 == 0)
            player = player1;
        else
            player = player2;

        turns++;
        player.getFrame().refill(pool);
        return player;
    }



    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Scrabble");

        stage.setScene(new Scene(ui.createPlayers()));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}