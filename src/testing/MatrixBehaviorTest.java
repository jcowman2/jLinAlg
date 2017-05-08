package testing;

import com.jlinalg.math.Matrix;

public class MatrixBehaviorTest {
	
	public static void test() {
		
		//testDefaultConstruction();
		
		//testSettingDiagonal();
		
	}
	
	public static void testDefaultConstruction() {
		
		System.out.println("\n~Constructing a 5x5 default matrix");
		
		Matrix zeroMatrix = new Matrix(5, 5);
		System.out.println("(3,3): " + Double.toString(zeroMatrix.getEntry(3, 3)));
		System.out.println("(3,4): " + Double.toString(zeroMatrix.getEntry(3, 4)));
		
	}
	
	public static void testSettingDiagonal() {
		
		System.out.println("\n~Setting the main diagonal of a 5x5 matrix");
		
		Matrix zeroMatrix = new Matrix(5, 5);
		zeroMatrix.setDiagonal(11.5);
		System.out.println("(3,3): " + Double.toString(zeroMatrix.getEntry(3, 3)));
		System.out.println("(3,4): " + Double.toString(zeroMatrix.getEntry(3, 4)));
		
	}

}
