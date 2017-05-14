package com.jlinalg.math;

import java.math.BigInteger;

public class Fraction implements MatrixElement {
	
	private BigInteger numerator;
	private BigInteger denominator;
	
	public Fraction(int num, int denom) {
		numerator = BigInteger.valueOf(num);
		denominator = BigInteger.valueOf(denom);
	}
	
	public Fraction(int num) {
		this(num, 1);
	}
	
	public Fraction() {
		this(0, 1);
	}
	
	@Override
	public Fraction add(MatrixElement e) {
		
		Fraction f;
		
		try {
			f = (Fraction) e;
		} catch (ClassCastException cce) {
			throw new IllegalMatrixOperationException("Cannot add " + this.getClass().toString() + " and " + e.getClass().toString());
		}
		
		return null;
		
	}


}
