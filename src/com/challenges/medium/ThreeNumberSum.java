package com.challenges.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * 
	Three Number Sum
	
	Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. The function should find all triplets in the array that sum up
	to the target sum and return a two-dimensional array of all these triplets. The numbers in each triplet should be ordered in ascending order, and the triplets themselves 
	should be ordered in ascending order with respect to the numbers they hold.
	
	If no three numbers sum up to the target sum, the function should return an empty array.
	
	Sample Input:
	array = [ 12, 3, 1, 2, -6, 5, -8, 6 ]
	targetSum = 0
	
	Sample Output:
	[[-8, 2, 6], [-8, 3, 5], [-6, 1, 5]]
 * 
 */

public class ThreeNumberSum {

	public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		
		List<Integer[]> triplets = new ArrayList<>();
		
		Arrays.sort(array);	
		
		System.out.println(Arrays.toString(array));
			
		for(int i = 0; i < array.length - 2; i++) {
			int l = i + 1;
			int r = array.length - 1;
			
			while(l < r) {
				
				int sum = array[i] + array[l] + array[r];
				
				if(sum == targetSum) {
					Integer[] triplet = {array[i], array[l], array[r]};
					triplets.add(triplet);
					l++;
					r--;
				} else if (sum < targetSum) {
					l++;
				} else if(sum > targetSum) {
					r--;
				}
				
			}
		}
		
		
		return triplets;
	}

	public static void main(String[] args) {
		int[] array1 = { 12, 3, 1, 2, -6, 5, -8, 6 };
		int target1 = 0;
		
		System.out.println(threeNumberSum(array1, target1));

	}

}
