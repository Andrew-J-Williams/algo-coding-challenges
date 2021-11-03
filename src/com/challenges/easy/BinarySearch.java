package com.challenges.easy;

/*
 * 
	Binary Search
	
	Write a function that takes in a sorted array of integers as well as a target integer. The function should use the Binary Search algorithm to determine if the
	target integer is contained in the array and should return its index if it is, otherwise -1.
	
	Binary search involves breaking down our set of values continuously in half until we find the value we are searching for. Take the example of a college professor
	searching through a stack of tests, all arranged in alphabetical order by first name. If the name we are looking for is "Jenny", we know if we open the stack to
	the middle all tests to the right can be eliminated. We continue the process until finding the paper.
	
	Sample Input:
	array = [ 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 ]
	target = 33
	
	Sample Output:
	3
 * 
 */


public class BinarySearch {

	public static int binarySearch(int[] array, int target) {
		
		return binaryCheck(array, target, 0, array.length - 1);
	}
	
	public static int binaryCheck(int[] array, int target, int left, int right) {
		
		if(left > right) {
			return -1;
		}
		
		int m = (left + right) / 2;
		int match = array[m];
		
		if(target == match) {
			return m;
		} else if(target < match) {
			return binaryCheck(array, target, left, m - 1);
		} else {
			return binaryCheck(array, target, m + 1, right);
		}
		
		
	}

	public static void main(String[] args) {
		int[] array1 = { 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 };
		int target1 = 33;

		System.out.println(binarySearch(array1, target1));
	}

}
