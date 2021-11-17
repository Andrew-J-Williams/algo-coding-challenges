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
		int maxSum = 0;
		int current = 0;
		
		if(array.length == 1){
			return array[0];
		}
		
		for(int i = 0; i < array.length; i++) {
			
			if(current + array[i] < 0) {
				current = 0;
				continue;
			}
			
			current += array[i];
			
			if(maxSum < current) {
				maxSum = current;
			}
			
		}
		
		if(maxSum == 0){
			return -1;
		} else {
			return maxSum;
		}
	}

	public static void main(String[] args) {
		int [] array1 = { 3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4 };
		
		System.out.println(kadanesAlgorithm(array1));
	}

}
