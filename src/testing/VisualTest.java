package testing;

import com.jlinalg.math.*;
import com.jlinalg.graphic.*;

public class VisualTest {
	
	public static void test() {
		
		//testMatrixToString();
		
		//testElementToString();
		
		//testCenterString();
		
	}
	
	public static void testMatrixToString() {
		
		System.out.println("\n~Converting matrix to string");
		
		Matrix zeroMatrix = new Matrix(4, 4);
		zeroMatrix.setDiagonal(11.5);
		zeroMatrix.setEntry(1, 3, 59823);
		zeroMatrix.setEntry(1, 1, 4);
		
		System.out.println(Printer.matrixToString(zeroMatrix));

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
