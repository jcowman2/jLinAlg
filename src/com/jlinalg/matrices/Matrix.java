package com.jlinalg.matrices;

import java.util.ArrayList;

/**
 * Generates and performs basic operations on matrices of doubles.
 * @author Joe Cowman
 */
public class Matrix {
	
	private ArrayList<ArrayList<Double>> rows;
	
	/**
	 * Constructs a matrix with the given dimensions, with each element having the given value.
	 * @param numRows the number of rows in the matrix
	 * @param numCols the number of columns in the matrix
	 * @param filler the value to fill every element in the matrix
	 * @throws IllegalArgumentException if <code>numRows</code> or <code>numCols</code> are less than one
	 */
	public Matrix(int numRows, int numCols, double filler) {
		
		if (numRows <= 0) {
			throw new IllegalArgumentException("Matrix must have at least one row.");
		}
		
		if (numCols <= 0) {
			throw new IllegalArgumentException("Matrix must have at least one column.");
		}
		
		this.rows = new ArrayList<ArrayList<Double>>();
		
		for (int r = 0; r < numRows; r++) {
			ArrayList<Double> row = new ArrayList<Double>();
			for (int c = 0; c < numCols; c++) {
				row.add(filler);
			}
			this.rows.add(row);
		}
		
	}
	
	/**
	 * Constructs a zero matrix with the given dimensions.
	 * @param numRows the number of rows in the matrix
	 * @param numCols the number of columns in the matrix
	 * @throws IllegalArgumentException if <code>numRows</code> or <code>numCols</code> are less than one
	 */
	public Matrix(int numRows, int numCols) {
		this(numRows, numCols, 0);
	}
	
}
