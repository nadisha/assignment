package com.booking.challenge.deltaencoding;

import java.util.LinkedList;

public class NumberEncoding {
	private static final int ESCAPE_TOKEN = -128;
	
	/**
	 * @param numbers list of integer number before the encoding
	 * @return encoded string
	 */
	public static String encode(int [] numbers){
		// To store ordered list of encoded numbers 
		LinkedList<Integer> numberList = new LinkedList<>();
		
		// The first number is not encoded
		numberList.add(numbers[0]);
		for (int i = 1; i < numbers.length; i++) {
			int diff = numbers[i] - numbers[i-1];
			if (diff < -127 || diff > 127) {
				numberList.add(ESCAPE_TOKEN);				
			} 
			numberList.add(diff);
		}
		
		return getEncodedResult(numberList);
	}
	
	/**
	 * @param numberList ordered list of encorded numbers
	 * @return space separated encoded string
	 */
	private static String getEncodedResult(LinkedList<Integer> numberList) {
		StringBuffer result = new StringBuffer();
		numberList.stream().forEach(a -> result.append(a + " "));
		return result.toString().trim();		
	}
}
