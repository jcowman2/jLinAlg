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
	 * @return this matrix
	 * @throws IllegalArgumentException if <code>row</code> or <code>col</code> are outside
	 * the dimensions of the matrix.
	 */
	public Matrix setEntry(int row, int col, double value) {
		
		if (row < 1 || row > this.numRows()) {
			throw new IllegalArgumentException("Invalid row parameter: " + String.valueOf(row));
		}
		
		if (col < 1 || col > this.numCols()) {
			throw new IllegalArgumentException("Invalid column parameter: " + String.valueOf(col));
		}
		
		this.rows.get(row-1).set(col-1, value);
		
		return this;
		
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
	 * @return this matrix
	 * @throws IllegalArgumentException if <code>row</code> is outside the dimension of the matrix.
	 */
	public Matrix fillRow(int row, double value) {
		
		if (row < 1 || row > this.numRows()) {
			throw new IllegalArgumentException("Invalid row parameter: " + String.valueOf(row));
		}
		
		row--;
		
		for (int i = 0; i < this.numCols(); i++) {
			this.rows.get(row).set(i, value);
		}
		
		return this;
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
	 * @return this matrix
	 * @throws IllegalArgumentException if <code>col</code> is outside the dimension of the matrix.
	 */
	public Matrix fillColumn(int col, double value) {
		
		if (col < 1 || col > this.numCols()) {
			throw new IllegalArgumentException("Invalid column parameter: " + String.valueOf(col));
		}
		
		col--;
		
		for (int i = 0; i < this.numRows(); i++) {
			this.rows.get(i).set(col, value);
		}
		
		return this;
		
	}
	
	/**
	 * Sets the value of every element in the main diagonal of the matrix.
	 * @param value number to which each element in the main diagonal is changed
	 * @return this matrix
	 */
	public Matrix setDiagonal(double value) {
		int rows = this.numRows();
		int cols = this.numCols();
		
		for (int r = 0; r < rows; r++) {
			if (r >= cols) {
				return this;
			}
			this.rows.get(r).set(r, value);
		}
		
		return this;
	}
	
	/**
	 * Swaps two rows in the matrix.
	 * @param row1 
	 * @param row2
	 * @return this matrix
	 * @throws IllegalArgumentException if either row is outside the dimension of the matrix.
	 */
	public Matrix swapRows(int row1, int row2) {
		
		if (row1 < 1 || row1 > this.numRows()) {
			throw new IllegalArgumentException("Invalid row parameter: " + String.valueOf(row1));
		}
		
		if (row2 < 1 || row2 > this.numRows()) {
			throw new IllegalArgumentException("Invalid row parameter: " + String.valueOf(row2));
		}
		
		if (row1 == row2) {
			return this;
		}
		
		row1--;
		row2--;
		
		ArrayList<Double> tempRow = this.rows.get(row1);
		this.rows.set(row1, this.rows.get(row2));
		this.rows.set(row2, tempRow);
		
		return this;
		
	}
	
	/**
	 * Swaps two columns in a matrix.
	 * @param col1
	 * @param col2
	 * @return this matrix
	 * @throws IllegalArgumentException if either column is outside the dimension of the matrix.
	 */
	public Matrix swapColumns(int col1, int col2) {
		
		if (col1 < 1 || col1 > this.numCols()) {
			throw new IllegalArgumentException("Invalid column parameter: " + String.valueOf(col1));
		}
		
		if (col2 < 1 || col2 > this.numCols()) {
			throw new IllegalArgumentException("Invalid column parameter: " + String.valueOf(col2));
		}
		
		if (col1 == col2) {
			return this;
		}
		
		col1--;
		col2--;
		
		for (int r = 0; r < this.numRows(); r++) {
			double temp = this.rows.get(r).get(col1);
			this.rows.get(r).set(col1, this.rows.get(r).get(col2));
			this.rows.get(r).set(col2, temp);
		}
		
		return this;
		
	}
	
	/**
	 * Returns an entrywise sum of this matrix with an equidimensional matrix
	 * @param matrix the matrix to be added to this matrix
	 * @return a new matrix with entries summed
	 * @throws IllegalArgumentException if the new matrix has different dimensions than this matrix
	 */
	public Matrix add(Matrix matrix) {
		return Matrix.sum(this, matrix);
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
	
	/**
	 * Multiplies this matrix by a real scalar
	 * @param scalar
	 * @return this matrix
	 */
	public Matrix scalarMultiply(double scalar) {
		
		for (int r = 1; r <= this.numRows(); r++) {
			for (int c = 1; c <= this.numCols(); c++) {
				this.setEntry(r, c, NumberUtils.fixRoundingError(this.getEntry(r, c) * scalar));
			}
		}
		
		return this;
		
	}
	
	/**
	 * Multiplies two matrices using an iterative algorithm
	 * @param a an n x m matrix
	 * @param b an m x p matrix
	 * @return resulting n x p matrix
	 * @throws IllegalArgumentException if the the number of columns in the first matrix doesn't match the number of rows in the second matrix
	 */
	public static Matrix multiply(Matrix a, Matrix b) {
		
		if (a.numCols() != b.numRows()) {
			throw new IllegalArgumentException("Number of columns in first matrix must match number of rows in second matrix.");
		}
		
		Matrix m = new Matrix(a.numRows(), b.numCols());
		
		for (int r = 1; r <= m.numRows(); r++) {
			for (int c = 1; c <= m.numCols(); c++) {
				
				int sum = 0;
				
				for (int i = 1; i <= a.numCols(); i++) {
					sum += a.getEntry(r, i) * b.getEntry(i, c);
				}
				
				m.setEntry(r, c, NumberUtils.fixRoundingError(sum));
				
			}
		}
		
		return m;
		
	}
	
	/**
	 * Multiplies this n x m matrix with another m x p matrix, using an iterative algorithm
	 * @param matrix
	 * @return resulting n x p matrix
	 * @throws IllegalArgumentException if the the number of columns in this matrix doesn't match the number of rows in the second matrix
	 */
	public Matrix multiply(Matrix matrix) {
		return Matrix.multiply(this, matrix);
	}
	
	/**
	 * Multiplies another n x m matrix with this m x p matrix, using an iterative algorithm
	 * @param matrix
	 * @return resulting n x p matrix
	 * @throws IllegalArgumentException if the the number of columns in the other matrix doesn't match the number of rows in this matrix
	 */
	public Matrix multiplyLeft(Matrix matrix) {
		return Matrix.multiply(matrix, this);
	}
	
	public String toString() {
		return Printer.matrixToString(this);
	}
	
}
