package com.jlinalg.math;

import java.math.BigInteger;

public class PolyConstant implements PolyBehavior{
	
	private BigInteger bigInt;
	
	public PolyConstant(int integer) {
		this.bigInt = BigInteger.valueOf(integer);
	}
	
	public PolyConstant(BigInteger bigInt) {
		this.bigInt = bigInt;
	}
	
	public String toString() {
		return this.bigInt.toString();
	}
	
}
