package com.challenges.medium;

/*
 * 
	Minimum Number of Passes
	
	Write a function that takes in an integer matrix of potentially unequal height and width and returns the minimum number of passes required to convert all the negative integers
	in the matrix into positive integers.
	
	A negative integer in the matrix can be converted to a positive integer if one or more of its adjacent elements are positive. An adjacent element is to the left, to the right,
	above, or below the current element in the matrix. Converting a negative to a positive simply involves multiplying it by -1.
	
	Note that the 0 value is neither positive or negative, meaning that a zero cannot convert an adjacent negative to a positive.
	
	A single pass through the matrix involves converting all the negative integers that can be converted at a particular point in time. 
	
	Note that the input matrix always contains at least one element. If the negative integers in the input matrix can't all be converted to positives, regardless of how many passes
	are run, the function should return -1.
	
	Sample Input:
	
		matrix = [
			[ 0, -1, -3, 2, 0 ],
			[ 1, -2, -5, -1, -3 ],
			[ 3, 0, 0, -4, -1 ],
		]
	
	Sample Output:
	3
 * 
 */

public class MinPassesOfMatrix {

	public static int minimumPassesOfMatrix(int[][] matrix) {
		// Write your code here.
		return -1;
	}
	
	public static void

	public static void main(String[] args) {
		int[][] matrix = { {0, -1, -3, 2, 0}, {1, -2, -5, -1, -3}, {3, 0, 0, -4, -1}};

		System.out.println(minimumPassesOfMatrix(matrix));
	}

}
