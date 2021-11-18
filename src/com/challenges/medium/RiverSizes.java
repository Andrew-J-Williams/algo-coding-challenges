package com.challenges.medium;

import java.util.*;

/*
 * 
	River Sizes
	
	You're given a two-dimensional array (a matrix) of potentially unequal height and width containing only 0s and 1s. Each 0 represents land and each 1 represents part of a river.
	A river consists of any number of 1s that are either horizontally or vertically adjacent (but not diagonally adjacent). The number of adjacent 1s forming a river determines
	size.
	
	Note that a river can twist. In other words, it doesn't have to be a straight vertical line or a straight horizontal line; it can be 'L' shaped.
	
	Write a function that returns an array of the sizes of all rivers represented in the input matrix. The sizes don't need to be in any particular order.
	
	Sample Input:
	matrix = [
		[1, 0, 0, 1, 0],
		[1, 0, 1, 0 ,0],
		[0, 0, 1, 0, 1],
		[1, 0, 1, 0, 1],
		[1, 0, 1, 1, 0],
	]
	
	Sample Output:
	[1, 2, 2, 2, 5] // The numbers could be ordered differently
	
	There rivers can be clearly seen here:
	
	[
		[1, ,  , 1, ],
		[1, , 1,  , ],
		[ , , 1, , 1],
		[1, , 1, , 1],
		[1, , 1, 1, ],
	]
	
 * 
 */

public class RiverSizes {

	public static List<Integer> riverSizes(int[][] matrix) {

		List<Integer> sizes = new ArrayList<>();

		boolean[][] matrix2 = new boolean[matrix.length][matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++) {
			for(int k = 0; k < matrix[i].length; k++) {

				if(matrix2[i][k]) {
					continue;
				}
				
				traverseNode(i, k, matrix, matrix2, sizes);
			}
		}

		return sizes;
	}
	
	public static void traverseNode(int i, int k, int[][] value, boolean[][] visited, List<Integer> sizes) {
		
		int currentSize = 0;
		
		Stack<Integer[]> nodesToExplore = new Stack<Integer[]>();
		
		nodesToExplore.push(new Integer[] {i, k});
		
		while(!nodesToExplore.isEmpty()) {
			
			Integer[] currentNode = nodesToExplore.pop();
			
			
		}
		
	}
	
	public static int findLength(int i, int k, int[][] current, boolean[][] checked) {
		
		
		return -1;
	}
	

	public static void main(String[] args) {
		int[][] matrix1 = { { 1, 0, 0, 1, 0 }, { 1, 0, 1, 0, 0 }, { 0, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 0 } };
		
		System.out.println(riverSizes(matrix1));
	}

}
