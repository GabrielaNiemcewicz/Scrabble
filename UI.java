package Jabba;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UI extends Application{
   int passedRoundsCount = 0;
    boolean turn = true;
    boolean won = false;
    Pool pool = new Pool();
    private Player player = new Player("Adam");
    private Player player2 = new Player("Gabi");

    Player [] players = {player,player2};
    Board board = new Board();
    Word word;
    Stage stage = new Stage();

    private Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(1000, 605);
        player.getFrame().refill(pool);

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

    public void FX_frame(Pane root, Player [] players){
        for(int j=0;j<2;j++) //loop through players array- for each of 2 players, display frame
        for(int i=0; i<7; i++){
            players[j].getFrame().getAllTiles().get(i).setTranslateX(((i+1)*42) + 600);
            players[j].getFrame().getAllTiles().get(i).setTranslateY(20+j*420);
            root.getChildren().add(players.getFrame().getAllTiles().get(i));
        }
    }

    public void score_counters(Player [] players) {
        //on event of succesful word placement, refresh
        int[] currentScores = new int[2];
        VBox[] scoreDisplays = new VBox(5)[2]; //spacing is 5
        //each PlayerName and score added to 2 Score counters-one up, one down. Please correct display after me for aesthetics
        for(int i=0; i<2;i++) {
            currentScores[i] = players[i].getScore();
            scoreDisplays[i].getChildren().addAll(new Text(players[i].getName()), new Text(currentScores[i]), new Text("TOTAL SCORE"));
            scoreDisplays[i].setTranslateX(100 + i * 800);
            scoreDisplay[i].setTranslateY(30);
            root.getChildren().add(scoreDisplay[i]);
        }


    }

    public [] int random_first_Rounds(Player [] players){ //golden scrabble rules- lower ascii of Tile in Frame determines who starts game
        char [] minLetter = new char [2]{'Z','Z'};

        for(int i=0; i<2;i++)
        {    String playerLetters = players[i].getFrame().displayAsString();
            for (char letter:playerLetters)
        {
            if (letter=="_")
                return i;
            else if (letter<playerLetters)
                min[i] =  letter;
            else continue;
        }}
        if(minLetter[0]<minLetter[1])
            return 0;
        else
            return 1;




    }


    public Player promptPlayer(Player [] players, Board board){
        int rounds = board.getNumPlays() +passedRoundsCount;
        if (rounds ==0 &&  this.random_first_Rounds()==1)
        { rounds++;     passedRoundsCount++; }

        if (turn==false)
            passedRoundsCount++;

        return players[rounds%2]; //if even number of round, first player chooses. Else, second player.
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


        Input.setOnAction(e -> {
            System.out.println(textField.getText());

            //if(Pattern.matches("\\EXCHANGE\\s+[a-zA-Z]"),textField.getText())
            //  p.getFrame().exchange(pool, userWord.substring(9); // for example, 'exchange wxpt'
            if (textField.getText().equalsIgnoreCase("PASS")) {
                turn = false;
                passedRoundsCount++;
                this.promptPlayer(players, board);
            }
            if(textField.getText().equalsIgnoreCase("HELP"))
                helpPopUp();
            if(textField.getText().equalsIgnoreCase("QUIT"))
                stage.close();
            else if((Pattern.matches("\\d{1,2}\\s+\\d{1,2}\\s+[a-zA-Z]\\s+[a-zA-Z]+", textField.getText()))) {
                parseInput(textField.getText());
                textField.clear();
            }
        });

    }

    public void helpPopUp(){
        Stage popUpWindow=new Stage();

        popUpWindow.initModality(Modality.APPLICATION_MODAL);
        popUpWindow.setTitle("HELP");


        Label label1= new Label("To avail of needed functionalities in Scrabble, you have to carefully rewrite:\n" +
                "QUIT  -" + "  to stop playing, exit, terminate the game\n" +
                "PASS  -" +"  to resign from your round and let your opponent pick word\n"+
                "HELP  -" +"  to display this menu\n" +
                "EXCHANGE  -" +"  to swap current tiles with random ones in the pool\n" +
                "\n" +
                "To input word, specify, in this order, after whitespaces: <grid ref> <across/down> <word>\n" +
                "<grid reference>:  intint  " + "Two numbers (row and column index on Board where word starts) with nothing between them, eg. 13\n"
                +"Valid positions: from 0 to 14\n" +
                "<across/down>  char  " +  "V for vertical, H for horizontal\n"+
                " You can put valid words up to bottom (h) or left to right (a) only\n"+
                "<word> " + "write your word on keyboard");

        label1.setPadding(new Insets(20, 20, 20, 20));
        Scene scene1= new Scene(label1);
        popUpWindow.setScene(scene1);
        popUpWindow.showAndWait();
        //I thought BorderPane layout could be nice

        //AnchorPane rootHelp = new AnchorPane();
        //BorderPane borderHelp = new BorderPane();
        //borderHelp.setTop(title);
        //borderHelp.setCenter(helpText);






    }

    public void parseInput(String userInput){
        Scanner scan = new Scanner(userInput);
        boolean isHorizontal;
        int row = scan.nextInt();
        int column = scan.nextInt();
        String direction = scan.next();
        String Word = scan.next();
        System.out.println("int x: " + row + " int y: "+ column + " direction: " + direction + " word: " + Word);

        if(direction.equalsIgnoreCase("h"))
            isHorizontal = true;
        else
            isHorizontal = false;

        word = new Word(row, column, isHorizontal, Word);
        if(board.isLegal(player.getFrame(), word)&& turn==true)
            board.place(player.getFrame(), word);

        player.getFrame().refill(pool);
        player.getFrame().displayAsFrame();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage.setTitle("Scrabble");
        stage.setScene(new Scene(createContent()));
        stage.show();
    }









    public static void main(String[] args) {
        launch(args);
    }
}
