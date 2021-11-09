package com.challenges.medium;

import java.util.*;

/*
 * 
	Merge Overlapping Intervals
	
	Write a function that takes in a non-empty array of arbitrary intervals, merges any overlapping intervals, and returns the new intervals in no particular order.
	
	Each interval 'interval' is an array of two integers, with 'interval[0]' as the start of the interval and interval[1] as the end of the interval.
	
	Note that back-to-back intervals aren't considered to be overlapping. For example, [1, 5] and [6, 7] aren't overlapping: however, [1, 6] and [6, 7] are indeed overlapping.
	
	Also note that the start of any particular interval will always be less than or equal to the end of that interval. 
	
	Sample Input:
	intervals = [[1, 2], [3, 5], [4, 7], [6, 8], [9, 10]]
	
	Sample Output:
	[[1, 2], [3, 8], [9, 10]]
	
 * 
 */

public class MergeOverlappingIntervals {

	public static int[][] mergeOverlappingIntervals(int[][] intervals) {
		
		
		// 1. We created a two dimensional array that is equal to a clone of the intervals array.
		int[][] sortedIntervals = intervals.clone();
		
		// 2. We sort the cloned array by checking the first values of each sub array. 
		Arrays.sort(sortedIntervals, (a, b) -> Integer.compare(a[0], b[0]));
		
		// 3. We create an ArrayList of integer arrays that will eventually hold our merged intervals.
		List<int[]> mergedIntervals = new ArrayList<>();
		
		// 4. We create an integer array equal to the first interval (array) from our sorted two dimensional array.
		int[] currentInterval = sortedIntervals[0];
		
		// 5. We add this first/current interval to our ArrayList.
		mergedIntervals.add(currentInterval);
		
		
		// 6. We create a 'for' loop that will iterate over each interval our sorted two dimensional array. 
		for(int[] nextInterval : sortedIntervals) {
			
			// 7. We create a variable to hold the end value of our current interval.
			int currentIntEnd = currentInterval[1];
			
			// 8. We create another variable to store the start value of our next interval.
			int nextIntStart = nextInterval[0];
			
			// 9. We create yet another variable to store the end value of our next interval.
			int nextIntEnd = nextInterval[1];
			
			// 10. We check if the current interval's end value is greater than or equal to the next interval's start value. If it is, we know we have an overlap and can begin the process
			// the process of merging... 
			if(currentIntEnd >= nextIntStart) {
				
				// ...so we set the end value of our current interval equal to the max value between the existing current interval's end and the next interval's end. Doing this merges the
				// results together since the 2 intervals overlap in value, create an interval that represents the new range.
				currentInterval[1] = Math.max(currentIntEnd, nextIntEnd);
			
			// 11. If the next interval's start value is greater than the current interval's end value, we can determine that there is no overlap, and since we have sorted our two dimensional
			// array by each interval's starting value, we know that we aren't missing out on any overlapping values.	
			} else {
				
				// 12. Since we know there is no overlap, we set out current interval equal to the next in order to compare it to the next interval in the array.
				currentInterval = nextInterval;
				
				// 13. We add this interval to our merged intervals ArrayList and then repeat the process over again.
				mergedIntervals.add(currentInterval);
			}
			
		}
		
		// 14. After we've iterated over our two dimensional array and added our merged intervals to the ArrayList, we return a new two dimensional array using '.toArray'. When doing this,
		// we use the ArrayList's size to set the length of our new two dimensional array.
		return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
	}
	

	public static void main(String[] args) {
		int[][] array1 = {{1, 2}, {3, 5}, {4, 7}, {6, 8}, {9, 10}};
		int[][] array2 = {{20, 21}, {22, 23}, {0, 1}, {3, 4}, {23, 24}, {25, 27}, {5, 6}, {7, 19}};

		int[][] results = mergeOverlappingIntervals(array2);
		
		for(int[] x : results) {
			System.out.println(Arrays.toString(x));
		}
	}

}
