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