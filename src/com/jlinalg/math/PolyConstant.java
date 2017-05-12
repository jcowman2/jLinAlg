package com.jlinalg.math;

import java.math.BigInteger;

public class PolyConstant implements PolyBehavior{
	
	public static final PolyConstant ONE = new PolyConstant(1);
	
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
	
	public boolean isLikeTerm(PolyBehavior p) {
		return p.getClass().equals(this.getClass());
	}
	
	public boolean isEquivalent(PolyBehavior p) {
		
		if (!this.isLikeTerm(p)) {
			return false;
		}
		
		PolyConstant c = (PolyConstant) p;
		
		return (this.bigInt.equals(c.bigInt));
		
	}
	
}
