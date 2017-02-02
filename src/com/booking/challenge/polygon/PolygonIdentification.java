package com.booking.challenge.polygon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolygonIdentification {
	enum Shape {
		SQUARE, RECTANGLE, OTHER
	}

	/**
	 * Identify whether four sides (given by four integers) can form a square, a rectangle, or neither.
	 * @param lines list of lines in an array. Each element contains four space-separated integers, 
	 * 		which represent the length of the sides of the polygon
	 * @return a single line which contains 3 space-separated integers; representing the number 
	 * 		of squares, number of rectangles, and number of other polygons with 4 sides.
	 */
	public static String getPolygonCount(String[] lines) {
		List<Shape> shapes = new ArrayList<>();
		for (String line : lines) {
			shapes.add(getShapeType(line));
		}
		long squareCount = shapes.stream().filter(type -> type == Shape.SQUARE).count();
		long rectangleCount = shapes.stream().filter(type -> type == Shape.RECTANGLE).count();
		long otherCount = shapes.stream().filter(type -> type == Shape.OTHER).count();
		return "" + squareCount + " " + rectangleCount + " " + otherCount;
	}

	/**
	 * Identify the shape based on the provided polygon lines
	 * @param sides string type four space-separated integer numbers
	 * @return shape either Square or Rectangle or neither
	 */
	private static Shape getShapeType(String sides) {
		int[] lines = convertLinesToInt(sides);

		if (isAllNotNegative(lines)) {
			return Shape.OTHER;
		} else if (isSquare(lines)) {
			return Shape.SQUARE;
		} else if (isRectangle(lines)) {
			return Shape.RECTANGLE;
		} else {
			return Shape.OTHER;
		}

	}

	/**
	 * Convert string type space-separated integer numbers to integer type
	 * @param sides string type four space-separated polygon sides
	 * @return integer array with polygon side lengths
	 */
	private static int[] convertLinesToInt(String sides) {
		int[] intCoordinates = Arrays.stream(sides.split(" ")).mapToInt(a -> {
			int value = Integer.valueOf(a.trim()).intValue();
			if (value < -2000 || value > 2000) {
				throw new RuntimeException("Incorrect side length : " + value);
			}
			return value;
		}).toArray();
		
		if (intCoordinates.length != 4) {
			throw new RuntimeException("Incorrect number of side lengths : " + intCoordinates.length);
		}
		return intCoordinates;
	}

	/**
	 * If all the sides of the polygon are either negative or positive numbers, then consider as a valid polygon.
	 * Otherwise, consider as a invalid polygon (if one of the four integers is a negative number) 
	 * @param line array of polygon side lengths
	 * @return TRUE - invalid polygon, FALSE - valid polygon
	 */
	private static boolean isAllNotNegative(int[] line) {
		// Count of negative numbers in the array
		long negativeCount = Arrays.stream(line).filter(a -> a <= 0).count();
		if (negativeCount == 4 || negativeCount == 0) {
			return Boolean.FALSE;
		} else {
			return Boolean.TRUE;
		}
	}

	/**
	 * If the length of opposite sides are equal, consider as a rectangle 
	 * @param lines array of polygon side lengths
	 * @return TRUE - polygon is a rectangle. FALSE - not a rectangle
	 */
	private static boolean isRectangle(int[] lines) {
		return (lines[0] == lines[2]) && (lines[1] == lines[3]);
	}

	/**
	 * If the length of four sides are equal, consider as a square 
	 * @param lines array of polygon side lengths
	 * @return TRUE - polygon is a square. FALSE - not a square
	 */
	private static boolean isSquare(int[] lines) {
		return (lines[0] == lines[1]) && (lines[1] == lines[2]) && (lines[2] == lines[3]);
	}
}
