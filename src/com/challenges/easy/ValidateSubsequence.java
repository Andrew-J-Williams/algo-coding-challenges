package com.challenges.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 	Validate Subsequence
 	
 	Given two non-empty array of integers, write a function that determines whether the second array is a subsequence of the first one.
 	
 	A subsequence of an array is a set of numbers that aren't necessarily adjacent in the array but that are in the same order as they appear in the array.
 	For instance, the numbers [1, 3, 4] form a subsequence of the array [1, 2, 3, 4], and so do the numbers [2, 4].
 	Not that a single number in an array and the array itself are both valid subsequences of the array.
 	
 	Sample Input:
 	array = [5, 1, 22, 25, 6, -1, 8, 10]
 	sequence = [1, 6, -1, 10]
 	
 	Sample Output:
 	true 
 * 
 */

public class ValidateSubsequence {

	public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
		
		// 1. We first use a 'for' loop to iterate over the elements in the main List, where 'x' represents an integer from the list.
		for(Integer x : array) {
			
			// 2. We check if this value is equal to the first value of the subsequence. 
			if(x == sequence.get(0)) {
				
				// 3. If it is, we remove the first element, which automatically shifts subsequent elements (if they exist) to the left and decreases their indexes by 1.
				sequence.remove(0);
			} else {
				
				// 4. If the values are not equal, we simply continue on to the next element in the 'array' list.
				continue;
			}
			
			// 5. A final check in the loop sees if there are any elements left in the subsequence. If all have been removed since they exist in the 'array' list...
			if(sequence.size() == 0) {
				
				// ...we return true, indicating the array contains the entire subsequence, breaking the loop.
				return true;
			}
			
		}
		
		// 6. If we make it through the entire array without the sequence's size equaling 0, then we know not all elements were found in the original. Thus we return 'false'.
		return false;
	}

	public static void main(String[] args) {
		
		Integer[] data1 = { 5, 1, 22, 25, 6, -1, 8, 10 };
		Integer[] sub1 = { 1, 6, -1, 10 };
		
		Integer[] data2 = { 5, 1, 22, 25, 6, -1, 8, 10 };
		Integer[] sub2 = { 25 };
		
		ArrayList <Integer> array1 = new ArrayList(Arrays.asList(data1));
		ArrayList <Integer> sequence1 = new ArrayList(Arrays.asList(sub1));
		
		ArrayList <Integer> array2 = new ArrayList(Arrays.asList(data2));
		ArrayList <Integer> sequence2 = new ArrayList(Arrays.asList(sub2));
		
		System.out.println(isValidSubsequence(array1, sequence1));
		System.out.println(isValidSubsequence(array2, sequence2));

	}

}
