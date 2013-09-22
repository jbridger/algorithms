package com.bdfun.sorting;


/**
 * Class that performs the classic bubble sort.
 */
public class BubbleSort implements Sorter {
	
	public int[] sort(int[] input) {
		// For every element
		for (int i = 0; i < input.length; i++) {
			// Compare elements in pairs
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] > input[j]) {
					// Left > right, swap elements
					int right = input[j];
					input[j] = input[i];
					input[i] = right;
				}
			}
		}
		return input;
	}

	@Override
	public String getName() {
		return "Bubble Sort";
	}
}
