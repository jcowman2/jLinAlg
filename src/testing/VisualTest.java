package testing;

import com.jlinalg.math.Matrix;
import com.jlinalg.graphic.Printer;

public class VisualTest {
	
	public static void test() {
		
		testMatrixToString();
		
		testElementToString();
		
		testCenterString();
		
	}
	
	public static void testMatrixToString() {
		
		System.out.println("\n~Converting matrix to string");
		
		Matrix zeroMatrix = new Matrix(5, 5);
		zeroMatrix.setDiagonal(11.5);
		
		System.out.println(Printer.matrixToString(zeroMatrix));
		
		for (int i=1; i <= 5; i++) {
			System.out.println(zeroMatrix.getRow(i));
		}
		System.out.println("\n");
	}
	
	public static void testElementToString() {
		
		System.out.println("\n~Converting doubles to strings");
		
		double doubs[] = {0., -0, -1, 0.30, 0.423498273, 9191827391283., -123.00001, 04.000000};
		
		for (double d : doubs) {
			System.out.println(Printer.elementToString(d));
		}
		
	}
	
	public static void testCenterString() {
		
		System.out.println("\n~Centering strings");
		
		String strings[] = {"dogy", "a", "ohyes", "woooot", "bab"};
		for (String s : strings) {
			System.out.println("|" + Printer.centerString(s, 7) + "|");
		}
		
	}
	
}
