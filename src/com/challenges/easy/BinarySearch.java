package com.challenges.easy;

/*
 * 
	Binary Search
	
	Write a function that takes in a sorted array of integers as well as a target integer. The function should use the Binary Search algorithm to determine if the
	target integer is contained in the array and should return its index if it is, otherwise -1.
	
	Binary search 
	
	Sample Input:
	array = [ 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 ]
	target = 33
	
	Sample Output:
	3
 * 
 */


public class BinarySearch {

	public static int binarySearch(int[] array, int target) {
		// Write your code here.
		
		int left = 0;
		int right = array.length - 1;
		
		return -1;
	}

	public static void main(String[] args) {
		int[] array1 = { 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 };
		int target1 = 33;

		System.out.println(binarySearch(array1, target1));
	}

}
