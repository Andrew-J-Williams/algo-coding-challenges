package com.challenges.medium;

import java.util.*;

/*
 * 
	Remove Islands
	
	You're given a two-dimensional array (a matrix) of potentially unequal height and width containing only 0s and 1s. The matrix represents a two-toned image, where each 1
	represents black and each 0 represents white. An island is defined as any number of 1s that are horizontally or vertically adjacent (but not diagonally adjacent) and that 
	don't touch the border of the image. In other words, a group of horizontally or vertically adjacent 1s isn't an island if any of those 1s are in the first row, last row, first
	column, or last column of the input matrix.
	
	Note that an island can twist. In other words, it doesn't have to be a straight vertical line or a straight horizontal line; it can be L-shaped.
	
	You can think of islands as patches of black that don't touch the border of the two-toned image.
	
	Write a function that returns a modified version of the input matrix, where all the islands are removed. You remove an island by replacing it with 0s.
	
	Naturally, you are allowed to mutate the input matrix.
	
	Sample Input:
	matrix = [
		[ 1, 0, 0, 0, 0, 0 ].
	 	[ 0, 1, 0, 1, 1, 1 ],
	 	[ 0, 0, 1, 0, 1, 0 ],
	 	[ 1, 1, 0, 0, 1, 0 ],
	 	[ 1, 0, 1, 1, 0, 0 ],
	 	[ 1, 0, 0, 0, 0, 1 ],
	] 
	
	Sample Output:
	[
		[ 1, 0, 0, 0, 0, 0 ].
	 	[ 0, 0, 0, 1, 1, 1 ],
	 	[ 0, 0, 0, 0, 1, 0 ],
	 	[ 1, 1, 0, 0, 1, 0 ],
	 	[ 1, 0, 0, 0, 0, 0 ],
	 	[ 1, 0, 0, 0, 0, 1 ],
	] 
	
	// The islands that were removed can be clearly seen here:
	
	[
		[ ,  ,  ,  ,  ,  ].
	 	[ , 1,  ,  ,  ,  ],
	 	[ ,  , 1,  ,  ,  ],
	 	[ ,  ,  ,  ,  ,  ],
	 	[ ,  , 1, 1,  ,  ],
	 	[ ,  ,  ,  ,  ,  ],
	]  
	 
	
 * 
 */

public class RemoveIslands {

	public static int[][] removeIslands(int[][] matrix) {
		
		
		boolean[][] edge = new boolean[matrix.length][matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++) {
			edge[i][matrix[0].length - 1] = false;
		}
		
		for(int row = 0; row < matrix.length; row++) {
			for(int col = 0; col < matrix[0].length; col++) {
				
				boolean rowIsBorder = row == 0 || row == matrix.length - 1;
				boolean colIsBorder = col == 0 || col == matrix[0].length - 1;
				boolean isBorder = rowIsBorder || colIsBorder;
				
				if(!isBorder) {
					continue;
				}
				
				if(matrix[row][col] != 1) {
					continue;
				}
				
				connectedToBorder(row, col, matrix, edge);
			}
		}
		
		
		for(int row = 1; row < matrix.length; row++) {
			for(int col = 1; col < matrix[0].length; col++) {
				if(edge[row][col]) {
					continue;
				}
				
				matrix[row][col] = 0;
			}
		}
		return matrix;
	}
	
	public static void connectedToBorder(int startRow, int startCol, int[][] matrix, boolean[][] edge) {
		
		
		
		
	}
	

	public static void main(String[] args) {
		int[][] matrix = { {1, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 1}, {0, 0, 1, 0, 1, 0}, {1, 1, 0, 0, 1, 0}, {1, 0, 1, 1, 0, 0}, {1, 0, 0, 0, 0, 1}};

		System.out.println(removeIslands(matrix));
	}

}