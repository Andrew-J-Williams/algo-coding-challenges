package com.challenges.medium;

import java.util.Arrays;

/*
 * 
	Number Of Ways To Make Change
	
	Given an array of distinct positive integers representing coin denominations and a single non-negative integer n representing the target amount of money, write a function
	that returns the number of ways to make change for that target amount using the given coin denominations.
	
	Note that an unlimited amount of coins is at your disposal.
	
	Sample Input:
	n = 6
	denoms = [ 1, 5 ]
	
	Sample Output:
	2 // 1x1 + 1x5 and 6x1
 * 
 */

public class NumberOfWaysToMakeChange {
	
	public static int numberOfWaysToMakeChange(int n, int[] denoms) {

		// 1. We create an array whose length is equal to n + 1. We do this so that we can capture all the values from 0 through n. In the case of our example data, our 'ways'
		// array's length is from 0 to 6 since n = 6. At each index, we will store the minimum amount of ways to make change.
		int[] ways = new int[n + 1];
		
		// 2. We set the value at the first index equal to one while every other index has a value of 0. We do this because there is 1 way for making change for $0 and that is 
		// not using any money.
		ways[0] = 1;
		
		// 3. We create 2 'for' loops: one that iterates over each value in our denoms array and another that for each denoms value iterates over our ways array until i is greater
		// than n + 1. 
		for(int denom : denoms) {
			for(int i = 1; i < n + 1; i++) {
				
				// 4. For each value of 'i', we check and see if our current denoms value is less than or equal to 'i', and if it is... 
				if(denom <= i) {
					
					// ...we add the value at index 'i' minus denom to the value at index 'i'.
					ways[i] += ways[i - denom];
					
				// Using our example data:
					
				/*
				 * 
				 	1 <= 0 = false (skip)
				 	1 <= 1 true
				 	ways[1] (0 **value at index 1**) = ways[1] (0) + ways[1-1=0] (1) => ways[1] = 1
				 	1 <= 2 true
				 	ways[2] = ways[2] + ways[2-1] => ways[2] = 1
				 	1 <= 3 true etc...
				 	
				 	Essentially, we are taking the previous value at index 'i' - 1 and adding it to our current value at index 'i'. As we traverse across the 'ways' array, as long
				 	as the value at denom is less than or equal to the index value, it will inherit the previous value. So given our example, the first iteration over 'way's using
				 	denom = 1 would produce the following array: [ 1, 1, 1, 1, 1, 1, 1 ].
				 	
				 	When denom = 5, the array would look like this: [ 1, 1, 1, 1, 1, 2, 2 ]. This happens because for every value of 'i' less than 5, we simply skip the value update
				 	logic. But when 5 <= 5, then we do engage in the logic, and for every value onward until the end of the array, ways[5] = ways[5] (1) + ways[5-1] (1) = 2. 
				 	
				 	Since our denoms array is short, we've already cycled through all values, ending the loops.
				 * 	
				 */
				}
			}
			
		}
		
		System.out.println(Arrays.toString(ways));
		
		// 5. Finally, we return the value at ways[n]. We do this because after cycling through all the values in denom, the highest number of ways will always be contained by the
		// final index value given the increasing nature of the double 'for' loop technique.
		return ways[n];	
	  }

	public static void main(String[] args) {
		int n = 6;
		int[] denoms = { 1, 5 };
		
		System.out.println(numberOfWaysToMakeChange(n, denoms));

	}

}
