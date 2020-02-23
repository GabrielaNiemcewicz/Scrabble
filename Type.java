
public enum Type {
	normal(1, 1, "  "),
	doubleWord(1, 2, "2W"),
	tripleWord(1, 3, "3W"),
	doubleLetter(2, 1, "2L"),
	tripleLetter(3, 1, "3L");
	
	private final int WordMultiplier;
	private final int LetterMultiplier;
	private final String identifier;
	
	Type(int LetterMultiplier, int WordMultiplier, String identifier){
		this.LetterMultiplier = LetterMultiplier;
		this.WordMultiplier = WordMultiplier;
		this.identifier = identifier;
	}
	
	public int getWordMultiplier() {
		return WordMultiplier;
	}
	
	public int getLetterMultiplier() {
		return LetterMultiplier;
	}
	
	public String toString() {
		return identifier;
	}
}
