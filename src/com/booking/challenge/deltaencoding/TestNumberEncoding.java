package com.booking.challenge.deltaencoding;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestNumberEncoding {
	@Test
	public void testEncode() {
		int [] numbers = {25626, 25757, 24367, 24267, 16, 100, 2, 7277};
		assertEquals("25626 -128 131 -128 -1390 -100 -128 -24251 84 -98 -128 7275", NumberEncoding.encode(numbers));
	}
}
