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

		int swap = 0;
		
		for(int i = 1; i < array.length; i++) {
			for(int k = i - 1; k >= 0; k--) {
				if(array[i] < array[k]) {
					swap = array[i];
					array[i] = array[k];
					array[k] = swap;
					i--;
				}
			}
		}
		
		
		return array;
	}

	public static void main(String[] args) {
		int[] array1 = { 8, 5, 2, 9, 5, 6, 3 };

		System.out.println(Arrays.toString(insertionSort(array1)));
	}

}
