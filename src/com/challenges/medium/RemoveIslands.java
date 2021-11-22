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
		
		// 1. We create a boolean two dimensional array that is the same size as our input matrix. All values are initialized to false.
		boolean[][] edge = new boolean[matrix.length][matrix[0].length];

		// 2. We create a double 'for' loop that will iterate over our matrix. This will allow our program to check every value in the matrix going from first row to last,
		// first element to last element in each row.
		for(int row = 0; row < matrix.length; row++) {
			for(int col = 0; col < matrix[0].length; col++) {
				
				// 3. We create 3 boolean variables: (1) 'rowIsBorder' checks if either the value of the row is 0 or the matrix's length minus 1 in an attempt to see if the first index is
				// in the starting or ending row. If either returns true, we know the element is a border element. (2) 'colIsBorder' checks to see if col is 0 or the length of the first 
				// row minus 1. If either option returns true, we know the element is in the first or last column, making it a border element as well. (3) Finally, 'isBorder' checks to see
				// if either 'rowIsBorder' or 'colIsBorder' are true, and if either one is we know that the element in question exists along one of the matrix's borders.
				boolean rowIsBorder = row == 0 || row == matrix.length - 1;
				boolean colIsBorder = col == 0 || col == matrix[0].length - 1;
				boolean isBorder = rowIsBorder || colIsBorder;
				
				// 4. If the value of 'isBorder' is false, we know we don't have an element that exists along a border in the matrix. As a result...
				if(!isBorder) {
					
					// ...we 'continue' to the next element in our matrix. We do this because we are first wanting to discover which elements in the matrix are border elements.
					continue;
				}
				
				// 5. We check if the value located at the particular row and column indexes is not equal to zero. If it's not...
				if(matrix[row][col] != 1) {
					
					// ...we continue on to the next element in our matrix. We do this because the other value present besides 1 is 0. We aren't interested in 0s since they never need
					// to be updated given the prompt. It's the 1s we are after.
					continue;
				}
				
				// 6. If we've made it this far, then we know the value at 'matrix[row][col]' equals 1. We will call our first helper function, 'connectedToBorder', and pass in our row
				// and column values, our matrix, and our boolean matrix. This helper will go through these border elements and update the corresponding element in the 'edge' matrix 
				// with a boolean value.
				connectedToBorder(row, col, matrix, edge);
			}
		}
		
		// 7. Once every border element has been found in the matrix, we enter another double 'for' loop that will check every value within the borders of the matrix, hence the reason
		// why we start our row and col indexes at 1 and run until the lengths minus 1. 
		for(int row = 1; row < matrix.length - 1; row++) {
			for(int col = 1; col < matrix[0].length - 1; col++) {
				
				// 8. If the value in our 'edge' matrix at the row and col indexes equals 'true', then we know that point is somehow connected adjacently to a border point with a value
				// of 1. As a result...
				if(edge[row][col]) {
					
					// ...we continue to the next element in the matrix.
					continue;
				}
				
				// 9. However, if the point in question is not 'true', then it is either a 1 island not connected to a border 1 or simply a 0. As a result, regardless of if the current
				// value is 1 or 0, we set the value at those indexes equal to 0.
				matrix[row][col] = 0;
			}
		}
		
		// 10. Once all points within the matrix's borders have been checked, we return the final, mutated version of our matrix, this time with all island 1s removed and replaced with 0s.
		return matrix;
	}
	
	// 11. Our first helper method, 'connectedToBorder', takes in 4 parameters: the indexes for a row and column, our input matrix, and our boolean matrix.
	public static void connectedToBorder(int startRow, int startCol, int[][] matrix, boolean[][] edge) {
		
		// 12. Similar to our approach with RiverSizes, we will create a stack that will hold integer arrays.
		Stack<int[]> stack = new Stack<>();
		
		// 13. We push in a new integer array that consists of two values: starting row index and starting column index.
		stack.push(new int[] {startRow, startCol});
		
		// 14. We create a 'while' loop that will run if the stack has at least 1 element in it. It breaks when the stack becomes empty.
		while(!stack.isEmpty()) {
			
			// 15. We create an integer array that is equal to the element we pop off the top of our stack.
			int[] position = stack.pop();
			
			// 16. We create two integer variables and set them equal to the 1st and 2nd elements of the popped integer array respectively. These represent the row and column index values.
			int currentRow = position[0];
			int currentCol = position[1];
			
			// 17. We create a boolean variable equal to the boolean value found in the 'edge' matrix at the row and column indexes.
			boolean alreadyVisited = edge[currentRow][currentCol];
			
			// 18. We check and see if the value of 'alreadyVisited' equals true. If it does, then it means this point is connected to a border point and has already been checked and 
			// modified given the 'edge' matrix initialized all values to 'false' to begin with. As a result...
			if(alreadyVisited) {
				
				// ...we continue on to the next element in the 'edge' matrix.
				continue;
			}
			
			// 19. Otherwise, if the value of 'alreadyVisited' was false, then we know we haven't check in on it yet. Thus we set the value at those indexes equal to 'true' to indicate
			// we are currently checking it.
			edge[currentRow][currentCol] = true;
			
			// 20. We create a variable for a two dimensional integer array and set it equal to the result of our second helper function 'getNeighbors', which is responsible for 
			// returning a two dimensional array containing the adjacent elements to our current element: above, below, left, and right.
			int[][] neighbors = getNeighbors(currentRow, currentCol, matrix);
			
			// 21. We create a 'for' loop that iterates over each array within our two dimensional array.
			for(int[] neighbor : neighbors) {
				
				
				// 22. We create two integer variables to represent the row and column points from the given array we are checking.
				int row = neighbor[0];
				int col = neighbor[1];
				
				// 23. We check and see if the value at these indexes is not equal to 1. If it isn't, again, like our previous logic, we are not concerned with it. As a result...
				if(matrix[row][col] != 1) {
					
					// ...we continue to the next element in the two dimensional array.
					continue;
				}
				
				// 24. Otherwise, if the value is 1, then we know one of the current element's neighboring elements is also equal to 1 and connected to a border element equal to 1.
				// We then know that this 1 point is not an island, thus we add it to our stack so that when the loop repeats its neighbors get checked to see if the extension
				// continues.
				stack.push(neighbor);
			}
			
		}
		
		
	}
	
	// 25. Our second helper method, 'getNeighbors', takes in 3 parameters: the row and column indexes as well as the input matrix.
	public static int[][] getNeighbors(int row, int col, int[][] matrix){
		
		// 26. We create two integer variables equal to the number of rows and columns found in our input matrix.
		int numRows = matrix.length;
		int numCols = matrix[row].length;
		
		// 27. We create an ArrayList that will temporarily hold any neighboring element that pass the conditional criteria below.
		List<int[]> temp = new ArrayList<>();
		
		// 28. For each element surrounding the current element, we first check and see if its an index that exists within the bounds of our matrix. If it does...
		if(row - 1 >= 0) {
			
			// ...we add it to our 'temp' ArrayList. In this case, we are checking the top element...
			temp.add(new int[] {row - 1, col});
		}
		
		// ...the next case we check the bottom element... 
		if(row + 1 < numRows) {
			temp.add(new int[] {row + 1, col});
		}
		
		// ...then the left element...
		if(col - 1 >= 0) {
			temp.add(new int[] {row, col - 1});
		}
		
		// ...and finally the right element.
		if(col + 1 < numCols) {
			temp.add(new int[] {row, col + 1});
		}
		
		// 29. We create a two dimensional array and set it equal to the length of our 'temp' ArrayList and sets the size of each array within to be a length of 2, 
		// representing our row and col values. Basically, every array within the two dimensional array will be row/col pairs.
		int[][] neighbors = new int[temp.size()][2];
		
		// 30. We create a for loop that will iterate over every element in the 'temp' ArrayList. 
		for(int i = 0; i < temp.size(); i++) {
			
			// 31. For the given index 'i', we set that index in neighbors equal to the value found at the index in the ArrayList.
			neighbors[i] = temp.get(i);
		}
		
		// 32. Finally, we return our two dimensional array of neighboring element indexes.
		return neighbors;
	}
	

	public static void main(String[] args) {
		int[][] matrix = { {1, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 1}, {0, 0, 1, 0, 1, 0}, {1, 1, 0, 0, 1, 0}, {1, 0, 1, 1, 0, 0}, {1, 0, 0, 0, 0, 1}};

		System.out.println(removeIslands(matrix));
	}

}
