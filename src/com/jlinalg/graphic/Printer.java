package com.jlinalg.graphic;

import com.jlinalg.math.Matrix;

public class Printer {
	
	private static final String VERTICAL_BEAM = "\u2502";
	private static final String UP_RIGHT_ELBOW = "\u250C";
	private static final String DOWN_RIGHT_ELBOW = "\u2514";
	private static final String UP_LEFT_ELBOW = "\u2510";
	private static final String DOWN_LEFT_ELBOW = "\u2518";
	
	public static String matrixToString(Matrix matrix) { //TODO
		StringBuilder strb = new StringBuilder();
		
		strb.append(UP_RIGHT_ELBOW).append("       ").append(UP_LEFT_ELBOW).append("\n");
		strb.append(VERTICAL_BEAM).append(" 1").append(" 0").append(" 0").append(" ").append(VERTICAL_BEAM).append("\n");
		strb.append(VERTICAL_BEAM).append(" 0").append(" 1").append(" 0").append(" ").append(VERTICAL_BEAM).append("\n");
		strb.append(VERTICAL_BEAM).append(" 0").append(" 0").append(" 1").append(" ").append(VERTICAL_BEAM).append("\n");
		strb.append(DOWN_RIGHT_ELBOW).append("       ").append(DOWN_LEFT_ELBOW).append("\n");
		
		//Get longest row length
		//Get longest element length for each column
		//Print each row:
			//Center each element in each column
		
		return strb.toString();
	}
	
	public static String doubleToString(double n) {
		
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

}
