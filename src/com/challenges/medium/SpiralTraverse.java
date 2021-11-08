package com.challenges.medium;

import java.util.*;

/*
 * 
	Spiral Traverse
	
	Write a function that takes in an n x m two dimensional array (that can be square-shaped when n == m) and returns a one-dimensional array of all the array's elements in spiral
	order.
	
	Spiral order starts at the top left corner of the two dimensional array, goes to the right, and proceeds in a spiral pattern all the way until every element has been visited.
	
	Sample Input:
	
	array = [
		[ 1, 2, 3, 4 ],
		[12, 13, 14, 5],
		[11, 16, 15, 6],
		[10, 9, 8, 7]
	]
	
	Sample Output:
	
	[ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 ]
 * 
 */

public class SpiralTraverse {
	
	public static List<Integer> spiralTraverse(int[][] array) {

		// 1. We create an ArrayList that will hold the values of our two dimensional array in order.
		List<Integer> finalArray = new ArrayList<>();
		
		// 2. We create 4 variables to represent the starting and ending rows and columns. We will traverse the array as if we were traversing the outside of a square, working our
		// way towards the center in a spiral-like fashion. Right -> Down -> Left -> Up (Repeat, ignoring any values that were already added). 
		
		int firstRow = 0; // 1, 2, 3, 4
		int firstColumn = 0; // 1, 12, 11, 10
		int endingRow = array.length - 1; // 10, 9, 8, 7
		int endingColumn = array[0].length - 1; // 4, 5, 6, 7 (we get this by checking the first array within the two dimensional array and grabbing the last value)
		
		// 3. We create a 'while' loop that runs until either the first row or first column's value exceeds the ending row or column's. This way we ensure our traversal stays
		// within the bounds of our imaginary square and we account for all values present.
		while(firstRow <= endingRow && firstColumn <= endingColumn) {
			
			// 4. We run 4 'for' loops, each responsible for traversing one side of the square. The first one goes across the starting row, running until the value of the 'i' is
			// greater than the ending column's value. In this case, 'i' is equal to the value of the starting column.
			for(int i = firstColumn; i <= endingColumn; i++) {
				
				// 5. We add every value into our ArrayList, covering every value in the starting row. Since this is a two dimensional array, the first value is our first row's value
				// followed by the value of 'i', representing the index of each value in the sub-array. i.e. [ 1, 2, 3, 4 ].
				finalArray.add(array[firstRow][i]);
			}
			
			// 6. The 2nd 'for' loop, 'j' equals the starting row's value and the loop runs until 'j' is greater than the ending row's value.
			for(int j = firstRow; j <= endingRow; j++) {
				
				// 7. We add the last value of each sub-array (row) to our ArrayList, with 'j' being the increasing value and the ending column being the last value.
				// i.e. [ 1, 2, 3, 4, 5, 6, 7 ]
				finalArray.add(array[j][endingColumn]);
			}
			
			// 8. For the 3rd 'for' loop, we set 'k' equal to the value of our ending column minus 1 (since we have already included the last value of the last row in our ArrayList)
			// and run it until 'k' is less than the value of the first column.
			for(int k = endingColumn - 1; k >= firstColumn; k--) {
				
				// 9. In order to account for an edge case, meaning when there's a single row in the middle of the matrix, we include a conditional that checks to see if the first row
				// is equal to the ending row. We do this to avoid double counting values. If it does...
				if(firstRow == endingRow) {
					
					// ...we break our 'for' loop and continue to the next step below.
					break;
				}
				
				// 10. Otherwise, we add in every value from our ending row from right to left, where the ending row's value is the first parameter in our two dimensional array and 'k'
				// is the decrementing value of each number in that row. i.e. [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ].
				finalArray.add(array[endingRow][k]);
			}
			
			// 11. Our 4th and final 'for' loop runs until 'l', which equals the ending row's value minus 1 (since we've already included the first value of the ending row), is less
			// than or equal to the starting row's value.
			for(int l = endingRow - 1; l > firstRow; l--) {
				
				// 12. As with the previous loop, we check for edge cases where there's a single column in the middle of the matrix by seeing if the starting column's value equals
				// the ending column's value. If it does...
				if(firstColumn == endingColumn) {
					
					// ...we break the loop and continue to the next step in our 'while' loop.
					break;
				}
				
				// 13. Otherwise, we add the first value of every row to our ArrayList. The decrementing value of 'l' represents each individual row while the value of starting
				// column represents the index of the starting element in each row. i.e. [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 ].
				finalArray.add(array[l][firstColumn]);
			}
			
			// 14. In order to add the remaining values, we have to close in the boundaries of our two dimensional array, or in figurative terms, decrease the boundaries of our square.
			// In order to do this, we increase the value of our starting row and column by 1 and decrease the value of our ending row and column by 1. This basically divides our 
			// square in half, allowing the loop to continue and capture the values located in the center of the matrix.
			firstRow++;
			endingRow--;
			firstColumn++;
			endingColumn--;
		}
		
		// 15. After our loop has completed, we return the ArrayList.
	    return finalArray;
	  }
	

	public static void main(String[] args) {
		int[][] array1 = { {1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7} };

		System.out.println(spiralTraverse(array1));
	}

}
