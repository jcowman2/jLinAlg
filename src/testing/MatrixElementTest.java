package testing;

import com.jlinalg.math.*;

public class MatrixElementTest {

	public static void test() {
		
		testConstruction();
		
	}
	
	public static void testConstruction() {
		
		System.out.println("\n~Testing construction of matrix elements");
		
		System.out.println(new Fraction().toString());
		System.out.println(new Fraction(38, 123).toString());
		System.out.println(new Fraction(6).toString());
		
	}


}
