import java.util.*; 

public class Board {

private Square[][] board = new Square[15][15];
private int SIZE = 15;

boolean isFirstRound = true;
//private String temporaryWord; //proposed implementation for checking if it's first turn. Will help in some implementations of challenging the word. GetWord() gets a word here, rest of functions access it from here.

//anything else?


		public Board() {
			for (int i=0; i<this.SIZE; i++)	
				for (int j=0; j<this.SIZE; j++)
					board[i][j] = new Square();
			Pattern p = new Pattern(15);
			
			
			for (int i=0; i<this.SIZE; i++)	
				for (int j=0; j<this.SIZE; j++) {
					board[i][j] = new Square();
					if(p.getScrabble()[i][j] == 'A')
						board[i][j].setWORD_MULTIPLIER(3);
					else if(p.getScrabble()[i][j] == 'B')
						board[i][j].setWORD_MULTIPLIER(2);
					else if(p.getScrabble()[i][j] == 'C')
						board[i][j].setTILE_MULTIPLIER(3);
					else if(p.getScrabble()[i][j] == 'D')
						board[i][j].setTILE_MULTIPLIER(2);
				}
		}
		
		
		
		public void display() {  
			for(int i=0; i<this.SIZE;i++) {
				System.out.print("          -------------------------------------------------------------\n          ");
				for(int j=0; j<this.SIZE; j++) {
					System.out.print("| " + board[i][j]);
				}
				System.out.println("|");
			}
			System.out.print("          -------------------------------------------------------------\n          ");
		}
		
		
		//on square.placeTile(Tile), refresh so that updated display square.display() shows
		
//do we use refresh each square, or refresh 
	

	public void refresh() {
		
		System.out.println("Use me in display on ending each successful word placement");
		
	}
	
	
	public void reset() {		
	}
	

	
	
	//do we need this?
	public boolean horizontallyOrVertically(char vh) throws Exception {
	if (vh=='h')
		return true;
	else if (vh =='v')
		return false;
	else throw new Exception("Wrong character inputted into vertically or horizontally in board");
	} 

	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	
	
	
	
	
	private Square[] squareWalkerHorizontal (int firstPosition_x, int firstPosition_y, int temporaryWordSize)
	{
		Square [] squareWalker = new Square[temporaryWordSize];
				
		for (int i=0; i<temporaryWordSize; i++)
			squareWalker[i] = this.board[firstPosition_x][firstPosition_y+i];
		
		return squareWalker;
		
	}
	
	private Square[] squareWalkerVertical (int firstPosition_x, int firstPosition_y, int temporaryWordSize)
	{
		Square [] squareWalker = new Square[temporaryWordSize];
		
		for (int i=0; i<temporaryWordSize; i++)
			squareWalker[i] = this.board[firstPosition_x+i][firstPosition_y];
		
		return squareWalker;
		
		
		
	}



	
	
	//all sets of tests together
	public boolean isValidHorizontally(int firstPosition_x, int firstPosition_y, Frame frame, String word, Player player) {
	//if first test not passed, immediately return false, output what happened, else (continue testing)
	//if all tests return true, then isValid returns true.
/////////////////////////////////////////////////////////////////////////////////////////////		
//////////////////////////////////////////////////////////////////////////////////////
	//	List<Square []> validationTestsScope = new ArrayList(); proposition for loop in connectsParallely check
/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////		
		ArrayList<Square[]> validationTestsScope = new ArrayList();
		Square [] squareWalker; //= this.squareWalkerHorizontal(firstPosition_x, firstPosition_y-1, word.length()+2); //contains word and 1 square before and after word finishes
		Square [] squareWalkerUp; //= this.squareWalkerHorizontal(firstPosition_x+1,firstPosition_y, word.length());		
		Square [] squareWalkerDown; //= this.squareWalkerHorizontal(firstPosition_x-1,firstPosition_y, word.length()); //1 row of squares above the word; //
		//possibly: change interfaces to take in ArrayList validationTestsScope instead of squareWalkers. Add to arraylist just before it's needed.
		//validationTestsScope.add(squareWalker); //if index in frame! Important check
		//validationTestsScope.add(squareWalkerDown); //if index in frame! Important check
		//validationTestsScope.add(squareWalkerUp); //if i in frame
		
		
	if(this.isFirstWord())	
		if(!this.inTheMiddle(firstPosition_x,  firstPosition_y, word)) //x is fixed, y is mobile
		{System.out.println("First word needs to connect to Square in the middle, 8th, 8th");
		return false;}
	
	if (!this.isFirstPositionValid(firstPosition_x, firstPosition_y))
		{System.out.println("You can't start your word here- square index out of Board");
		return false;}	

	else if (!this.isWithinBounds(firstPosition_y, word)) //y is mobile
		{System.out.println("You can't start your word here- square from which you started the word is out of Board");
		return false;	
		}	
	else
		squareWalker = this.squareWalkerHorizontal(firstPosition_x, firstPosition_y-1, word.length()+2);
	 if(!this.noConflicts(word, squareWalker))
			{System.out.println("Your word clashes with letters on the board.");
			return false;}	
	
	
	else if(!this.usesFrameTiles(squareWalker, word)) {
			System.out.println("You used no Tile from Frame. All letters making word are already on Board. ");
			return false;}
	
	else if(!this.isInFrame(squareWalker, frame, word))
	{System.out.println("You don't have enough Tiles of required type to produce this word there");
		return false;}	
		else
		{
			squareWalkerUp = this.squareWalkerHorizontal(firstPosition_x+1,firstPosition_y, word.length());		
			squareWalkerDown = this.squareWalkerHorizontal(firstPosition_x-1,firstPosition_y, word.length());
		}
	
		 if(!this.connectsToTiles(squareWalker, squareWalkerUp, squareWalkerDown))
		{System.out.println("Your word neither uses Tiles on Board nor connects to them paralelly");
		return false;}
		 
		
		 System.out.println("Congrats" + player.getName()+ "! What a surprise. You had intellectual capacity to create word: "+word+" How clever. How lucky");
		for (int i=0;i<6-word.length(); i++) System.out.print("*CLAP* ");
		 return true; //if all tests passed as true
	}	
	
