package com.booking.challenge.hotelreview;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestHotelSortForGuestReview {
	@Test
	public void testHotels_A() {
		String words = "breakfast beach citycenter location metro view staff price";
		String [][] reviews = {
				{"1", "This hotel has a nice view of the citycenter. The location is perfect"},
				{"2", "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth."},
				{"1", "Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel."},
				{"1", "They said I couldn't take my dog and there were other guests with dogs! That is not fair."},
				{"2", "Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter."}};
		assertEquals("2 1", HotelSortForGuestReview.hotels(words, reviews));
	}
	
	@Test
	public void testHotels_B() {
		String words = "breakfast beach citycenter location metro view staff price";
		String [][] reviews = {
				{"1", "This hotel has a nice view of the citycenter. The location is perfect"},
				{"2", "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth."},
				{"1", "Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel."},
				{"1", "They said I couldn't take my dog and there were other guests with dogs! That is not fair."},
				{"2", "Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter."},
				{"0", "They breakfast I couldn't take breakfast dog location citycenter were citycenter location with dogs! That is not fair."},};
		assertEquals("2 0 1", HotelSortForGuestReview.hotels(words, reviews));
	}	
}
