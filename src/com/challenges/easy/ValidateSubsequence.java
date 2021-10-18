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
		
		for(Integer x : array) {
					
			if(x == sequence.get(0)) {
				sequence.remove(0);
			} else {
				continue;
			}
			
			if(sequence.size() == 0) {
				return true;
			}
			
		}
		
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
