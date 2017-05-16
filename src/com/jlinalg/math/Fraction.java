package com.jlinalg.math;

import java.math.BigInteger;

public class Fraction implements MatrixElement<Fraction> {
	
	private BigInteger numerator;
	private BigInteger denominator;
	
	public Fraction(BigInteger num, BigInteger denom) {
		
		if (denom.compareTo(BigInteger.ZERO) == 0) {
			throw new ArithmeticException("Cannot divide by zero");
		}
		
		this.numerator = num;
		this.denominator = denom;
		
	}
	
	public Fraction(int num, int denom) {
		this(BigInteger.valueOf(num), BigInteger.valueOf(denom));
	}
	
	public Fraction(int num) {
		this(num, 1);
	}
	
	public Fraction() {
		this(0, 1);
	}
	
	public Fraction(Fraction f) {
		this(f.getNumerator(), f.getDenominator());
	}
	
	public BigInteger getNumerator() {
		return this.numerator;
	}
	
	public BigInteger getDenominator() {
		return this.denominator;
	}
	
	@Override
	public Fraction add(Fraction e) {
		
		Fraction f;
		
		return this;
		
	}
	
	@Override
	public String toString() {
		
		if (numerator.intValue() == 0) {
			return String.valueOf(0);
		} else if (denominator.intValue() == 1) {
			return numerator.toString();
		} else {
			return new StringBuilder().append(this.numerator.toString()).append("/").append(this.denominator.toString()).toString();
		}
		
	}


}
