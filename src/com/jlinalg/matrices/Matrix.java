package com.jlinalg.matrices;

import java.util.ArrayList;

public class Matrix {
	
	private ArrayList<ArrayList<Double>> rows;
	
	
	public Matrix(int numRows, int numCols, double filler) {
		
		this.rows = new ArrayList<ArrayList<Double>>();
		
		for (int r = 0; r < numRows; r++) {
			ArrayList<Double> row = new ArrayList<Double>();
			for (int c = 0; c < numCols; c++) {
				row.add(filler);
			}
			this.rows.add(row);
		}
		
	}
	
	
	public Matrix(int numRows, int numCols) {
		this(numRows, numCols, 0);
	}
	
}
