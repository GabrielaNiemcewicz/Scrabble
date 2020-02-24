//to draw valid Scrabble Board, use  use .drawScrabble. 
//To use smaller methods, Board SIZE = 15, V argument size=7. Also, 7=middle() for SIZE=15. use method. use print. use reset().
 	//A = TRIPLE WORD SCORE
	//B = DOUBLE WORD SCORE
	//C= TRIPLE LETTER SCORE
	//D= DOUBLE LETTER SCORE
	//o= regular Square

//algorithm uses 2 symmetry axes of scrabble board- one axis by divide and conquer, second by absolut= |x|
//absolut = distance of referenced mirror images of 2 Squares from pointy "peak" of V. 



public class Pattern {
public Square [][] scrabble; //Scrabble Board in chars

private int SIZE; //size of Board. For scrabble, SIZE=15

Pattern(int size, Square[][] board){ //initializer
	this.SIZE = size;
	this.setScrabble(board);
	this.reset(board); //sets all characters to regular square, "o"
	drawScrabble(board);
}
	
public void print() { //print board at any moment
	for (int i=0; i<this.SIZE; i++)
		for (int j=0; j<this.SIZE; j++) {
			System.out.print(this.getScrabble()[i][j]+" "); 
			if (j==this.SIZE-1) 
				System.out.println(""); //go down a line if the row is over
			else continue;}
		
}


public void reset(Square[][] board) { 
	for (int i=0; i<this.SIZE; i++)
		for (int j=0; j<this.SIZE; j++)
			board[i][j] = new Square();
}


public Square [][] drawScrabble(Square[][] board) { //invoke this method to draw a valid Scrabble board at once
this.draw_all_V(this.middle(), board);
this.draw_X_as_VV(board);
this.draw_scattered_2L(board);
this.draw_scattered_3W(board);
return board;
}


private int middle() //middle of the board- single index
{ return middle(this.SIZE); }

private int middle(int size) //middle of V pattern- absolut here equals 0, it's "peak", "pointed part"
{ return size/2; }




private void draw_X_as_VV(Square[][] board) { //part of drawing X. X, ><, as > and <. Draws from up 0 row, down to bottom row, by going left>-right<-left>-right<-left>-right<....
	int j;
	int absolut;
	for (int i=0+1; i<this.SIZE-1; i++) //Vs don't 'touch' edges of Board
	{	absolut= java.lang.Math.abs(i-this.middle(this.SIZE));
		if (absolut==0) continue; //double assigning problem at square(middle(),middle()) solved by omitting it 
	
		//left half of the X,  V-shape. Draw >
		j=this.middle(this.SIZE)- absolut;	
		board[j][i].setType(assign_type_V(absolut));
		
		//right half of the X, of V-shape. Draw <
		j=this.SIZE-1-j;
		board[j][i].setType(assign_type_V(absolut));
		
	
	}
}




public void draw_all_V (int size, Square[][] board) {
	int j;
	int absolut;
	for (int i=(this.SIZE-size)/2+1; i<(size+this.SIZE)/2-1; i++)
		{absolut = java.lang.Math.abs(i-(this.SIZE-size)/2-this.middle(size));
		
		  j=this.middle(size)-absolut;
		  board[i][j].setType(assign_type_V(absolut)); //left
		  board[j][i].setType(assign_type_V(absolut)); //up
		
		  j=this.SIZE-1-j;
		  board[i][j].setType(assign_type_V(absolut)); //right
		  board[j][i].setType(assign_type_V(absolut)); //down
}

}

public void draw_scattered_3W (Square[][] board) {
	for (int i=0; i<this.SIZE; i+=this.middle())
		for (int j=0; j<this.SIZE; j+=this.middle())
				  board[i][j].setType(assign_type_scattered_3W(i,j));}
	
	


public void draw_scattered_2L (Square[][] board) { 
	int [] I = {0,this.SIZE-1}; //first [] => up and down border of Board, OR second [] => left and right border 
	int [] J = {this.middle(this.middle()),I[1]-this.middle(this.middle())}; //3 positions away from left and right borders
		for (int i: I) 
		for (int j: J)
		{board[i][j].setType(assign_type_scattered_2L());
		board[j][i].setType(assign_type_scattered_2L());}
}



private Type assign_type_V(int absolut) {
	//absolut for small V-pattern: 21012 and 3 more mirrors
	//absolut for X-pattern: 654321123456 and 1 mirror //no 0, because double assigning conflict at 0

	
	if (absolut<2)
		return Type.doubleLetter;
	else if (absolut==2)
		return Type.tripleLetter;
	else //if (absolut<7)
		return Type.doubleWord;
	
}

private Type assign_type_scattered_3W(int position_x, int position_y)//A = TRIPLE WORD SCORE, B= DOUBLE word SCORE
{
	if (position_x==this.middle() && position_y==this.middle())
		return Type.doubleWord;
	else
		return Type.tripleWord; }

private Type assign_type_scattered_2L () 	//D= DOUBLE LETTER SCORE
{ return Type.doubleLetter; }


private Type 


public Square [][] getScrabble() {
	return scrabble;
}

public void setScrabble(Square [][] scrabble) {
	this.scrabble = scrabble;
}

}

/*absolut value algorithm is derived as set of transformations of f(x) = |x| function:
|x-7|, to return only positive indices within scope of scrabble board, size = 15. If size=?, then|x-middle()|
 7-|x-7|, to start drawing V from 0, that is from edge of board.  
 middle()-|x-middle()| 
Exclude i=0, i=SIZE-1 from the 'for-loop'to not include Squares that are on edge of board
Exclude Square with absolut=0 from drawing X pattern by two V patterns- left and right. Reason: value assigned two times. Different value to rule of V assignment. If removed from rules, V and X assignment rules are identical. Middle X assignment belongs to draw_Scttered_3W. 
middle(size)-|x+VECTOR-middle(size)| For small V: add displacement vector, so that's middle(size) is at middle(). So that small V is in the middle, and not drawn from index 0.
VECTOR OF DISPLACEMENT: start drawing at egde of board at (SIZE-size)/2. 
	for small v= (15-7)/2 = 3 mod.1 = 3 (drop modulo).
	for big V = (15-15)/0 = 0 ( X goes across the corners, thus 0)
Divide by 2 because of symmetry of Squares outside of V. If V.size is 7, 15-7=8 squares outside of V. 4 squares each side. Counted from index 0.  So using V-start vector ends up with result 3.
END OF VECTOR OF DISPLACEMENT= beginning+length = (SIZE-size)/2 + size = SIZE/2 +size/2 = (size+SIZE)/2
^in practice, FROM (size-SIZE)/2-1 TO (size+SIZE)/2-1, because ends of V were trimmed, so that they don't touch edge of board 
*/