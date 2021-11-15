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
		
		int[] coins = new int[n + 1];
		Arrays.fill(coins, Integer.MAX_VALUE);
		coins[0] = 0;
		
		int compare = 0;
		
		for(int denom : denoms) {
			
			for(int i = 0; i < n + 1; i++) {
				
				
				if(denom <= i) {
					
					if(coins[i - denom] == Integer.MAX_VALUE) {
						compare = coins[i - denom];
					} else {
						compare = coins[i - denom] + 1;
					}
					
					coins[i] = Math.min(coins[i], compare);
				}
				
				
			}
			
			System.out.println(Arrays.toString(coins));
			
		}
		
		return coins[n] != Integer.MAX_VALUE ? coins[n] : -1;
	  }

	public static void main(String[] args) {
		int n = 6;
		int[] denoms = {1, 2, 4};
		
		System.out.println(minNumberOfCoinsForChange(n, denoms));

	}

}
