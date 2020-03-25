package Jabba;
public class Word {

	private int row, column; // first letter position
	private boolean isHorizontal;  // true = horizontal, false = vertical
	private String letters;
	private boolean isBingo;
	private int tilesToBingo = 0;
	
	Word(int row, int column, boolean isHorizontal, String letters) {
		this.row = row;
		this.column = column;
		this.isHorizontal = isHorizontal;
		this.letters = letters.toUpperCase();
	}

	// getRow pre-condition: isHorizontal is true
	public int getRow() {
		return row;
	}

	// getColumn pre-condition: isHorizonal is flase
	public int getColumn() {
		return column;
	}

	public boolean getIsBingo() {
		return isBingo;
	}

	public int getLastRow() {
		if (isHorizontal) {
			return row;
		} else {
			return row + letters.length() - 1;
		}
	}



	public int getLastColumn() {
		if (!isHorizontal) {
			return column;
		} else {
			return column + letters.length() - 1;
		}
	}

	public String getLetters() {
		return letters;
	}
	
	public char getLetter(int i) {
		return letters.charAt(i);
	}
	
	public int getLength() {
		return letters.length();
	}
	
	public boolean isHorizontal() {
		return isHorizontal;
	}

	public boolean isVertical () {
		return !isHorizontal;
	}

	public boolean bingoChecker (){
	//prerequisite- run in Board bingo incremator
	//	size = this.get
		if(this.getLength()<7)
			this.isBingo = false;

			return this.isBingo;

	}


	public void bingoIncrementor (){
		this.tilesToBingo+= 1;
		if (this.tilesToBingo>6)
			this.isBingo = true;
	}

}
