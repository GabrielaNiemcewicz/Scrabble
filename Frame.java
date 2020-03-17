package Jabba;

import java.util.ArrayList;

public class Frame {

	private static final int MAX_TILES = 7;
	private ArrayList<Tile> frame;
	
//initialization
	Frame() {
		frame = new ArrayList<Tile>();
	}


//size-related
	public int size() {
		return(frame.size());
	}
	
	public boolean isEmpty() {
		return(frame.size()==0?true:false);
	}
	
	public boolean isFull() {
		return frame.size() == MAX_TILES?true:false;
	}



//check if Tile(s) are in the Frame	
	public boolean isStringIn(String letters) {
		letters = letters.toUpperCase();
		boolean found = true;
		if (letters.length() > frame.size()) {
			found = false;
		}
		else {
			ArrayList<Tile> copyTiles = new ArrayList<Tile>(frame);
			for (int i=0; (i<letters.length()) && found; i++) {
				Tile tileSought = new Tile(letters.charAt(i));
				if (copyTiles.contains(tileSought)) {
					copyTiles.remove(tileSought);
				}
				else {
					found = false;
					break;
				}
			}
		}
		return found;
	}
	
	public boolean isStringIn(char letter) {
		boolean found;
		if (this.size() < 1) {
			found = false;
		}
		else {
			
			 {
				Tile tileSought = new Tile(letter);
				if (frame.contains(tileSought))
				{	found = true;	}
				else 
				{	found = false; }
			}
		}
		return found;
	}
	
	

//accessors
	public ArrayList<Tile> getAllTiles() {
		return frame;
	}

	public Tile accessByIndex (int i) throws Exception
		{ 
		if (i<frame.size()&&i>-1)
		return frame.get(i);
		else 
		throw new Exception("Outside of scope of this frame");
		 }


			//allows access to single letter in the frame
	public Tile accessByLetter (char checkedCharacter) {
			if (this.isStringIn(checkedCharacter)) 
			return frame.get(atWhichIndex(checkedCharacter));	//frame.get(accessTileByIndex(atWhichIndex(checkedCharacter)));
			else return null; 
		}


		public int atWhichIndex (char checkedLetter) {
			int whichIndex = -1;
			if (!frame.isEmpty())
				if (this.isStringIn(checkedLetter)){
			   for (int i=0; i<frame.size(); i++) {
			       		if (frame.get(i).getLetter() == checkedLetter) 
			       			{whichIndex = i; return whichIndex;}
			       } //if not in, in previous version, return -1
			}
			
			if(whichIndex == -1)
				throw new IllegalArgumentException("Didnt convert to uppercase");
				return whichIndex;
			//return checkedLetter;
		}

//setters
	public void refill(Pool pool) {
		int numTilesToDraw = MAX_TILES - this.size();
		ArrayList<Tile> draw = pool.drawTiles(numTilesToDraw);
		frame.addAll(draw);
	}


// helps/aids for getters
	void cleanString(String letters) {
             if(this.isStringIn(letters))
		for (int i=0; (i<letters.length()); i++) {
			frame.remove(new Tile(letters.charAt(i)));
		}
             
	}
  	


	//getters
	public ArrayList<Tile> getTilesByWord(String letters){
		letters = letters.toUpperCase();
		ArrayList<Tile> copy_of_temporary_word = new ArrayList<Tile>(); //temporary_word = word user places on board. Copy has removed letters that are already on board.
		Tile pickedTile;
		char pickedLetter;
		if(this.isStringIn(letters))		
			for (int i=0; i<letters.length(); i++)
				{pickedLetter = letters.charAt(i);
				pickedTile = this.accessByLetter(pickedLetter);
				copy_of_temporary_word.add(pickedTile);}	
		return copy_of_temporary_word;}
	
	
	
	
	
	
	//display on screen
	public void displayAsFrame(){
			/*System.out.print(" || ");
			
		for (int i=0; i<frame.size();i++){ 
			frame.get(i).display(); 
			System.out.print(" | ");
		   }
			System.out.print(" || ");*/
		
		for(int i=0; i<frame.size()*2; i++) {
			if(i==frame.size())
				System.out.println();
			if(i<frame.size())
				System.out.print("|" + frame.get(i).getLetter() + "| ");
			else
				System.out.print("|" + frame.get(i%frame.size()).getValue() + "| ");
		}
		}

	
	public String displayAsString(){
 {			String word = new String();
				for (int i=0; i<frame.size(); i++)
					{word = word + (frame.get(i).getLetter());}
	return word;}
	}
	
	public void addTile(Tile tile) {
		frame.add(tile);
	}
		
//cleaning
		public void reset()
		{ frame.clear();	}

}
	