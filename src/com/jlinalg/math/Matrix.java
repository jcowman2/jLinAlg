package com.jlinalg.math;

import java.util.ArrayList;

import com.jlinalg.graphic.Printer;

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
	 * Copy constructor for matrix object
	 * @param matrix the matrix to be duplicated
	 */
	public Matrix(Matrix matrix) {
		
		this.rows = new ArrayList<ArrayList<Double>>();
		
		for (int i = 0; i < matrix.numRows(); i++) {
			this.rows.add(matrix.getRow(i));
		}
		
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
			throw new IllegalArgumentException("Invalid row parameter: " + String.valueOf(row));
		}
		
		if (col < 1 || col > this.numCols()) {
			throw new IllegalArgumentException("Invalid column parameter: " + String.valueOf(col));
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
			throw new IllegalArgumentException("Invalid row parameter: " + String.valueOf(row));
		}
		
		if (col < 1 || col > this.numCols()) {
			throw new IllegalArgumentException("Invalid column parameter: " + String.valueOf(col));
		}
		
		return this.rows.get(row-1).get(col-1);
	}
	
	/**
	 * Returns an <code>ArrayList</code> containing the entries of a single row in the matrix.
	 * @param row the row to be retrieved
	 * @return an <code>ArrayList</code> of the entries in the specified row
	 * @throws IllegalArgumentException if <code>row</code> is outside the dimension of the matrix.
	 */
	public ArrayList<Double> getRow(int row) {
		
		if (row < 1 || row > this.numRows()) {
			throw new IllegalArgumentException("Invalid row parameter: " + String.valueOf(row));
		}
		
		return new ArrayList<Double>(this.rows.get(row-1));
	}
	
	/**
	 * Changes every element in a row of the matrix to the given value
	 * @param row
	 * @param value
	 * @return the new value of every element in the modified row
	 * @throws IllegalArgumentException if <code>row</code> is outside the dimension of the matrix.
	 */
	public double fillRow(int row, double value) {
		
		if (row < 1 || row > this.numRows()) {
			throw new IllegalArgumentException("Invalid row parameter: " + String.valueOf(row));
		}
		
		row--;
		
		for (int i = 0; i < this.numCols(); i++) {
			this.rows.get(row).set(i, value);
		}
		
		return value;
	}
	
	/**
	 * Returns an <code>ArrayList</code> containing the entries of a single column in the matrix.
	 * @param col the column to be retrieved
	 * @return an <code>ArrayList</code> of the entries in the specified column
	 * @throws IllegalArgumentException if <code>col</code> is outside the dimension of the matrix.
	 */
	public ArrayList<Double> getColumn(int col) {
		
		if (col < 1 || col > this.numCols()) {
			throw new IllegalArgumentException("Invalid column parameter: " + String.valueOf(col));
		}
		
		ArrayList<Double> column = new ArrayList<Double>();
		
		for (int row = 0; row < this.rows.size(); row++) {
			column.add(this.rows.get(row).get(col-1));
		}
		
		return column;
		
	}
	
	/**
	 * Changes every element in a column of the matrix to the given value
	 * @param col
	 * @param value
	 * @return the new value of every element in the modified column
	 * @throws IllegalArgumentException if <code>col</code> is outside the dimension of the matrix.
	 */
	public double fillColumn(int col, double value) {
		
		if (col < 1 || col > this.numCols()) {
			throw new IllegalArgumentException("Invalid column parameter: " + String.valueOf(col));
		}
		
		col--;
		
		for (int i = 0; i < this.numRows(); i++) {
			this.rows.get(i).set(col, value);
		}
		
		return value;
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
	
	/**
	 * Swaps two rows in the matrix.
	 * @param row1 
	 * @param row2
	 * @throws IllegalArgumentException if either row is outside the dimension of the matrix.
	 */
	public void swapRows(int row1, int row2) {
		
		if (row1 < 1 || row1 > this.numRows()) {
			throw new IllegalArgumentException("Invalid row parameter: " + String.valueOf(row1));
		}
		
		if (row2 < 1 || row2 > this.numRows()) {
			throw new IllegalArgumentException("Invalid row parameter: " + String.valueOf(row2));
		}
		
		if (row1 == row2) {
			return;
		}
		
		row1--;
		row2--;
		
		ArrayList<Double> tempRow = this.rows.get(row1);
		this.rows.set(row1, this.rows.get(row2));
		this.rows.set(row2, tempRow);
		
	}
	
	/**
	 * Swaps two columns in a matrix.
	 * @param col1
	 * @param col2
	 * @throws IllegalArgumentException if either column is outside the dimension of the matrix.
	 */
	public void swapColumns(int col1, int col2) {
		
		if (col1 < 1 || col1 > this.numCols()) {
			throw new IllegalArgumentException("Invalid column parameter: " + String.valueOf(col1));
		}
		
		if (col2 < 1 || col2 > this.numCols()) {
			throw new IllegalArgumentException("Invalid column parameter: " + String.valueOf(col2));
		}
		
		if (col1 == col2) {
			return;
		}
		
		col1--;
		col2--;
		
		for (int r = 0; r < this.numRows(); r++) {
			double temp = this.rows.get(r).get(col1);
			this.rows.get(r).set(col1, this.rows.get(r).get(col2));
			this.rows.get(r).set(col2, temp);
		}
		
	}
	
	/**
	 * Returns an entrywise sum of this matrix with an equidimensional matrix
	 * @param matrix the matrix to be added
	 * @return a new matrix with entries summed
	 * @throws IllegalArgumentException if the new matrix has different dimensions than this matrix
	 */
	public Matrix add(Matrix matrix) {
		return sum(this, matrix);
	}
	
	/**
	 * Returns an entrywise sum of two equidimensional matrices
	 * @param a
	 * @param b
	 * @return a new matrix with entries summed
	 * @throws IllegalArgumentException if the matrices have different numbers of rows or columns
	 */
	public static Matrix sum(Matrix a, Matrix b) {
		
		if (a.numRows() != b.numRows() || a.numCols() != b.numCols()) {
			throw new IllegalArgumentException("Matrices must be the same size.");
		}
		
		Matrix sum = new Matrix(a.numRows(), b.numCols());
		
		for (int r = 1; r <= b.numRows(); r++) {
			for (int c = 1; c <= b.numCols(); c++) {
				sum.setEntry(r, c, NumberUtils.fixRoundingError(a.getEntry(r, c) + b.getEntry(r, c)));
			}
		}
		
		return sum;
		
	}
	
	public String toString() {
		return Printer.matrixToString(this);
	}
	
}
