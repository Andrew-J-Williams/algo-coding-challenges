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

		// 1. First, we sort both of our arrays in ascending order.
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		
		// 2. We create two pointer variables and set them equal to 0. These will represent the index of the values in both arrays.
		int i1 = 0;
		int i2 = 0;
		
		// 3. We create two variables: one that will represent the smallest running difference and the current difference. We set them both equal to the maximum positive integer
		// by using "Integer.MAX_VALUE" so that any difference we compare the smallest to will always be smaller.
		int smallest = Integer.MAX_VALUE;
		int current = Integer.MAX_VALUE;
		
		// 4. We create an integer array that will eventually hold our pair of values that create the smallest difference.
		int[] smallestPair = new int[2];
		
		// 5. We create a 'while' loop that runs until either i1 or i2 equal the length of their respective arrays.
		while(i1 < arrayOne.length && i2 < arrayTwo.length) {
			
			// 6. We create variables that hold the current values represented by each index for each array.
			int first = arrayOne[i1];
			int second = arrayTwo[i2];
			
			// 7. If the first value is less than the second value...
			if(first < second) {
				
				// ...we set current equal to the larger number minus the smaller and increment i1 by one;
				current = second - first;
				i1++;
			
				// 8. If the first value is greater than the second value...
			} else if(first > second) {
				
				// ...we set current equal to the larger number minus the smaller and increment i2 plus one;
				current = first - second;
				i2++;
				
			// 9. If both numbers are equal to each other, that means their absolute difference is zero, the smallest difference possible. If this is so...	
			} else {
				
				// ...we return a new integer array with our difference values, making sure to put the first array's value first.
				return new int[] {first, second};
			}
			
			// 10. If the current difference is less than our smallest running difference...
			if(smallest > current) {
				
				// ...we set smallest equal to the current difference value...
				smallest = current;
				
				// ...and set smallestPair equal to a new array with our values from each array, again putting taking the first array's value as the first value.
				smallestPair = new int[] {first, second};
			}
			
		}
		
		// 11. Finally, we return our array with the smallest difference pair after the while loop completes.
		return smallestPair;
	}


	public static void main(String[] args) {
		int[] arrayOne = { -1, 5, 10, 20, 28, 3 };
		int[] arrayTwo = { 26, 134, 135, 15, 17 };

		System.out.println(Arrays.toString(smallestDifference(arrayOne, arrayTwo)));
	}

}
