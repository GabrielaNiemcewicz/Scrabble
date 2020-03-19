package Jabba;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class UI extends Application{
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







    boolean ifCommandValidPlacer(string usersWord) {
        boolean isHorizontally;
        int first_position_x;
        int first_position_y;

        while(Character.isWhitespace(usersWord.charAt(0)))
            usersWord = usersWord.substring(1); //delete unneeded whitespaces

        if(!Character.isDigit(usersWord.charAt(0))) //row number
        {   System.out.println("Row index is first digit and a number between 0-14");
            return false; }
         first_position_x =  Integer.parseInt(String.valueOf(usersWord.charAt(0)));

        while(Character.isWhitespace(usersWord.charAt(1)) || usersWord.charAt(1) == ',' || usersWord.charAt(1) == ';' )
            usersWord = usersWord.substring(0,0) + usersWord.substring(2); //delete unneeded whitespaces or coma


        if(!Character.isDigit(usersWord.charAt(1))) //column number
        {   System.out.println("Column index is second digit after row and a number between 0-14");
            return false; }
        first_position_y =  Integer.parseInt(String.valueOf(usersWord.charAt(1)));

        while(Character.isWhitespace(usersWord.charAt(2)) || usersWord.charAt(2) == ',' || usersWord.charAt(2) == ';' )
            usersWord = usersWord.substring(0,1) + usersWord.substring(3); //delete unneeded whitespaces or coma


        if(usersWord.charAt(2)=='h' || usersWord.charAt(2)=='H')//accross A or horizontal H
            isHorizontally = true;
        if(usersWord.charAt(2)=='a'|| usersWord.charAt(2)=='A')
            isHorizontally = false;
        else
        {   System.out.println("After row and index, separate choice of placement direction: A for across and H for horizontal");
            return false; }




        usersWord = usersWord.substring(3);//get rid of information that is checked already

        while(Character.isWhitespace(usersWord.charAt(0)) || usersWord.charAt(0) == ',' || usersWord.charAt(0) == ';' )
            usersWord = usersWord.substring(1); //delete unneeded whitespaces or coma


       //not needed for(char letter : usersWord)
         //not needed   if(letter < 'a' || (letter > 'z' && letter < 'A') || letter <= 'Z')
       if(Board.isValid(usersWord)) //needed, might be buggy syntax - waiting how placeWord is implemented after update
            Board.placeWord(usersWord, first_position_x, first_position_y, isHorizontally);
    }




    public static void main(String[] args) {
        launch(args);
    }
}
