import java.util.ArrayList;
import java.util.Scanner;

public class Player{
/***** The Private Instance Variables of Class Player *****/
	
	private String Name;
	private int Score;
	private Frame Frame;

/***** Player Constructor *****/
	
	public Player(String name){
		setFrame();
		setName(name);	
	}
	
/***** The Accessors And The Mutators *****/
	
	public Frame getFrame() { return Frame; }

	public void setFrame() {
		this.Frame = new Frame();
	}

	public String getName() { return Name; }

	public void setName(String name) {
		/*This if statement checks for 3 different cases for the name:*/
		if(name.length() == 0 /*if the user did not insert a name at all OR*/
		|| " ".equals(name)   /*if the user inserted a white space character as a name OR*/
		|| "\n".equals(name)) /*if the user hit a newline without entering a name*/
		{
			System.out.println("Failed: The Name you entered is not valid, try again");
			throw new IllegalArgumentException(); 
		}
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

/***** Extra Methods *****/
	
	public void increaseScore(int score) { 
		if(score >= 0)          /*This if statement checks first for a positive score
		                         * if its true then the Score is increased. */ 						                        
			Score += score;
		else 
			throw new IllegalArgumentException();
	}
	
	public void reset(String name) { /*reset method is responsible for reseting the 
	 								  * players names and the scores and the frame from the frame class.*/
		Scanner in = new Scanner(System.in);
		System.out.println("Please Enter The Name of the Player");
		name = in.nextLine();
		setName(name);
		setScore(0);
		Frame.removeAllTiles();    /*removeAllTiles Method is a method in class Frame()
		                            * which remove all the tiles in the frame and reset them again. */
		in.close();
	}
	
	public String toString() { /* toString method would be used for the display
	 							* of the different players with their scores.*/
		return "Player: "+getName()+", Score = "+getScore();
	}
	
	public static void main(String[] args) {
		
	System.out.println("---------------- Player Testing ---------------\n");

  /*********************************************/
	System.out.println("--- Player Testing - setName() ---");
	Player p1 = new Player("Nagham");
	String expectedResult = "Nagham";
	String actualResult = p1.getName();
				
	System.out.println("Player Name: "+actualResult);
	System.out.println("Player Name expected: "+expectedResult);
				
				
	if(actualResult == expectedResult)
			System.out.println("Pass");
	else
			System.out.println("Failed");
				
  /*********************************************/
				
	System.out.println("\n--- Player Testing - setScore() ---");
				
	Player p2 = new Player("Adam");
	int actualResultScore = p2.getScore();
	int expectedResultScore = 0;
	System.out.println("Player Name: "+p2.getName()+"\t Score = "+actualResultScore);
	System.out.println("Player Score expected =          "+expectedResultScore);
				
	if(actualResultScore == expectedResultScore)
		System.out.println("Pass");
	else 
		System.out.println("Failed: Actual result is not equal to the expected result");
			
  /**********************************************/
				
	System.out.println("\n--- Player Testing - increaseScore() ---");
	int newScore = 4;
	p2.increaseScore(newScore);
	System.out.println(p2.getName()+" Scored 4");
	System.out.println("Player Name: "+p2.getName()+"    new Score = "+p2.getScore());
	System.out.println("Player Score expected =          "+newScore);
				
	if(p2.getScore() == newScore)
		System.out.println("Pass");
	else 
		System.out.println("Failed: Actual result is not equal to the expected result");
	
   /*******************************************/
	
	System.out.println("\n--- Player Testing - reset() ---");
	p2.reset("Gabi");
	System.out.println(p2);
				
 /***********************************************/
	Pool pool = new Pool();
		
	System.out.println("\n*********************************************\n");
	System.out.println("---------------- Pool Testing ---------------\n");
	
	//******************* Testing Draw() ******************************
	
	ArrayList<Tile> temp = pool.drawTiles(5);
	System.out.println("--- Testing Pool - Draw() ---\n\n*Testing Tiles are removed*");
	System.out.println("Expected tiles in pool: 95" + "\nResult: " + pool.size());
	System.out.println("\n*Testing tiles are generated*");
	for(int i=0; i<10; i++) {
		if(i==5)
			System.out.println();
		if(i<5)
			System.out.print("|" + temp.get(i).getLetter() + "| ");
		else
			System.out.print("|" + temp.get(i%5).getValue() + "| ");
	}
	
//******************* Testing IsEmpty() ******************************
	System.out.println("\n\n--- Testing Pool - IsEmpty() ---\n\n*When pool is full*");
	System.out.println("Expected Result: False" + "\nResult: " + pool.isEmpty());
		
	for(int i=0;i<19;i++)
		pool.drawTiles(5);
	    System.out.println("\n*When pool is empty*");
	    System.out.println("Expected Result: True" + "\nResult: " + pool.isEmpty());
		
//******************* Testing resetPool() ******************************
	pool.resetPool();
	System.out.println("\n--- Testing Pool - resetPool() ---\n\n*When pool is empty*");
	System.out.println("Expected Result: 100" + "\nResult: " + pool.size());
	
	pool.drawTiles(7);
	pool.resetPool();
	System.out.println("\n*When pool contains tiles*");
    System.out.println("Expected Result: 100" + "\nResult: " + pool.size());
	
	}
	
}
