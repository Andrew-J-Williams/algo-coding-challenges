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

		if(array.length == 0) {
			return new int[] {};
		}
		
		for(int i = 1; i < array.length; i++) {
			int j = i;
			
			while(j > 0 && array[j] < array[j - 1]) {
				swap(j, j - 1, array);
				j--;
			}
		}
		
		return array;
	}
	
	public static void swap(int i, int j, int[] array) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}

	public static void main(String[] args) {
		int[] array1 = { 8, 5, 2, 9, 5, 6, 3 };

		System.out.println(Arrays.toString(insertionSort(array1)));
	}

}
