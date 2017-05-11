package com.jlinalg.math;

import java.util.concurrent.ThreadLocalRandom;

public class NumberUtils {
	
	public static int randomInt(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	
	public static int randomInt() {
		return randomInt(Integer.MIN_VALUE, Integer.MAX_VALUE - 1);
	}
	
	public static double randomDouble(double min, double max) {
		return ThreadLocalRandom.current().nextDouble(min, max);
	}
	
	public static double randomDouble() {
		return randomDouble(Double.MIN_VALUE, Double.MAX_VALUE);
	}
	
}
