package testing;

import com.jlinalg.math.*;

public class PolynomialTest {
	
	public static void test() {
		
		testConstantConstruction();
		
	}
	
	public static void testConstantConstruction() {
		
		System.out.println("\n~Testing constructing constants");
		
		PolyConstant c1 = new PolyConstant(1);
		
		System.out.println("Value of c1: " + c1.toString());
		
	}

}
