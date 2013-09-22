package com.bdfun.sorting;

/**
 * Class that performs insertion sort.
 * 
 * For each element we swap the element to the left until the next element
 * is larger than it, and the preceding element is smaller than it.
 */
public class InsertionSort implements Sorter {
	@Override
	public String getName() {
		return "Insertion Sort";
	}

	@Override
	public int[] sort(int[] input) {
		// For every element in input array
		for (int j = 1; j < input.length; j++) {
			// Get the current element
			int key = input[j];

			// Get index for preceding element
			int i = j - 1;

			// While elements are smaller than the key, shift them to the right
			while (i >= 0 && input[i] > key) {
				input[i + 1] = input[i];
				i--;
			}

			// Put the key in its natural place
			input[i + 1] = key;
		}

		return input;
	}
}
