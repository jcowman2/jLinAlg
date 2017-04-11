package testing;

import com.jlinalg.math.Matrix;
import com.jlinalg.graphic.Printer;

public class Driver {
	
	public static void main(String[] args) {
		
		Matrix zeroMatrix = new Matrix(5, 5);
		System.out.println("(3,3): " + Double.toString(zeroMatrix.getEntry(3, 3)));
		System.out.println("(3,4): " + Double.toString(zeroMatrix.getEntry(3, 4)));
		zeroMatrix.setDiagonal(11.5);
		System.out.println("(3,3): " + Double.toString(zeroMatrix.getEntry(3, 3)));
		System.out.println("(3,4): " + Double.toString(zeroMatrix.getEntry(3, 4)));
		
<<<<<<< HEAD
		System.out.println(Printer.matrixToString(zeroMatrix));
=======
		for (int i=1; i <= 5; i++) {
			System.out.println(zeroMatrix.getRow(i));
		}
		System.out.println("\n");
		for (int i=5; i > 0; i--) {
			System.out.println(zeroMatrix.getColumn(i));
		}
>>>>>>> refs/remotes/origin/master
		
	}
	
}
