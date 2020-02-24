import java.util.ArrayList;
import java.util.Scanner;

public class TestingMain {

	public static void main(String[] args) {
  
/***** Initializing necessary Variables. *****/
		Board Bo = new Board();       
		Bo.display();
		Frame f = new Frame();
		int PF = 0;
		Player p = new Player("Mary");
		Pool pool = new Pool();
		String HV = null;
		
		System.out.println("\n"+p);
	   
		f.refill(pool);            // Refills the frame from pool.
	    f.displayAsFrame();        // Displays the random array of the tiles.
		
		Scanner in = new Scanner(System.in);
		System.out.println("\nEnter The Word: ");
		String word = in.nextLine();
		
/********* TEST 1 - CHECK THE WORD VALIDITY *************/
		if(f.isStringIn(word) == true)
		{ 
			System.out.println("Validity Test - PASS");
		}
		
		else if(f.isStringIn(word) == false)
		{
			System.out.println("Validity Test - FAIL");
			PF = 1;
		}
		
/************** WHEN THE ENTERED WORD PASS THE TEST IT IS CONTINUED TO BE PLACED. **************/
		
		if(PF == 0) 
		{
		  //********* TEST - WHATHER ITS THE FIRST WORD OR NOT *************//	
		   if(Bo.isFirstWord())
				System.out.println("Test For First Word: This is the first word on the board.");
			else
				System.out.println("Test For First Word: This is NOT the first word on the board.");
		 
		 //********* HORIZALTAL / VERTICAL *************//
		   
			System.out.println("*****************\nWould You like to Place it Horizontally Or Vertically: ");
			HV = in.nextLine();
			System.out.println("Choose What Row: ");
			int x = in.nextInt();
			System.out.println("Choose What Column: ");
			int y = in.nextInt();
			
			if(HV.equalsIgnoreCase("H") || HV.equalsIgnoreCase("h") || HV.equalsIgnoreCase("Horizontally") || HV.equalsIgnoreCase("horizontally"))
			{
			  //************* Testing for word placing validity horizontally.
				if(Bo.isValidHorizontally(x, y, f, word, p)) 
				{
					System.out.println("The place Is valid Horizontally.");
					Bo.placeWordHorizontally(f, x, y, word, p);      // allows for the word to be placed on the board Vertically.
					Bo.display();
				}
				else 
					System.out.println("The place Is NOT valid Horizontally.");		
			}
			
			else if(HV.equalsIgnoreCase("V") || HV.equalsIgnoreCase("v") || HV.equalsIgnoreCase("Vertically") || HV.equalsIgnoreCase("vertically"))
			{
				if(Bo.isValidVertically(x, y, f, word, p) == true) // check if the word is valid to be placed Vertically.
				{ 
					System.out.println("The place Is valid Horizontally.");
					Bo.placeWordVertically(f, x, y, word, p);      // allows for the word to be placed on the board Vertically.
					Bo.display();
				}
				else 
					System.out.println("The place Is NOT valid Vertically.");		
			}
		
			
		}
		
	}
}


