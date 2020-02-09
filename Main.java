
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pool pool = new Pool();
		
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("\t\t\tTesting Pool...\n");
		
	//******************* Testing IsEmpty() ******************************
		System.out.println("---Testing IsEmpty()---\n\n*When pool is full*");
		System.out.println("Expected Result: False" + "\nResult: " + pool.IsEmpty());
		
		for(int i=0;i<20;i++)
			pool.Draw(5);
		System.out.println("\n*When pool is empty*");
		System.out.println("Expected Result: True" + "\nResult: " + pool.IsEmpty());
		
		//******************* Testing resetPool() ******************************
		pool.resetPool();
		System.out.println("---Testing resetPool()---\n\n*When pool is empty*");
		System.out.println("Expected Result: 0" + "\nResult: " + pool.NumOfTiles());
	}
}
