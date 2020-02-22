import java.util.ArrayList;
import java.util.Scanner;

public class TestingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board Bo = new Board();
		Bo.display();
		
		Frame f = new Frame();
		Player p = new Player("Mary", f);
		System.out.println("\n"+p);
		
		Pool pool = new Pool();
		ArrayList<Tile> temp = pool.drawTiles(5);
		for(int i=0; i<10; i++) {
			if(i==5)
				System.out.println();
			if(i<5)
				System.out.print("|" + temp.get(i).getLetter() + "| ");
			else
				System.out.print("|" + temp.get(i%5).getValue() + "| ");
		}
		
		Scanner in = new Scanner(System.in);
		System.out.println("\nEnter The Word: ");
		String word = in.nextLine();
		
/********* TEST 1 - CHECK THE WORD VALIDITY *************/
		if(f.isStringIn(word) == true)
			System.out.println("PASS");
		else if(f.isStringIn(word) == false)
			System.out.println("FAIL");
		
/********* TEST 2 - PLACEMENT WITHIN THE BOURD BOUNDS *************/
		System.out.println("\nEnter The Row: ");
		int firstPositionMobile = in.nextInt();
		if(Bo.isWithinBounds(firstPositionMobile, word) == true)
			System.out.println("Test For Bounds: Word is WITHIN the Board Bounds.");
		else 
			System.out.println("Test For Bounds: Word is OUT of the Board Bounds.");
		
/********* TEST 3 - WHATHER THE WORD CONFLICTS WITH EXISTING LETTERS *************/	

/********* TEST 4 - WHATHER ITS THE FIRST WORD OR NOT *************/	
		if(Bo.isFirstWord())
			System.out.println("Test For First Word: This is the first word on the board.");
		else
			System.out.println("Test For First Word: This is NOT the first word on the board.");
		
	}
}


