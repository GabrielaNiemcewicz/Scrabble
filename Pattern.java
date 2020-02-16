
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
	draw_V_right(this.SIZE);
	draw_V_left(this.SIZE);
}

public void draw_V_left(int size) {
	int j;
	for (int i=(this.SIZE-size)/2; i<(size+this.SIZE)/2; i++)
		{j=this.middle(size)-java.lang.Math.abs(i-(this.SIZE-size)/2-this.middle(size));
		this.cardboard[i][j] = 'v'; }
}

public void draw_V_right(int size) {
	int j;
	for (int i=(this.SIZE-size)/2; i<(size+this.SIZE)/2; i++)
		{j=this.SIZE-1-(this.middle(size)-java.lang.Math.abs(i-(this.SIZE-size)/2-this.middle(size)));
		this.cardboard[i][j] = 'v'; }
	
}

public void draw_V_up(int size) {
	int j;
	for (int i=(this.SIZE-size)/2; i<(size+this.SIZE)/2; i++)
		{j=this.middle(size)-java.lang.Math.abs(i-(this.SIZE-size)/2-this.middle(size));
		this.cardboard[j][i] = 'v'; }
}



public void draw_V_down (int size) {
	int j;
	for (int i=(this.SIZE-size)/2; i<(size+this.SIZE)/2; i++) {
		{j=this.SIZE-1-(this.middle(size)-java.lang.Math.abs(i-(this.SIZE-size)/2-this.middle(size)));
		this.cardboard[j][i] = 'v'; }
}

}

public void draw_all_V (int size) {
	int j;
	for (int i=(this.SIZE-size)/2; i<(size+this.SIZE)/2; i++)
		j=this.middle(size)-java.lang.Math.abs(i-(this.SIZE-size)/2-this.middle(size));
			this.cardboard[i][j] = 'v';
			this.cardboard[j][i] = 'v';
		j=this.SIZE-1-(this.middle(size)-java.lang.Math.abs(i-(this.SIZE-size)/2-this.middle(size)));
			this.cardboard[i][j] = 'v';
			this.cardboard[j][i] = 'v';
}


}