package com.booking.challenge.hotelreview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class HotelSortForGuestReview {
	
	/**
	 * 
	 * @param words space-separated set of words which you want to find mentions in the hotel reviews
	 * @param reviews 2D array which contains hotelIds and guest reviews belong to each hotel. First column represents hotelIds and second column represents respective review
	 * @return a list of hotelIds sorted, in descending order, by how many mentions they have of the words specified in the reviews
	 */
	public static String hotels(String words, String[][] reviews) {
		Map<Integer, Integer> hotelReviewCount = new HashMap<>();
		for (int x = 0; x < reviews.length; x++) {
			int hotelId = Integer.valueOf(reviews[x][0]);		
			int count = wordCountOnReview(words, reviews[x][1]);
			if (hotelReviewCount.containsKey(hotelId)){
				count += hotelReviewCount.get(hotelId);
			}
			hotelReviewCount.put(hotelId, count);
		}
		
		return getSortedHotelId(hotelReviewCount);
	}
	
	/**
	 * Sort the map and get hotelIds in descending order, by how many mentions they have of the words specified in the reviews
	 * @param hotelReviewCount total word count against each hotelId
	 * @return space-separated hotelIds
	 */
	private static String getSortedHotelId(Map<Integer, Integer> hotelReviewCount) {
		// Create a LinkedHashMap to store stored key-value pairs
		Map<Integer, Integer> orderedHotelReview = new LinkedHashMap<>();
		StringBuffer result = new StringBuffer();
		
		// Sorting a map using lambda expressions
		hotelReviewCount.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).forEachOrdered(x -> orderedHotelReview.put(x.getKey(),  x.getValue()));
		
		// Concatenate sorted map keys
		orderedHotelReview.keySet().forEach(a -> result.append(a + " "));		
		return result.toString().trim();
	}
	
	/**
	 * Identify number of words in the provided review
	 * @param words space-separated set of words which you want to find mentions in the hotel reviews
	 * @param review a guest review
	 * @return number of words in the guest review
	 */
	private static int wordCountOnReview(String words, String review) {
		// Check words in the review against the words statement.
		Stream<String> str = Arrays.stream(review.split(" ")).filter(a -> {
			a = a.replace(",", "").replace(".", "");
			return words.matches(".*\\b"+a.trim().toLowerCase()+"\\b.*");
			});
		return (int) str.count();
	}
}
