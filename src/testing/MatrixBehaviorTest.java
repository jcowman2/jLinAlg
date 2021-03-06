package testing;

import java.util.ArrayList;
import java.util.Arrays;

import com.jlinalg.graphic.Printer;
import com.jlinalg.math.*;

public class MatrixBehaviorTest {
	
	public static void test() {
		
		//testDefaultConstruction();
		
		//testSettingDiagonal();
		
		//testIdentity();
		
		//testRowSwapping();
		
		//testColumnSwapping();
		
		//testRowFill();
		
		//testColumnFill();
		
		testGenerateRandom();
		
		testAdd();
		
		testScalarMultiply();
		
		testMultiply();
		
	}
	
	public static void testDefaultConstruction() {
		
		System.out.println("\n~Constructing a default matrix");
		
		Matrix m = new Matrix(5, 5);
		System.out.println(m.toString());
		
	}
	
	public static void testSettingDiagonal() {
		
		System.out.println("\n~Setting the main diagonal of a matrix");
		
		Matrix m = new Matrix(6, 4);
		m.setDiagonal(11.5);
		System.out.println(m.toString());
		
	}
	
	public static void testIdentity() {
		
		System.out.println("\n~Generating an identity matrix");
		
		Matrix identity = MatrixGenerator.generateIdentity(10);
		System.out.println(identity.toString());
		
	}
	
	public static void testRowSwapping() {
		
		System.out.println("\n~Testing row swapping in a matrix");
		
		Matrix m = new Matrix(3,4);
		m.setDiagonal(131).setEntry(1, 2, -67);
		
		System.out.println(m);
		
		System.out.println("-> Swapping rows 1 and 2\n");
		m.swapRows(1, 2);
		
		System.out.println(m);
	}
	
	public static void testColumnSwapping() {
		
		System.out.println("\n~Testing column swapping in a matrix");
		
		Matrix m = new Matrix(2,5);
		
		for (int i = 1; i <= 5; i++) {
			m.setEntry(1, i, i).setEntry(2, i, -1 * i);
		}
		
		System.out.println(m);
		
		System.out.println("-> Swapping columns 1 and 5, 2 and 4, 5 and 3\n");
		m.swapColumns(1, 5).swapColumns(2, 4).swapColumns(5, 3);
		
		System.out.println(m);
		
	}
	
	public static void testRowFill() {
		
		System.out.println("\n~Testing filling a row of a matrix");
		
		Matrix m = MatrixGenerator.generateIdentity(6);
		m.fillRow(2, 43).fillRow(6, -789);
		
		System.out.println(m);
		
	}
	
	public static void testColumnFill() {
		
		System.out.println("\n~Testing filling a column of a matrix");
		
		Matrix m = new Matrix(9, 4, -1);
		m.fillColumn(1, 0).fillColumn(3, 0);
		
		System.out.println(m);
		
	}
	
	public static void testGenerateRandom() {
		
		System.out.println("\n~Testing generating several random matrices");
		
		System.out.println("-> 3x4 integer matrix between 0 and 100");
		
		Matrix m = MatrixGenerator.generateRandom(3, 4, 0, 100);
		System.out.println(m);
		
		System.out.println("-> 3x3 double matrix between 0 and 100, precision 3");
		
		m = MatrixGenerator.generateRandom(3, 3, 0, 100, 3);
		System.out.println(m);
		
		System.out.println("-> 5x5 double matrix between -5 and 5, precision 1");
		
		m = MatrixGenerator.generateRandom(5, 5, -5, 5, 1);
		System.out.println(m);
		
	}
	
	public static void testAdd() {
		
		System.out.println("\n~Testing adding several random matrices");
		
		System.out.println("-> Test 1");
		
		int r = NumberUtils.randomInt(2, 6);
		int c = NumberUtils.randomInt(2, 6);
		
		Matrix m1 = MatrixGenerator.generateRandom(r, c, -5, 10, 1);
		Matrix m2 = MatrixGenerator.generateRandom(r, c, -5, 10, 1);
		Matrix m3 = Matrix.sum(m1, m2);
		
		ArrayList<String> addList = new ArrayList<String>();
		addList.add(m1.toString());
		addList.add("+");
		addList.add(m2.toString());
		addList.add("=");
		addList.add(m3.toString());
		
		System.out.println(Printer.alignStringBlocks(addList));
		
		System.out.println("-> Test 2");
		
		ArrayList<Matrix> matrixList = new ArrayList<Matrix>();
		ArrayList<String> stringList = new ArrayList<String>();
		
		Matrix startMatrix = MatrixGenerator.generateRandom(3, 3, -5, 10, 1);
		matrixList.add(startMatrix);
		stringList.add(startMatrix.toString());
		
		for (int i = 0; i < 3; i++) {
			Matrix m = MatrixGenerator.generateRandom(3, 3, -5, 10, 1);
			startMatrix = startMatrix.add(m);
			matrixList.add(m);
			stringList.add("+");
			stringList.add(m.toString());
		}
		
		stringList.add("=");
		stringList.add(startMatrix.toString());
		
		System.out.println(Printer.alignStringBlocks(stringList));
		
	}
	
	public static void testScalarMultiply() {
		
		System.out.println("\n~Testing multiplying a matrix by a scalar");
		
		Matrix m = MatrixGenerator.generateRandom(4, 4, -5, 10);
		int scalar = NumberUtils.randomInt(-5, 10);
		String strs[] = {Integer.toString(scalar), m.toString(), " = ", m.scalarMultiply(scalar).toString()};
		
		System.out.println(Printer.alignStringBlocks(new ArrayList<String>(Arrays.asList(strs)), Integer.MAX_VALUE, 0));
		
	}
	
	public static void testMultiply() {
		
		System.out.println("\n~Testing multiplying matrices");
		
		System.out.println("-> Test 1");
		
		Matrix m1 = MatrixGenerator.generateRandom(NumberUtils.randomInt(2, 5), NumberUtils.randomInt(2, 5), -10, 10);
		Matrix m2 = MatrixGenerator.generateRandom(m1.numCols(), NumberUtils.randomInt(2, 5), -10, 10);
		String strs[] = {m1.toString(), m2.toString(), " = ", Matrix.multiply(m1,m2).toString()};
		
		System.out.println(Printer.alignStringBlocks(new ArrayList<String>(Arrays.asList(strs)), Integer.MAX_VALUE, 0));
		
		System.out.println("-> Test 2");
		
		m1 = MatrixGenerator.generateRandom(2, 2, -10, 10);
		m2 = MatrixGenerator.generateRandom(2, 2, -10, 10);
		Matrix m3 = MatrixGenerator.generateRandom(2, 2, -10, 10);
		String strs2[] = {m1.toString(), m2.toString(), m3.toString(), " = ", m2.multiplyLeft(m1).multiply(m3).toString()};
		
		System.out.println(Printer.alignStringBlocks(new ArrayList<String>(Arrays.asList(strs2)), Integer.MAX_VALUE, 0));
		
	}

}
