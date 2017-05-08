package com.jlinalg.graphic;

import com.jlinalg.math.Matrix;

public class Printer {
	
	private static final String VERTICAL_BEAM = "\u2502";
	private static final String UP_RIGHT_ELBOW = "\u250C";
	private static final String DOWN_RIGHT_ELBOW = "\u2514";
	private static final String UP_LEFT_ELBOW = "\u2510";
	private static final String DOWN_LEFT_ELBOW = "\u2518";
	
	public static String matrixToString(Matrix matrix) { //TODO
		
		int columnWidths[] = new int[matrix.numCols()];
		String elementStrings[][] = new String[matrix.numRows()][];
		
		for (int r = 0; r < matrix.numRows(); r++) {
			
			elementStrings[r] = new String[matrix.numCols()];
			
			for (int c = 0; c < matrix.numCols(); c++) {
				String elementString = elementToString(matrix.getEntry(r + 1, c + 1));
				elementStrings[r][c] = elementString;
				columnWidths[c] = Math.max(elementString.length(), columnWidths[c]);
			}
			
		}
		
		int innerLineSpace = 0;
		for (int w : columnWidths) {
			innerLineSpace += w + 2;
		}
		
		StringBuilder strb = new StringBuilder();
		
		strb.append(UP_RIGHT_ELBOW).append(String.format("%"+innerLineSpace+"s", "")).append(UP_LEFT_ELBOW).append("\n");
		
		for (int r = 0; r < matrix.numRows(); r++) {
			
			strb.append(VERTICAL_BEAM);
			
			for (int c = 0; c < matrix.numCols(); c++) {
				strb.append(" ").append(centerString(elementStrings[r][c], columnWidths[c])).append(" ");
			}
			
			strb.append(VERTICAL_BEAM).append("\n");
			
		}
		
		strb.append(DOWN_RIGHT_ELBOW).append(String.format("%"+innerLineSpace+"s", "")).append(DOWN_LEFT_ELBOW).append("\n");
		
		return strb.toString();
	}
	
	public static String elementToString(double n) {
		
		String str = Double.toString(n);
		
		int decimalIndex = str.length() - 1;
		
		while (str.charAt(decimalIndex) == '0') {
			decimalIndex--;
		}

		if (str.charAt(decimalIndex) == '.') {
			str = str.substring(0, decimalIndex);
		}
		
		return str;
		
	}
	
	public static String elementToString(int i) {
		return Integer.toString(i);
	}
	
	public static String centerString(String str, int totalWidth) {
		
		int padLength = totalWidth - str.length();
		
		if (padLength <= 0) {
			return str;
		}
		
		int leftPad = 0;
		int rightPad = 0;
		
		leftPad = padLength / 2;
		rightPad = padLength - leftPad;
		
		StringBuilder strb = new StringBuilder();
		
		while (leftPad > 0) {
			strb.append(" ");
			leftPad--;
		}
		
		strb.append(str);
		
		while (rightPad > 0) {
			strb.append(" ");
			rightPad--;
		}
		
		return strb.toString();
		
	}

}
