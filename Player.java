import java.util.Scanner;

public class Player {
	
	private String Name;
	private int Score;
	
	public Player(String name) {
		
		setName(name);
	}
	
	public String getName() { return Name; }

	public void setName(String name) {
		//This if statement checks for 3 different cases for the name
		if(name.length() == 0 /*if the user did not insert a name at all OR*/
		|| " ".equals(name)   /*if the user inserted a white space character as a name OR*/
		|| "\n".equals(name)) /*if the user hit a newline without entering a name*/
			throw new IllegalArgumentException(); 
		else
		    Name = name;
	}
	
	public int getScore() { return Score; }

	public void setScore(int score) {
		if(score < 0)             /*This if statement ensures that score 
		                           * is always a positive integer. */
			throw new IllegalArgumentException(); 
		Score = score;
	}
	
	public void increaseScore(int score) { 
		if(score >= 0)          /*This if statement checks first for a positive score
		                         * if its true then the Score is increased. */ 						                        
			Score += score;
		else 
			throw new IllegalArgumentException();
	}
	
	public void reset(String name) { 
		/*reset method is responsible for reseting the 
		 * players names and the scores and the frame from the frame class.*/
	Scanner in = new Scanner(System.in);
	System.out.println("Please Enter The Name of the Player");
	name = in.nextLine();
	setName(name);
	setScore(0);
	}
}
