package com.challenges.medium;

/*
 * 
	Kadane's Algorithm
	
	Write a function that takes in a non-empty array of integers and returns the maximum sum that can be obtained by summing up all of the integers in a non-empty subarray of the
	input array. A subarray must only contain adjacent numbers (numbers that are next to each other in the input array)
	
	Sample Input:
	array = [ 3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4 ]
	
	Sample Output:
	19 // 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1
 * 
 */

public class KadanesAlgorithm {

	public static int kadanesAlgorithm(int[] array) {
	
		// 1. We create a variable that will represent our subarray's max sum and set it equal to Integer.MIN_VALUE. We do this in order to account for input arrays that consist 
		// only of negative numbers. This ways we never run into a value that is less than the maximum sum's starting value.
		int maxSum = Integer.MIN_VALUE;
		
		// 2. We create another variable that will represent our current running sum and set it equal to 0.
		int current = 0;
		
		// 3. We create a 'for' loop that iterates over every element in the input array until 'i' exceeds that length of the array.
		for(int i = 0; i < array.length; i++) {
			
			// 4. We set current equal to the maximum value between our value at index 'i' or the sum of our current plus the value at index 'i'. Using our example data, starting
			// with the number 3 in 'array1', our function checks for current = Math.max(3, 0 + 3) = 3. Later on in the same array, when we reach the value of 1 that comes after
			// -9, we check current = Math.max(1, -1 + 1) = 1. This allows us to account for any large negatives that could impact the max sum.
			current = Math.max(array[i], current + array[i]);
			
			// 5. We set maxSum equal to the max value between maxSum and current. This is how we ultimately determine the maximum sum of the subarray: it captures the value of 
			// every updated current with each iteration. Take our example data at the point where 'i' equals -9: before our current updates to -1, the current value
			// was 8, and because it was greater than the previous maxSum value, it became maxSum. But when we advance to 1 after -9, the current sum becomes equal to 1 (as seen
			// above), and the maxSum will not be updated since this value is less than its value of 8.
			maxSum = Math.max(maxSum, current);
			
			
		}
		
		// 6. Finally, once all elements have been iterated over once, we return maxSum.
		return maxSum;
	}

	public static void main(String[] args) {
		int [] array1 = { 3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4 };
		int [] array2 = { -1, -2, -3, -4, -5, -6, -7, -8, -9, -10 };
		
		System.out.println(kadanesAlgorithm(array1));
	}

}
