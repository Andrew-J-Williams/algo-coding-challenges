package com.challenges.easy;

import java.util.Arrays;

/*
 * 
	Two Number Sum

	Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum.
	If any two numbers in the input array sum up to the target sum, the function should return them in an array, in any order.
	If no two numbers sum up to the target sum, the function should return an empty array.

	Note that the target sum has to be obtained by summing two different integers in the array; you can't add a single integer to itself in order to obtain the target sum.

	You can assume that there will be at most one pair of numbers summing up to the target sum.


	Sample Input:
	array = [3, 5, -4, 8, 11, 1, -1, 6]
	targetSum = 10


	Sample Output:
	[-1, 11]

 * 
 */

public class TwoNumberSum {

	public static int[] twoNumberSum(int[] array, int targetSum) {

		int[] newarray = {};

		return newarray;
	}

	public static void main(String[] args) {
		int[] array1 = { 3, 5, -4, 8, 11, 1, -1, 6 };
		int targetSum1 = 10;

		System.out.println(Arrays.asList(twoNumberSum(array1, targetSum1)));

	}

}
