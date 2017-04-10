package testing;

import com.jlinalg.math.Matrix;

public class Driver {
	
	public static void main(String[] args) {
		
		Matrix zeroMatrix = new Matrix(5, 5);
		System.out.println("(3,3): " + Double.toString(zeroMatrix.getEntry(3, 3)));
		System.out.println("(3,4): " + Double.toString(zeroMatrix.getEntry(3, 4)));
		zeroMatrix.setDiagonal(11.5);
		System.out.println("(3,3): " + Double.toString(zeroMatrix.getEntry(3, 3)));
		System.out.println("(3,4): " + Double.toString(zeroMatrix.getEntry(3, 4)));
		
	}
	
}
