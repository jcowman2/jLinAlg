package com.jlinalg.math;

public class MatrixGenerator {
	
	public static Matrix generateIdentity(int size) {
		
		Matrix m = new Matrix(size, size);
		m.setDiagonal(1);
		
		return m;
		
	}

}
