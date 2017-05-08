package testing;

import com.jlinalg.math.*;
import com.jlinalg.graphic.*;

public class MatrixBehaviorTest {
	
	public static void test() {
		
		testDefaultConstruction();
		
		testSettingDiagonal();
		
		testIdentity();
		
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

}
