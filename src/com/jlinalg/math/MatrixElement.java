package com.jlinalg.math;

public interface MatrixElement<T extends MatrixElement<T>> {
	
	public T add(T e);
	
	public T multiply(T e);
	
	public T multiply(double d);

}
