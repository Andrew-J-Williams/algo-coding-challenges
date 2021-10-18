package com.challenges.easy;

import java.util.Arrays;

/*
 * 
	Sorted Square Array
	
	Write a function that takes in a non-empty array of integers that are sorted in ascending order and returns a new array of the same length
	with the squares of the original integers also sorted in ascending order.
	
	Sample Input:
	array = [1, 2, 3, 5, 6, 8, 9]
	
	Sample Output:
	[1, 4, 9, 25, 36, 64, 81]
 * 
 */

public class SortedSquaredArray {
	
	public static int[] sortedSquaredArray(int[] array) {
		
		// 1. We define a new array of integers equal to the length of the array being passed in.
		int[] squared = new int[array.length];
		
		// 2. We create a 'for' loop that will iterate over each element in the array passed in.
		for(int i = 0; i < array.length; i++) {
			
			// 3. We create a variable equal to the value at index 'i' times itself, squaring it.
			int square = array[i] * array[i];
			
			// 4. We then take the same index value in the array we created and set it equal to the squared value.
			squared[i] = square;
			
		}
		
		// 5. After the loop completes and all squared values have been added, we sort the array using 'Arrays.sort'
		Arrays.sort(squared);
		
		// 6. Finally, we return the new array, containing squared values in ascending order.
	    return squared;
	}

	public static void main(String[] args) {
		int[] array1 = {1, 2, 3, 5, 6, 8, 9};
		int[] array2 = {-10, -5, 0, 5, 10};
		
		System.out.println(Arrays.toString(sortedSquaredArray(array1)));
		System.out.println(Arrays.toString(sortedSquaredArray(array2)));
	}

}
