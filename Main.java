package Jabba;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application{
    boolean turn = true;
    Pool pool = new Pool();
    Player p = new Player("Adam");
    Board board = new Board();
    Stage stage = new Stage();

    private Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(1000, 605);
        p.getFrame().refill(pool);

        for(int i=0; i<15; i++)
            for(int j=0; j<15; j++){
                board.board[i][j].setTranslateX(j*40+5);
                board.board[i][j].setTranslateY(i*40);
                root.getChildren().add(board.board[i][j]);
            }

        for(int i=1; i<=7; i++){
            p.getFrame().frame.get(i-1).setTranslateX((i*42) + 600);
            p.getFrame().frame.get(i-1).setTranslateY(10);
            root.getChildren().add(p.getFrame().frame.get(i-1));
        }

        TextField textf = new TextField("Enter Word");
        textf.setTranslateX(700);
        textf.setTranslateY(100);
        root.getChildren().add(textf);

        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Circle c = new Circle();
        //CheckBox ch = new CheckBox();
        stage.setTitle("Scrabble");
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
