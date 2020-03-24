package Jabba;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
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

        createBoard(root);
        FX_frame(root);
        FX_input(root);

        return root;
    }

    public void createBoard(Pane root){
        for(int i=0; i<15; i++)
            for(int j=0; j<15; j++){
                board.getBoard()[i][j].setTranslateX(j*40+5);
                board.getBoard()[i][j].setTranslateY(i*40);
                root.getChildren().add(board.getBoard()[i][j]);
            }
    }

    public void FX_frame(Pane root){
        for(int i=0; i<7; i++){
            p.getFrame().getAllTiles().get(i).setTranslateX(((i+1)*42) + 600);
            p.getFrame().getAllTiles().get(i).setTranslateY(20);
            root.getChildren().add(p.getFrame().getAllTiles().get(i));
        }
    }

    public void readTextfield(String input){

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage.setTitle("Scrabble");
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    public void FX_input(Pane root){

        GridPane grid = new GridPane();
        Label inputLabel = new Label("Write your word");
        TextField textField = new TextField ();
        textField.setPromptText("Choose word or command. For help, HELP");
        grid.add(inputLabel, 0, 0);
        grid.add(textField, 1, 0);
        Button Input = new Button("ENTER");
        grid.add(Input, 1, 1);
        grid.setHgap(15);
        grid.setVgap(20);

        grid.setTranslateX(650);
        grid.setTranslateY(100);
        root.getChildren().add(grid);

        String userWord = textField.getText();

        Input.setOnAction(e -> {
            System.out.println(textField.getText());
            readTextfield(textField.getText());
        });

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
                "<word> " + "write your word on keyboard";
        AnchorPane rootHelp = new AnchorPane();
        BorderPane borderHelp = new BorderPane();
        Text title = new Text("Help menu- commands");
        Text helpText = new Text(helpMessage);
        borderHelp.setTop(title);
        borderHelp.setCenter(helpText);



        //end creating help file

        //possibly trim spaces at the beginning or end, and ignore many spaces between commands
        if (userWord.equals("QUIT")||userWord.equals("quit"))
            won = true;
        if (userWord.equals("PASS")||userWord.equals("pass"))
            turn = false;
        //if (userWord.equals("HELP")||userWord.equals("help"))
            //display help;
        //if (userWord.equals("EXCHANGE")||userWord.equals("exchange"))
          //  p.getFrame().exchange(2);

        Button enterUInput = new Button("ENTER");
        enterUInput.setOnAction(e -> {
            System.out.println("We'll put here Board method to confirm word and placeWord: ");
        }); //that's how we pass user Input in button
    }


    public boolean ifCommandValidPlacer(String usersWord) {
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
       //if(Board.isValid(usersWord)) //needed, might be buggy syntax - waiting how placeWord is implemented after update
          //  Board.placeWord(usersWord, first_position_x, first_position_y, isHorizontally);
        return false;
    }




    public static void main(String[] args) {
        launch(args);
    }
}
