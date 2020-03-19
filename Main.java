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
    boolean won = false;
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
                board.getBoard()[i][j].setTranslateX(j*40+5);
                board.getBoard()[i][j].setTranslateY(i*40);
                root.getChildren().add(board.getBoard()[i][j]);
            }

        for(int i=1; i<=7; i++){
            p.getFrame().getAllTiles().get(i-1).setTranslateX((i*42) + 600);
            p.getFrame().getAllTiles().get(i-1).setTranslateY(10);
            root.getChildren().add(p.getFrame().getAllTiles().get(i-1));
        }
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
    Label inputLabel = new Label("Write your word");
    TextField textField = new TextField ();
    textField.setPromptText("Choose word or command. For help, HELP");
    HBox userInput = new HBox();
    userInput.getChildren().addAll(inputLabel, textField);
    userInput.setSpacing(8);

    String userWord = textField.getText();

    //start creating help file
    String helpMessage = "To avail of needed functionalities in Scrabble, you have to carefully rewrite:" +
            "QUIT  -" + "  to stop playing, exit, terminate the game/n" +
            "PASS  -" +"  to resign from your round and let your opponent pick word/n"+
            "HELP  -" +"  to display this menu/n" +
            "EXCHANGE  -" +"  to swap current tiles with random ones in the pool/n" +
            "/n" +
            "To input word, specify, in this order, after whitespaces: <grid ref> <across/down> <word>/n" +
            "<grid reference>:  intint  " + "Two numbers (row and column index on Board where word starts) with nothing between them, eg. 13/n"
                    +"Valid positions: from 0 to 14/n" +
            "<across/down>  char  " +  "A for across, H for horizontal/n"+
            " You can put valid words up to bottom (h) or left to right (a) only/n"+
            "<word> " + "write your word on keyboard"


            

    //end creating help file

   //possibly trim spaces at the beginning or end, and ignore many spaces between commands
    if (userWord.equals("QUIT")||userWord.equals("quit"))
        won = true;
    if (userWord.equals("PASS")||userWord.equals("pass"))
        turn = false;
    if (userWord.equals("HELP")||userWord.equals("help"))
        //display help;
        if (userWord.equals("EXCHANGE")||userWord.equals("exchange"))
        //frame.exchange needs getting created

    Button enterUInput = new Button("ENTER");
    button.setOnAction(action -> {
        System.out.println("We'll put here Board method to confirm word and placeWord: "+word);
    }); //that's how we pass user Input in button






    textField.getText();


    public static void main(String[] args) {
        launch(args);
    }
}