	//all sets of tests together
	public boolean isValidVertically(int firstPosition_x, int firstPosition_y, Frame frame, String temporaryWord) {
		Square [] squareWalker; //contains word and 1 square before and after word finishes
		Square [] squareWalkerRight; //1 column of squares on the right to the word
		Square [] squareWalkerLeft; //1 column of squares on the left the word
	return true;
	}	


	
	
	
	
	public boolean isFirstPositionValid(int firstPosition_x, int firstPosition_y) {
		if(firstPosition_x> -1 && firstPosition_x<15 && firstPosition_y> -1 && firstPosition_y<15)
			return true;
		else 
			return false;	
	}
	
	
	public boolean usesFrameTiles(Square[] squareWalker,  String word) {		
		for (int i = 1; i<word.length()+1; i++) // first Square doesn't belong to a word
			if (squareWalker[i].isEmpty()) //beginning and end of squareWalker is outside of word scope
				return true;
		
		return false;}
	//EXTREMELY IMPORTANT- DO THIS TEST AFTER CHECKING FOR CLASHES WITH EXISTING TILES
	public boolean isInFrame(Square[] squareWalker,Frame frame, String word)
	{
	String word_copy = "";	
	
	for (int i=0; i<squareWalker.length-2; i++)
		if(squareWalker[i+1].isEmpty())
			{
			word_copy +=word.charAt(i);}
	return frame.isStringIn(word_copy);
	
	}


public boolean connectsToTiles(Square [] squareWalker, Square [] squareWalkerUp, Square [] squareWalkerDown)
{ //make a list of square walkers and loop through that list
for (Square squares: squareWalker)	
	if (squares.isEmpty())
		return false;

for (Square squares: squareWalkerUp)	
	if (squares.isEmpty())
		return false;

for (Square squares: squareWalkerDown)	
	if (squares.isEmpty())
		return false;
return true;
}
	
	
	public boolean isWithinBounds  (int firstPositionMobile, String temporaryWord)
	{
	
		if (firstPositionMobile+temporaryWord.length()>15) return false; 
		else return true;
	
	}
	

	
	
	
	public boolean noConflicts(String word, Square[] squareWalker)
	{ 
		for (int i=1; i<word.length(); i++) { //squareWalker includes 2 squares that don't belong in the word
			
			if (squareWalker[i].getCharacter() != word.charAt(i-1))
				return false; 
			else 
				continue;
			}
		
		return true;
			}
		
	public void set_IsFirstRoundToFalse () 
	{ this.isFirstRound= false; }
	
	
	public boolean isFirstWord() {
		if (this.isFirstRound==true) {
			for (int i=0; i<this.SIZE; i++)
				for (int j=0; j<this.SIZE; j++)
					if (!this.board[i][j].isEmpty())
						{this.set_IsFirstRoundToFalse();
						return false;}
			
		
		return true; }
		return false;
	}
	
	

	
	public boolean inTheMiddle(int firstPositionFixed, int firstPositionMobile, String temporaryWord)
	{
		if(firstPositionFixed!=7)
			return false;
		else if (firstPositionMobile<=7 && temporaryWord.length()+firstPositionMobile>=7)
			return true;
	return false;
	}
	

	

	

}