import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FrameTest2 {

	Frame frame = new Frame(); 
	Frame frame2 = new Frame(); 
	Tile letterA;
	@BeforeEach
	void setUp() throws Exception {
		letterA = new Tile('a',2);
		Tile letterB = new Tile('b',3);
		Tile letterC = new Tile('c',4);
		Tile  letterss[] = new Tile[3];
		letterss[0]= letterA;
		letterss[1]= letterB;
		letterss[2]= letterC;
		frame.addTiles(letterss); 
	}

	@Test
	void emptyFrameMethods() {			
		try{
			assertTrue(frame2.Empty());
			assertFalse(frame.Empty());
			assertFalse(frame.Full());
			assertEquals(4, frame.requestTiles());
			System.out.println("Expected output - nothing displayed, actual output:x"+frame.displayAllTilesAsLetters());
		} catch(IllegalArgumentException ex) {}
		
	}
	
	@Test
	void check_passTiles() throws Exception{
		try{
		assertEquals(letterA, frame.passTiles('a'));
			}catch(IllegalArgumentException ex) {}
		
	}
	
	@Test
	void check_removeTiles() throws Exception{
	try{
		frame.removeTiles('a');
		assertEquals("bc", frame.displayAllTilesAsLetters());
		
			}catch(IllegalArgumentException ex) {}
	}
	
	@Test
	void check_atWhichIndex () throws Exception {
		try{
		assertEquals(1, frame.atWhichIndex('b'));
			}catch(IllegalArgumentException ex) {}
	}
	
	@Test
	void check_isLetterIn() throws Exception {
		
		try{
			assertTrue(frame.isLetterIn('c'));
			

				}catch(IllegalArgumentException ex) {}
		}
	
	@Test
	public void check_isStringIn(){
		try{
		assertTrue(frame.isStringIn("abc"));

			}catch(IllegalArgumentException ex){}
	}
	

}
