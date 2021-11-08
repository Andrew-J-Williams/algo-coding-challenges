package com.challenges.medium;

import java.util.Arrays;

/*
 * 
	Array of Products
	
	Write a function that takes in a non-empty array of integers and returns an array of the same length, where each element in the output array is equal to the product of every other
	number in the input array.
	
	In other words, the value at 'output[i]' is equal to the product of every number in the input array other than 'input[i]'.
	
	Note that you are expected to solve the problem without using division.
	
	Sample Input:
	array = [ 5, 1, 4, 2 ]
	
	Sample Output:
	[ 8, 40, 10, 20 ]
	
	// 8 is equal to 1 x 4 x 2
	// 40 is equal to 5 x 4 x 2
	// 10 is equal to 5 x 1 x 2
	// 20 is equal to 5 x 4 x 1
 * 
 */

public class ArrayOfProducts {

	public static int[] arrayOfProducts(int[] array) {
		int[] products = new int[array.length];
		
		int i = 0;
		
		while(i < array.length) {
			
			int product = 1;
			
			int left = i - 1;
			int right = i + 1;
			
			while(left >= 0) {
				product *= array[left];
				left--;
			}
			
			while(right < array.length) {
				product *= array[right];
				right++;
			}
			
			products[i] = product;
			
			i++;
		}
		
		return products;
	}

	public static void main(String[] args) {
		int[] array1 = { 5, 1, 4, 2 };

		System.out.println(Arrays.toString(arrayOfProducts(array1)));
	}

}
