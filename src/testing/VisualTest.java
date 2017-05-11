package testing;

import java.util.ArrayList;

import com.jlinalg.math.*;
import com.jlinalg.graphic.*;

public class VisualTest {
	
	public static void test() {
		
		//testMatrixToString();
		
		//testElementToString();
		
		//testCenterString();
		
		testAlignStringBlocks();
		
	}
	
	public static void testMatrixToString() {
		
		System.out.println("\n~Testing converting matrix to string");
		
		Matrix zeroMatrix = new Matrix(4, 4);
		zeroMatrix.setDiagonal(11.5);
		zeroMatrix.setEntry(1, 3, 59823);
		zeroMatrix.setEntry(1, 1, 4);
		
		System.out.println(Printer.matrixToString(zeroMatrix));

	}
	
	public static void testElementToString() {
		
		System.out.println("\n~Testing converting doubles to strings");
		
		double doubs[] = {0., -0, -1, 0.30, 0.423498273, 9191827391283., -123.00001, 04.000000};
		
		for (double d : doubs) {
			System.out.println(Printer.elementToString(d));
		}
		
	}
	
	public static void testCenterString() {
		
		System.out.println("\n~Testing centering strings");
		
		String strings[] = {"dogy", "a", "ohyes", "woooot", "bab"};
		for (String s : strings) {
			System.out.println("|" + Printer.centerString(s, 7) + "|");
		}
		
	}
	
	public static void testAlignStringBlocks() {
		
		System.out.println("\n~Testing aligning string blocks");
		
		Matrix m1 = MatrixGenerator.generateRandom(3, 4, -5, 10, 1);
		Matrix m2 = MatrixGenerator.generateRandom(5, 2, -5, 10, 1);
		Matrix m3 = MatrixGenerator.generateRandom(4, 6, -5, 10, 1);
		
		ArrayList<String> ms = new ArrayList<String>();
		ms.add("Your matrices are:");
		ms.add(m1.toString());
		ms.add(",");
		ms.add(m2.toString());
		ms.add(", and");
		ms.add(m3.toString());
		
		System.out.println(Printer.alignStringBlocks(ms));
		System.out.println("-> 15 randomized matrices, string length 100\n");
		
		ArrayList<String> matrixStrings = new ArrayList<String>();
		for (int i = 1; i <= 15; i++) {
			matrixStrings.add(MatrixGenerator.generateRandom(NumberUtils.randomInt(1, 5), 
					NumberUtils.randomInt(1, 5), -5, 10, 1).toString());
		}
		
		System.out.println(Printer.alignStringBlocks(matrixStrings, 100));
		
	}
	
}
