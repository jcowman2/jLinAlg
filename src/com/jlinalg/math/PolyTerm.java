package com.jlinalg.math;

import java.util.ArrayList;

public class PolyTerm implements PolyBehavior {
	
	private ArrayList<PolyBehavior> bases = new ArrayList<PolyBehavior>();
	private ArrayList<PolyBehavior> exponents = new ArrayList<PolyBehavior>();
	
	public PolyTerm(PolyBehavior firstTerm, PolyBehavior firstExponent) {
		bases.add(firstTerm);
		exponents.add(firstExponent);
	}
	
	public PolyTerm(PolyBehavior firstTerm) {
		bases.add(firstTerm);
		exponents.add(PolyConstant.ONE);
	}
	
	public boolean isLikeTerm(PolyBehavior p) {
		
		if (!p.getClass().equals(this.getClass())) {
			return false;
		}
		
		PolyTerm t = (PolyTerm) p;
		
		if (this.bases.size() != t.bases.size()) {
			return false;
		}
		
		for (int i = 0; i < this.bases.size(); i++) {
		
			if (!this.bases.get(i).isLikeTerm(t.bases.get(i)) ||
					!this.exponents.get(i).isEquivalent(t.exponents.get(i))) {
				return false;
			}
			
		}
		
		return true;
		
	}
	
	public boolean isEquivalent(PolyBehavior p) {
		
		if (!p.getClass().equals(this.getClass())) {
			return false;
		}
		
		PolyTerm t = (PolyTerm) p;
		
		if (this.bases.size() != t.bases.size()) {
			return false;
		}
		
		for (int i = 0; i < this.bases.size(); i++) {
			
			if (!this.bases.get(i).isEquivalent(t.bases.get(i)) || 
					!this.exponents.get(i).isEquivalent(t.exponents.get(i))) {
				return false;
			}
			
		}
		
		return true;
	}
	
	public String toString() {
		
		StringBuilder strb = new StringBuilder();
			
		strb.append(this.bases.get(0).toString());
		
		if (!this.exponents.get(0).equals(PolyConstant.ONE)) {
			
			String str = this.exponents.get(0).toString();
			
			if (str.length() > 1) {
				strb.append("^(").append(str).append(")");
			} else {
				strb.append("^").append(str);
			}
			
		}
		
		for (int i = 1; i < bases.size(); i++) {
			
			strb.append("(").append(this.bases.get(i).toString());
			
			if (!this.exponents.get(i).equals(PolyConstant.ONE)) {
				
				String str = this.exponents.get(i).toString();
				
				if (str.length() > 1) {
					strb.append("^(").append(str).append(")");
				} else {
					strb.append("^").append(str);
				}
				
			}
			
			strb.append(")");
			
		}
		
		return strb.toString();
		
	}
	
}
