package com.challenges.easy;

import java.util.Arrays;

/*
 * 
	Insertion Sort
	
	Write a function that takes in an array of integers and returns a sorted version of that array. Use the Insertion Sort algorithm to sort the array.
	
	Sample Input:
	array = [ 8, 5, 2, 9, 5, 6, 3 ]
	
	Sample Output:
	[ 2, 3, 5, 5, 6 , 8, 9 ] 
 * 
 */

public class InsertionSort {

	public static int[] insertionSort(int[] array) {

		// 1. We check first to see if our array is empty, if it is...
		if(array.length == 0) {
			
			// ...we simply return an empty array.
			return new int[] {};
		}
		
		// 2. We create a 'for' loop to iterate over all elements in our array from left to right starting at the 2nd element.
		for(int i = 1; i < array.length; i++) {
			
			// 3. We create a variable called j and set it equal to i.
			int j = i;
			
			// 4. We create a 'while' loop that iterates over our elements from right to left, while j is greater than 0 and the value of the current element is
			// less than the element that preceded it. Otherwise the loop breaks and the 'for' loop continues.
			while(j > 0 && array[j] < array[j - 1]) {
				
				// 5. If the conditions are met, we call our 'swap' function, which swaps the place of the current value with the preceding value.
				swap(j, j - 1, array);
				
				// 6. We decrement j by 1 and continue the 'while' loop until the conditions are false.
				j--;
			}
		}
		
		// 7. After the for loop has iterated through the entire array, we return our sorted array.
		return array;
	}
	
	// 8. The 'swap' function takes in 3 parameters: i's value, j's value, and our array.
	public static void swap(int i, int j, int[] array) {
		
		// 9. We create a 'temp' variable and set it equal to j's value...
		int temp = array[j];
		
		// ...then we set j's index value equal to i's...
		array[j] = array[i];
		
		// ...and finally set i's index value equal to the 'temp' value, effectively swapping values.
		array[i] = temp;
	}

	public static void main(String[] args) {
		int[] array1 = { 8, 5, 2, 9, 5, 6, 3 };

		System.out.println(Arrays.toString(insertionSort(array1)));
	}

}
