
public class Board {

private Square[][] board;
private int SIZE = 15;	  
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
QUESTION- DO WE PUT REFRESH IN TILE, OR IN BOARD?
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
		
	}
	
	public ArrayList<Tile> placeWordHorizontally(){ //necessary to be separate!
		//does set of checks first
		
	}
	
	
	public void getFirstPosition(int firstPosition_x,int firstPosition_y) {  
	  // gets first position from **Player** keyboard input. My idea for algorithm starts from index 0. 
	// merge to single function
	//-> merging help word validity test named	isWordWithinBounds 
}

	public boolean verticallyOrHorizontally() {
	//probably doesn't have to be merged to single function yet 
	
	} 
	
	
	//all sets of tests together
	public boolean isWordValid(String checked_word) {
	//if first not valid, on false, throw new Exception with explanation what happened, else (continue testing)
		//else if second not valid, throw, else (continue testing)
			//...
				//...
	// return true; 
	
	}
	
	
	//sets of tests
	public boolean isAnyTileFromFrame(String checked_word) {
	//necessary - remove from word search character(s) already "on the path" on Board that word of this length contains 
	// Frame contains ready method	boolean isLetterIn (char checkedLetter)
		// loop until first letter found - then break
	
	}
	
	
	public boolean areAllTilesInFrame(String checked_word) {
		//necessary - remove from "word search" character(s) already "on the path" on Board that word of this length contains 
		//Frame contains ready method boolean isStringIn (String checked_word)
	
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
	for (int i=; i<checked_word.length(); i++) {
		
	//have to loop through squares IN RIGHT DIRECTION VERTICALLY
	//if square.isEmpty()   //This method I made for displaying if Tile is not on Square yet	
		//do nothing, carry on, i++, continue
	//else if (square.getCharacter() == checked_word[i])
		//do nothing, carry on, i++
	//else if (square.getCharacter() != checked_word[i])
		//return false
		
	//outside of loop: return true
	}
	
	}
	
	public boolean isConflictingWithTilesOnBoardHorizontally(String checked_word, int firstPosition_x, int firstPosition_y)
	{
		for (int i=; i<checked_word.length(); i++) {
			
			//have to loop through squares IN RIGHT DIRECTION HORIZONTALLY
			//if square.isEmpty()   //This method I made for displaying if Tile is not on Square yet	
				//do nothing, carry on, i++, continue
			//else if (square.getCharacter() == checked_word[i])
				//do nothing, carry on, i++
			//else if (square.getCharacter() != checked_word[i])
				//return false
				
			//outside of loop: return true
			}
		
	
	}
	
	public boolean isFirstWord() {
		// ??????????????????????
			//word counter in Board?? no?
			//if all Squares.isEmpty()??
			//separately in main??
			//idk??
	//switches which condition to test as the last?? Either one condition, not both.
	  //if first, this big first testing method at the end has test if inTheMiddle(checked_word)
	  //if not first, this big first testing method at the end has test if connectsToTileOnBoard(...) 
	}
	
	
	public boolean inTheMiddleVertically(String checked_word, int firstPosition_x, int firstPosition_y)
	{
	//x=8
		//AND
	//firstPosition_y<=8 && checked_word.length()+firstPosition_y>=8
	
	}
	
	public boolean inTheMiddleHorizontally(String checked_word, int firstPosition_x, int firstPosition_y)
	{
		//y=8
				//AND
			//firstPosition_x<=8 && checked_word.length()+firstPosition_x>=8
	
	}
	
	public boolean connectsToTileOnBoardHorizontally(String checked_word, int firstPosition_x, int firstPosition_y) {
	//EXTREMELY IMPORTANT- DO THIS TEST ~AFTER~ TESTING FOR CONFLICTS WITH TILES ON BOARD! 
	//have to loop through squares IN RIGHT DIRECTION HORIZONTALLY
		//if square.isEmpty()   //This method I made for displaying if Tile is not on Square yet	
			//do nothing, carry on, i++, continue
		//else if (!square.isEmpty())
			//return true;
		
			
//outside of loop: return false
		}
		
	}
	
	public void reset() {
	//set each square's tile (in squares) to NULL. I can provide a method called square.reset() for that.
	//unless we treat reset only as global 
		//but if we do, challenging word could be tricky
	//refresh (all)
	}
	
	//there will be return function for challenged words => not implementing this Sprint. Just heads up.
	// heads up => there will be player generated inputs 

	
	