package com.bdfun.sorting.benchmarker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.bdfun.sorting.BubbleSort;
import com.bdfun.sorting.InsertionSort;
import com.bdfun.sorting.MergeSort;
import com.bdfun.sorting.QuickSort;
import com.bdfun.sorting.Sorter;


/**
 * Class that benchmarks sorting algorithms.
 */
public class Benchmarker {
	/**
	 * Gets a sequence of integers.
	 * 
	 * begin < end and begin > end are supported. i.e. ascending or descending sequence.
	 * 
	 * @param begin Beginning of sequence.
	 * @param end End of sequence.
	 * 
	 * @return Sequence of integers.
	 */
	private static int[] getRange(int begin, int end) {
		
		// Calculate the size of the sequence
		int sizeRange = begin < end ? end-begin+1 : begin-end+1;
		
		// Create output array
		int[] range = new int[sizeRange];

		// Create sequence in array
		for (int i = 0; i < sizeRange; i++)
		{
			range[i] = begin < end ? begin + i : begin - i;
		}
		
		return range;
	}
	
	/**
	 * Gets random range of integers.
	 * 
	 * @param end End of range.
	 * @return Random range of integers.
	 */
	private static int[] getRandomRange(int end)
	{
		// Create output array
		int[] range = new int[end];

		// Create random numbers in array
		Random random = new Random();
		for (int i = 0; i < end; i++)
		{
			range[i] = random.nextInt(end);
		}

		return range;
	}

	/**
	 * Benchmarks a list of sorting algorithms.
	 * @param sorters Sorting algorithms to run.
	 * @param data Data to sort.
	 */
	private static void benchmark(List<Sorter> sorters, int[] data)
	{
		for(Sorter sorter : sorters)
		{
			// Get start time
			Date start = new Date();
			
			// Run sort
			sorter.sort(Arrays.copyOf(data, data.length));
			
			// Get end time
			Date end = new Date();
			
			// Output time taken
			long timeDiff = end.getTime() - start.getTime();

			long hours = TimeUnit.MILLISECONDS.toHours(timeDiff);
			long minutes = TimeUnit.MILLISECONDS.toMinutes(timeDiff) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeDiff));
			long seconds = TimeUnit.MILLISECONDS.toSeconds(timeDiff) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeDiff));
			long millis = timeDiff - (TimeUnit.HOURS.toMillis(hours) + TimeUnit.MINUTES.toMillis(minutes) + TimeUnit.SECONDS.toMillis(seconds));
			
			System.out.println(String.format("[%s] took %d:%d:%d:%d", sorter.getName(), hours, minutes, seconds, millis));
		}
	}
	
	public static void main(String[] args)
	{
		int[] data = getRandomRange(5000);
		
		// Build list of sorters to benchmark
		List<Sorter> sorters = new ArrayList<Sorter>();
		sorters.add(new BubbleSort());
		sorters.add(new InsertionSort());
		sorters.add(new MergeSort());
		sorters.add(new QuickSort());
		
		// Run benchmark
		benchmark(sorters, data);		
	}

}
