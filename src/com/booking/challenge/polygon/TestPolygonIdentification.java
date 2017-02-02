package com.booking.challenge.polygon;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestPolygonIdentification {
	@Test
	public void testNumberOfPolygonTypes_A() {
		String [] lines = {
				"36 30 36 30", 
				"15 15 15 15", 
				"46 96 90 100" , 
				"86 86 86 86", 
				"100 200 100 200", 
				"-100 200 -100 200"};
		
		assertEquals("2 2 2", PolygonIdentification.getPolygonCount(lines));
	}
	
	@Test
	public void testNumberOfPolygonTypes_B() {
		String [] lines = {
				"10 10 10 10", 
				"-200 -100 -200 -100", 
				"10 20 10 20" , 
				"10 20 30 40", 
				"-150 200 -150 200"};
		
		assertEquals("1 2 2", PolygonIdentification.getPolygonCount(lines));
	}	
}
