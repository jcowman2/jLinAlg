package com.jlinalg.graphic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jlinalg.math.Matrix;

public class Printer {
	
	private static final String VERTICAL_BEAM = "\u2502";
	private static final String UP_RIGHT_ELBOW = "\u250C";
	private static final String DOWN_RIGHT_ELBOW = "\u2514";
	private static final String UP_LEFT_ELBOW = "\u2510";
	private static final String DOWN_LEFT_ELBOW = "\u2518";
	
	public static String matrixToString(Matrix matrix) {
		
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
		
		strb.append(DOWN_RIGHT_ELBOW).append(String.format("%"+innerLineSpace+"s", "")).append(DOWN_LEFT_ELBOW);
		
		return strb.toString();
	}
	
	public static String elementToString(double n) {
		
		if (n == -0.0) {
			n = 0.0;
		}
		
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
		
		rightPad = padLength / 2;
		leftPad = padLength - rightPad;
		
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
	
	public static String alignStringBlocks(List<String> strings, int lineLength, int spacesBetween, 
			boolean justifyCenter) {
		
		StringBuilder strb = new StringBuilder();
		
		ArrayList<ArrayList<String>> blockList = new ArrayList<ArrayList<String>>();
		
		for (String str : strings) { //Convert flat strings into rectangular string blocks
			
			ArrayList<String> tempLines = new ArrayList<String>(Arrays.asList(str.split("\n")));
			
			while (tempLines.contains("")) {
				tempLines.remove("");
			}
			
			if (tempLines.size() > 1) {
			
				int maxLength = tempLines.get(0).length();
				
				for (String line : tempLines.subList(1, tempLines.size())) {
					if (line.length() > maxLength) {
						maxLength = line.length();
					}
				}
				
				if (justifyCenter) {
				
					for (int i = 0; i < tempLines.size(); i++) {
						tempLines.set(i, centerString(tempLines.get(i), maxLength));
					}
				
				} else { //justify left
					
					for (int i = 0; i < tempLines.size(); i++) {
						
						StringBuilder wordStrb = new StringBuilder();
						wordStrb.append(tempLines.get(i));
						
						int rightPad = maxLength - tempLines.get(i).length();
						while (rightPad > 0) {
							wordStrb.append(" ");
							rightPad--;
						}
						
						tempLines.set(i, wordStrb.toString());
						
					}
					
				}
			
			}
			
			blockList.add(tempLines);
			
		}
		
		while (!blockList.isEmpty()) {
			
			ArrayList<ArrayList<String>> stagingList = new ArrayList<ArrayList<String>>(); 	//stage blocks to be printed in current line
			
			int maxHeight = blockList.get(0).size();
			int spacesRemainingInLine = lineLength - blockList.get(0).get(0).length();
			stagingList.add(blockList.get(0));
			blockList.remove(0);
			
			while (!blockList.isEmpty() && spacesRemainingInLine - blockList.get(0).get(0).length() - spacesBetween >= 0) {
				
				if (blockList.get(0).size() > maxHeight) {
					maxHeight = blockList.get(0).size();
				}
				
				spacesRemainingInLine -= (blockList.get(0).get(0).length() + spacesBetween);
				stagingList.add(blockList.get(0));
				blockList.remove(0);

			}
			
			for (ArrayList<String> block : stagingList) {
				
				int blockWidth = block.get(0).length();
				
				if (block.size() < maxHeight) {
					
					int totalPad = maxHeight - block.size();
					int topPad = 0;
					int bottomPad = 0;
					
					topPad = totalPad / 2;
					bottomPad = totalPad - topPad;
					
					while (topPad > 0) {
						block.add(0, String.format("%"+blockWidth+"s", ""));
						topPad--;
					}
					
					while (bottomPad > 0) {
						block.add(String.format("%"+blockWidth+"s", ""));
						bottomPad--;
					}
					
				}
				
			}
			
			for (int i = 0; i < maxHeight; i++) { //add staged blocks to block line
				
				strb.append(stagingList.get(0).get(i));
				
				for (List<String> block : stagingList.subList(1, stagingList.size())) {
					for (int s = 1; s <= spacesBetween; s++) {
						strb.append(" ");
					}
					strb.append(block.get(i));
				}
				
				strb.append("\n");
				
			}
			
			strb.append("\n");
			
		}
		
		return strb.toString();
		
	}
	
	public static String alignStringBlocks(List<String> strings, int lineLength, int spacesBetween) {
		return alignStringBlocks(strings, lineLength, spacesBetween, false);
	}
	
	public static String alignStringBlocks(List<String> strings, int lineLength, boolean justifyCenter) {
		return alignStringBlocks(strings, lineLength, 1, justifyCenter);
	}
	
	public static String alignStringBlocks(List<String> strings, int lineLength) {
		return alignStringBlocks(strings, lineLength, 1, false);
	}
	
	public static String alignStringBlocks(List<String> strings, boolean justifyCenter) {
		return alignStringBlocks(strings, Integer.MAX_VALUE, 1, justifyCenter);
	}
	
	public static String alignStringBlocks(List<String> strings) {
		return alignStringBlocks(strings, Integer.MAX_VALUE, 1, false);
	}

}
