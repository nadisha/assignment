package com.booking.challenge.sumarray;

import java.util.HashMap;
import java.util.Map;

public class PairOfNumbers {
	/**
	 * Identify whether there exists a pair of numbers in an array such that their sum is equal to given number.
	 * @param sum one integer which is the sum we are going to find
	 * @param numbers array of numbers
	 * @return 1 if there exists a pair of numbers in the array. If a pair does not exist 0
	 */
	public static int isPairExist(int sum, int [] numbers) {
		Map<Integer, Integer> mapValues = new HashMap<>();
		
		for (int num : numbers) {
			if (mapValues.containsKey(num)) {
				return 1;
			} else {
				mapValues.put((sum - num), num);
			}
		}
		return 0;
	}
}
