package com.jlinalg.math;

import java.util.ArrayList;

public class Expression implements PolyBehavior{
	
	private ArrayList<PolyTerm> terms = new ArrayList<PolyTerm>();
	
	public Expression(int i) {
		terms.add(new PolyTerm(new PolyConstant(i)));
	}
	
	public Expression add(int i) {
		terms.add(new PolyTerm(new PolyConstant(i)));
		return this;
	}
	
	public boolean isLikeTerm(PolyBehavior p) {
		return this.isEquivalent(p); //not exactly right -- doesn't take scalar multiples into account
	}
	
	public boolean isEquivalent(PolyBehavior p) {
		
		if (!p.getClass().equals(this.getClass())) {
			return false;
		}
		
		Expression e = (Expression) p;
		
		if (this.terms.size() != e.terms.size()) {
			return false;
		}
		
		for (int i = 0; i < this.terms.size(); i++) {
			if (!this.terms.get(i).isEquivalent(e.terms.get(i))) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public String toString() {
		
		StringBuilder strb = new StringBuilder();
		
		strb.append(terms.get(0).toString());
		
		for (PolyTerm pt : terms.subList(1, terms.size())) {
			strb.append(" + ").append(pt.toString());
		}
		
		return strb.toString();
		
	}

}
