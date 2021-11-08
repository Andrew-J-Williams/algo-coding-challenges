package com.challenges.medium;

import java.util.*;

/*
 * 
	First Duplicate Value
	
	Given an array of integers between 1 and 'n', inclusive, where 'n' is the length of the array, write a function that returns the first integer that appears more than once (when the
	array is read from left to right).
	
	In other words, out of all the integers that might occur more than once in the input array, your function should return the one whose first duplicate value has the minimum index.
	
	If no integer appears more than once, your function should return -1.
	
	Note that you are allowed to mutate the input array.
 * 
 */

public class FirstDuplicateValue {
	
	public static int firstDuplicateValue(int[] array) {
	    
		// 1. We create a HashSet for the purpose of identifying unique values. A HashSet will NOT accept duplicate values, only one unique instance of each integer.
		HashSet<Integer> values = new HashSet<>();
		
		// 2. We create a 'for' loop that iterates over every element 'x' in our integer array, covering every single value.
		for(int x : array) {
			
			// 3. We set up a conditional that checks if our HashSet doesn't contain the current value, if it doesn't...
			if(!values.contains(x)) {
				// ...we add that value to the HashSet.
				values.add(x);
			// 4. Otherwise, if 'x' is present in the HashSet, we know it has to be a duplicate since it was previously added...	
			} else {
				// ...thus we return the value of x.
				return x;
			}
		}
		
		// 5. If the loop completes, it means that there were no duplicate values in the array, thus we return -1 to indicate this fact.
	    return -1;
	  }

	public static void main(String[] args) {
		int[] array1 = { 2, 1, 5, 3, 3, 2, 4 };
		
		System.out.println(firstDuplicateValue(array1));
	}

}
