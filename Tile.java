class Tile {

/***** The Private Instance Variables of Class Tile *****/
	private char letter;
	private int value;

	/***** Tile Constructor *****/
	public Tile (char letter, int value) {
		if(letter >= 'a' && letter <= 'z') // This if statement checks for lowerCase characters, 
			letter = (char) (letter - 32); // Converts LowerCase to UpperCase.
		
		if(!(letter >= 'a' && letter <= 'z') && !(letter >= 'A' && letter <= 'Z')) // if the letter isn't A-z then it throws an exception.
			throw new IllegalArgumentException();
		
		this.letter = letter; // if the above if statement is passed, then it assigns the passed letter to the Instance Var letter.
		
		if(value >= 0 || value <= 10)    // This if statement checks for the value for it to be 0-10 
			this.value = value;
		else throw new IllegalArgumentException();
			
	}

/***** Extra Methods *****/
	
	public char readLetter ()           // Method readLetter() acts like a getter so returns the instance Var letter.
	{ return letter; }
	
	public int readValue ()             // Method readValue() acts like a getter so returns the instance Var Value.
	{ return value; }
	
	public void display ()             // Method display() prints out each letter with its value beside each other.
	{ System.out.println(letter + " " + value); }
	
	public String toString() {        // method toString() is used for display the letter and the value on the Tile.
		return letter + "\n" + value;
	}
	
	
public static void main(String[] args) {
	// Small Test for Display.
		Tile t = new Tile('a', 1);
		System.out.print(t);
	}
}
