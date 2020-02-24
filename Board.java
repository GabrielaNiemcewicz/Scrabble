import java.util.*; 

public class Board {

private Square[][] board;
private int SIZE = 15;

boolean isFirstRound = true;



	public Board() {
		Pattern p = new Pattern(SIZE, board);
		
		for (int i=0; i<15; i++)
			for (int j=0; j<15; j++)
				this.board[i][j] = new Square();
	}
		
		
		
		public void display() {  
			/*for(Square[] rows: board) {
				System.out.print("          -------------------------------------------------------------\n          ");
				for(Square squares: rows) {
					System.out.print("| " + squares);
				}
				System.out.println("|");
			}
			System.out.print("          -------------------------------------------------------------\n          ");*/
			
			for(int i=0; i<this.SIZE;i++) {
				System.out.printf("            -------------------------------------------------------------\n        %-4d", i);
				for(int j=0; j<this.SIZE; j++) {
					System.out.print("| " + board[i][j]);
				}
				System.out.println("|");
			}
			System.out.println("            -------------------------------------------------------------");
			System.out.println("              0   1   2   3   4   5   6   7   8   9   10  11  12  13  14");
		}
		
		
		
		//on square.placeTile(Tile), refresh so that updated display square.display() shows
		
//do we use refresh each square, or refresh 
	

	public void refresh() {
		
		System.out.println("Use me in display on ending each successful word placement");
		
	}
	
	
	public void reset() {
		for (Square [] rows:board)
			for (Square squares:rows)
				squares.removeTile();
	}
	
	public void placeWordVertically(Frame frame, int firstPosition_x,int firstPosition_y, String word, Player player)
	{ //in main: board.placeWordVertically(frame.someGetterFunction()) //best get all Tiles needed, get one Tile ok
		ArrayList <Tile> tilesFromFrame= new ArrayList<Tile>();
		String onlyNeededLetters = "";
		
		for (int i=0; i<word.length(); i++)
			if (board[firstPosition_x+i][firstPosition_y].isEmpty())
				onlyNeededLetters+= word.charAt(i);
		
		tilesFromFrame.addAll(frame.getTilesByWord(onlyNeededLetters));
		if(isValidVertically(firstPosition_x, firstPosition_y, frame, onlyNeededLetters, player)) {
			for (Tile tiles:tilesFromFrame) 
				if (board[firstPosition_x+i][firstPosition_y].isEmpty())	
					board[firstPosition_x+i][firstPosition_y].placeTile(tiles);
			
		}
		frame.cleanString(onlyNeededLetters);
		
	}
	
