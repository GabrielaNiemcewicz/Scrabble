<<<<<<< HEAD
class Tile (char letter, int value) 
{
private char letter;
private int value;

public Tile (char letter, int value) {
 //[a-zA-Z]
//char properValue = '[0-10]'
//char isALetter = '[a-zA-Z]'
this.letter = letter;
this.value =  value;
}

public char readLetter ()
{ return letter; }

public int readValue ()
{ return value; }

public void display ()
{System.out.printf("%c%d",letter, value);}
}
=======
class Tile {
	private char letter;
	private int value;
	
	public Tile (char letter, int value) {
		this.letter = letter;
		this.value = value;
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
		Tile t = new Tile('A', 1);
		
		System.out.print(t);
	}
}
>>>>>>> refs/remotes/origin/master
