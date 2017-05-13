package com.jlinalg.math;

import java.math.BigInteger;

public class Fraction {
	
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

}
