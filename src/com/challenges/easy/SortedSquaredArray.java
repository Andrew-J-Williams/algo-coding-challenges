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
	    // Write your code here.
	    return new int[] {};
	}

	public static void main(String[] args) {
		int[] array1 = {1, 2, 3, 5, 6, 8, 9};
		int[] array2 = {-10, -5, 0, 5, 10};
		
		System.out.println(Arrays.toString(sortedSquaredArray(array1)));
		System.out.println(Arrays.toString(sortedSquaredArray(array2)));
	}

}