	public void placeWordVertically(Frame frame, int firstPosition_x,int firstPosition_y, String word, Player player)
	{ //in main: board.placeWordVertically(frame.someGetterFunction()) //best get all Tiles needed, get one Tile ok
		ArrayList <Tile> tilesFromFrame= new ArrayList<Tile>();
		
		String onlyNeededLetters = "";
		
		for (int i=0; i<word.length(); i++)
			if (board[firstPosition_x][firstPosition_y+i].isEmpty())
				onlyNeededLetters+= word.charAt(i);
		
		tilesFromFrame = frame.getTilesByWord(onlyNeededLetters);
		if(isValidVertically(firstPosition_x, firstPosition_y, frame, onlyNeededLetters, player)) {
			for (Tile tiles:tilesFromFrame) {
				if (board[firstPosition_x+i][firstPosition_y].isEmpty())	
					board[firstPosition_x+i][firstPosition_y].placeTile(tiles);
			}
		}
		frame.cleanString(onlyNeededLetters);
		
	}
	
	
	//do we need this?
	public boolean isPutHorizontally(char h) {
	if (h=='h')
		return true;
	else
		return false;

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
		{System.out.println("You can't place your word here-last square is out of Board");
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
		 
		
		 System.out.println("Bravo," + player.getName()+ "! You were able to create word: "+word+"...What a luck.");
		for (int i=0;i<6-word.length(); i++) System.out.print("*CLAP*\t");
		System.out.println();
		 return true; //if all tests passed as true
	}	
	
	
	//all sets of tests together
	public boolean isValidVertically(int firstPosition_x, int firstPosition_y, Frame frame, String Word, Player player) {
		Square [] squareWalker; //contains word and 1 square before and after word finishes
		Square [] squareWalkerRight; //1 column of squares on the right to the word
		Square [] squareWalkerLeft; //1 column of squares on the left the word
		
		if(this.isFirstWord())
		   if(!this.inTheMiddle(firstPosition_y,  firstPosition_x, Word))
		   {System.out.println("First word needs to connect to Square in the middle, 8th, 8th");
			return false;}
		
		if(!this.isFirstPositionValid(firstPosition_y, firstPosition_x))
		{System.out.println("You can't start your word here- square index out of Board");
		return false;}
		
		else if(!this.isWithinBounds(firstPosition_x, Word)) //x is mobile
		{System.out.println("You can't place your word here-last square is out of Board");
		return false;}
		
		else
		squareWalker = this.squareWalkerHorizontal(firstPosition_y, firstPosition_x-1,Word.length()+2);
		
		 if(!this.noConflicts(Word, squareWalker))
		 {System.out.println("Your word clashes with letters on the board.");
		  return false;}
		 
		else if(!this.usesFrameTiles(squareWalker, Word)) {
			System.out.println("You used no Tile from Frame. All letters making word are already on Board. ");
				return false;}		 
		
		else if(!this.isInFrame(squareWalker, frame, Word))
		{System.out.println("You don't have enough Tiles of required type to produce this word there");
			return false;}	
		 
		else
		{
		   squareWalkerRight = this.squareWalkerHorizontal(firstPosition_y+1,firstPosition_x, Word.length());		
		   squareWalkerLeft = this.squareWalkerHorizontal(firstPosition_y-1,firstPosition_x, Word.length());
		}
		
		 if(!this.connectsToTiles(squareWalker, squareWalkerRight, squareWalkerLeft))
			{System.out.println("Your word neither uses Tiles on Board nor connects to them paralelly");
			return false;}
		 
		 System.out.println("OH LA LA!," + player.getName()+ "! You were able to create word: "+Word+"...Daamn You're GOOD!.");
			for (int i=0;i<6-Word.length(); i++) System.out.print("*CLAP*\t");
			 return true; //if all tests passed as true
	}	


	
	
	
	
	public boolean isFirstPositionValid(int firstPosition_x, int firstPosition_y) {
		if(firstPosition_x> -1 && firstPosition_x<15 && firstPosition_y> -1 && firstPosition_y<15)
			return true;
		else 
			return false;	
	}
	
	
	public boolean usesFrameTiles(Square[] squareWalker,  String word) {		
		for (int i = 1; i<word.length()+1; i++) // first Square doesn't belong to a word
			if (squareWalker[i].isEmpty()) 
				return true;
		
		return false;}
	//EXTREMELY IMPORTANT- DO THIS TEST AFTER CHECKING FOR CLASHES WITH EXISTING TILES
	public boolean isInFrame(Square[] squareWalker,Frame frame, String word)
	{
	String word_copy = "";	
	
	for (int i=0; i<word.length(); i++)
		if(squareWalker[i+1].isEmpty())
			{
			word_copy +=word.charAt(i);}
	return frame.isStringIn(word_copy);
	
	}


public boolean connectsToTiles(Square [] squareWalker, Square [] squareWalkerUp, Square [] squareWalkerDown)
{ //make a list of square walkers and loop through that list
if(this.isFirstWord())
	return true;

for (Square squares: squareWalker)	
	if (!squares.isEmpty())
		return true;

for (Square squares: squareWalkerUp)	
	if (!squares.isEmpty())
		return true;

for (Square squares: squareWalkerDown)	
	if (!squares.isEmpty())
		return true;

return false;
}
	
	
	public boolean isWithinBounds  (int firstPositionMobile, String temporaryWord)
	{
		if (firstPositionMobile+temporaryWord.length()>15) return false; 
		else return true;	
	}
	

	
	
	
	public boolean noConflicts(String word, Square[] squareWalker)	{
		if(this.isFirstRound)
			return true;	
		
		for (int i=1; i<word.length(); i++)  //squareWalker includes 2 squares that don't belong in the word
			if(!squareWalker[i].isEmpty)
			if (squareWalker[i].getCharacter() != word.charAt(i-1))
				return false; 	
		
		return true;  }
		
	public void set_IsFirstRoundToFalse () 
	{ this.isFirstRound= false; }
	
	
	public boolean isFirstWord() {
		if (this.isFirstRound==true) 
			for (Square []rows:board)
				for (Square squares:rows)
					if (!squares.isEmpty())
						this.set_IsFirstRoundToFalse();
		return this.isFirstRound;
	}
	
	

	
	public boolean inTheMiddle(int firstPositionFixed, int firstPositionMobile, String temporaryWord)
	{
		if(firstPositionFixed!=7)
			return false;
		else if (firstPositionMobile<=7 || temporaryWord.length()+firstPositionMobile>=7)
			return false;
	return true;
	}
	
	public static void main(String[] args) {
		Pool p = new Pool();
		Player p1 = new Player("adam");
		Board b = new Board();
		
		b.display();
		ArrayList<Tile> t = new ArrayList<Tile>();
		p1.getFrame().addTile(new Tile('a'));
		p1.getFrame().displayAsFrame();
		p1.getFrame().getTilesByWord("a");
	}
}