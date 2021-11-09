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
		
		
		
		int[][] sortedIntervals = intervals.clone();
		Arrays.sort(sortedIntervals, (a, b) -> Integer.compare(a[0], b[0]));
		
		List<int[]> mergedIntervals = new ArrayList<>();
		
		int[] currentInterval = sortedIntervals[0];
		
		mergedIntervals.add(currentInterval);
		
		for(int[] nextInterval : sortedIntervals) {
			
			int currentIntEnd = currentInterval[1];
			int nextIntStart = nextInterval[0];
			int nextIntEnd = nextInterval[1];
			
			if(currentIntEnd >= nextIntStart) {
				currentInterval[1] = Math.max(currentIntEnd, nextIntEnd);
			} else {
				currentInterval = nextInterval;
				mergedIntervals.add(currentInterval);
			}
			
		}
		
		return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
	}
	

	public static void main(String[] args) {
		int[][] array1 = {{1, 2}, {3, 5}, {4, 7}, {6, 8}, {9, 10}};
		int[][] array2 = { {20, 21}, {22, 23}, {0, 1}, {3, 4}, {23, 24}, {25, 27}, {5, 6}, {7, 19}};

		System.out.println(Arrays.toString(mergeOverlappingIntervals(array2)));
	}

}
