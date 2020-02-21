
public class Square {

	private int TILE_MULTIPLIER;
	private int WORD_MULTIPLIER;
	private Tile tile; 
	
	Square(){
		this.TILE_MULTIPLIER = 1;
		this.WORD_MULTIPLIER = 1;
	}
	
	public void setTILE_MULTIPLIER(int TILE_MULTIPLIER) {
		this.TILE_MULTIPLIER = TILE_MULTIPLIER;
	}
	
	public void setWORD_MULTIPLIER(int WORD_MULTIPLIER) {
		this.WORD_MULTIPLIER = WORD_MULTIPLIER;
	}
	
	public void placeTile(Tile tile){
		if (this.isEmpty())	
			this.tile = tile;
	}

	public void removeTile(){
		this.tile = null;
	}
	
	public char getCharacter() {
		if(tile == null)
			return ' ';
		else
			return tile.getLetter(); 
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

}