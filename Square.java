
public class Cell {
private int position_x;
private int position_y;
private final int TILE_VALUE_MULTIPLIER = 1;
private final int WORD_SCORE_MULTIPLIER = 1;
private Tile tile; 

Cell(position_x,position_y){
	//if(position_x > -1 && position_x < 15) 
	this.position_x = position_x;
	this.position_y = position_y; 
	//!out of bounds x>14?
	
}


public void placeTile(Tile tile) {
this.tile = tile;
}
