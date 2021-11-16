package com.challenges.medium;

import java.util.Arrays;

/*
 * 
	Number Of Ways To Traverse Graph
	
	You're given two positive integers representing the width and height of a grid-shaped, rectangular graph. Write a function that returns the number of ways to reach the bottom
	right corner of the graph when starting from the top left corner. Each move you take must either go down or right. In other words, you can never move up or left in the graph.
	
	For example, given the graph illustrated below, with width = 2 and height = 3, there are three ways to reach the bottom right corner when starting at the top left corner:
	
	 _ _
	|_|_|
	|_|_|
	|_|_| 
	
	1. Down, Down, Right
	2. Right, Down, Down
	3. Down, Right, Down
	
	NOTE: You may assume that width * height >= 2. In other words, the graph will never be a 1x1 grid.
	
	Sample Input:
	width = 4
	height = 3
	
	Sample Output:
	10
 * 
 */


public class NumberOfWaysToTraverseGraph {

	public static int numberOfWaysToTraverseGraph(int width, int height) {

		int[][] grid = new int[height][width];
			
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(i == 0 && j == 0) {
					grid[i][j] = 0;
				} else if((i == height - 1 && j == 0) || (i == 0 && j == width - 1)) {
					grid[i][j] = 1;
				} else {
					checkSquare(i, j, grid);
				}	
			}
		}
		
		System.out.println(Arrays.toString(grid[0]));
		System.out.println(Arrays.toString(grid[1]));
		System.out.println(Arrays.toString(grid[2]));
			
		return grid[height - 1][width - 1];
	}
	
	public static void checkSquare(int i, int j, int[][] grid) {
		
		if(i - 1 < 0 || j - 1 < 0) {
			grid[i][j] += 1;
		} else {
			grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
		}
		
	}

	public static void main(String[] args) {
		
		int width = 4;
		int height = 3;
		
		System.out.println(numberOfWaysToTraverseGraph(width, height));

	}

}
