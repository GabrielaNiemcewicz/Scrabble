import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FrameTest {

	Frame frame = new Frame();
	Frame frame2 = new Frame();
	Frame frame3 = new Frame();
	Tile letterA;
	Tile letterB;
	Tile letterC;
	Tile letterD;
	Tile letterE;
	Tile letterF;
	Tile letterG;
	Tile letterH;
	@BeforeEach
	void setUp() throws Exception {
		letterA = new Tile('a');
		letterB = new Tile('b');
		letterC = new Tile('c');
		letterD = new Tile('d');
		letterE = new Tile('e');
		letterF = new Tile('f');
		letterG = new Tile('g');
		letterH = new Tile('h');
		
		Tile letterss[] = new Tile[3];
		letterss[0]= letterA;
		letterss[1]= letterB;
		letterss[2]= letterC;
		
		
		frame.addTiles(letterss);
		
		Tile lettersFull[] = new Tile [7];
		lettersFull[0]= letterA;
		lettersFull[1]= letterB;
		lettersFull[2]= letterC;
		lettersFull[3]= letterD;
		lettersFull[4]= letterE;
		lettersFull[5]= letterF;
		lettersFull[6]= letterG;
		
		frame3.addTiles(lettersFull);
	}
	
	@Test
	void emptyFrameMethods() {
	try{
		assertTrue(frame2.Empty());
		assertFalse(frame.Empty());
		assertFalse(frame3.Empty());
		assertFalse(frame.Full());
		assertFalse(frame2.Full());
		assertTrue(frame3.Full());
		assertEquals(4, frame.requestTiles());
		assertEquals(7, frame2.requestTiles());
		assertEquals(0, frame3.requestTiles());
		System.out.println("Expected output - nothing displayed, actual output:"+frame2.displayAllTilesAsLetters());
		System.out.println("Expected output - abc, actual output:"+frame.displayAllTilesAsLetters());
		System.out.println("Expected output - abcdefg, actual output:"+frame3.displayAllTilesAsLetters());
	} catch(IllegalArgumentException ex) {}
	
	}
	
	@Test
	void check_passTiles() throws Exception{
	try{
		assertEquals(letterA, frame.passTiles('A'));
		assertEquals(letterB, frame3.passTiles('B'));
		assertNotEquals(letterF, frame3.passTiles('C'));
	}catch(IllegalArgumentException ex) {}
	
	}
	
	@Test
	void check_removeTiles() throws Exception{
	try{
		frame.removeTiles('A');
		assertEquals("BC", frame.displayAllTilesAsLetters());
		frame3.removeTiles('G');
		assertEquals("ABCDEF", frame3.displayAllTilesAsLetters());
	}catch(IllegalArgumentException ex) {}
	}
	
	@Test
	void check_atWhichIndex () throws Exception {
	try{
		assertEquals(1, frame.atWhichIndex('B'));
		assertEquals(0, frame3.atWhichIndex('A'));
		}catch(IllegalArgumentException ex) {}
	}
	
	@Test
	void check_isLetterIn() throws Exception {
	
	try{
		assertTrue(frame.isLetterIn('C'));
		assertTrue(frame3.isLetterIn('E'));
		assertTrue(frame3.isLetterIn('F'));
		
		assertFalse(frame.isLetterIn('D'));
		assertFalse(frame.isLetterIn('H'));
		assertFalse(frame3.isLetterIn('H'));
	}catch(IllegalArgumentException ex) {}
	}
	
	@Test
	public void check_isStringIn(){
	try{
		assertTrue(frame.isStringIn("ABC"));
		assertTrue(frame.isStringIn("CB"));
		assertTrue(frame3.isStringIn("DEAF"));
		assertFalse(frame.isStringIn("DIG"));
		assertFalse(frame.isStringIn("AAAAA"));
	
	}catch(IllegalArgumentException ex){}
	}
	public void check_accessTileByIndex() throws Exception{
	try{
		assertEquals(letterC,frame.accessTileByIndex(2));
		assertEquals(letterA,frame.accessTileByIndex(0));
		assertEquals(letterD,frame3.accessTileByIndex(3));
		assertNotEquals(letterD,frame3.accessTileByIndex(5));
		
	
	}catch(IllegalArgumentException ex){}
	}
}