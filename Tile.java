class Tile (char letter) 
{
private char letter 
private int value 

<<<<<<< HEAD
public Tile (char letter) {
this.letter = letter
this.value =  setValue(letter);
}

public char readLetter ()
{ return letter; }

public int readValue ()
{ return value; }

public void display ()
{ System.out.println(letter, value) }

private int setValue(char letter){
switch(letter) {
case 'A':
    return 1;
    break;
case 'B':
    return 3;
    break;
case 'C':
    return 3;
    break;
case 'D':
    return 2;
    break;
case 'E':
    return 1;
    break;
case 'F':
    return 4;
    break;
case 'G':
    return 2;
    break;
case 'H':
    return 4;
    break;
case 'I':
    return 1;
    break;
case 'J':
    return 8;
    break;
case 'K':
    return 5;
    break;
case 'L':
    return 1;
    break;
case 'M':
    return 3;
    break;
case 'N':
    return 1;
    break;
case 'O':
    return 1;
    break;
case 'P':
    return 3;
    break;
case 'Q':
    return 10;
    break;
case 'R':
    return 1;
    break;
case 'S':
    return 1;
    break;
case 'T':
    return 1;
    break;
case 'U':
    return 1;
    break;
case 'V':
    return 4;
    break;
case 'W':
    return 4;
    break;
case 'X':
    return 8;
    break;
case 'Y':
    return 4;
    break;
case 'Z':
    return 10;
    break;
case ' ':
    return 0;
    break;

default:
throw new Exception("Such tile cannot be created");
}
}
=======
public class Tile {
}

>>>>>>> c7e718b1fb25d21c9e0d9fabecbd0ef5bb578a3a
