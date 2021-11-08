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
	    
		HashSet<Integer> values = new HashSet<>();
		
		for(int x : array) {
			if(!values.contains(x)) {
				values.add(x);
			} else {
				return x;
			}
		}
		
		
	    return -1;
	  }

	public static void main(String[] args) {
		int[] array1 = { 2, 1, 5, 3, 3, 2, 4 };
		
		System.out.println(firstDuplicateValue(array1));
	}

}
