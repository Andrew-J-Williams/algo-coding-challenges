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
		
		// 1. We create an output array that will hold all the products we compute from the input array. It will be the same length as our input array.
		int[] products = new int[array.length];
		
		// 2. We create a variable to represent the current index in our input array.
		int i = 0;
		
		// 3. We create a while loop that runs until the 'i' is greater than the length of the input array.
		while(i < array.length) {
			
			// 4. We create a variable that will represent our product for a given i. Essentially, we are finding the product of all the numbers in the array EXCEPT the value at 'i'.
			int product = 1;
			
			// 5. We create 2 variables to represent the values immediately to the left and right of 'i'.
			int left = i - 1;
			int right = i + 1;
			
			// 6. We create a 'while' loop that runs until the left index value is less than 0.
			while(left >= 0) {
				
				// 7. While conditions remain true, we multiply the current product value by the value at the left index and decrement the the value of left by 1.
				product *= array[left];
				left--;
			}
			
			// 7. We also create another 'while' loop that runs until the right index value exceeds the length of the array.
			while(right < array.length) {
				
				// 8. Just like with the left 'while' loop, we multiply the product by the value at the right index in the array. Only difference is we increment right by 1.
				product *= array[right];
				right++;
			}
			
			// 9. We add the product to the products array using 'i' as the index.
			products[i] = product;
			
			// 10. We increment i by 1 and repeat the process for each value in the array.
			i++;
		}
		
		// 11. After all values have been computed, we return the products array.
		return products;
	}

	public static void main(String[] args) {
		int[] array1 = { 5, 1, 4, 2 };

		System.out.println(Arrays.toString(arrayOfProducts(array1)));
	}

}
