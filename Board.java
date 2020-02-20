import java.util.ArrayList; 

public class Board {

private Square[][] board;
private int SIZE = 15;

boolean isFirstRound = true;
//private String temporaryWord; //proposed implementation for checking if it's first turn. Will help in some implementations of challenging the word. GetWord() gets a word here, rest of functions access it from here.
//protected Tile uninitializedNullTile; //never gets initialized. Reassign * pointer to this null-returning object for Square's Tile to return Null on reset/challenge again
//anything else?

	public Board() {
		
		//initialize board of [SIZE][SIZE] squares
		
		//What do you think is better: 
		//a)hard-coding in input 4 score multipliers
		//b) do two classes extending Square- makes display code cleaner, without ifs/switch cases
		
	}
	
	
	
	public void display() {  
	 //display board as an enhanced loop of for each square in squares, square.display()
	 //at the end of each 15 for loop, \n
	//can add a || left and right, or ___ top and bottom if feeling fancy
	}
	
	
	//on square.placeTile(Tile), refresh so that updated display square.display() shows
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
//QUESTION- DO WE PUT REFRESH IN TILE, OR IN BOARD?//
////////////////////////////////////////////////////////////////////////////////////////////////////////
	

	public void refresh() {
		
		System.out.println("Use me in display on ending each successful word placement");
		
	}

	
	public void placeWordVertically(ArrayList <Tile> tilesFromFrame, int firstPosition_x,int firstPosition_y, String temporaryWord)
	{ //in main: board.placeWordVertically(frame.someGetterFunction()) //best get all Tiles needed, get one Tile ok
		//does its set of checks first
		//if (!this.isWordValidVertically())
		
			
			//this.temporaryWord = ""; //only if this is the first round
			System.out.println("Choose your word again, I'm a method in progress");
			//give user input
		//}
		//else	//if passed tests
			for (int i=0; i<temporaryWord.length(); i++)
					System.out.println("x is mobile. x+i. I'm in progress");	//ArrayList <Tile> dummy = new ArrayList() ;
		
		
		
	}
	
	public void placeWordHorizontally(ArrayList <Tile> tilesFromFrame, int firstPosition_x,int firstPosition_y, String temporaryWord){ //necessary to be separate! //change interface
		//does set of checks first
		//if (this.isWordValidHorizontally(/*variables variable variable*/))
		//ArrayList <Tile> dummy = new ArrayList() ;
				for (int i=0; i<temporaryWord.length(); i++)
					System.out.println("y is mobile. y+i. I'm in progress");
		
	}
	
	



