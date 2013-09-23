package com.bdfun.sorting;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class that sorts input using merge sort algorithm.
 */
public class MergeSort implements Sorter {

	/**
	 * Sorts an array using merge sort recursion.
	 * 
	 * @param input Data to be sorted.
	 * @param low Beginning index
	 * @param high End index
	 * 
	 * @return Sorted input.
	 */
	private void mergeSort(int[] input, int low, int high)
	{
		if (low < high)
		{
			// Work out middle index
			int middle = (int) Math.floor((low + high)/ 2);
			
			// Sub sort each half recursively
			mergeSort(input, low, middle);
			mergeSort(input, middle+1, high);
			
			// Merge halves
			merge(input, low, middle, high);
		}
	}
	
	/**
	 * Function for merging two sorted inputs.
	 * 
	 * @param input Data to be merged
	 * @param left Beginning index of left half
	 * @param middle Middle element between two halves
	 * @param right End index of the right half
	 * 
	 * @return Merged array in sorted order.
	 */
	private void merge(int[] input, int low, int middle, int high)
	{
		// Create copy of both halves separately as we need to overwrite the area in
		// the input array.
		Queue<Integer> left = new LinkedList<Integer>();
		Queue<Integer> right = new LinkedList<Integer>();
		
		for(int i = low; i <= middle; i++)
		{
			left.add(input[i]);
		}
		
		for(int i = middle + 1; i <= high; i++)
		{
			right.add(input[i]);
		}
		
		// Now merge the two halves together back into the input array
		int indexInInput = low;
		while(!(left.isEmpty() || right.isEmpty()))
		{
			if (left.peek() < right.peek())
			{
				input[indexInInput++] = left.remove();
			}
			else
			{
				input[indexInInput++] = right.remove();
			}
		}
		
		// Add any left over elements into input array
		while(!left.isEmpty())
		{
			input[indexInInput++] = left.remove();
		}
		
		while(!right.isEmpty())
		{
			input[indexInInput++] = right.remove();
		}
	}
	
	@Override
	public int[] sort(int[] input) 
	{
		mergeSort(input, 0, input.length - 1);
		
		return input;
	}

	@Override
	public String getName() 
	{
		return "Merge sort";
	}
}
