package com.challenges.easy;

import java.util.Arrays;

/*
 * 
	Bubble Sort
	
	Write a function that takes in an array of integers and returns a sorted version of that array. Use the Bubble Sort algorithm to sort the array.
	
	A bubble sort occurs in place, we are not putting them in another "helper" array. We are swapping values to determine which of two values is greater.
	
	Sample Input:
	array = [ 8, 5, 2, 9, 5, 6, 3 ]
	
	Sample Output:
	[ 2, 3, 5, 5, 6 , 8, 9 ] 
 * 
 */

public class BubbleSort {

	public static int[] bubbleSort(int[] array) {
		
		// 1. We create a variable that will store the swapped value from our array.
		int swap = 0;
		
		// 2. We create a 'for' loop that will iterate over all elements in the array.
		for(int i = 0; i < array.length; i++) {
			
			// 3. If the index value of i + 1 is less than the array's length AND i's value is greater than i + 1's value (current is greater than the next value)...
			if(i+1 < array.length && array[i] > array[i+1]) {
				
				// ...we set swap equal to the next value...
				swap = array[i+1];
				
				// ...set i + 1 equal to the current i's value...
				array[i+1] = array[i];
				
				// ...and set i equal to swap. This flip-flops the values of i and i + 1. We continue to do this for each index value until the end of the array.
				array[i] = swap;
			}
		}
		
		// 4. If the value of swap is not equal to zero (meaning we had to set it equal to a value in the array), then we know we made adjustments and the array
		// may not sorted completely. In order to be sure it is...
		if(swap != 0) {
			
			/// ...we treat our function as a recursive function as call it again, using the modified array as the argument.
			return bubbleSort(array);
		}

		// 5. Once we've called our function enough times to know that swap equals zero, we return the array knowing it is now fully sorted.
		return array;
	}
	

	public static void main(String[] args) {
		int[] array1 = { 8, 5, 2, 9, 5, 6, 3 };
		
		System.out.println(Arrays.toString(bubbleSort(array1)));
	}

}
