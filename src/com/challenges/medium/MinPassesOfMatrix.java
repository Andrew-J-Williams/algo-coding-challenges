package com.challenges.medium;

import java.util.*;

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

		int result = findNegatives(matrix, 0, 0);
		
		return result;
	}
	
	public static int findNegatives(int[][] matrix, int passes, int total) {
		
		List<Integer> positives = new ArrayList<>();
		List<Integer> negatives = new ArrayList<>();
		List<int[]> negativePairs = new ArrayList<>();
		int count = 0;
		
		for(int i = 0; i < matrix.length; i++) {
			for(int k = 0; k < matrix[i].length; k++) {
				
				if(matrix[i][k] >= 0) {
					positives.add(matrix[i][k]);
					count++;
					continue;
				}
				
				boolean current = checkNeighbors(i, k, matrix);
				
				if(current && matrix[i][k] < 0) {
					negatives.add(matrix[i][k]);
					negativePairs.add(new int[] {i, k});
				} else if(matrix[i][k] < 0) {
					negatives.add(matrix[i][k]);
				}
				
				count++;
			}
		}

		if(positives.size() == count && negatives.size() == 0) {
			return passes;
		}
		
		for(int[] negative : negativePairs) {
			int i = negative[0];
			int k = negative[1];
			
			matrix[i][k] *= -1;
		}
		
		if(negatives.size() == 0) {
			return passes;
		} else if(negatives.size() > 0 && negatives.size() != total) {
			return findNegatives(matrix, passes + 1, negatives.size());
		}
		
		return -1;
	}
	
	public static boolean checkNeighbors(int i, int k, int[][] matrix) {
		
		if(i > 0 && matrix[i - 1][k] > 0) {
			return true;
		}
		
		if(i < matrix.length - 1 && matrix[i + 1][k] > 0) {
			return true;
		}
		
		if(k > 0 && matrix[i][k - 1] > 0) {
			return true;
		}
		
		if(k < matrix[i].length - 1 && matrix[i][k + 1] > 0) {
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = { {0, -1, -3, 2, 0}, {1, -2, -5, -1, -3}, {3, 0, 0, -4, -1}};
		int[][] matrix2 = { {0, -2, -1}, {-5, 2, 0}, {-6, -2, 0} };
		int[][] matrix3 = { {1} };

		System.out.println(minimumPassesOfMatrix(matrix));
	}

}
