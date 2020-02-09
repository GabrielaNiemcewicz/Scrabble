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
				assertEquals("",frame.displayAllTilesAsLetters())
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
	
		Letter check_PassTiles() {
			
			
		}
	
	
	
	
		Letter check_removeTiles() {
		
		}
	
		Letter [] removeString(String passedString) //not created []- it's void now
	
	
		boolean check_isLetterIn (char checkedLetter) {
			
			
		}
		
		
		public int check_atWhichIndex (char checkedLetter) {
			
			
		}
		
		
		public boolean check_isStringIn(string passedString){
			
		}
		
		boolean check_empty()
		
		ArrayList<Letter> accessAll() {
			
			
		}
		
		
		
		
		Letter check_accessTileByLetter (char checkedCharacter){
			
			
			
		}

		Letter check_accessTileByIndex (int i) {
			
			
		}
		
	
		void check_addTiles (Tile[] letters) {
			
			
			
			
		}
		
		 boolean check_Full()
		 
		 public int requestTiles() {
			 
			 
		 }
		 
		 public void check_readAll()
		 {
		
		 }

		 public string check_displayAllTilesAsLetters()
		 }
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
