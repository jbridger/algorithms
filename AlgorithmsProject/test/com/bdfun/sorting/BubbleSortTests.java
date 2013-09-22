package com.bdfun.sorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * Tests for the BubbleSort class
 */
public class BubbleSortTests {

	/**
	 * Tests sorting with best case data. i.e. Data is already sorted.
	 */
	@Test
	public void bestCaseSort()
	{
		int[] input = {1, 2, 3, 4, 5, 6};
		int[] expected = {1, 2, 3, 4, 5, 6};

		assertArrayEquals(expected, new BubbleSort().sort(input));
	}
	
	/**
	 * Tests sorting with worst case data. i.e. Data is reverse sorted.
	 */
	@Test
	public void worstCaseSort()
	{
		int[] input = {6, 5, 4, 3, 2, 1};
		int[] expected = {1, 2, 3, 4, 5, 6};

		assertArrayEquals(expected, new BubbleSort().sort(input));
	}
	
	/**
	 * Tests sorting with some duplicate elements adjacent to each other in the input.
	 */
	@Test
	public void duplicatesTogether()
	{
		int[] input = {6, 5, 3, 3, 1, 1};
		int[] expected = {1, 1, 3, 3, 5, 6};

		assertArrayEquals(expected, new BubbleSort().sort(input));
	}
	
	/**
	 * Tests sorting with only one element in the input.
	 */
	@Test
	public void oneElementSort()
	{
		int[] input = {1};
		int[] expected = {1};

		assertArrayEquals(expected, new BubbleSort().sort(input));
	}
	
	/**
	 * Tests empty input
	 */
	@Test
	public void emptyInput()
	{
		int[] input = {1};
		int[] expected = {1};

		assertArrayEquals(expected, new BubbleSort().sort(input));
	}
}
