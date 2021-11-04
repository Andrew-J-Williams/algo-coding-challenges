package com.challenges.medium;

import java.util.ArrayList;
import java.util.Arrays;
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
		
		// 1. We create an ArrayList that will hold all our triplet combinations.
		List<Integer[]> triplets = new ArrayList<>();
		
		// 2. We sort the input array in ascending order, least to greatest values.
		Arrays.sort(array);	
		
		// 3. We create a 'for' loop to iterate over all the values in the array. It runs until the length minus 2 because we will have a pointer equal to the final value.
		for(int i = 0; i < array.length - 2; i++) {
			
			// 4. We create variables to represent the left and right ends of the array, with the left end being i + 1.
			int l = i + 1;
			int r = array.length - 1;
			
			// 5. We create a 'while' loop that runs until the left pointer is greater than the right pointer.
			while(l < r) {
				
				// 6. We create a variable equal to the sum of all the values i, l, and r are pointing to.
				int sum = array[i] + array[l] + array[r];
				
				// 7. We use an 'if' conditional to check if the sum is equal to our target sum. If it is...
				if(sum == targetSum) {
					
					// ...we create an Integer array and add all 3 values to it...
					Integer[] triplet = {array[i], array[l], array[r]};
					
					// ...we add that array to our ArrayList...
					triplets.add(triplet);
					
					// ...and we increment our l pointer by 1 while decreasing our r pointer by 1.
					l++;
					r--;
				
				// 8. If the sum is less than the target sum...
				} else if (sum < targetSum) {
					
					// ...we increment l by 1.
					l++;
					
				// 9. If the sum is greater than the target sum...	
				} else if(sum > targetSum) {
					
					// ...we decrement r by 1.
					r--;
				}
				
			}
		}
		
		// 10. Once we have looped through all values in the array, we return our ArrayList with the triplets that are all in numeric order.
		return triplets;
	}

	public static void main(String[] args) {
		int[] array1 = { 12, 3, 1, 2, -6, 5, -8, 6 };
		int target1 = 0;
		
		System.out.println(threeNumberSum(array1, target1));

	}

}
