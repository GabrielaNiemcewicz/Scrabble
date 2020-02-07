public class Frame ()
{
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

//oAllows a check to be made if letters are in the frame

//allows a check to be made if letters are in the frame- isIn covers this case too- check if isLetter in is significantly faster or needs type casting- otherwise don't implement
	public boolean isLetterIn (char checkedLetter) throws Exception{
		if (atWhichIndex(checkedLetter) == -1)
		return false;
		else if (atWhichIndex(checkedLetter)<frame.size())
		return true;
		else throw new Exception("Wrong index passed");
	}

	//helps allow a check to be made if letters are in the frame- could do with enhanced loop
	public int atWhichIndex (char checkedLetter) throws Exception{
		if (!frame.isEmpty()){
		   for (int i=0; i<frame.size(); i++) {
		       if (frame.get(i).readLetter() == checkedLetter) return i;
		       else return -1;
		       }
		}
		else throw new Exception("The frame is empty");
		return checkedLetter;
	}

//allows a check to be made if letters are in the frame- not finished because wrong algorithm
	/*public boolean isStringInPrototype(String passedString){
		ArrayList<int> indices = new ArrayList<int>();
		for (int i=0; i<passedString.size(); i++) {
			if (indices.contains(i)) continue;
			if (frame.isIn(!passedString[i])){break;}
			else {
				indices.add(i) continue;}
	
		if (indices.size()==passedString.size()) return [] indices
		}}
		else throw new Exception("Frame is empty- can't remove 1 tile");
	
		//allows a check to be made if letters are in the frame- not finisged because wrong algorithm
		public boolean isStringInPrototype2(String passedString){
		for (int i=0; i<frame.size(); i++) 
		for (int j=0; j<passedString.size();j++)
		if(passedString[i]==frame.get(i).readLetter()) break; else if j
	}*/

//oAllows a check to be made to see if the frame is empty
//oAllows access to the letters in the frame
//oAllows a frame to be refilled from the pool
//oAllows a frame to be displayed++


}