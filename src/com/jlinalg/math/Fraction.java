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
		
		this.simplify();
		
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
	
	private void simplify() {
		
		BigInteger gcd = this.numerator.gcd(this.denominator);
		this.numerator = this.numerator.divide(gcd);
		this.denominator = this.denominator.divide(gcd);
		
		if (this.denominator.signum() == -1) {
			this.numerator = this.numerator.negate();
			this.denominator = this.denominator.negate();
		}
		
	}
	
	@Override
	public Fraction add(Fraction e) {
		
		BigInteger newNum = this.numerator.multiply(e.getDenominator()).add(e.getNumerator().multiply(this.denominator));
		BigInteger newDenom = this.denominator.multiply(e.getDenominator());
		
		return new Fraction(newNum, newDenom);
		
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
