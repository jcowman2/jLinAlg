package com.jlinalg.math;

import java.util.ArrayList;

/**
 * Generates and performs basic operations on matrices of doubles.
 * @author Joe Cowman
 * @since 2017-04-08
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
	
	/**
	 * Returns the number of rows in the matrix.
	 * @return the number of rows in the matrix
	 */
	public int numRows() {
		return this.rows.size();
	}
	
	/**
	 * Returns the number of columns in the matrix.
	 * @return the number of columns in the matrix
	 */
	public int numCols() {
		return this.rows.get(0).size();
	}
	
	/**
	 * Sets the value of a single entry in the matrix.
	 * @param row row at which the entry is to changed
	 * @param col column at which the entry is to changed
	 * @param value number to which the entry is changed
	 * @return the value of the updated entry
	 * @throws IllegalArgumentException if <code>row</code> or <code>col</code> are outside
	 * the dimensions of the matrix.
	 */
	public double setEntry(int row, int col, double value) {
		
		if (row < 1 || row > this.numRows()) {
			throw new IllegalArgumentException("Invalid row parameter.");
		}
		
		if (col < 1 || col > this.numCols()) {
			throw new IllegalArgumentException("Invalid column parameter.");
		}
		
		this.rows.get(row-1).set(col-1, value);
		return value;
	}
	
	/**
	 * Returns the value of a single entry in the matrix.
	 * @param row row at which the entry is to retrieved
	 * @param col column at which the entry is to be retrieved
	 * @return the value of the specified entry
	 * @throws IllegalArgumentException if <code>row</code> or <code>col</code> are outside
	 * the dimensions of the matrix. 
	 */
	public double getEntry(int row, int col) {
		
		if (row < 1 || row > this.numRows()) {
			throw new IllegalArgumentException("Invalid row parameter.");
		}
		
		if (col < 1 || col > this.numCols()) {
			throw new IllegalArgumentException("Invalid column parameter.");
		}
		
		return this.rows.get(row-1).get(col-1);
	}
	
	/**
	 * Sets the value of every element in the main diagonal of the matrix.
	 * @param value number to which each element in the main diagonal is changed
	 * @return the new value of each element in the diagonal
	 */
	public double setDiagonal(double value) {
		int rows = this.numRows();
		int cols = this.numCols();
		
		for (int r = 0; r < rows; r++) {
			if (r >= cols) {
				return value;
			}
			this.rows.get(r).set(r, value);
		}
		
		return value;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		//TODO
		
		return sb.toString();
	}
	
}
