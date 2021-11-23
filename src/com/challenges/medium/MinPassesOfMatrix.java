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

		// 1. We create an integer variable that is equal to the result of our helper function 'findNegatives', which returns an integer representing the number of passes completed
		// on our matrix to change negatives to positives.
		int result = findNegatives(matrix, 0, 0);

		// 2. We return our 'result'.
		return result;
	}
	
	// 3. Our first helper function, 'findNegatives', takes in 3 parameters: our input matrix, an integer representing the number of passes taken so far, and an integer representing
	// the total number of negative values found in the matrix. Upon using this helper for the first time, we set 'passes' and 'totalNegatives' equal to 0 since we have not yet
	// traversed our matrix.
	public static int findNegatives(int[][] matrix, int passes, int totalNegatives) {
		
		// 4. We create an ArrayList to hold all positive integers found in our matrix.
		List<Integer> positives = new ArrayList<>();
		
		// 5. We create another ArrayList to hold all negative integers found in our matrix.
		List<Integer> negatives = new ArrayList<>();
		
		// 6. We create yet another ArrayList that will store integer arrays, each array representing a pair of 'i' and 'k' values.
		List<int[]> negativePairs = new ArrayList<>();
		
		// 7. We create an integer variable called 'count' that keeps track of the total number of elements in our matrix.
		int count = 0;
		
		// 8. We create a double 'for' loop that allows our function to traverse and check each element in our matrix starting with the first
		// element in the first row and ending with the last element in the last row.
		for(int i = 0; i < matrix.length; i++) {
			for(int k = 0; k < matrix[i].length; k++) {
				
				// 9. We check if the value at 'i' and 'k' is either a positive number or equal to 0. If it is, we know we don't have a negative
				// number. As a result...
				if(matrix[i][k] >= 0) {
					
					// ...we add that positive integer to our 'positives' ArrayList...
					positives.add(matrix[i][k]);
					
					// ...increment the value of count by 1...
					count++;
					
					// ...and continue to the next element in the matrix, skipping the logic below.
					continue;
				}
				
				// 10. We create a boolean variable and set it equal to the result of our second helper function 'checkNeighbors', which will 
				// check and see if any of the adjacent elements are positive numbers. If they are, then the current negative element can be
				// converted to a positive number. 
				boolean current = checkNeighbors(i, k, matrix);
				
				// 11. If the value of 'current' is 'true', then we know a negative to positive conversion is possible. As a result...
				if(current) {
					
					// ...we add the negative number to our 'negatives' ArrayList...
					negatives.add(matrix[i][k]);
					
					// ...we create an integer array consisting of 'i' and 'k' and add it to our 'negativePairs' ArrayList...
					negativePairs.add(new int[] {i, k});
					
					// ...increment the value of 'count' by 1...
					count++;
					
					// ...and finally continue to the next element in the matrix, skipping the logic below.
					continue;
				} 
				
				// 12. If we reach this point in the logic, we know we have a negative number, but none of the adjacent elements are positive
				// integers, meaning for this pass a conversion from negative to positive is not possible. Regardless, we add the negative
				// element to our 'negatives' ArrayList in order to account for it being present.
				negatives.add(matrix[i][k]);
				
				// 13. We increment the value of 'count' by 1 to account for this negative integer and then repeat the loop until all elements
				// are accounted for.
				count++;
			}
		}

		// 14. We check and see if our 'positives' ArrayList is equal to the total number of elements in the matrix. If this is true, we know 
		// we've converted all possible negatives into positives. We know this because if the number of positive integers is equal to the total
		// number of elements in the matrix, all values must either be positive or zero. As a result...
		if(positives.size() == count) {
			
			// ...we will return the value of passes. This also accounts for a matrix that consists of positive values and/or values that equal
			// 0 since the initial value passed into the helper for passes would be 0.
			return passes;
		}
		
		// 15. If there are less positives than total elements, we create a 'for' loop that iterates over every integer array in our negativePairs
		// ArrayList.
		for(int[] negative : negativePairs) {
			
			// 16. We create two integer variables, 'i' and 'k', and set each respectively to the values of 'i' and 'k' contained within each.
			int i = negative[0];
			int k = negative[1];
			
			// 17. We take the value in the matrix found at 'i' and 'k' and multiply it by -1. This turns the negative into a positive value.
			// We do this for each value pair in 'negativePairs'.
			matrix[i][k] *= -1;
		}
		
		// 18. We check and see if the number of values in our 'negatives' ArrayList does NOT equals the previous number of negatives we found
		// on our last pass. If they aren't equal then we know conversions took place and less negatives were added as a result. If this is the
		// case...
		if(negatives.size() != totalNegatives) {
			
			// we return the result of our helper function, calling it recursively. We add 1 to passes to account for the pass we just made and
			// pass in the size of the 'negatives' ArrayList for 'totalNegatives' for comparison after our next pass. Eventually, if all negatives
			// can be converted, the 'positives' size will equal the count and the value of passes will be returned.
			return findNegatives(matrix, passes + 1, negatives.size());
		}
		
		// 19. If the total number of negative elements does equal the previous amount of negatives, we know that our latest pass made no changes
		// to the matrix, indicating there are negative values that cannot be converted to positive values. As a result, per the prompts instructions,
		// we return -1.
		return -1;
	}
	
	// 20. Our 
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