	public boolean horizontallyOrVertically(char vh) throws Exception {
	if (vh=='h')
		return true;
	else if (vh =='v')
		return false;
	else throw new Exception("Wrong character inputted into vertically or horizontally in board");
	} 
	
	
	//all sets of tests together
	public boolean isWordValidHorizontally(int firstPosition_x, int firstPosition_y, Frame frame, String temporaryWord) {
	//if first not valid, on false, write output what happened, else (continue testing)
		//else if second not valid, throw, else (continue testing)
			//...
				//...
	// return true; 
	if(this.isFirstWord())	
		if(!this.inTheMiddle(firstPosition_x,  firstPosition_y)) //x is fixed, y is mobile
		{System.out.println("First word needs to connect to Square in the middle, 8th, 8th");
		return false;}
	
	if (!this.isFirstPositionValid(firstPosition_x, firstPosition_y))
		{System.out.println("You can't start your word here- square index out of Board");
		return false;}	
	else if (!this.isWordWithinBounds(firstPosition_y)) //change interface
		{System.out.println("Your word is too long to be placed here at this place on Board");
		return false;}	
	else if(!this.isInHarmonyWithTilesOnBoard(firstPosition_x, firstPosition_y)
			{System.out.println("Your word clashes with letters on the board.");
			return false;}		
	else if(!this.areAllTilesInFrame(firstPosition_x, firstPosition_y, frame)) 
	//function prints one of 3 errors- all has to be inside
	return false;
	
	
	else	
return true; 
	}
	
	//all sets of tests together
	public boolean isWordValidVertically(int firstPosition_x, int firstPosition_y, Frame frame, String temporaryWord) {
		return this.isWordValidHorizontally(firstPosition_y, firstPosition_x, frame)
		//we swap indices = now x is mobile, and y is fixed
		//because algorithms are symmetrical
	}
	
	
	
	
	public boolean isFirstPositionValid(int firstPosition_x, int firstPosition_y) {
		if(firstPosition_x> -1 && firstPosition_x<15 && firstPosition_y> -1 && firstPosition_y<15)
			return true;
		else return false;	
	}
	
	//EXTREMELY IMPORTANT- DO THIS TEST AFTER CHECKING FOR CLASHES WITH EXISTING TILES
	public boolean areAllTilesInFrame(int firstPositionFixed, int firstPositionMobile, Frame frame, String temporaryWord) {
		String copyOf_checked_word = temporaryWord;
		char tempRemovedCharacter ;
		Frame tempFrame = frame;
		for (int i = 0; i<temporaryWord.length(); i++)
			if (board[firstPositionFixed][firstPositionMobile+i].isEmpty())
				continue;
			else {
				 tempRemovedCharacter = board[firstPositionFixed][firstPositionMobile+i].getCharacter(); //error in Square method. Not in Bord method.
///////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////copyOf_checked_word.delete(tempRemovedChar);////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
			}
		if 	(copyOf_checked_word.length()==0)
			{System.out.println("Word invalid- no letter from Frame used");
			return false;}
		else if (copyOf_checked_word.length()==temporaryWord.length()) //on start of game. temp.length=0, so no need to check if it's beginning
			{System.out.println("Word invalid- doesn't connect to any words on Board");
			return false;}
		
		else 
		{
		if (!frame.isStringIn(copyOf_checked_word.toString()))
		{System.out.println("You don't have necessary tiles in the frame to create this word");
		return false;}
		else return true;
		}
		}		
		
		//done with bugs//necessary - remove from "word search" character(s) already "on the path" on Board that word of this length contains 
		//done//Frame contains ready method boolean isStringIn (String checked_word)

	



	
	
	
	public boolean isWordWithinBounds  (int firstPositionMobile, String temporaryWord)
	{
	
		if (firstPositionMobile+temporaryWord.length()>14) return false; 
		else return true;
	
	}
	

	
	
	
	public boolean isInHarmonyWithTilesOnBoard( int firstPositionFixed, int firstPositionMobile, String temporaryWord) throws Exception
	{ 
		for (int i=0; i<temporaryWord.length(); i++) {
			
		
			if (board[firstPositionFixed][firstPositionMobile+i].isEmpty())   //This method I made for displaying if Tile is not on Square yet	
				 continue;
			else if (board[firstPositionFixed][firstPositionMobile+i].getCharacter() == temporaryWord.charAt(i))
				continue;
			else if (board[firstPositionFixed][firstPositionMobile+i].getCharacter() != temporaryWord.charAt(i))
				return false;
			else 
				throw new Exception("Equality between Square.getCharacter(i) and String.charAt(i) is failing");
			}
		
		return true;
			}
		
	
	
	
	public boolean isFirstPlacement() {
		if (this.isFirstPlacement()==true) 
			for (int i=0; i<this.SIZE; i++)
				for (int j=0; j<this.SIZE; j++)
					if (this.board[i][j].isEmpty())
						continue;
					else if (!this.board[i][j].isEmpty())
						{this.isFirstRound = false; 
						return this.isFirstRound;}
					else System.out.println("Error in FirstPlacement, likely caused by isEmpty function in Square")
					
		return false;
		
		 // how to make program aware what is the first word??????????????????????
		
		  //if first, this big first testing method at the beginning has test if inTheMiddle(checked_word)
		  //if not first, this big first testing method at the beginning has test if connectsToTileOnBoard(...)
	}
	
	

	
	public boolean inTheMiddle(int firstPositionFixed, int firstPositionMobile, String temporaryWord)
	{
		if(firstPositionFixed!=7)
			return false;
		else if (firstPositionMobile<=7 && temporaryWord.length()+firstPositionMobile>=7)
			return true;
	return false;
	}
	

	
	public void reset() {
//at initialization, Tile is null. => isEmpty= true
//at placing Tile on Square, isEmpty = false, either square.reset or board.reset
	//have 1 extra private uninitialized Tile dummyTile somewhere- possibly in the Board. It NEVER gets initialized!
	//use created string isEmpty
		//a) in Square as separate variable
		//b) in Square as check tile.isNull()
		//c) make board a two-dimensional boolean Array[15][15] //that's what Chris said...
		//
	System.out.println("Use me! \n For: \n resetting whole board at beginning/end game \n refreshing Square on each (whole word)/(tile?) placement");
	//void reset()
		//set isEmpty = false and set temporaryWord = null
		//{if (this.tile.isEmpty == false) 
			//this.tile = userInputterTile
		//else if (!this.tile.isEmpty == true)
			//this.tile= dommyTile
//last 4 lines should be the same in the initializer of Square
	}
	

}