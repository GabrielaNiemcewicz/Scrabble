
public enum Type {
	normal(1, "  "),
	doubleWord(2, "2W"),
	tripleWord(3, "3W"),
	doubleLetter(2, "2L"),
	tripleLetter(3, "3L");
	
	private final int multiplier;
	private final String identifier;
	
	Type(int multiplier, String identifier){
		this.multiplier = multiplier;
		this.identifier = identifier;
	}
	
	public int getMultiplier() {
		return multiplier;
	}
	
	public String toString() {
		return identifier;
	}
}
