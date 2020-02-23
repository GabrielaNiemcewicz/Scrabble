import java.util.ArrayList;
import java.util.Scanner;

public class TestingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board Bo = new Board();
		Bo.display();
		Frame f = new Frame();
		int PF = 0;
		Player p = new Player("Mary");
		Pool pool = new Pool();
		String HV = null;
		
		System.out.println("\n"+p);
	   
		f.refill(pool);
		f.displayAsFrame();
		
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
		
		if(PF == 0) {
			System.out.println("*****************\nWould You like to Place it Horizontally Or Virtaclly: ");
			HV = in.next();
			System.out.println("Choose What Row: ");
			int x = in.nextInt();
			System.out.println("Choose What Column: ");
			int y = in.nextInt();
			
			if(true)
			{
					System.out.println("The place Is valid Horizontally.");
					Bo.placeWordHorizontally(f, x, y, word, p);
					Bo.display();	
			}
			
			if(HV == "V" || HV == "v" || HV == "Vertically" || HV == "vertically")
			{
				if(Bo.isValidVertically(x, y, f, word, p) == true)
				{
					System.out.println("The place Is valid Horizontally.");
					Bo.placeWordVertically(f, x, y, word, p);
					Bo.display();
				}
				else 
					System.out.println("The place Is NOT valid Vertically.");		
			}
		
			
		}
		
		f.displayAsFrame();

/********* TEST 4 - WHATHER ITS THE FIRST WORD OR NOT *************/	
		if(Bo.isFirstWord())
			System.out.println("Test For First Word: This is the first word on the board.");
		else
			System.out.println("Test For First Word: This is NOT the first word on the board.");
		
	}
}


