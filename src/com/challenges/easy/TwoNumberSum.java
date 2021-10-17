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

		// 1. Define 2 variables: one for the 1st index of the array and one for the last index of the array.
		int p1 = 0;
		int p2 = array.length - 1;

		// 2. We sort the given array (we can do this before or after defining our index values).
		Arrays.sort(array);

		// 3. Create a while loop that runs until p1 is greater or equal to p2.
		while (p1 < p2) {
			
			// 4. Create a variable called "sum" equal to the sum of the array values at index p1 and p2. 
			int sum = array[p1] + array[p2];

			// 5. Create an if..else conditional that first checks if sum is equal to the given targetSum. If it is...
			if (sum == targetSum) {
				
				//...we return a new array comprised of the values at index p1 and p2. This will break our loop and the program will stop running.
				return new int[] { array[p1], array[p2] };
			
			// 6. If the values are not equal, we hit our first "else if" statement that checks if the sum is greater than the targetSum. If it is...	
			} else if (sum > targetSum) {
				
				//...we decrease the value of p2 by 1. This will move p2 closer to p1, and retrieve a value that is less than the previous one in the array. 
				p2--;
			
			// 7. If the previous condition is not met, we check and see if the sum is less than the target value. If it is...	
			} else if (sum < targetSum) {
				
				// ...we increase the value of p1 by 1, moving it closer to p2 and retrieving an increased value from the array.
				p1++;
				
			}
			
			// As long as the sum is not equal to the targetSum, the values of p1 and p2 will move closer to each other. If the loop is broken because no sum is equal...
		}

		// ...we return an empty array.
		return new int[0];
		
	}

	public static void main(String[] args) {
		
		int[] array1 = { 3, 5, -4, 8, 11, 1, -1, 6 };
		int targetSum1 = 10;

		int[] array2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 15 };
		int targetSum2 = 18;

		System.out.println("Solution 1: " + Arrays.toString(twoNumberSum(array1, targetSum1)));
		System.out.println("Solution 2: " + Arrays.toString(twoNumberSum(array2, targetSum2)));

	}

}
