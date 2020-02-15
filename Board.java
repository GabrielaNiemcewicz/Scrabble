import java.util.ArrayList; 

public class Board {

private Square[][] board;
private int SIZE = 15;
private String temporaryWord; //proposed implementation for checking if it's first turn. Will help in some implementations of challenging the word. GetWord() gets a word here, rest of functions access it from here.
protected Tile uninitializedNullTile; //never gets initialized. Reassign * pointer to this null-returning object for Square's Tile to return Null on reset/challenge again
//private boolean [][] isEmpty; 
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
	
	public void getWord(String userWord) {
		
		this.temporaryWord = userWord;
		//in 3rd assignment, gets word from **Player** keyboard input. Now no parsing input needed.  
		//doing it this way from beginning might save work for later. 
		//maybe separate Class for storing a word and checking its validity? Maybe? 
		//I'm leaving it in Board for a now
		//merge to 1 function
		
	}
	
	
	public void placeWordVertically(ArrayList <Tile> tilesFromFrame, int firstPosition_x,int firstPosition_y){ //in main: board.placeWordVertically(frame.someGetterFunction()) //best get all Tiles needed, get one Tile ok
		//does its set of checks first
		if (this.isWordValidVertically(temporaryWord))
			
			for (int i=0; i<this.temporaryWord.length(); i++)
					System.out.println("I'm in progress");	//ArrayList <Tile> dummy = new ArrayList() ;
		
	}
	
	public void placeWordHorizontally(){ //necessary to be separate! //change interface
		//does set of checks first
		if (this.isWordValidHorizontally(this.temporaryWord))
		//ArrayList <Tile> dummy = new ArrayList() ;
				for (int i=0; i<this.temporaryWord.length(); i++)
					System.out.println("I'm in progress");
		
	}
	
	
	public void getFirstPosition(int firstPosition_x,int firstPosition_y) {  
	  // gets first position from **Player** keyboard input. My idea for algorithm starts from index 0. 
	// merge to single function
	//-> merging help word validity test named	isWordWithinBounds 
}

