package com.challenges.easy;

import java.util.Arrays;

/*
 * 
	Non-Constructible Change
	
	Given an array of positive integers representing the values of coins in your possession, write a function that returns the minimum amount of change (the minimum
	sum of money) that you CANNOT create. The given coins can have any positive integer value and aren't necessarily unique (i.e. you can have multiple coins of the same value).
	
	For example, if you are given 'coins = [1, 2, 5]', the minimum amount of change that you can't create is 4. If you are given no coins, the minimum amount of change you can't
	create is 1.
	
	Sample Input:
	coins = [5, 7, 1, 1, 2, 3, 22]
	
	Sample Output:
	20
 * 
 */

public class NonConstructibleChange {

	public static int nonConstructibleChange(int[] coins) {

		// 1. We sort the values in our coins array from smallest to greatest.
		Arrays.sort(coins);
		
		// 2. We create a variable that will represent our target value and set it equal to 0.
		int target = 0;
		
		// 3. Create a 'for' loop that will iterate over each value in the coins array.
		for(int value : coins) {
		
			// 4. If the current value of the coin is greater than the target value plus 1...
			if(value > target + 1) {
				
				// ... then we return the target value plus 1 since the coins in the array cannot add up to it.
				return target + 1;
			}
			
			// 5. If the current value is less than or equal to the target, we simply add that value to the target and continue to the next value in the array.
			target += value;
		}
		
		// 6. If we make it through all values without returning the target, we return the final target value plus 1.
		return target + 1;
	}

	public static void main(String[] args) {
		int[] coins1 = { 5, 7, 1, 1, 2, 3, 22 };
		int[] coins2 = { 1, 1, 1, 1, 1};
		
		System.out.println(nonConstructibleChange(coins1));
		System.out.println(nonConstructibleChange(coins2));

	}

}
