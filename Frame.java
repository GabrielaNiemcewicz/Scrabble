import java.util.ArrayList;

public class Frame {
	
	private ArrayList<Tile> frame;


	//stores the letters that each player has in their frame- stores empty frame
	public Frame()
	{
	 this.frame = new ArrayList<Tile>();
	}


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
	public void removeTiles (char passedLetter) throws Exception
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

	//allows letters to be removed from the frame- probably not needed- alternative implementation
	public void removeAllTiles()
	{
		frame.clear();
	}

	//allows letters to be removed from the frame- uses method that has commands after return
	public void removeString(String passedString) throws Exception{
		if (passedString.length()>frame.size()) throw new Exception("Too many letters entered");
		for (int i=0; i<passedString.length();i++) removeTilesTo(passedString.charAt(passedString.length()));
	}
	

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




	//allows check to be made if frame is empty
	public boolean Empty()
	{
	return frame.isEmpty();
	}






	//allows access to letters in the frame
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






	//allows a frame to be refilled from the pool
	public void addTiles (Tile[] letters) throws Exception
	{ //new dynamic n= frame.size()
		//Bag bag;
		//bag.draw(frame.requestTiles());
		int i=0;
		if (Full()) throw new Exception("Frame is full, you can't add another tile");
		else {
			while (!Full()){
				frame.add(letters[i]);
				++i;
			}
		}
	}


	//add exchange all tiles- or maybe it's combination of existing functions to implement in main?


	//helps allow a frame to be refilled from the pool 
	public boolean Full()
	{
		if (frame.size() == 7) 
			return true;
		else 
			return false;
	}

	//allows frame to be refilled from the pool
	public int requestTiles()
	{
	int n= 7-frame.size();
	return n;
	}


	//allows a frame to be displayed
	public void readAll()
	{
	for (int i=0; i<frame.size();i++){ 
		frame.get(i).display(); 
	   }
	}
	

	public StringBuilder displayAllTilesAsLetters()
	{
	StringBuilder word = new StringBuilder();
	for (int i=0; i<frame.size(); i++) word.append(frame.get(i).readLetter());
	return word;
	}