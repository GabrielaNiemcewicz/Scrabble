import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class FrameTest {




		
		@BeforeEach
		void createNewFrame() throws Exception {
			frame = new Frame();
		}

		@Test
		void emptyFrameMethods() {			
			try{
				assertTrue(frame.empty());
				assertFalse(frame.full());
				assertEquals(7, frame.requestTiles());
				System.out.println("Expected output - nothing displayed, actual output:x",frame.displayAllTilesAsLetters())
			} catch(IllegalArgumentException ex) {}
			
			try{
				for(int i=0;i<20;i++)
					pool.Draw(5);
				assertTrue(pool.IsEmpty());
			} catch(IllegalArgumentException ex) {}
			
		}
		
		@Test
		void check_draw() {
			try{
				pool.Draw(8);
				fail("Should not allow numOfTiles above 7");
			} catch(IllegalArgumentException ex) {}
			
			try{
				pool.Draw(-3);
				fail("Should not allow numOfTiles below 0");
			} catch(IllegalArgumentException ex) {}
		}
		
		@Test
		void check_NumOfTiles() {
			try{
				pool.Draw(5);
				assertEquals(pool.NumOfTiles(), 95);
			} catch(IllegalArgumentException ex) {}

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Letter check_PassTiles() {
			try{
			frame.passTiles()

				}catch() {}
			
		}
	
	
	
	
		Letter check_removeTiles() {
		try{
			frame.removeTiles()

				}catch() {}
		}
	
		Letter [] removeString(String passedString) //not created []- it's void now
	
	
		boolean check_isLetterIn (char checkedLetter) {
			
			
		}
		
		
		public int check_atWhichIndex (char checkedLetter) {
			try{
			frame.atWhichIndex(checkedLetter)

				}catch() {}
		}
		
		
		public boolean check_isStringIn(string passedString){
			try{
			frame.isStringIn(passedString)

				}catch() {}
		}
		
		boolean check_empty() {
			try{
			frame.Empty()

				}catch() {}

}
		
		ArrayList<Letter> accessAll() {
			try{
			frame.accessAll()

				}catch() {}
			
		}
		
		
		
		
		Letter check_accessTileByLetter (char checkedCharacter){
			try{
			frame.accessTileByLetter(checkedLetter)

				}catch() {}
			
			
		}

		Letter check_accessTileByIndex (int i) {
			try{
			frame.accessTileByIndex(checkedLetter)

				}catch() {}
			
		}
		
	
		void check_addTiles (Tile[] letters) {
			try{
			frame.addTiles(Tile [] letters)

				}catch() {}
			
			
			
		}
		
		 boolean check_Full(){
try{
			frame.Full()

				}catch() {}

}
		 
		 public int requestTiles() {
			 try{
			frame.requestTiles()

				}catch() {}
			 
		 }
		 
		 public void check_readAll()
		 {
		try{
			frame.readAll()

				}catch() {}
		 }

		 public string check_displayAllTilesAsLetters(){

try{
			frame.displayAllTilesAsLetters()

				}catch() {}

		 }
	
	

}











Frame frame = new Frame ();
			// tests on  empty frame //
			Tile [] leters = new Tile[8] ;

			Tile letterA = new Tile(a,2);
			Tile letterB = new Tile(b,3);
			Tile letterC = new Tile(c,4);
			Tile letterD = new Tile(d,5);
			Tile letterE = new Tile(e,6);
			Tile letterF = new Tile(f,7);
			Tile letterG = new Tile(g,8);
			Tile letterH = new Tile(h,9);

			letters[0] = letterA;
			letters[1] = letterB;
			letters[2] = letterC;
			letters[3] = letterD;
			letters[4] = letterE;
			letters[5] = letterF;
			letters[6] = letterG;
			letters[7] = letterH;

			//try adding each of letters to Frame, correctly display error at 8th Tile
			//only addTiles([]) does it = test not exactly simulates Pool behaviour, 1 Tile at the time => check requestTiles() after each add 


			//full frame tests/assertions

			//test each non-removing non-adding non-requesting method on arbitrary number of Tiles, remove 1-3 casually

			//test unused methods removing Tiles, including reset

			//is frame empty after reset