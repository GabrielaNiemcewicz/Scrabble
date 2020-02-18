import java.util.ArrayList; 

public class Boar {

private Tile[][] board;
private char [][] cardboard;
private boolean[][] isEmpty;
private int SIZE = 15;
private String temporaryWord;
private Pattern scrabble; 
//protected Tile uninitializedNullTile; //never gets initialized. Reassign * pointer to this null-returning object for Square's Tile to return Null on reset/challenge again
private boolean [][] hasTile; 
//anything else?

	public Boar(int SIZE) {
		this.SIZE = SIZE;
		Tile[][]board = new Tile[SIZE][SIZE];
		boolean[][]isEmpty = new boolean[SIZE][SIZE];
		scrabble.drawScrabble();
		for (int i=0;i<this.SIZE; i++)
			for (int j=0;j<this.SIZE; j++)
				{ this.cardboard[i][j]= scrabble.cardboard[i][j];  //bad encapsulation, will fix later
				  this.hasTile[i][j] = false;
				}
	}
	
	
	
	public char display_Tile(int row, int column) {  
		return board[row][column].getLetter();
	}
	
	public char display_Square(int row, int column) {
		return cardboard[row][column];
	}
	
	public void display_TileOrSquare(int row, int column) {
		if (this.hasTile[row][column] == true)
			System.out.print(this.display_Tile(row, column));
		else 
			System.out.print(this.display_Square(row, column));
	}
	
	public void display() {
		for (int i=0;i<this.SIZE; i++)
			for (int j=0;j<this.SIZE; j++)
				{display_TileOrSquare(i,j);
				if (j==this.SIZE-1) 
					System.out.println(); //go 1 line down to new row
				}
		
		
	
	}

	
	
	public void getWord(String userWord) {
		
		this.temporaryWord = userWord;
   
		
	}
	
	
	public void putWordOnBoardHorizontally (ArrayList<Tile> frameWord, int start_row, int start_column){
		//after passing TRUE all validity tests, merged into one horizontal function
		int j=0;
		for (int i=0; i<frameWord.size(); i++)
			if (this.hasTile[start_row][start_column+i]==true)
				continue;
			else //if square is empty
				{this.board[start_row][start_column+i]= frameWord.get(j);
				j++;} 
	}
	
	public void putWordOnBoardVertically (ArrayList<Tile> frameWord, int start_row, int start_column){
		//after passing TRUE all validity tests, merged into one horizontal function
		int j=0;
		for (int i=0; i<frameWord.size(); i++)
			if (this.hasTile[start_row+i][start_column]==true)
				continue;
			else //if square is empty
				{this.board[start_row+i][start_column]= frameWord.get(j);
				j++;} 
	}
	
	public void refresh() {
		
		//???
	}
	
	
	public void putTileOnSquare(Tile tile,int row, int column)
	{
		if (this.hasTile[row][column])
			{this.board[row][column] = tile;
			this.isEmpty[row][column] = false;
			}
		else if (!this.hasTile[row][column])
			System.out.printf("You can't put Tile there- there's already tile at %d,%d",row,column);
		else 
			System.out.printf("Error at %d,%d",row,column);
	}
	}

//method to sort Tiles from Frame to create order to put on board