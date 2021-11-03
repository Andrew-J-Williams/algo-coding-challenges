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
		
		int swap = 0;
		
		for(int i = 0; i < array.length; i++) {
			if(i+1 < array.length && array[i] > array[i+1]) {
				swap = array[i+1];
				array[i+1] = array[i];
				array[i] = swap;
			}
		}
		
		if(swap != 0) {
			return bubbleSort(array);
		}

		return array;
	}
	

	public static void main(String[] args) {
		int[] array1 = { 8, 5, 2, 9, 5, 6, 3 };
		
		System.out.println(Arrays.toString(bubbleSort(array1)));
	}

}
