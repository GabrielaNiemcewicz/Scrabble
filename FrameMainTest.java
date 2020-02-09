
public class FrameMainTest {

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frame = new Frame();
		if(frame.Full())
		System.out.println("-------------------------------------------------");
		else System.out.println("\t\t\tTesting Frame...");
		
		
				assertNull(frame);
				assertTrue(frame.Empty());
				assertFalse(frame.Full());
				assertEquals(7, frame.requestTiles());
				assertEquals("",frame.displayAllTilesAsLetters());
		
		
		
		
		System.out.println("Result: " + frame.Full());
	};

}