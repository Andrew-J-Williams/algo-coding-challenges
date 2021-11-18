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

		// 1. We create an ArrayList of Integers that will eventually store all of our river sizes.
		List<Integer> sizes = new ArrayList<Integer>();

		// 2. We create a two dimensional array of booleans that is equal in size to the matrix. We do this by using the matrix's length for the height and the length of the first
		// first array for the width. When it is created, every value in the array is initialized to 'false'. The purpose of creating this two dimensional array is to help us
		// determine which nodes we've already visited. As will be seen later in the logic, nodes that have not been visited will equal 'false', and after we visit them we will
		// update their values to 'true'. Thus, as we iterate over each node, we avoid the mistake of repeats.
		boolean[][] matrix2 = new boolean[matrix.length][matrix[0].length];
		
		// 3. We create a double 'for' loop that iterates over every element in our two dimensional array starting in the upper left corner and working its way down to the lower
		// right corner. Basically we iterate through one row and then move to the row below it, repeating the process until the last value is reached.
		for(int i = 0; i < matrix.length; i++) {
			for(int k = 0; k < matrix[0].length; k++) {

				// 4. If our current value is 'true'...
				if(matrix2[i][k]) {
					
					// ...then we continue forward in the iteration to the next element since 'true' indicates we've already checked this node to see if it's a river, continues
					// a river, or is land.
					continue;
				}
				
				// 5. If our node's value is 'false', then we know we have not checked it yet. Thus we call our first helper function 'traverseNode', which will help determine
				// if the current node is a river or land, check the surrounding nodes if it is a river, and finally add a final size to our ArrayList if its greater than 0. We
				// call this helper on every node whose value is currently 'false'.
				traverseNode(i, k, matrix, matrix2, sizes);
			}
		}

		// 6. Once all nodes have been checked, we return our 'sizes' ArrayList, which will contain the lengths of all rivers found in the matrix.
		return sizes;
	}
	
	// 7. Our first helper function, 'traverseNode', takes in 5 arguments: index 'i', index 'k', our original matrix, our boolean matrix, and our ArrayList of sizes.
	public static void traverseNode(int i, int k, int[][] value, boolean[][] visited, List<Integer> sizes) {
		
		// 8. We create a variable that will keep track of the current size of our river. We initialize this variable to 0 since we have not checked our node to see if it is a 1 or
		// a 0.
		int currentSize = 0;
		
		// 9. We create a Stack of Integer arrays that will hold arrays that consist of differing values of 'i' and 'k' that represent either our current node or the nodes that 
		// surround it. A Stack is helpful for this algorithm since it allows us to store data by 'pushing' it in the top of the data structure and 'popping' out the top value.
		// A Stack holds elements in a Last-in, First-out fashion. A real-world comparison would be the magazine for a gun: the first bullet 'pushed' in will end up at the bottom
		// and the last bullet in will be the first one 'popped' out.
		Stack<Integer[]> nodesToExplore = new Stack<Integer[]>();
		
		// 10. We push our current node into the Stack, creating an Integer array that would look like the following: [i, k].
		nodesToExplore.push(new Integer[] {i, k});
		
		// 11. We create a 'while' loop that runs while our Stack is not empty. Essentially, this loop will run until all surrounding nodes equal either 0 in the original matrix or
		// 'false' in matrix2.
		while(!nodesToExplore.isEmpty()) {
			
			// 12. We create and Integer array that will hold the top element we pop out of the Stack. In the case of our example data, starting with the very first node in the upper
			// left corner, is would be [0, 0].
			Integer[] currentNode = nodesToExplore.pop();
			
			// 13. We set 'i' equal to the value of 'i' in the array and 'k' equal to the value of 'k' in the array. We do this because (as will be seen later on), the values of 'i'
			// and 'k' will change based on which node we are checking.
			i = currentNode[0];
			k = currentNode[1];
			
			// 14. If the value at 'i' and 'k' in our boolean matrix returns true...
			if(visited[i][k]) {
				
				// ...then we continue to the next node in our loop since 'true' indicates we have visited before.
				continue;
			
			// 15. Otherwise, if the value comes back 'false'...	
			} else {
				
				// ...we set the value at 'i' and 'k' equal to 'true' so that going forward we have record of checking this specific node and won't accidentally check it again.
				visited[i][k] = true;
			}
			
			// 16. If the value at 'i' and 'k' in the integer matrix (the original matrix) is equal to 0...
			if(value[i][k] == 0) {
				
				// ...then we also continue since 0 indicates land and no extension of the river is present at this value.
				continue;
			// 17. Otherwise, if the value equals 1, we know that the river either begins or continues at this node...	
			} else {
				
				// ...and we will increment the value of 'currentSize' by one to represent the current length of the river. Given our example data, we would set visited[0][0] = 
				// true and currentSize = 1 since value[0][0] = 1.
				currentSize++;
			}
			
			// 18. We create an ArrayList of Integer arrays and set it equal to the result of our second helper function 'getNeighbors'. As its name suggests, this function is 
			// responsible for check every node around our current node to see if their values are either 1 or 0. If any of the surrounding nodes above, below, left, or right of
			// the current node have a value of 1 and are false in the boolean matrix, we know we have an extension of the river. This helper will return an ArrayList of arrays
			// that consist of different combinations of 'i' and 'k', representing these surrounding nodes and their values in both matrixes. 
			List<Integer[]> neighbors = getNeighbors(i, k, value, visited);
			
			// 19. After calling our helper, we create a 'for' loop that iterates over all the arrays in the ArrayList resulting from our helper function. 
			for(Integer[] neighbor : neighbors) {
				
				// 20. We add each array (represented by 'neighbor') to the end of our Stack. And once our 'for' loop finishes iterating and adding each element, the 'while' loop
				// will run again if there is at least one element added to the Stack. In the event that there is not, our function knows the end of the river has been reached.
				// Given our example data, the Stack would have one element in it: the value at [1][0].
				nodesToExplore.add(neighbor);
			}
			
			
		}
		
		// 21. Once the loop breaks, indicating either the end of a river has been found or the node and its surrounding nodes were equal to 0, we check if our 'currentSize' variable is
		// greater than zero. If it is, we know at least one of our nodes had 1 as a value and it indicates 1 river. As a result...
		if(currentSize > 0) {
			
			// ...we add 'currentSize' representing the length of the river, to our ArrayList 'sizes'. Given our previous example data, since the node below [0][0] is also 1, the
			// value of 'currentSize' would be 2 when the 'while' loop breaks, and that value is added to the ArrayList.
			sizes.add(currentSize);
		}
		
	}
	
	// 22. Our second helper method, 'getNeighbors', takes in 4 arguments: index 'i', index 'k', our integer matrix, and our boolean matrix.
	public static List<Integer[]> getNeighbors(int i, int k, int[][] value, boolean[][] visited) {
		
		// 23. We create an ArrayList of Integer arrays that will eventually hold the pairs of 'i' and 'k' that represent values of 1 in the integer matrix, indicating the
		// continuation of a river.
		List<Integer[]> neighbors = new ArrayList<Integer[]>();
		
		// 24. We check the node above our current node (top) to see if the value of 'i' is within the bounds of the matrix AND if it has not been visited in the boolean matrix
		// (indicated by a value of 'false'). If both these conditions evaluate to true... 
		if(i > 0 && !visited[i - 1][k]) {
			
			// ...then we create an Integer array consisting of i - 1 and k and add it to our neighbors 'ArrayList'. From here this process repeats for...
			neighbors.add(new Integer[] {i - 1, k});
		}
		
		// ...the node below our current node (bottom)...
		if(i < value.length - 1 && !visited[i + 1][k]) {
			neighbors.add(new Integer[] {i + 1, k});
		}
		
		// ...the node to the left of our current node...
		if(k > 0 && !visited[i][k - 1]) {
			neighbors.add(new Integer[] {i, k - 1});
		}
		
		// ...and finally for the node to the right of our current node.
		if(k < value[i].length - 1 && !visited[i][k + 1]) {
			neighbors.add(new Integer[] {i, k + 1});
		}
		
		// 25. Once all neighboring nodes have been checked, we return our ArrayList.
		return neighbors;
	}
	

	public static void main(String[] args) {
		int[][] matrix1 = { { 1, 0, 0, 1, 0 }, { 1, 0, 1, 0, 0 }, { 0, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 0 } };
		
		System.out.println(riverSizes(matrix1));
	}

}
