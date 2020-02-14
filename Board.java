import java.util.ArrayList; 

public class Board {

private Square[][] board;
private int SIZE = 15;
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
	
	public void getWord(String word) {
		//in 3rd assignment, gets word from **Player** keyboard input. Now no parsing input needed.  
		//doing it this way from beginning might save work for later. 
		//maybe separate Class for storing a word and checking its validity? Maybe? 
		//I'm leaving it in Board for a now
		//merge to 1 function
		
	}
	
	
	public ArrayList<Tile> placeWordVertically(){ //necessary to be separate!
		//does set of checks first
		ArrayList <Tile> dummy = new ArrayList() ;
		return dummy;
	}
	
	public ArrayList<Tile> placeWordHorizontally(){ //necessary to be separate!
		//does set of checks first
		
		ArrayList <Tile> dummy = new ArrayList() ;
		return dummy;
	}
	
	
	public void getFirstPosition(int firstPosition_x,int firstPosition_y) {  
	  // gets first position from **Player** keyboard input. My idea for algorithm starts from index 0. 
	// merge to single function
	//-> merging help word validity test named	isWordWithinBounds 
}

	public boolean verticallyOrHorizontally() {
	//probably doesn't have to be merged to single function yet 
	return false;
	} 
	
	
	//all sets of tests together
	public boolean isWordValid(String checked_word) {
	//if first not valid, on false, throw new Exception with explanation what happened, else (continue testing)
		//else if second not valid, throw, else (continue testing)
			//...
				//...
	// return true; 
	return false;
	}
	
	
	//sets of tests
	public boolean isAnyTileFromFrame(String checked_word) {
	//necessary - remove from word search character(s) already "on the path" on Board that word of this length contains 
	// Frame contains ready method	boolean isLetterIn (char checkedLetter)
		// loop until first letter found - then break
	return false;
	}
	
	
	public boolean areAllTilesInFrame(String checked_word) {
		//necessary - remove from "word search" character(s) already "on the path" on Board that word of this length contains 
		//Frame contains ready method boolean isStringIn (String checked_word)
	return false;
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
	
	public boolean isInHarmonyWithTilesOnBoardVertically(String checked_word, int firstPosition_x, int firstPosition_y)
	{
	//for (int i=; i<checked_word.length(); i++) {
		
	//have to loop through squares IN RIGHT DIRECTION VERTICALLY
	//if square.isEmpty()   //This method I made for displaying if Tile is not on Square yet	
		//do nothing, carry on, i++, continue
	//else if (square.getCharacter() == checked_word[i])
		//do nothing, carry on, i++
	//else if (square.getCharacter() != checked_word[i])
		//return false
		
	//outside of loop: return true
		return false;
	}
	
	
	
	public boolean isInHarmonyWithTilesOnBoardHorizontally(String checked_word, int firstPosition_x, int firstPosition_y)
	{
		//for (int i=; i<checked_word.length(); i++) {
			
			//have to loop through squares IN RIGHT DIRECTION HORIZONTALLY
			//if square.isEmpty()   //This method I made for displaying if Tile is not on Square yet	
				//do nothing, carry on, i++, continue
			//else if (square.getCharacter() == checked_word[i])
				//do nothing, carry on, i++
			//else if (square.getCharacter() != checked_word[i])
				//return false
				
			//outside of loop: return true
		return false;
			}
		
	
	
	
	public boolean isFirstWord() {
		// how to make program aware what is the first word??????????????????????
			
	
	  //if first, this big first testing method at the end has test if inTheMiddle(checked_word)
	  //if not first, this big first testing method at the beginning has test if connectsToTileOnBoard(...) 
		return true;
	}
	
	
	public boolean inTheMiddleVertically(String checked_word, int firstPosition_x, int firstPosition_y)
	{
	//x=8
		//AND
	//firstPosition_y<=8 && checked_word.length()+firstPosition_y>=8
	return false;
	}
	
	public boolean inTheMiddleHorizontally(String checked_word, int firstPosition_x, int firstPosition_y)
	{
		//y=8
				//AND
			//firstPosition_x<=8 && checked_word.length()+firstPosition_x>=8
	return false;
	}
	
	public boolean connectsToTileOnBoardHorizontally(String checked_word, int firstPosition_x, int firstPosition_y) {
	//EXTREMELY IMPORTANT- DO THIS TEST ~AFTER~ TESTING FOR CONFLICTS WITH TILES ON BOARD! 
	//have to loop through squares IN RIGHT DIRECTION HORIZONTALLY
		//if square.isEmpty()   //This method I made for displaying if Tile is not on Square yet	
			//do nothing, carry on, i++, continue
		//else if (!square.isEmpty())
			//continue;
	return false;	
			
//outside of loop: return false
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
	
	//void reset()
		//set isEmpty = false
		//{if (this.tile.isEmpty == false) 
			//this.tile = userInputterTile
		//else if (!this.tile.isEmpty == true)
			//this.tile= dommyTile
//last 4 lines should be the same in the initializer of Square
	}
	

}