import java.util.ArrayList;

public class Frame (){
 private ArrayList<Tile> frame;

//A class called Frame that:
//oStores the letters that each player has in their frame+++
public Frame()
{
 this.frame = new ArrayList<Tile>();
}


//oAllows letters to be removed from a frame
//allows letters to be removed from the frame- return statement before clear-> main() sequence?
	/*public void removeAllTiles()
	{
	  frame.accessAll();
	  frame.clear();
	}*/

//allows letters to be removed from the frame - one tile
	private Tile passTiles(char passedLetter) throws Exception
	{return frame.get(atWhichIndex(passedLetter));}


//allows letters to be removed from the frame- one tile
	private void removeTiles (char passedLetter) throws Exception
	{ frame.remove(atWhichIndex(passedLetter)); }

//allows letters to be removed from the frame - no longer return before clearing
	public Tile removeTilesTo(char passedLetter) throws Exception{
		if (isLetterIn(passedLetter)){
			Tile t = passTiles(passedLetter);
			removeTiles(passedLetter);
			return t;
		}
		return null;
	}

//allows letters to be removed from the frame- uses method that had commands after return, now corrected
	public void removeString(String passedString) throws Exception{
		if (passedString.length()>frame.size()) throw new Exception("Too many letters entered");
		for (int i=0; i<passedString.length();i++) removeTilesTo(passedString.charAt(passedString.length()));
	}

//oAllows a check to be made if letters are in theframe
//oAllows a check to be made to see if the frame is empty
//oAllows access to the letters in the frame
//oAllows a frame to be refilled from the pool
//oAllows a frame to be displayed++


}