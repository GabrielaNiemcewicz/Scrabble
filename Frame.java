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

//helps reset User- removes all tiles without returning them
public void removeAllTiles()
	{
		frame.clear();
	}


//allows letters to be removed from the frame- uses method that had commands after return, now corrected
	public void removeString(String passedString) throws Exception{
		if (passedString.length()>frame.size()) throw new Exception("Too many letters entered");
		for (int i=0; i<passedString.length();i++) removeTilesTo(passedString.charAt(passedString.length()));
	}

//oAllows a check to be made if letters are in theframe

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

	//allows a check to be made if letters are in the frame- good algorithm, could do with 'enhanced for loop'
	public boolean isStringIn(String passedString){
		boolean wasFound[] = new boolean[passedString.length()];
		for (int i = 0; i<passedString.length(); i++) 
			wasFound[i] = false;
	
		for (int i=0; i<frame.size(); i++)
		for (int j=0; j<passedString.length();j++) //enhance it
		if (wasFound[j]==false){
		 if (passedString.charAt(j)==frame.get(i).readLetter()){
		wasFound[j]=true;
		break;
		} else continue;
	} 

	for (int j=0;j<passedString.length(); j++)  //enhance it
	if(wasFound[j]==false) return false; else continue;
	return true;
	}
//oAllows a check to be made to see if the frame is empty
public boolean Empty()
	{
	return frame.isEmpty();
	}



//oAllows access to the letters in the frame
public ArrayList<Tile> accessAll()
	{ return(frame); }

	//allows access to single letter in the frame
	public Tile accessTileByLetter (char checkedCharacter) throws Exception{
		if (isLetterIn(checkedCharacter)) 
		return frame.get(atWhichIndex(checkedCharacter));	//frame.get(accessTileByIndex(atWhichIndex(checkedCharacter)));
		else throw new Exception("Letter not in the Frame");
	}

	//allows access to letter in the frame
	public Tile accessTileByIndex (int i) throws Exception
	{ 
	if (i<frame.size()&&i>-1)
	return frame.get(i);
	else 
	throw new Exception("Outside of scope of this frame");
	 }





//oAllows a frame to be refilled from the pool
//oAllows a frame to be displayed++


}