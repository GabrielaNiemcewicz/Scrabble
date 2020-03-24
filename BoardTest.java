package Jabba;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardTest {
	/*
	/***** Initializing necessary Variables. *****
	public static Board Bo = new Board();       
	public static String HV = null;
	public static Pool pool = new Pool();
	static Scanner in1 = new Scanner(System.in);
	static Scanner in2 = new Scanner(System.in);
	
	public void Testing(Player p, String word, Scanner in) {
		
/************** WHEN THE ENTERED WORD PASS THE TEST IT IS CONTINUED TO BE PLACED. **************
		//********* TEST - WHATHER ITS THE FIRST WORD OR NOT *************
		   if(Bo.isFirstWord())
			  System.out.println("Test For First Word: This is the first word on the board.");
		   else
			   System.out.println("Test For First Word: This is NOT the first word on the board.");

		 //********* HORIZALTAL / VERTICAL *************
		 
			System.out.println("*****************\nWould You like to Place it Horizontally Or Vertically: ");
			HV = in.nextLine();
			System.out.println("Choose What Row: ");
			int x = in.nextInt();
			System.out.println("Choose What Column: ");
			int y = in.nextInt();
			
			if(HV.equalsIgnoreCase("H") || HV.equalsIgnoreCase("Horizontally"))
			{
			  //************* Testing for word placing validity horizontally. which checks for:
			  //TEST - WHATHER THE SECOND WORD CONFLICTS WITH THE FIRST WORD 
				
				if(Bo.isValidHorizontally(x, y, p.getFrame(), word, p)) 
				{
					System.out.println("The place Is valid Horizontally.");
					Bo.placeWordHorizontally(p.getFrame(), x, y, word, p);      // allows for the word to be placed on the board Vertically.
					Bo.display();
				}
				else 
					System.out.println("The place Is NOT valid Horizontally.");		
			}
			
			if(HV.equalsIgnoreCase("V") ||  HV.equalsIgnoreCase("Vertically"))
			{
				if(Bo.isValidVertically(x, y, p.getFrame(), word, p) == true) // check if the word is valid to be placed Vertically.
				{ 
					System.out.println("The place Is valid Vertically.");
					Bo.placeWordVertically(p.getFrame(), x, y, word, p);      // allows for the word to be placed on the board Vertically.
					Bo.display();
				}
				else 
					System.out.println("The place Is NOT valid Vertically.");		
			}
		}	
	
	public static void main(String[] args) {
  
		Bo.display();
		

//*********************	PLAYER 1 ******************************
		Player p1 = new Player("Mary");
		System.out.println("\n"+p1);
	   
		p1.getFrame().refill(pool);            // Refills the frame from pool.
		p1.getFrame().displayAsFrame();        // Displays the random array of the tiles.
		
		System.out.println("\nEnter The Word: ");
		String word1 = in1.nextLine();
		
		BoardTest t1 = new BoardTest();
		t1.Testing(p1, word1,in1);
			
//********************	PLAYER 2 ******************************
		
		Player p2 = new Player("Joey");  
		System.out.println("\n"+p2);
		   
		p2.getFrame().refill(pool);            // Refills the frame from pool.
		p2.getFrame().displayAsFrame();        // Displays the random array of the tiles.
		
		System.out.println("\nEnter The Word: ");
		String word2 = in2.nextLine();
		
		BoardTest t2 = new BoardTest();
		t2.Testing(p2, word2,in2);
		
	}
	*/
}


