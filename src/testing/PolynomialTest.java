package testing;

import com.jlinalg.math.*;

public class PolynomialTest {
	
	public static void test() {
		
		testConstantConstruction();
		
		testExpressionConstruction();
		
	}
	
	public static void testConstantConstruction() {
		
		System.out.println("\n~Testing constructing constants");
		
		PolyConstant c1 = new PolyConstant(1);
		
		System.out.println("Value of c1: " + c1.toString());
		
	}
	
	public static void testExpressionConstruction() {
		
		System.out.println("\n~Testing expression construction");
		
		Expression e1 = new Expression(31).add(26);
		
		System.out.println("Value of e1: " + e1.toString());
		
	}

}
