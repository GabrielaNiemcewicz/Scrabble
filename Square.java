import static org.junit.Assert.assertNotNull;

public class Square() {
private int position_x;
private int position_y;
private final int TILE_VALUE_MULTIPLIER = 1;
private final int WORD_SCORE_MULTIPLIER = 1;
private Tile tile; 

Square(position_x, position_y){
	if(position_x> -1 && position_x < 15  && position_y> -1 && position_y < 15) { //use isWithinBoard
	this.position_x = position_x;
	this.position_y = position_y; }
	else throw IllegalArgumentException();
	
}

boolean isWithinBoard(int position)
{
	if(position> -1 && position < 15) return true;
	else return false; 
}

public void placeTile(Tile tile) {
this.tile = tile;
}

public boolean isEmpty() {
 if(assertNotNull(tile)) return false;
 else return true;

}

public static void main(String[] args) {
	
	Square square = new Square(3,3);
	System.out.println(square);
	
	
	
}