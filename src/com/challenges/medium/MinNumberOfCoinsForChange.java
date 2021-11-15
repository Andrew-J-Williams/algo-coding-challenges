package com.challenges.medium;

import java.util.*;

/*
 * 
	Min Number Of Coins For Change
	
	Given an array of positive integers representing coin denominations and a single non-negative integer 'n' representing a target amount of money, write a function that returns
	the smallest number of coins needed to make change for (to sum up to) that target amount using the given coin denominations.
	
	Note that you have access to an unlimited amount of coins. In other words, if the denominations are [ 1, 5, 10], you have access to an unlimited amount of 1s, 5s, and 10s.
	
	If it's impossible to make change for the target amount, return -1.
	
	Sample Input:
	n = 7
	denoms = [ 1, 5, 10 ]
	
	Sample Output:
	3 // 2x1 + 1x5
	
 * 
 */

public class MinNumberOfCoinsForChange {
	
	public static int minNumberOfCoinsForChange(int n, int[] denoms) {
		
		// 1. We create an integer array whose length is n + 1, in order for us to represent every coin value between 0 and n.
		int[] coins = new int[n + 1];
		
		// 2. We used the 'Arrays.fill' method to specify a value to each element of the array. In this case, we are setting every element equal to the maximum value allowed by the
		// Integer data type.
		Arrays.fill(coins, Integer.MAX_VALUE);
		
		// 3. We set the first element of the array equal to 0 since we do not need any coins to equal a value of 0.
		coins[0] = 0;
		
		// 4. We create an integer variable and set it equal to 0. This variable will be used for comparison purposes later in the function.
		int compare = 0;
		
		// 5. We create a double 'for' loop where the first loop iterates over every integer in the denoms array while the second loop (for every denom) will loop over our coins
		// array until 'i' exceeds n + 1.
		
		System.out.println(Arrays.toString(coins));
		for(int denom : denoms) {
			
			for(int i = 0; i < n + 1; i++) {
				
				// 6. We check and see if the value of denom is less than or equal to the index 'i', which represents of coin of 'i' value. If it's not, our loop simply skips over
				// it. But if it is, then we know that at least 1 denom can be used to add up to the value of 'i'. In the case of our sample data, when 1 <= 1, it returns true since
				// a coin of $1 value can equal or add up to $1. As a result...
				if(denom <= i) {
					
					// 7. We check and see if the value at the index of the difference between i and denoms is equal to Integer.MAX_VALUE, and if it is...
					if(coins[i - denom] == Integer.MAX_VALUE) {
						
						// ...we set our 'compare' variable equal to the value at index i minus denom. In the case of our example data, coins[1 - 1] = coins[0] = 0. Since 0 is less
						// than Integer.MAX_VALUE by a long shot, we would skip this 'if' statement and advance to the 'else' below...
						compare = coins[i - denom];
						
					// 8. Otherwise...	
					} else {
						
						// ...we set our compare equal to the value at index i minus denom PLUS 1. We add 1 on to represent the fact that denom is 1 instance of a coin added to
						// however many coins are represented at the index we computed. Again in our example data, since coins[0] = 0, we would do the following:
						// compare = coins[1 - 1] + 1 => coins[0] + 1 => 0 + 1 = 1. If i = 2, then the process would unfold like this: 1 <= 2 -> coins[2 - 1] =>
						// coins[1] = 0 == Integer.MAX_VALUE (FALSE) -> compare = coins[2 - 1] + 1 => coins[1] + 1 => 1 + 1 = 2.
						compare = coins[i - denom] + 1;
					}
					
					// 9. Once we've set a value for 'compare', we compare it to the value currently at coins[i] and set coins[i] equal to the minimum value between the two. Since
					// the original value of coins[i] is equal to Integer.MAX_VALUE, our 'compare' variable (from the example currently being 1) will always be less than it, 
					// so coins[1] = 1.
					coins[i] = Math.min(coins[i], compare);
				}
				
				
			}
			
			System.out.println(Arrays.toString(coins));
			
		}
		
		// 10. After both our 'for' loops finish executing, we return a conditional: if the value at coins[n] is not equal to Integer's max value, then return the value at coins[n].
		// Otherwise, return -1. We would return -1 to indicate that the coins we had in denoms can not add up to the target 'n'. We know this because if the coins do not add up 
		// the last value of the array will still be equal to the MAX_VALUE.
		return coins[n] != Integer.MAX_VALUE ? coins[n] : -1;
	  }

	public static void main(String[] args) {
		int n = 7;
		int[] denoms = {2, 4};
		
		System.out.println(minNumberOfCoinsForChange(n, denoms));

	}

}
