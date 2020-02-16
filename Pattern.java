
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

//public void draw_X () {
//	for (int i=0; i<this.SIZE; i++)
//		{this.cardboard[i][i] = 'x';
//		this.cardboard[this.SIZE-1-i][i] = 'x';}
			
//}
public int middle() {
	return middle(this.SIZE/2);
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
	for (int i=(this.SIZE-size)/2; i<(size+this.SIZE)/2; i++)
	{	absolut= java.lang.Math.abs(i-(this.SIZE-size)/2-this.middle(size));
		j=this.middle(size)- absolut;
		this.cardboard[i][j] = 'v';}
}

public void draw_V_right(int size) {
	int j;
	int absolut; 
	for (int i=(this.SIZE-size)/2; i<(size+this.SIZE)/2; i++)
		{absolut= java.lang.Math.abs(i-(this.SIZE-size)/2-this.middle(size));
		j=this.SIZE-1-(this.middle(size)-absolut);
		this.cardboard[i][j] = 'v'; }
	
}

public void draw_V_up(int size) {
	int j;
	int absolut;
	for (int i=(this.SIZE-size)/2; i<(size+this.SIZE)/2; i++)
		{absolut=java.lang.Math.abs(i-(this.SIZE-size)/2-this.middle(size));
		j=this.middle(size)-absolut;
		this.cardboard[j][i] = 'v'; }
}



public void draw_V_down (int size) {
	int j;
	int absolut;
	for (int i=(this.SIZE-size)/2; i<(size+this.SIZE)/2; i++) {
		{	absolut = java.lang.Math.abs(i-(this.SIZE-size)/2-this.middle(size));
			j=this.SIZE-1-(this.middle(size)-absolut);
		this.cardboard[j][i] = 'v'; System.out.print(absolut); }
}

}

public void draw_all_V (int size) {
	int j;
	int absolut;
	for (int i=(this.SIZE-size)/2; i<(size+this.SIZE)/2; i++)
		{absolut = java.lang.Math.abs(i-(this.SIZE-size)/2-this.middle(size));
		j=this.middle(size)-absolut;
			this.cardboard[i][j] = 'v';
			this.cardboard[j][i] = 'v';
		j=this.SIZE-1-(this.middle(size)-absolut);
			this.cardboard[i][j] = 'v';
			this.cardboard[j][i] = 'v';
}

}

public char assign_type_X(int absolut) throws Exception
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

public char assign_type_V(int absolut) throws Exception {
	//absolut for V: 21012
	//A = TRIPLE WORD SCORE
	//B = DOUBLE WORD SCORE
	//C= TRIPLE LETTER SCORE
	//D= DOUBLE LETTER SCORE
	if (absolut<2)
		return 'D';
	else if (absolut==2)
		return 'C';
	else if (absolut<7)
		return 'B';
	else if (absolut ==7)
		return 'A';
	else throw new Exception("Distance of Tile with value multiplier from the middle is out of bounds of the board");
	
}

}