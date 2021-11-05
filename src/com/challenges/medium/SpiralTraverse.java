package com.challenges.medium;

import java.util.*;

/*
 * 
	Spiral Traverse
	
	Write a function that takes in an n x m two dimensional array (that can be square-shaped when n == m) and returns a one-dimensional array of all the array's elements in spiral
	order.
	
	Spiral order starts at the top left corner of the two dimensional array, goes to the right, and proceeds in a spiral pattern all the way until every element has been visited.
 * 
 */

public class SpiralTraverse {
	
	public static List<Integer> spiralTraverse(int[][] array) {
	    // Write your code here.
	    return new ArrayList<Integer>();
	  }

	public static void main(String[] args) {
		int[][] array1 = { {1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7} };

		System.out.println(spiralTraverse(array1));
	}

}
