package com.challenges.easy;

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
		// Write your code here.
		return -1;
	}

	public static void main(String[] args) {
		int[] coins1 = { 5, 7, 1, 1, 2, 3, 22 };
		int[] coins2 = { 1, 1, 1, 1, 1};
		
		System.out.println(nonConstructibleChange(coins1));
		System.out.println(nonConstructibleChange(coins2));

	}

}
