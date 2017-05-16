package testing;

import java.math.BigInteger;

import com.jlinalg.math.*;

public class MatrixElementTest {

	public static void test() {
		
		testConstruction();
		
		testInvalidConstruction();
		
	}
	
	public static void testConstruction() {
		
		System.out.println("\n~Testing construction of matrix elements");
		
		System.out.println(new Fraction().toString());
		System.out.println(new Fraction(38, 123).toString());
		System.out.println(new Fraction(6).toString());
		System.out.println(new Fraction(BigInteger.valueOf(4), BigInteger.valueOf(5)));
		
	}
	
	public static void testInvalidConstruction() {
		
		System.out.println("\n~Testing illegal construction of matrix elements");
		
		try {
			new Fraction(1, 0);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		
	}


}
