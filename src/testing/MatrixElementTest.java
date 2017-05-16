package testing;

import java.math.BigInteger;

import com.jlinalg.math.*;

public class MatrixElementTest {

	public static void test() {
		
		testConstruction();
		
		testInvalidConstruction();
		
		testAddition();
		
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
	
	public static void testAddition() {
		
		System.out.println("\n~Testing addition");
		
		Fraction fracs[] = new Fraction[4];
		
		for (int i = 0; i < 4; i++) {
			int d = NumberUtils.randomInt(-100, 100);
			d = (d == 0) ? d + 1 : d;
			fracs[i] = new Fraction(NumberUtils.randomInt(-100,100), d);
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = i; j < 4; j++) {
				System.out.println(fracs[i].toString() + " + " + fracs[j].toString() + " = " + fracs[i].add(fracs[j]).toString());
			}
		}
	}


}