	public boolean verticallyOrHorizontally(char vh) throws Exception {
	if (vh=='h')
		return true;
	else if (vh =='v')
		return false;
	else throw new Exception("Wrong character inputted into vertically or horizontally in board");
	} 
	
	
	//all sets of tests together
	public boolean isWordValidHorizontally(String checked_word) {
	//if first not valid, on false, throw new Exception with explanation what happened, else (continue testing)
		//else if second not valid, throw, else (continue testing)
			//...
				//...
	// return true; 
	if(this.isFirstWord())	
		if(!this.inTheMiddleHorizontally(checked_word, firstPosition_x, firstPosition_y)) //change interface, unneeded vars
		{System.out.println("First word needs to connect to Square in the middle, 8th, 8th");
		return false;}
	
	if (!this.isFirstPositionValid(firstPosition_x, firstPosition_y))
		{System.out.println("You can't start your word here- square index out of Board");
		return false;}	
	else if (!this.isWordWithinBoundsHorizontally(checked_word, firstPosition_x, firstPosition_y)) //change interface
		{System.out.println("Your word is too long to be placed here at this place on Board");
		return false;}	
	else if(!this.isInHarmonyWithTilesOnBoardHorizontally(firstPosition_x, firstPosition_y)
			{System.out.println("Your word clashes with letters on the board.");
			return false;}		
	else if(!this.areAllTilesInFrameHorizontally(checked_word, firstPosition_x, firstPosition_y, frame)) 
	//function prints one of 3 errors- all has to be inside
	return false;
	
	
	
return true; 
	}
	
	//all sets of tests together
	public boolean isWordValidVertically(String checked_word) {
	//if first not valid, on false, throw new Exception with explanation what happened, else (continue testing)
		//else if second not valid, throw, else (continue testing)
			//...
				//...
	// return true; 
	return false;
	}
	
	
	////sets of tests
	//public boolean isAnyTileFromFrame(String checked_word) {
	////necessary - remove from word search character(s) already "on the path" on Board that word of this length contains 
	//// Frame contains ready method	boolean isLetterIn (char checkedLetter)
	//	// loop until first letter found - then break
//	return false;
//	}
	
	
//commented out, because there is a neat way to check it on the way to areAllTilesInTheFrame, but nice code idea if we resign from this implementation
	
	public boolean isFirstPositionValid(int firstPosition_x, int firstPosition_y) {
		if(firstPosition_x> -1 && firstPosition_x<15 && firstPosition_y> -1 && firstPosition_y<15)
			return true;
		else return false;
	
	}
	
	public boolean areAllTilesInFrameHorizontally(StringBuffer checked_word, int firstPosition_x, int firstPosition_y, Frame frame) {
		StringBuffer copyOf_checked_word = checked_word;
		char tempRemovedCharacter ;
		Frame tempFrame = frame;
		for (int i = 0; i<checked_word.length(); i++)
			if (board[firstPosition_x][firstPosition_y+i].isEmpty())
				continue;
			else {
				 tempRemovedCharacter = board[firstPosition_x][firstPosition_y+i].getCharacter(); //error in Square method. Not in Bord method.
///////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////copyOf_checked_word.delete(tempRemovedChar);////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
			}
		if 	(copyOf_checked_word.length()==0)
			{System.out.println("Word invalid- no letter from Frame used");
			return false;}
		else 
		{
		if (!frame.isStringIn(copyOf_checked_word.toString()))
		{System.out.println("You don't have necessary tiles in the frame to create this word");
		return false;}
		else return true;
		}
		}		
		
		//done//necessary - remove from "word search" character(s) already "on the path" on Board that word of this length contains 
		//done//Frame contains ready method boolean isStringIn (String checked_word)

	
	//EXTREMELY IMPORTANT- DO THIS TEST AFTER CHECKING FOR CLASHES WITH EXISTING TILES
	public boolean areAllTilesInFrameVertically(StringBuffer checked_word,int firstPosition_x,int firstPosition_y, Frame frame) {
		StringBuffer copyOf_checked_word = checked_word;
		char tempRemovedCharacter;
		
		for (int i = 0; i<checked_word.length(); i++)
			if (board[firstPosition_x+i][firstPosition_y].isEmpty())
				continue;
			else {
				 tempRemovedCharacter = board[firstPosition_x+i][firstPosition_y].getCharacter(); //error in Square at Tile initialization. GetCharacter errors with Tile on.
///////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////copyOf_checked_word.delete(tempRemovedChar);////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
			}
		if 	(copyOf_checked_word.length()==0) 
			{System.out.println("Word invalid- no letter from Frame used");
			return false;}
		
		else if (copyOf_checked_word.length()==this.temporaryWord.length()) //on start of game. temp.length=0, so no need to check if it's beginning
			{System.out.println("Word invalid- doesn't connect to any words on Board");
			return false;}
		else 
		{
		return frame.isStringIn(copyOf_checked_word.toString());
		
		}
			
	}

	
	
	
	public boolean isWordWithinBoundsVertically(String checked_word, int firstPosition_x, int firstPosition_y)
	{
		//if Square at first position is invalid, return false, else (continue) 
		if (firstPosition_y+checked_word.length()>15) return false; 
		else return true;
	
	}
	
	public boolean isWordWithinBoundsHorizontally(String checked_word, int firstPosition_x, int firstPosition_y)
	{
		//if Square at first position is invalid, return false, else (continue) => used again, maybe separate function? Check in input function?
		if (firstPosition_x+checked_word.length()>15) return false;
		else return true;
	}
	
	public boolean isInHarmonyWithTilesOnBoardVertically(int firstPosition_x, int firstPosition_y) throws Exception
	{		
		for (int i=0; i<this.temporaryWord.length(); i++) {
			
			
			if (board[firstPosition_x+i][firstPosition_x].isEmpty())   //This method I made for displaying if Tile is not on Square yet	
				 continue;
			else if (board[firstPosition_x+i][firstPosition_y].getCharacter() == this.temporaryWord.charAt(i))
				continue;
			else if (board[firstPosition_x+i][firstPosition_y+i].getCharacter() != this.temporaryWord.charAt(i))
				return false;
			else throw new Exception("Equality between Square.getCharacter(i) and String.charAt(i) is failing");}
		return true;	




	}
	
	
	
	public boolean isInHarmonyWithTilesOnBoardHorizontally( int firstPosition_x, int firstPosition_y) throws Exception
	{ 
		for (int i=0; i<this.temporaryWord.length(); i++) {
			
			//have to loop through squares IN RIGHT DIRECTION HORIZONTALLY
			if (board[firstPosition_x][firstPosition_x+i].isEmpty())   //This method I made for displaying if Tile is not on Square yet	
				 continue;
			else if (board[firstPosition_x][firstPosition_y+i].getCharacter() == this.temporaryWord.charAt(i))
				continue;
			else if (board[firstPosition_x][firstPosition_y+i].getCharacter() != this.temporaryWord.charAt(i))
				return false;
			else throw new Exception("Equality between Square.getCharacter(i) and String.charAt(i) is failing");}
		
		return true;
			}
		
	
	
	
	public boolean isFirstWord() {
		 if (this.temporaryWord==null)
			 return true;
		 else 
			return false;
		
		 // how to make program aware what is the first word??????????????????????
		
		  //if first, this big first testing method at the beginning has test if inTheMiddle(checked_word)
		  //if not first, this big first testing method at the beginning has test if connectsToTileOnBoard(...)
	}
	
	
	public boolean inTheMiddleVertically(String checked_word, int firstPosition_x, int firstPosition_y)
	{
		
			if(firstPosition_x!=7)
				return false;
			else if (firstPosition_y<=7 && checked_word.length()+firstPosition_y>=7)
				return true;
		return false;
		
	
	}
	
	public boolean inTheMiddleHorizontally(String checked_word, int firstPosition_x, int firstPosition_y)
	{
		if(firstPosition_y!=7)
			return false;
		else if (firstPosition_x<=7 && checked_word.length()+firstPosition_x>=7)
			return true;
	return false;
	}
	
	//public boolean connectsToTileOnBoard(String checked_word, int firstPosition_x, int firstPosition_y) {
	//EXTREMELY IMPORTANT- DO THIS TEST ~AFTER~ TESTING FOR CONFLICTS WITH TILES ON BOARD! 
	//have to loop through squares IN RIGHT DIRECTION HORIZONTALLY
		//if square.isEmpty()   //This method I made for displaying if Tile is not on Square yet	
			//do nothing, carry on, i++, continue
		//else if (!square.isEmpty())
			//continue;
//	return false;	
			
//outside of loop: return false
//		}
//if added to areAllTilesInFrame, doesn't need a separate function. And doesn't anymore need distinction vertical vs horizontal.		
	
	
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