package Jabba;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UI extends Application{
 //******** Instance Variables ************//
    int passedRoundsCount = 0;
    boolean turn = true;
    boolean won = false;
    Pool pool = new Pool();
    Player player;
    Board board = new Board();
    Word word;
    Scrabble scrabble;
    Pane root = new Pane();
    GridPane FXgrid = new GridPane();
    Label playerInfo = new Label();
    Stage stage = new Stage();
    // create a font
    Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 13);

    //******* Parent Method To implement the Player's names ***********//
    public Parent createPlayers(){
        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);
        root.setPrefSize(1000, 605);
        root.setStyle("-fx-background-color: lightblue;");
        Button play, help;
        TextField playerName1, playerName2;
        Label p1, p2;
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);  // This makes sure that it displays in the middle of the grid
        grid.setHgap(10);
        grid.setVgap(8);

        // Player's names:
        p1 = new Label("Player Name 1: ");
        p1.setFont(font);
        GridPane.setConstraints(p1, 1, 5);

        p2 = new Label("Player Name 2: ");
        p2.setFont(font);
        GridPane.setConstraints(p2, 3, 5);

        //Player's input Textfields
        playerName1 = new TextField();
        GridPane.setConstraints(playerName1, 1, 6);

        playerName2 = new TextField();
        GridPane.setConstraints(playerName2, 3, 6);

        //button This Button is set on action to call another scene called createContent() i.e Scrabble Board and Game
        play = new Button("Lets Play");
        GridPane.setConstraints(play, 2, 9 );
        play.setOnAction(p -> {
            scrabble = new Scrabble();
            scrabble.createPlayers(pool, playerName1.getText(), playerName2.getText());
            player = scrabble.getPlayer(pool);
            stage.setScene(new Scene(createContent()));
        });

        grid.getChildren().addAll(p1, playerName1, p2, playerName2, play);
        root.getChildren().add(grid);

        return root;
    }

    //******* Parent Method To implement the Scrabble Board ie Game **********//
    private Parent createContent(){

        root.setPrefSize(1000, 605);

        createBoard(root);
        root.getChildren().add(FXgrid);
        FX_frame(root);  // Part 1: the Frame.
        FX_input(root);  // Part 2: Players Input.
        createPlayerInfo();

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

    public void FX_frame(Pane root /*,Player player*/ ){
        FXgrid.getChildren().removeAll(FXgrid.getChildren());

        FXgrid.setTranslateX(640);
        FXgrid.setTranslateY(40);
        FXgrid.setHgap(3);

        for (int i = 0; i < player.getFrame().size(); i++) {
            FXgrid.add(player.getFrame().getAllTiles().get(i), i, 0);
        }
    }

    public void createPlayerInfo(){
        playerInfo.setPadding(new Insets(10, 10, 10, 10));
        playerInfo.setText("Player: "+player.getName() + "\t\t\t\t Score: " + player.getScore());
        playerInfo.setFont(font);
        playerInfo.setTranslateX(635);
        playerInfo.setTranslateY(2);
        root.getChildren().add(playerInfo);
    }

    public void score_counters(Player player) {
        //on event of succesful word placement, refresh
         int currentScore=player.getScore();
         Rectangle rscore = new Rectangle(35, 45);
         Text text = new Text(currentScore);



                    rscore.setFill(COLOR.GREY);
                    rscore.setStroke(Color.GREEN);
                    text.setFont(Font.font("Castellar", FontWeight.BOLD, 18));
                    text.setFill(Color.GREEN);
                    setAlignment(Pos.CENTER);

            rscore.setTranslateX(100 + i * 800);
            rscore.setTranslateY(30);
            root.getChildren().add(rscore,text);


           /*    on event of successful word placement, showScore (Player player){

                   text.setText(player.getScore()); */


                }



    public int random_first_Rounds(Player [] players){ //golden scrabble rules- lower ascii of Tile in Frame determines who starts game
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
    }*/

public void FX_input(Pane root){
        // Displaying Player's names:
        GridPane grid = new GridPane();

        Label inputLabel = new Label("Write your word");
        inputLabel.setFont(font);
        grid.add(inputLabel, 0, 2);

        TextField textField = new TextField ();
        textField.setPromptText("Choose word or command. For help, HELP");
        grid.add(textField, 1, 2);

        Button Input = new Button("ENTER");
        grid.add(Input, 1, 3);

        Label choices = new Label("You can also");
        choices.setFont(font);
        grid.add(choices, 0, 4);
        Button quit = new Button("QUIT GAME");
        quit.setOnAction(e -> { stage.close(); });
        Button pass = new Button("PASS TURN");
        pass.setOnAction(e -> { player = scrabble.getPlayer(pool);
        FX_frame(root);
        });
        Button help = new Button("HELP");
        help.setOnAction(e -> { helpPopUp(); });

        grid.add(quit, 0, 5);
        grid.add(pass, 1, 5);
        grid.add(help, 0, 6);

        grid.setHgap(15);
        grid.setVgap(20);
        grid.setTranslateX(650);
        grid.setTranslateY(100);

        root.getChildren().addAll(grid);
        Input.setOnAction(e -> {
        readInput(textField.getText(), textField);
        });
        }


public void readInput(String input, TextField textField){
        System.out.println(input);

        if(Pattern.matches("\\^EXCHANGE\\s+\\[a-zA-Z]+", input))
        player.getFrame().exchange(pool, input.substring(9).trim()); // for example, 'exchange wxpt'
        if (input.equalsIgnoreCase("PASS")) {
        turn = false;
        passedRoundsCount++;
        //this.promptPlayer(players, board);
        }
        if(input.equalsIgnoreCase("HELP"))
            helpPopUp();
        if(input.equalsIgnoreCase("QUIT"))
            stage.close();
        if(input.equalsIgnoreCase("PASS"))
        {
            player = scrabble.getPlayer(pool);
            FX_frame(root);
            playerInfo.setText("Player: "+player.getName() + "\t\t\t\t Score: " + player.getScore());
        }
        else if((Pattern.matches("\\d{1,2}\\s+\\d{1,2}\\s+[a-zA-Z]\\s+[a-zA-Z]+", input))) {
        parseInput(input);
        textField.clear();
        playerInfo.setText("Player: "+player.getName() + "\t\t\t\t Score: " + player.getScore());
        }
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

    }

    public void parseInput(String userInput){
        Scanner scan = new Scanner(userInput);
        boolean isHorizontal;
        int row = scan.nextInt();
        int column = scan.nextInt();
        String direction = scan.next();
        String Word = scan.next();

        if(direction.equalsIgnoreCase("h"))
            isHorizontal = true;
        else
            isHorizontal = false;

        word = new Word(row, column, isHorizontal, Word);
        if(board.isLegal(player.getFrame(), word)) {
            board.place(word, player);
            player = scrabble.getPlayer(pool);
            FX_frame(root);
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage.setTitle("Scrabble");

        stage.setScene(new Scene(createPlayers()));
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}


