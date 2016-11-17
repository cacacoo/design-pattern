package com.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class SelfNumber {

	public void extractSelfNumber(long input) {
		TreeSet<Long> sortedSet = new TreeSet<>();
		long pivot = 1;
		for(long idx =1; idx <= input; idx++) {
			long result = dee(idx);
			sortedSet.add(result);
			if(sortedSet.last() > result && pivot < idx) {
				for(;pivot <= result; pivot++) {
					if(!sortedSet.contains(pivot) && pivot <= input) {
						System.out.println(pivot); //this is selfNumber!
					}else {
						sortedSet.remove(pivot);
					}
				}
			}
		}
	}

	private long dee(long generator) {
		if(generator < 10) {
			return generator * 2;
		}

		Map<Integer, Integer> cart = new HashMap<>();
		int degree = findDegree(generator);
		putCart(cart, degree, generator);

		long result = 0;
		for(int value : cart.values()) {
			result += value;
		}
		return result + generator;
	}

	private void putCart(Map<Integer, Integer> cart, int degree, long generator) {
		for(int idx=1; idx <= degree; idx ++) {
			double divider = Math.pow(10, idx);
			cart.put(idx, (int) ((generator % divider) / Math.pow(10, idx-1)));
			generator = generator - cart.get(idx);
		}
	}

	private int findDegree(long generator) {
		int degree = 0;
		while (generator > 0) {
			generator = generator / 10;
			degree++;
		}
		return degree;
	}
}
