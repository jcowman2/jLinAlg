package testing;

import com.jlinalg.math.*;

public class MatrixElementTest {

	public static void test() {
		
		testInvalidAddition();
		
	}

	private static void testInvalidAddition() {
		
		System.out.println("\n~Testing invalid element addition");
		
		Fraction f = new Fraction();
		Dummy d = new Dummy();
		f.add(d);
		
	}

}
