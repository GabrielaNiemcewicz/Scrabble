import java.util.*; 

public class Board {

private Square[][] board = new Square [15][15];
private int SIZE = 15;

boolean isFirstRound;



	public Board() {
		Pattern pattern = new Pattern(board);
		pattern.drawScrabble(board);
		this.isFirstRound = true;
	}
		
		
		
		public void display() {  
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
				if (board[firstPosition_x++][firstPosition_y].isEmpty())	
					board[firstPosition_x++][firstPosition_y].placeTile(tiles);
			frame.cleanString(onlyNeededLetters);
			this.display();
		}
		
		
	}
	
	public void placeWordHorizontally(Frame frame, int firstPosition_x,int firstPosition_y, String word, Player player)
	{ //in main: board.placeWordVertically(frame.someGetterFunction()) //best get all Tiles needed, get one Tile ok
		ArrayList <Tile> tilesFromFrame= new ArrayList<Tile>();
		
		String onlyNeededLetters = "";
		
		for (int i=0; i<word.length(); i++)
			if (board[firstPosition_x][firstPosition_y+i].isEmpty())
				onlyNeededLetters+= word.charAt(i);
		
		tilesFromFrame = frame.getTilesByWord(onlyNeededLetters);
		if(isValidVertically(firstPosition_x, firstPosition_y, frame, onlyNeededLetters, player)) {
			for (Tile tiles:tilesFromFrame) {
				if (board[firstPosition_x][firstPosition_y++].isEmpty())	
					board[firstPosition_x][firstPosition_y++].placeTile(tiles);
			}
			frame.cleanString(onlyNeededLetters);
			this.display();
		}
		
		
	}
	
	
	//do we need this?
	public boolean isPutHorizontally(char h) {
	if (h=='h')
		return true;
	else
		return false;

	} 

	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	
	
	
	
	
	private ArrayList<Square> squareWalkerHorizontal (int firstPosition_x, int firstPosition_y, int temporaryWordSize)
	{
		ArrayList <Square> squareWalker = new ArrayList<Square>();
				
		for (int i=0; i<temporaryWordSize; i++)
			if(firstPosition_y+i>-1 &&firstPosition_y+i<15)
				squareWalker.add(this.board[firstPosition_x][firstPosition_y+i]);
		
		return squareWalker;
		
	}
	
	private ArrayList<Square> squareWalkerVertical (int firstPosition_x, int firstPosition_y, int temporaryWordSize)
	{
		ArrayList <Square> squareWalker = new ArrayList<Square>();
		for (int i=0; i<temporaryWordSize; i++)
			if(firstPosition_y+i>-1 &&firstPosition_y+i<15)		
				squareWalker.add(this.board[firstPosition_x+i][firstPosition_y]);
		
		return squareWalker;
		
	}



	
	
	//all sets of tests together
	public boolean isValidHorizontally(int firstPosition_x, int firstPosition_y, Frame frame, String word, Player player) {
	//if first test not passed, immediately return false, output what happened, else (continue testing)
	//if all tests return true, then isValid returns true.


		ArrayList<Square> validationTestsScope = new ArrayList();
		ArrayList <Square> squareWalker; 
		ArrayList<Square> squareWalkerUp; 	
		ArrayList<Square> squareWalkerDown; 
		
		
		
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
		{
		squareWalker = this.squareWalkerHorizontal(firstPosition_x, firstPosition_y-1, word.length()+2);
		validationTestsScope.addAll(squareWalker);
		
		}
	 if(!this.noConflicts(word, validationTestsScope))
			{System.out.println("Your word clashes with letters on the board.");
			return false;}	
	
	
	else if(!this.usesFrameTiles(validationTestsScope, word)) {
			System.out.println("You used no Tile from Frame. All letters making word are already on Board. ");
			return false;}
	
	else if(!this.isInFrame(validationTestsScope, frame, word))
	{System.out.println("You don't have enough Tiles of required type to produce this word there");
		return false;}	
		else
		{
			squareWalkerUp = this.squareWalkerHorizontal(firstPosition_x+1,firstPosition_y, word.length());		
			squareWalkerDown = this.squareWalkerHorizontal(firstPosition_x-1,firstPosition_y, word.length());
			validationTestsScope.addAll(squareWalkerUp);
			validationTestsScope.addAll(squareWalkerUp);
		}
	
		 if(!this.connectsToTiles(validationTestsScope))
		{System.out.println("Your word neither uses Tiles on Board nor connects to them paralelly");
		return false;}
		 
		
		 System.out.println("Bravo," + player.getName()+ "! You were able to create word: "+word+"...What a luck.");
		for (int i=0;i<(5-word.length())*3; i++) System.out.print("*CLAP*\t");
		System.out.println();
		 return true; //if all tests passed as true
	}	
	
	
	//all sets of tests together
	public boolean isValidVertically(int firstPosition_x, int firstPosition_y, Frame frame, String word, Player player) {
		ArrayList<Square> validationTestsScope = new ArrayList();
		ArrayList <Square> squareWalker; //= this.squareWalkerHorizontal(firstPosition_x, firstPosition_y-1, word.length()+2); //contains word and 1 square before and after word finishes
		ArrayList<Square> squareWalkerLeft; //= this.squareWalkerHorizontal(firstPosition_x+1,firstPosition_y, word.length());		
		ArrayList<Square> squareWalkerRight;
		
		if(this.isFirstWord())
		   if(!this.inTheMiddle(firstPosition_y,  firstPosition_x, word))
		   {System.out.println("First word needs to connect to Square in the middle, 8th, 8th");
			return false;}
		
		if(!this.isFirstPositionValid(firstPosition_y, firstPosition_x))
		{System.out.println("You can't start your word here- square index out of Board");
		return false;}
		
		else if(!this.isWithinBounds(firstPosition_x, word)) //x is mobile
		{System.out.println("You can't place your word here-last square is out of Board");
		return false;}
		
		else
		{squareWalker = this.squareWalkerVertical(firstPosition_x-1, firstPosition_y,word.length()+2);
		validationTestsScope.addAll(squareWalker);}
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
		   squareWalkerRight = this.squareWalkerVertical(firstPosition_x,firstPosition_y+1, word.length());		
		   squareWalkerLeft = this.squareWalkerVertical(firstPosition_x,firstPosition_y-1, word.length());
		   validationTestsScope.addAll(squareWalkerRight);
		   validationTestsScope.addAll(squareWalkerLeft);
		
		}
		
		 if(!this.connectsToTiles(validationTestsScope))
			{System.out.println("Your word neither uses Tiles on Board nor connects to them paralelly");
			return false;}
		 
		 System.out.println("OH LA LA!," + player.getName()+ "! You were able to create word: "+word+"...Daamn You're GOOD!.");
			for (int i=0;i<(6-word.length())*2; i++) System.out.print("*CLAP*\t");
			 return true; //if all tests passed as true
	}	


	
	
	
	
	public boolean isFirstPositionValid(int firstPosition_x, int firstPosition_y) {
		if(firstPosition_x> -1 && firstPosition_x<15 && firstPosition_y> -1 && firstPosition_y<15)
			return true;
		else 
			return false;	
	}
	
	
	public boolean usesFrameTiles(ArrayList<Square> validationTestsScope,  String word) {		
		for (int i = 1; i<word.length()+1; i++) // first Square doesn't belong to a word
			if (validationTestsScope.get(i).isEmpty()) 
				return true;
		
		return false;}
	//EXTREMELY IMPORTANT- DO THIS TEST AFTER CHECKING FOR CLASHES WITH EXISTING TILES
	public boolean isInFrame(ArrayList<Square> validationTestsScope,Frame frame, String word)
	{
	String word_copy = "";	
	
	for (int i=0; i<word.length(); i++)
		if(validationTestsScope.get(i).isEmpty())
			{
			word_copy +=word.charAt(i);}
	return frame.isStringIn(word_copy);
	
	}


public boolean connectsToTiles(ArrayList<Square> validationTestsScope)
{ //make a list of square walkers and loop through that list
if(this.isFirstWord())
	return true;

for (Square squares: validationTestsScope)	
	if (!squares.isEmpty())
		return true;


return false;
}
	
	
	public boolean isWithinBounds  (int firstPositionMobile, String temporaryWord)
	{
		if (firstPositionMobile+temporaryWord.length()>15) return false; 
		else return true;	
	}
	

	
	
	
	public boolean noConflicts(String word, ArrayList<Square> validationTestsScope)	{
		if(this.isFirstRound)
			return true;	
		
		for (int i=1; i<validationTestsScope.size()-1; i++)  //squareWalker includes 2 squares that don't belong in the word
			if(!validationTestsScope.get(i).isEmpty())
				if (validationTestsScope.get(i).getCharacter() != word.charAt(i-1))
					return false; 	
		
		return true;  }
	
		
	public void set_IsFirstRoundToFalse () 
	{ this.isFirstRound= false; }
	
	
	public boolean isFirstWord() {
		if (this.isFirstRound==true) 
			for (int i=0; i<this.SIZE; i++)
				for (int j=0; j<this.SIZE; j++)
					if (!this.board[i][j].isEmpty())
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