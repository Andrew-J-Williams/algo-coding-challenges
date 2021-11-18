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

		List<Integer> sizes = new ArrayList<Integer>();

		boolean[][] matrix2 = new boolean[matrix.length][matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++) {
			for(int k = 0; k < matrix[0].length; k++) {

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
			
			i = currentNode[0];
			k = currentNode[1];
			
			if(visited[i][k]) {
				continue;
			} else {
				visited[i][k] = true;
			}
				
			if(value[i][k] == 0) {
				continue;
			} else {
				currentSize++;
			}
				
			List<Integer[]> neighbors = getNeighbors(i, k, value, visited);
			
			for(Integer[] neighbor : neighbors) {
				nodesToExplore.add(neighbor);
			}
			
			
		}
		
		if(currentSize > 0) {
			sizes.add(currentSize);
		}
		
	}
	
	public static List<Integer[]> getNeighbors(int i, int k, int[][] value, boolean[][] visited) {
		
		List<Integer[]> neighbors = new ArrayList<Integer[]>();
		
		// top
		if(i > 0 && !visited[i - 1][k]) {
			neighbors.add(new Integer[] {i - 1, k});
		}
		
		// bottom
		if(i < value.length - 1 && !visited[i + 1][k]) {
			neighbors.add(new Integer[] {i + 1, k});
		}
		
		//left
		if(k > 0 && !visited[i][k - 1]) {
			neighbors.add(new Integer[] {i, k - 1});
		}
		
		if(k < value[i].length - 1 && !visited[i][k + 1]) {
			neighbors.add(new Integer[] {i, k + 1});
		}
		
		return neighbors;
	}
	

	public static void main(String[] args) {
		int[][] matrix1 = { { 1, 0, 0, 1, 0 }, { 1, 0, 1, 0, 0 }, { 0, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 0 } };
		
		System.out.println(riverSizes(matrix1));
	}

}
