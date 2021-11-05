package com.challenges.medium;

/*
 * 
	Monotonic Array
	
	Write a function that takes in an array of integers and returns a boolean representing whether the array is monotonic.
	
	An array is said to be monotonic if its elements, from left to right, are entirely non-increasing or entirely non-decreasing.
	
	Non-increasing elements aren't necessarily exclusively decreasing; they simply don't increase. Similarly, non-decreasing elements aren't necessarily exclusively increasing;
	they simply don't decrease.
	
	Note that empty arrays and arrays of one element are monotonic.
	
	Sample Input:
	array = [ -1, -5, -10, -1100, -1101, -1102, -9001 ]
	
	Sample Output:
	true
 * 
 */

public class MonotonicArray {

	public static boolean isMonotonic(int[] array) {

		// 1. We create 2 boolean variables, one representing if the values in the array are non-increasing and one representing if they are non-decreasing. We set both equal to
		// true since we have not determined what our array will be yet.
		boolean isNonIncreasing = true;
		boolean isNonDecreasing = true;
		
		// 2. We create a for loop that starts at the 2nd element in the array and iterates over each until the end of the array. We start at the 2nd element because we are going
		// to continuously be comparing the current element to the element left of it in an attempt to see if the values are increasing or decreasing. 
		for(int i = 1; i < array.length; i++) {
			
			// 3. We check if our current value is less than the value behind it. If it is, we know that the array should be classified as non-increasing. As a result...
			if(array[i] < array[i - 1]) {
				
				// ...we set our non-decreasing variable equal to false, leaving our non-increasing as true.
				isNonDecreasing = false;
			}
			
			// 4. If the current value is greater than the previous, we know the array should be non-decreasing in nature. As a result...
			if(array[i] > array[i - 1]) {
				
				// ...we set non-increasing to false, since each new value should be greater than or equal to the previous value.
				isNonIncreasing = false;
			}
			
			// NOTE: This logic implies that in order for the array to remain monotonic, isNonIncreasing and isNonDecreasing must either both be true or one of the two is true in
			// order for the method to return true. If it is increasing at one point but decreasing at another, the array cannot be monotonic. In order to return this logic...
			
		}
		
		// 5. We return an 'or' expression, which only returns false we both variables equal false. Any other combination will return true.
		return isNonIncreasing || isNonDecreasing;
	}

	public static void main(String[] args) {
		int[] array1 = { -1, -5, -10, -1100, -1101, -1102, -9001 };
		int[] array2 = { 1, 2, 0 };
		
		System.out.println(isMonotonic(array1));

	}

}
