package com.booking.challenge.sumarray;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestPairOfNumbers {
	@Test
	public void testIsPairExist_A() {
	    int [] numbers = {66,10,18,11,21,28,31,38,40,55,60,62};
	    int sum = 66;
	    assertEquals(1, PairOfNumbers.isPairExist(sum, numbers));
	}
	
	@Test
	public void testIsPairExist_B() {
	    int [] numbers = {66,10,18,11,21,28,31,38,40,55,60,62};
	    int sum = 40;
	    assertEquals(0, PairOfNumbers.isPairExist(sum, numbers));
	}	
}
