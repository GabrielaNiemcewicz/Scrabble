class Tile {
	private char letter;
	private int value;
	
	public Tile (char letter, int value) {
		if(letter >= 'a' && letter <= 'z')
			letter = (char) (letter - 32);
		
		if(!(letter >= 'a' && letter <= 'z') && !(letter >= 'A' && letter <= 'Z'))
			throw new IllegalArgumentException();
		
		this.letter = letter;
		
		if(value >= 0 || value <= 10)
			this.value = value;
		else throw new IllegalArgumentException();
			
	}

	public char readLetter ()
	{ return letter; }
	
	public int readValue ()
	{ return value; }
	
	public void display ()
	{ System.out.println(letter + " " + value); }
	
	public String toString() {
		return letter + "\n" + value;
	}
	
	
public static void main(String[] args) {
		Tile t = new Tile('a', 1);
		
		System.out.print(t);
	}
}
