package testing;

import com.jlinalg.math.*;
import com.jlinalg.graphic.*;

public class MatrixBehaviorTest {
	
	public static void test() {
		
		testDefaultConstruction();
		
		testSettingDiagonal();
		
		testIdentity();
		
		testRowSwapping();
		
		testColumnSwapping();
		
		testRowFill();
		
		testColumnFill();
		
	}
	
	public static void testDefaultConstruction() {
		
		System.out.println("\n~Constructing a default matrix");
		
		Matrix m = new Matrix(5, 5);
		System.out.println(m.toString());
		
	}
	
	public static void testSettingDiagonal() {
		
		System.out.println("\n~Setting the main diagonal of a matrix");
		
		Matrix m = new Matrix(6, 4);
		m.setDiagonal(11.5);
		System.out.println(m.toString());
		
	}
	
	public static void testIdentity() {
		
		System.out.println("\n~Generating an identity matrix");
		
		Matrix identity = MatrixGenerator.generateIdentity(10);
		System.out.println(identity.toString());
		
	}
	
	public static void testRowSwapping() {
		
		System.out.println("\n~Testing row swapping in a matrix");
		
		Matrix m = new Matrix(3,4);
		m.setDiagonal(131);
		m.setEntry(1, 2, -67);
		
		System.out.println(m);
		
		System.out.println("-> Swapping rows 1 and 2\n");
		m.swapRows(1, 2);
		
		System.out.println(m);
	}
	
	public static void testColumnSwapping() {
		
		System.out.println("\n~Testing column swapping in a matrix");
		
		Matrix m = new Matrix(2,5);
		
		for (int i = 1; i <= 5; i++) {
			m.setEntry(1, i, i);
			m.setEntry(2, i, -1 * i);
		}
		
		System.out.println(m);
		
		System.out.println("-> Swapping columns 1 and 5, 2 and 4, 5 and 3\n");
		m.swapColumns(1, 5);
		m.swapColumns(2, 4);
		m.swapColumns(5, 3);
		
		System.out.println(m);
		
	}
	
	public static void testRowFill() {
		
		System.out.println("\n~Testing filling a row of a matrix");
		
		Matrix m = MatrixGenerator.generateIdentity(6);
		m.fillRow(2, 43);
		m.fillRow(6, -789);
		
		System.out.println(m);
		
	}
	
	public static void testColumnFill() {
		
		System.out.println("\n~Testing filling a column of a matrix");
		
		Matrix m = new Matrix(9, 4, -1);
		m.fillColumn(1, 0);
		m.fillColumn(3, 0);
		
		System.out.println(m);
		
	}

}
