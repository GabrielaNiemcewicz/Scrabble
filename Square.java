
public class Square {

private int TILE_MULTIPLIER;
private int WORD_MULTIPLIER;
private Tile tile; 

Square(){
	this.TILE_MULTIPLIER = 1;
	this.WORD_MULTIPLIER = 1;
	
}

public void placeTile(Tile tile){
	if (this.isEmpty())	
		this.tile = tile;
	//else throw new Exception("Error! There's already a Tile placed on the Square...");
}

public char getCharacter() {
	//if(this.tile == null) {//use isEmpty() if check needed; I THINK not needed- it may return NULL if object is NULL => desired property!!
		return tile.getLetter(); 
		//else return ''; //see later whether Exception or NULL is more useful
	}


public int getSinglePlacementScore() {
	if((this.isEmpty())) 
	return 0; //CHECK LATER: isn't checking Score of empty Square *ALWAYS* indicative of ERROR? => Exception  	
	else return this.TILE_MULTIPLIER*this.tile.getValue();
}

public int getWordScoreMultiplier() {
	return this.WORD_MULTIPLIER ;
}

public boolean isEmpty() {
	return  this.tile == null ? true : false;

}

public void removeTile(){
	this.tile = null;
}

}