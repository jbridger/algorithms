package com.bdfun.sorting;

/**
 * Class that implements quick sort.
 */
public class QuickSort implements Sorter {

	/**
	 * Partitions the input.
	 * 
	 * @param input Data to sort.
	 * @param low Low index.
	 * @param high High index.
	 * 
	 * @return pivot Index of pivot
	 */
	private int partition(int[] input, int low, int high)
	{
		// Determine pivot. We just pick the middle element.
		int pivot = (int) Math.floor((low + high)/ 2);
		
		// Copy value of pivot
		int pivotValue = input[pivot];
		
		// Move pivot to end
		swap(input, high, pivot);

		int firstHigh = low;
		for (int i = low; i < high; i++)
		{
			if (input[i] < pivotValue)
			{
				swap(input, firstHigh, i);
				firstHigh++;
			}
		}
		
		// Put pivot in correct place
		swap(input, firstHigh, high);
		
		return firstHigh;
	}
	
	/**
	 * Swaps specified elements in array.
	 * 
	 * @param input Input data.
	 * @param firstIndex Index of first element to swap.
	 * @param secondIndex Index of second element to swap.
	 */
	private void swap(int[] input, int firstIndex, int secondIndex)
	{
		int buff = input[firstIndex];
		input[firstIndex] = input[secondIndex];
		input[secondIndex] = buff;
	}
	
	/**
	 * Applies QuickSort to the input.
	 * 
	 * @param input Data to sort.
	 * @param low Low index.
	 * @param high High index.
	 */
	private void quickSort(int[] input, int low, int high)
	{
		if ((high-low) > 0)
		{
			// Partition input
			int pivot = partition(input, low, high);
			
			// Apply quicksort to each half
			quickSort(input, low, pivot - 1);
			quickSort(input, pivot + 1, high);
		}
	}
	
	@Override
	public int[] sort(int[] input) 
	{
		quickSort(input, 0, input.length - 1);
		return input;
	}

	@Override
	public String getName() 
	{
		return "Quick Sort";
	}
}