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
	
	public static double fixRoundingError(double d) { //NOTE: Untested for high levels of precision
		return (double) Math.round(d * 100000) / 100000;
	}
	
	public static boolean isInt(double d) {
		return d == (int) d;
	}
	
}
