
public class Square {

	private int letterMultiplier;
	private int wordMultiplier;
	private Tile tile;
	private Type type;
	
	Square(){
		setType(Type.normal);
	}
	
	private void setLetterMultiplier(int letterMultiplier) {
		this.letterMultiplier = letterMultiplier;
	}
	
	private void setWordMultiplier(int wordMultiplier) {
		this.wordMultiplier = wordMultiplier;
	}
	
	public void setType(Type type) {
		this.type = type;
		setWordMultiplier(type.getWordMultiplier());
		setLetterMultiplier(type.getLetterMultiplier());
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
	
	public int getWordScoreMultiplier() {
		return this.wordMultiplier ;
	}
	
	public int getLetterScoreMultiplier() {
		return this.letterMultiplier ;
	}
	
	public boolean isEmpty() {
		return  this.tile == null ? true : false;
	}
	
	public String toString() {
		return type.toString();
	}

}