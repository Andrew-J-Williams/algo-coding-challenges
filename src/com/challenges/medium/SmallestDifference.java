package com.challenges.medium;

import java.util.Arrays;

/*
 * 
	Smallest Difference
	
	Write a function that takes in two non-empty arrays of integers, finds the pair of numbers (one from each array) whose absolute difference is closest to zero, and returns an
	array containing these two numbers, with the number from the first array in the first position.
	
	Note that the absolute difference of two integers is the distance between them on the real number line. For example, the absolute difference of -5 and 5 is 10, and the absolute
	difference of -5 and -4 is 1.
	
	You can assume there will only be one pair of numbers with the smallest difference.
	
	Sample Input:
	arrayOne = [ -1, 5, 10, 20, 28, 3 ]
	arrayTwo = [ 26, 134, 135, 15, 17 ]
	
	Sample Output:
	[ 26, 28 ]
 * 
 */

public class SmallestDifference {

	public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {

		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		
		int i1 = 0;
		int i2 = 0;
		
		int smallest = Integer.MAX_VALUE;
		int current = Integer.MAX_VALUE;
		
		int[] smallestPair = new int[2];
		
		while(i1 < arrayOne.length && i2 < arrayTwo.length) {
			
			int first = arrayOne[i1];
			int second = arrayTwo[i2];
			
			if(first < second) {
				current = second - first;
				i1++;
			} else if(first > second) {
				current = first - second;
				i2++;
			}else {
				return new int[] {first, second};
			}
			
			if(smallest > current) {
				smallest = current;
				smallestPair = new int[] {first, second};
			}
			
		}
		
		return smallestPair;
	}


	public static void main(String[] args) {
		int[] arrayOne = { -1, 5, 10, 20, 28, 3 };
		int[] arrayTwo = { 26, 134, 135, 15, 17 };

		System.out.println(Arrays.toString(smallestDifference(arrayOne, arrayTwo)));
	}

}
