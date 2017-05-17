package testing;

import java.math.BigInteger;

import com.jlinalg.math.*;

public class FractionTest {

	public static void test() {
		
		testConstruction();
		
		testInvalidConstruction();
		
		testAddition();
		
		testMultiplication();
		
		testDoubleConstructor();
		
	}
	
	public static void testConstruction() {
		
		System.out.println("\n~Testing construction of matrix elements");
		
		System.out.println(new Fraction().toString());
		System.out.println(new Fraction(38, 123).toString());
		System.out.println(new Fraction(6).toString());
		System.out.println(new Fraction(BigInteger.valueOf(4), BigInteger.valueOf(6)));
		
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
			int d = NumberUtils.randomInt(-20, 20);
			d = (d == 0) ? d + 1 : d;
			fracs[i] = new Fraction(NumberUtils.randomInt(-1 * Math.abs(d),Math.abs(d)), d);
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = i; j < 4; j++) {
				System.out.println(fracs[i].toString() + " + " + fracs[j].toString() + " = " + fracs[i].add(fracs[j]).toString());
			}
		}
	}
	
	public static void testMultiplication() {
		
		System.out.println("\n~Testing multiplication");
		
		Fraction fracs[] = new Fraction[4];
		
		for (int i = 0; i < 4; i++) {
			int d = NumberUtils.randomInt(-20, 20);
			d = (d == 0) ? d + 1 : d;
			fracs[i] = new Fraction(NumberUtils.randomInt(-1 * Math.abs(d),Math.abs(d)), d);
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = i; j < 4; j++) {
				System.out.println(fracs[i].toString() + " * " + fracs[j].toString() + " = " + fracs[i].multiply(fracs[j]).toString());
			}
		}
	}
	
	public static void testDoubleConstructor() {
		
		System.out.println("\n~Testing double constructor");
		
		double doubs[] = {1.5, 6, 1.679, 100.5, 329871.123873, 23.200};
		
		for (double d : doubs) {
			System.out.println(String.valueOf(d) + " --> " + new Fraction(d).toString());
		}
		
	}


}
