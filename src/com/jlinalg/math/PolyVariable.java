package com.jlinalg.math;

public class PolyVariable implements PolyBehavior {
	
	private String var;
	
	public PolyVariable(String str) {
		this.var = str;
	}
	
	public String getName() {
		return var;
	}
	
	public String toString() {
		return var;
	}
	
	public boolean isLikeTerm(PolyBehavior p) {
		
		if (!p.getClass().equals(this.getClass())) {
			return false;
		}
		
		PolyVariable polyvar = (PolyVariable) p;
		
		return this.var.equals(polyvar.getName());
		
	}
	
	public boolean isEquivalent(PolyBehavior p) {
		return this.isLikeTerm(p);
	}

}
