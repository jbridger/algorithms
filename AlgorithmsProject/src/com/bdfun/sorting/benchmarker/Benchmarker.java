package com.bdfun.sorting.benchmarker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
	 * begin < end and begin > end are supported. i.e. ascending or descending
	 * sequence.
	 * 
	 * @param begin Beginning of sequence.
	 * @param end End of sequence.
	 * 
	 * @return Sequence of integers.
	 */
//	private static int[] getRange(int begin, int end) {
//
//		// Calculate the size of the sequence
//		int sizeRange = begin < end ? end - begin + 1 : begin - end + 1;
//
//		// Create output array
//		int[] range = new int[sizeRange];
//
//		// Create sequence in array
//		for (int i = 0; i < sizeRange; i++) {
//			range[i] = begin < end ? begin + i : begin - i;
//		}
//
//		return range;
//	}

	/**
	 * Gets random range of integers.
	 * 
	 * @param end End of range.
	 * 
	 * @return Random range of integers.
	 */
	private static int[] getRandomRange(int end) {
		// Create output array
		int[] range = new int[end];

		// Create random numbers in array
		Random random = new Random();
		for (int i = 0; i < end; i++) {
			range[i] = random.nextInt(end);
		}

		return range;
	}

	/**
	 * Benchmarks a list of sorting algorithms. Will rank the algorithms by the
	 * time it took to run.
	 * 
	 * @param sorters Sorting algorithms to run.
	 * @param data Data to sort.
	 * 
	 * @return List of results
	 */
	private static List<Result> benchmark(List<Sorter> sorters, int[] data) {
		// Create list for results
		List<Result> results = new ArrayList<Result>();

		// Test each sorter
		for (Sorter sorter : sorters) {
			// Get start time
			Date start = new Date();

			// Run sort
			sorter.sort(Arrays.copyOf(data, data.length));

			// Get end time
			Date end = new Date();

			// Store time taken
			results.add(new Result(end.getTime() - start.getTime(), sorter));
		}

		return results;
	}

	/**
	 * Display results in order of time taken to run.
	 * 
	 * @param results List of results.
	 */
	private static void displayResults(List<Result> results) {
		// Sort results by natural order
		Collections.sort(results);
		
		// Display the rank of the algorithms
		for (int i = 0; i < results.size(); i++) {
			Result result = results.get(i);

			// Convert time taken in milliseconds to human readable format
			long timeTaken = result.timeTaken;
			long hours = TimeUnit.MILLISECONDS.toHours(timeTaken);
			long minutes = TimeUnit.MILLISECONDS.toMinutes(timeTaken)
					- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
							.toHours(timeTaken));
			long seconds = TimeUnit.MILLISECONDS.toSeconds(timeTaken)
					- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
							.toMinutes(timeTaken));
			long millis = timeTaken
					- (TimeUnit.HOURS.toMillis(hours)
							+ TimeUnit.MINUTES.toMillis(minutes) + TimeUnit.SECONDS
								.toMillis(seconds));

			// Rank is loop index + 1 as we started from 0
			int rank = i + 1;

			// Display result
			System.out.println(String.format("%d. [%s] took %d:%d:%d:%d", rank,
					result.sorter.getName(), hours, minutes, seconds, millis));
		}
	}

	public static void main(String[] args) {
		// Get random data to sort
		int[] data = getRandomRange(50000);

		// Build list of sorters to benchmark
		List<Sorter> sorters = new ArrayList<Sorter>();
		sorters.add(new BubbleSort());
		sorters.add(new InsertionSort());
		sorters.add(new MergeSort());
		sorters.add(new QuickSort());

		// Run benchmark
		displayResults(benchmark(sorters, data));
	}

	/**
	 * Class to store a benchmark result with an algorithm
	 */
	private static class Result implements Comparable<Result> {
		long timeTaken;
		Sorter sorter;

		public Result(long timeTaken, Sorter sorter) {
			this.timeTaken = timeTaken;
			this.sorter = sorter;
		}

		@Override
		public int compareTo(Result o) {
			long otherTimeTaken = o.timeTaken;

			return (int) (timeTaken - otherTimeTaken);
		}
	}
}
