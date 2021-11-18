package com.challenges.medium;

public class RemoveIslands {

	public static int[][] removeIslands(int[][] matrix) {
		// Write your code here.
		return new int[][] { {} };
	}

	public static void main(String[] args) {
		int[][] matrix = { {1, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 1}, {0, 0, 1, 0, 1, 0}, {1, 1, 0, 0, 1, 0}, {1, 0, 1, 1, 0, 0}, {1, 0, 0, 0, 0, 1}};

		System.out.println(removeIslands(matrix));
	}

}
