package testing;

import com.jlinalg.math.*;
import com.jlinalg.graphic.*;

public class MatrixBehaviorTest {
	
	public static void test() {
		
		testDefaultConstruction();
		
		testSettingDiagonal();
		
		testIdentity();
		
		testRowSwapping();
		
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
		
		m.swapRows(1, 2);
		
		System.out.println(m);
	}

}
