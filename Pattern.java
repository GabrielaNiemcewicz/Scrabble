//to draw valid Scrabble Board, use  use .drawScrabble. 
//To use smaller methods, Board SIZE = 15, V argument size=7. use method. use print. use reset().
 	//A = TRIPLE WORD SCORE
	//B = DOUBLE WORD SCORE
	//C= TRIPLE LETTER SCORE
	//D= DOUBLE LETTER SCORE
	//o= regular Square

public class Pattern {
private char [][] cardboard; //Scrabble Board in chars

private int SIZE; //size of Board. For scrabble, SIZE=15

Pattern(int size){ //initializer
	this.SIZE = size;
	this.setCardboard(new char[SIZE][SIZE]);
	this.reset(); //sets all characters to regular square, "o"

}
	
public void print() { //print board at any moment
	for (int i=0; i<this.SIZE; i++)
		for (int j=0; j<this.SIZE; j++) {
			System.out.print(this.getCardboard()[i][j]+" "); //display each char one by one
			if (j==this.SIZE-1) 
				System.out.println(""); //go down a line if the row is over
			else continue;}
		
}


public void reset() { 
	for (int i=0; i<this.SIZE; i++)
		for (int j=0; j<this.SIZE; j++)
			this.getCardboard()[i][j] = 'o';
}


public void drawScrabble() { //invoke this method to draw a valid Scrabble board at once
this.draw_all_V(7);
this.draw_X_as_VV();
this.draw_scattered_2L();
this.draw_scattered_3W();
this.print();
}


private int middle() //middle of the board- single index
{ return middle(this.SIZE); }

private int middle(int size) //middle of V pattern- absolut here equals 0, it's "peak", "pointed part"
{ return size/2; }



public void draw_X_as_VV() { 
	draw_V_right();
	draw_V_left();
}

private void draw_V_left() { //part of drawing X
	int j;
	int absolut;
	for (int i=0+1; i<this.SIZE-1; i++)
	{	absolut= java.lang.Math.abs(i-this.middle(this.SIZE));
		j=this.middle(this.SIZE)- absolut;
		
			this.getCardboard()[i][j] = this.assign_type_X(absolut);}
}

private void draw_V_right() { //part of drawing X
	int j;
	int absolut; 
	for (int i=0+1; i<this.SIZE-1; i++){
			absolut= java.lang.Math.abs(i-this.middle(this.SIZE));
			j=this.SIZE-1-(this.middle(this.SIZE)-absolut);

			this.getCardboard()[i][j] = this.assign_type_X(absolut); }
	
}




public void draw_all_V (int size) {
	int j;
	int absolut;
	for (int i=(this.SIZE-size)/2+1; i<(size+this.SIZE)/2-1; i++)
		{absolut = java.lang.Math.abs(i-(this.SIZE-size)/2-this.middle(size));
		j=this.middle(size)-absolut;
			this.getCardboard()[i][j] = this.assign_type_V(absolut); //left
			this.getCardboard()[j][i] = this.assign_type_V(absolut); //up
		j=this.SIZE-1-(this.middle(size)-absolut);
			this.getCardboard()[i][j] = this.assign_type_V(absolut); //right
			this.getCardboard()[j][i] = this.assign_type_V(absolut); //down
}

}

public void draw_scattered_3W () { //scattered squares "multiply word score by 3" 
	for (int i=0; i<this.SIZE; i+=this.middle())
		for (int j=0; j<this.SIZE; j+=this.middle())
			{ if (i==j && i==this.middle())
				continue; //covered by assign_type_X
			  else
				this.getCardboard()[i][j] = this.assign_type_scattered_3W();}
	
	
}

public void draw_scattered_2L () { //scattered squares "multiply letter score by 2" 
	int [] I = {0,14};
	int [] J = {3,this.SIZE-1-3};
		for (int i: I)
		for (int j: J)
		{this.getCardboard()[i][j] = this.assign_type_scattered_2L();
		this.getCardboard()[j][i] = this.assign_type_scattered_2L();}
}

private char assign_type_X(int absolut) 
{ 
	//absolut for X: 6543210123456 and 1 more mirror 
	if (absolut==0)
		return 'B';
	else 
		return this.assign_type_V(absolut);
}

private char assign_type_V(int absolut) {
	//absolut for V: 21012 and 3 more mirrors

	
	if (absolut<2)
		return 'D';
	else if (absolut==2)
		return 'C';
	else //if (absolut<7)
		return 'B';
	
}

private char assign_type_scattered_3W()//A = TRIPLE WORD SCORE
{return 'A'; }

private char assign_type_scattered_2L () 	//D= DOUBLE LETTER SCORE
{ return 'D'; }

public char [][] getCardboard() {
	return cardboard;
}

public void setCardboard(char [][] cardboard) {
	this.cardboard = cardboard;
}

}