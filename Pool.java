import java.util.ArrayList;
import java.util.Random;

public class Pool {
	ArrayList<Tile> pool = new ArrayList<Tile>();		//stores tile objects for the pool
	
	public Pool() {
		setPool();			//creates the pool
	}
	
	//this function initializes 100 tiles and stores them in an array list
	public void setPool() {
		//Adds the tiles that appear only once in the pool
		pool.add(new Tile('J', 8));
		pool.add(new Tile('K', 5));
		pool.add(new Tile('Q', 10));
		pool.add(new Tile('X', 8));
		pool.add(new Tile('Z', 10));
		
		for(int i=0;i<12;i++) {	
                        //Adds tiles that appear twice 
			if(i<2) {
				pool.add(new Tile('B', 3));
				pool.add(new Tile('C', 3));
				pool.add(new Tile('F', 4));
				pool.add(new Tile('H', 4));
				pool.add(new Tile('M', 3));
				pool.add(new Tile('P', 3));
				pool.add(new Tile('V', 4));
				pool.add(new Tile('W', 4));
				pool.add(new Tile('Y', 4));
				pool.add(new Tile(' ', 0));
			}
			//Adds tiles that appear three times
			if(i<3)
				pool.add(new Tile('G', 2));
			//Adds tiles that appear 4 times
			if(i<4) {
				pool.add(new Tile('D', 2));
				pool.add(new Tile('L', 1));
				pool.add(new Tile('S', 1));
				pool.add(new Tile('U', 1));
			}
			//Adds tiles that appear 6 times
			if(i<6) {
				pool.add(new Tile('N', 1));
				pool.add(new Tile('R', 1));
				pool.add(new Tile('T', 1));
			}
			//Adds tiles that appear 8 times
			if(i<8)
				pool.add(new Tile('O', 1));
                        //Adds tiles that appear 9 times
			if(i<9) {
				pool.add(new Tile('I', 1));
				pool.add(new Tile('A', 1));
			}
                        //Adds tiles that appears 12 times
			if(i<12)
				pool.add(new Tile('E', 1));
		}
	}
	
	//resets the pool by calling setpool()
	public void resetPool() {
		pool.removeAll(pool);
		setPool();
		System.out.println("Pool has been reset");
	}
	
	//returns the number of tiles in the pool
		public int NumOfTiles() {
			return pool.size();
		}
		
	//function to check if the pool is empty
	//returns true if empty
	public boolean IsEmpty() {
		return pool.isEmpty();
	}
	
	//method to draw N random tiles from the pool
	public Tile[] Draw(int NumOfTiles) {
		if(NumOfTiles>7 || NumOfTiles<0)			//checks if the number of tiles 
			throw new IllegalArgumentException();
		
		Random r = new Random();
		int random;                //initialising an int value to store the random number generated
		Tile temp[] = new Tile[NumOfTiles];		//array to store randomly generated tiles. Size is dependent on the number of tiles requested
	
		for(int i=0; i<NumOfTiles; i++) {
			if(IsEmpty())						//if pool is empty it breaks from the loop
				break;
			random = r.nextInt(pool.size());		//chooses a random number between 0 and 26
			temp[i] = pool.get(random);                   //stores the random tile in the array
			pool.remove(random);                       //removes selected tile from the pool
		}		
		return temp;        //returns the filled array
	}	
	
	//method that returns the value of a tile
	public int valueOfTile(Tile tile) {
		return tile.readValue();
	}
}
