//to draw valid Scrabble Board, use Board SIZE = 15, function V argument size=7, methods in progress
public class Pattern {
private char [][] cardboard;

private int SIZE;

Pattern(int size){
	this.SIZE = size;
	this.cardboard = new char[SIZE][SIZE];
	this.reset();

}
	
public void print() {
	for (int i=0; i<this.SIZE; i++)
		for (int j=0; j<this.SIZE; j++) {
			System.out.print(this.cardboard[i][j]+" ");
			if (j==this.SIZE-1) 
				System.out.println("");
			else continue;}
		
}


public void reset() {
	
	for (int i=0; i<this.SIZE; i++)
		for (int j=0; j<this.SIZE; j++)
			this.cardboard[i][j] = 'o';
	
}

public void drawScrabble() {
this.draw_all_V(7);
this.draw_X_as_VV();
this.draw_scattered_2L();
this.draw_scattered_3W();
}
//public void draw_X () {
//	for (int i=0; i<this.SIZE; i++)
//		{this.cardboard[i][i] = 'x';
//		this.cardboard[this.SIZE-1-i][i] = 'x';}
			
//}
public int middle() {
	return middle(this.SIZE);
}

public int middle(int size)
{
	return size/2;
}

public void draw_V_left () { //part of X
	draw_V_left(this.SIZE);
}

public void draw_V_right() { //part of X
	draw_V_right(this.SIZE);
}

public void draw_X_as_VV() {
	draw_V_right();
	draw_V_left();
}

public void draw_V_left(int size) {
	int j;
	int absolut;
	for (int i=(this.SIZE-size)/2+1; i<(size+this.SIZE)/2-1; i++)
	{	absolut= java.lang.Math.abs(i-(this.SIZE-size)/2-this.middle(size));
		j=this.middle(size)- absolut;
		
		if (this.SIZE==size) //think over lambda as an argument? Or rewrite to separate function?
			this.cardboard[i][j] = this.assign_type_X(absolut);
		else
			this.cardboard[i][j] = this.assign_type_V(absolut);}
}

public void draw_V_right(int size) {
	int j;
	int absolut; 
	for (int i=(this.SIZE-size)/2+1; i<(size+this.SIZE)/2-1; i++)
		{absolut= java.lang.Math.abs(i-(this.SIZE-size)/2-this.middle(size));
		j=this.SIZE-1-(this.middle(size)-absolut);
		if (this.SIZE==size) //think over lambda as an argument? Or rewrite to separate function?
			this.cardboard[i][j] = this.assign_type_X(absolut);
		else
			this.cardboard[i][j] = this.assign_type_V(absolut); }
	
}

public void draw_V_up(int size) {
	int j;
	int absolut;
	for (int i=(this.SIZE-size)/2+1; i<(size+this.SIZE)/2-1; i++)
		{absolut=java.lang.Math.abs(i-(this.SIZE-size)/2-this.middle(size));
		j=this.middle(size)-absolut;
		this.cardboard[j][i] = this.assign_type_V(absolut); }
}



public void draw_V_down (int size) {
	int j;
	int absolut;
	for (int i=(this.SIZE-size)/2+1; i<(size+this.SIZE)/2-1; i++) {
		{	absolut = java.lang.Math.abs(i-(this.SIZE-size)/2-this.middle(size));
			j=this.SIZE-1-(this.middle(size)-absolut);
		this.cardboard[j][i] = this.assign_type_V(absolut); }
}

}

public void draw_all_V (int size) {
	int j;
	int absolut;
	for (int i=(this.SIZE-size)/2+1; i<(size+this.SIZE)/2-1; i++)
		{absolut = java.lang.Math.abs(i-(this.SIZE-size)/2-this.middle(size));
		j=this.middle(size)-absolut;
			this.cardboard[i][j] = this.assign_type_V(absolut);
			this.cardboard[j][i] = this.assign_type_V(absolut);
		j=this.SIZE-1-(this.middle(size)-absolut);
			this.cardboard[i][j] = this.assign_type_V(absolut);
			this.cardboard[j][i] = this.assign_type_V(absolut);
}

}

public void draw_scattered_3W () {
	for (int i=0; i<this.SIZE; i+=this.middle())
		for (int j=0; j<this.SIZE; j+=this.middle())
			{ if (i==j && i==this.middle())
				continue; //covered by assign_type_X
			  else
				this.cardboard[i][j] = this.assign_type_scattered_3W();}
	
	
}

public void draw_scattered_2L () {
	int [] I = {0,14};
	int [] J = {2,this.SIZE-1-2};
		for (int i: I)
		for (int j: J)
		{this.cardboard[i][j] = this.assign_type_scattered_2L();
		this.cardboard[j][i] = this.assign_type_scattered_2L();
		//System.out.printf("i: %d, j: %d\n",i,j);
		}
}

public char assign_type_X(int absolut) 
{ 
	//absolut for X: 765432101234567 and mirror 
	//A = TRIPLE WORD SCORE
	//B = DOUBLE WORD SCORE
	//C= TRIPLE LETTER SCORE
	//D= DOUBLE LETTER SCORE
	if (absolut==0)
		return 'B';
	else 
		return this.assign_type_V(absolut);
}

public char assign_type_V(int absolut) {
	//absolut for V: 21012
	//A = TRIPLE WORD SCORE
	//B = DOUBLE WORD SCORE
	//C= TRIPLE LETTER SCORE
	//D= DOUBLE LETTER SCORE
	char d = 'D';
	char c = 'C';
	char b = 'B';
	if (absolut<2)
		return d;
	else if (absolut==2)
		return c;
	else if (absolut<7)
		return b;
	else return 'e';
	
}

public char assign_type_scattered_3W()//A = TRIPLE WORD SCORE
{return 'A'; }

public char assign_type_scattered_2L () 	//D= DOUBLE LETTER SCORE
{ return 'D'; }

}