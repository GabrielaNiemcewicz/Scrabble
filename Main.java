
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println("---------------- Player Testing ---------------\n");

  /*********************************************************************/
	System.out.println("--- Player Testing - setName() ---");
	Frame f = new Frame();
	Player p1 = new Player("Nagham",f);
	String expectedResult = "Nagham";
	String actualResult = p1.getName();
				
	System.out.println("Player Name: "+actualResult);
	System.out.println("Player Name expected: "+expectedResult);
				
				
	if(actualResult == expectedResult)
			System.out.println("Pass");
	else
			System.out.println("Failed");
				
  /*********************************************************************/
				
	System.out.println("\n--- Player Testing - setScore() ---");
				
	Player p2 = new Player("Adam",f);
	int actualResultScore = p2.getScore();
	int expectedResultScore = 0;
	System.out.println("Player Name: "+p2.getName()+"\t Score = "+actualResultScore);
	System.out.println("Player Score expected =          "+expectedResultScore);
				
	if(actualResultScore == expectedResultScore)
		System.out.println("Pass");
	else 
		System.out.println("Failed: Actual result is not equal to the expected result");
			
  /*********************************************************************/
				
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
				
 /*********************************************************************/
	Pool pool = new Pool();
		
	System.out.println("**************************************************\n");
	System.out.println("---------------- Pool Testing ---------------\n");
		
//******************* Testing IsEmpty() ******************************
	System.out.println("--- Testing Pool - IsEmpty() ---\n\n*When pool is full*");
	System.out.println("Expected Result: False" + "\nResult: " + pool.IsEmpty());
		
	for(int i=0;i<20;i++)
		pool.Draw(5);
	    System.out.println("\n*When pool is empty*");
	    System.out.println("Expected Result: True" + "\nResult: " + pool.IsEmpty());
		
//******************* Testing resetPool() ******************************
	pool.resetPool();
	System.out.println("\n--- Testing Pool - resetPool() ---\n\n*When pool is empty*");
	System.out.println("Expected Result: 0" + "\nResult: " + pool.NumOfTiles());
	}
}
