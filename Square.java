package Jabba;

public class Square {

	private Tile tile;
	private Type type;
	
	Square(){
		setType(Type.NORMAL);
	}
	
	public void setType(Type type) {
		this.type = type;
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
	
	public int getWordMultiplier() {
		return type.getWordMultiplier();
	}
	
	public int getLetterMultiplier() {
		return type.getLetterMultiplier();
	}
	
	public boolean isEmpty() {
		return  this.tile == null ? true : false;
	}
	
	public String toString() {
		if(isEmpty())
			return type.toString();
		else
			return "" + tile.toString();
	}
}
