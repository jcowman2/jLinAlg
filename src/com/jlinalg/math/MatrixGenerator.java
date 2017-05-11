package com.jlinalg.math;

public class MatrixGenerator {
	
	public static Matrix generateIdentity(int size) {
		
		if (size <= 0) {
			throw new IllegalArgumentException("Matrix must have positive dimension.");
		}
		
		Matrix m = new Matrix(size, size);
		m.setDiagonal(1);
		
		return m;
		
	}
	
	public static Matrix generateRandom(int rows, int cols, double min, double max, int precision) {
		
		if (rows <= 0) {
			throw new IllegalArgumentException("Matrix must have at least one row.");
		}
		
		if (cols <= 0) {
			throw new IllegalArgumentException("Matrix must have at least one column.");
		}
		
		if (precision < 0) {
			throw new IllegalArgumentException("Precision must be greater than or equal to zero.");
		}
		
		Matrix m = new Matrix(rows, cols);
		double value = 0;

		for (int r = 1; r <= rows; r++) {
			for (int c = 1; c <= cols; c++) {
				
				value = NumberUtils.randomDouble(min, max);
				value = Double.valueOf(String.format("%." + precision + "f", value));  //Set precision
				
				m.setEntry(r, c, value);
			}
		}
		
		return m;
		
	}
	
	public static Matrix generateRandom(int rows, int cols, double min, double max) {
		return generateRandom(rows, cols, min, max, 0);
	}

}
