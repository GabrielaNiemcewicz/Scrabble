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
		Frame	frame = new Frame();
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
Tile check_passTiles() {
			try{
			frame.passTiles()

				}catch() {}
			
		}
	
	
	
	
		Tile   check_removeTiles() {
		try{
			frame.removeTiles()

				}catch() {}
		}
	
		Tile   [] removeString(String passedString) //not created []- it's void now
	
	
		
		
		public int check_atWhichIndex (char checkedLetter) {
			try{
			frame.atWhichIndex(checkedLetter)

				}catch() {}
		}
		
		public boolean check_isLetterIn(char checkedLetter) {
			
			try{
				frame.isLetterIn(char checkedLetter);
				

					}catch() {}
			}
			
			
			
			
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
		
		ArrayList<Letter> check_accessAll() {
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
		 
		 public int check_requestTiles() {
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
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////










createNewFrame()
			// tests on  empty frame //
			Tile [] leters = new Tile[8];

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
			//only addTiles([]) does it = test not exactly simulates Pool behavior, 1 Tile at the time => check requestTiles() after each add 
		for (int i=0; i<7; i++) { 
			check_addTiles(letters[i]); //in scope
			check_requestTiles();
			check_Full();//false
			check_Empty();//false
		}// 6 5 4 3 2 1 0
		check_addTiles(letters[8]); //correct behavior is throw error out of scope
		check_requestTiles() // should still request 0

			//full frame tests/assertions
		check_Full() //true
		check_Empty() //false
		
		//VALID-ASSERT OR DISPLAY?
	check_atWhichIndex(a) //0
	check_atWhichIndex(b) //1
	check_atWhichIndex(c) //2
	check_atWhichIndex(g) //6
	//check_atWhichIndex(E) //4
										//invalid -1	ASSERT OR DISPLAY?
												check_atWhichIndex(h)
												check_atWhichIndex(z)
												//check_atWhichIndex(K)
												
														//should show exception
												//check_atWhichIndex(aa)
											//check_atWhichIndex(dy)
										 //check_atWhichIndex(xw)
														
														
		
		
		
		
		
		//TRUE- ASSERT OR DISPLAY?
	check_isLetterIn(a)
	check_isLetterIn(b)
	check_isLetterIn(c)
	check_isLetterIn(d)
	check_isLetterIn(e)
	check_isLetterIn(f)
	check_isLetterIn(g)
	//check_isLetterIn(C)
										//FALSE- ASSERT OR DISPLAY?
												check_isLetterIn(h)
														check_isLetterIn(z)
														//check_isLetterIn(Z)
												//ERROR
												//check_isLetterIn(ab)
											//check_isLetterIn(az) 
										 //check_isLetterIn(yz)
					
														
	check_isStringIn(abcdefg) //true
	check_isStringIn(abcefg)//true
	check_isStringIn(afg) //true
	check_isStringIn(gfad)//true
	check_isStringIn(d) //true
	//check_isStringIN(AD) //true
	
	check_isStringIn(abcdtfg) //false
	check_isStringIn(aacdefg)//false
	check_isStringIn(bBc) //false
	
			check_AccessAll() // should display a 2 b 3 c 4 ... g 8 
			
			check_accessTileByIndex(0) // a2
			check_accessTileByIndex(1) //b3
			check_accessTileByIndex(2) //c4
			check_accessTileByIndex(3) //d5
			check_accessTileByIndex(4) //e6
			check_accessTileByIndex(5) //f7
			check_accessTileByIndex(6) //g8
			
			
			check_accessTileByLetter(a); //a2
		check_accessTileByLetter(b); // b3
		check_accessTileByLetter(e); //e6
		check_accessTileByLetter(w); //error should occur
		check_accessTileByLetter(5); //error should occur

	 check_readAll()


	 check_displayAllTilesAsLetters()
		
		
		
			//test each non-removing non-adding non-size-dependent	method on arbitrary number of Tiles, remove 1-3 casually

			//test unused methods removing Tiles, including reset

			//is frame empty after reset
