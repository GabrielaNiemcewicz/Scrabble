
import java.util.Objects;


public class Square {
private int position_x;
private int position_y;

private final int TILE_VALUE_MULTIPLIER = 1;
private final int WORD_SCORE_MULTIPLIER = 1;
private Tile tile; 

Square(int position_x,int position_y){
	this.position_x = setPosition(position_x);
	this.position_y = setPosition(position_y); 

	
}

public int setPosition (int position) {
	if(position> -1 && position < 15)
		return position;
	else throw new IllegalArgumentException();}


	


public void placeTile(Tile tile) throws Exception {
	if (this.isEmpty())	
		this.tile = tile;
	else throw new Exception("Error! There's already a Tile placed on the Square...");
}

public char getCharacter() {
	//if(this.tile == null) {//use isEmpty() if check needed; I THINK not needed- it may return NULL if object is NULL => desired property!!
		return tile.readLetter();
		//else return ''; //see later whether Exception or NULL is more useful
	}


public int getSinglePlacementScore() {
	if((this.isEmpty())) 
	return 0; //CHECK LATER: isn't checking Score of empty Square *ALWAYS* indicative of ERROR? => Exception  	
	//private int pointsForLetterPlacement =  this.TILE_VALUE_MULTIPLIER;
	//pointsForLetterPlacement*= this.tile.readValue();
	//return pointsForLetterPlacement; 
	else return this.TILE_VALUE_MULTIPLIER*this.tile.readValue();
}

public int getWordScoreMultiplier() {
	return this.WORD_SCORE_MULTIPLIER ;
}

public boolean isEmpty() {
	return  this.tile == null ? true : false;

}

public boolean isInTheCenter() { //at beginning of game, one of Tiles must land here. Golden rules.
	if(this.position_x==8 && this.position_y==8) 
		return true;
	else return false;
	//then invoke each in Board until true found; if not found => invalid starting word placement on board

	
//alternative implementation in Board-> column beginning word index<=8<=ending word index and row =8; 
//reverse conditions row and column if placed vertically  
}



public void display() { //doesn't go wrong when initiating whole Board, but is quite simplistic...
	//multiple if statements=> 1. multiple functions? (not nice for board initiation...)
	//2. DoubleWordSquare, TripleWordSquare, DoubleLetterSquare, TripleLetterSquare extend Square (too many?)
	//3. MultipleWordSquare, MultipleLetterSquare extend Square (nice!)
	if (this.isEmpty()) {
		if (this.TILE_VALUE_MULTIPLIER>1)
			System.out.printf("[_%iL]",this.TILE_VALUE_MULTIPLIER);
		else if (this.WORD_SCORE_MULTIPLIER>1)
			System.out.printf("[_%iW]",this.WORD_SCORE_MULTIPLIER);
		else System.out.printf("[__]");}
		
	else if (!this.isEmpty())
	System.out.printf("[_%c_],this.getCharacter()");
	else System.out.print("Cell Display error- neither empty nor full");
	
}




}