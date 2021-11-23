package com.challenges.medium;

import java.util.*;

/*
 * 
	Cycle In Graph
	
	You're given a list of edges representing an unweighted, directed graph with at least one node. Write a function that
	returns a boolean representing whether the given graph contains a cycle.
	
	For the purpose of this question, a cycle is defined as any number of vertices, including just one vertex, that are
	connected in a closed chain. A cycle can also be defined as a chain of at least one vertex in which the first vertex
	is the same as the last.
	
	The given list is what's called an adjacency list, and it represents the graph. The number of vertices in the graph
	is equal to the length of the edge, where each index i in edges contains vertex 'i's outbound edges, in no particular
	order. Each individual edge is represented by a positive integer that denotes an index (a destination vertex) in the
	list that this vertex is connected to. Note that these edges are directed, meaning that you can only travel from a
	particular vertex to its destination, not the other way around (unless the destination vertex itself has an outbound
	edge to the original vertex).
	
	Also note that this graph may contain self-loops. A self-loop is an edge that has the same destination and origin; in
	other words, it's an edge that connects a vertex to itself. For the purpose of this question, a self-loop is considered
 	a cycle.
 	
 	Sample Input:
 	edges = [
 		[1, 3],
 		[2, 3, 4],
 		[0],
 		[],
 		[2, 5],
 		[]
 	]
 	
 	Sample Output:
 	true
 	(There are multiple cycles in this graph:
 		1) 0 -> 1 -> 2 -> 0
 		2) 0 -> 1 -> 4 -> 2 -> 0
 		3) 1 -> 2 -> 0 -> 1
 	These are just 3 examples; there are more)
 	
 * 
 */

public class CycleInGraph {

	public static boolean cycleInGraph(int[][] edges) {

		// 1. We create two boolean arrays: (1) 'visited' that will represent the nodes that have been already traversed and (2) 'inStack' which represents the elements in the recursive stack.
		boolean[] visited = new boolean[edges.length];
		boolean[] inStack = new boolean[edges.length];
		
		// 2. Create a 'for' loop that will run the length of our 'edges' matrix.
		for(int i = 0; i < edges.length; i++) {
			
			// 3. We check and see if at index 'i' in our 'visited' array the value is equal to true. If it is, it indicates we have already checked this element. As a result...
			if(visited[i]) {
				
				// ...we continue on to the next element in the array.
				continue;
			}
			
			// 4. Once we reach a value in 'visited' that returns false, then we know we haven't check it in 'edges' yet, thus we create a boolean variable called 'containsCycle' that will be 
			// equal to the result of our helper method 'nodesInCycle', which checks to see if there is a cycle given the element in question.
			boolean containsCycle = nodeIsInCycle(i, edges, visited, inStack);
			
			// 5. If the value of 'containsCycle' is true, then our helper function was able to find a cycle given the element. As a result...
			if(containsCycle) {
				
				// ...we return true.
				return true;
			}
			
		}
		
		// 6. If we have covered all the elements in our matrix and 'containsCycle' never comes back as true, we know we did not find a cycle. As a result, we return false if the loop finishes.
		return false;
	}
	
	// 7. Our helper function, 'nodesInCyle', takes in 4 parameters: the index 'i', our edges matrix, our visited array, and our inStack array.
	public static boolean nodeIsInCycle(int i, int[][] edges, boolean[] visited, boolean[] inStack) {
		
		// 8. For both Boolean arrays, we set the value at index 'i' equal to true to indicate we've visited it as well as added it to our recursion stack. 
		visited[i] = true;
		inStack[i] = true;
		
		// 9. We create a boolean variable that will represent whether or not a cycle is found with our elements and initialize it to false (since we have just started to check).
		boolean containsCycle = false;
		
		// 10. We create an integer array called 'neighbors' and set it equal to the array found at index 'i' in edges.
		int[] neighbors = edges[i];
		
		// 11. We create a 'for' loop that will iterate over every element in the 'neighbors' array..
		for(int neighbor : neighbors) {
			
			System.out.println("Neighbor: " + neighbor);
			System.out.println("Visited[neighbor]: " + visited[neighbor]);
			
			// 12. If the given element we are checking is not found in our 'visited' array...
			if(!visited[neighbor]) {
				
				// ...we call our helper function recursively and pass in the element in place of 'i'. The result becomes the value of 'containsCycle'. 
				containsCycle = nodeIsInCycle(neighbor, edges, visited, inStack);
			}
			
			// 13. Whether or not the conditional is executed, we check the value of 'containsCycle' to see if it is true, if it is...
			if(containsCycle) {
				
				// ...we return true to indicate a cycle has been found.
				return true;
			
			// 14. If containsCycle is not true, we then check and see if the value at the index 'neighbor' is true, and if it is...	
			} else if(inStack[neighbor]) {
				
				// ...we return true since if that element exists in our recursion stack, it has been visited since we started executing our helper method, indicating a cycle is present.
				return true;
			}
			
		}
		
		// 15. If we irate through all elements in our 'neighbors' array and nothing comes back true, we have failed to find a cycle in the array at 'i' in edges. As a result, we will set
		// the value at 'i' in the stack equal to false and return false.
		inStack[i] = false;
		return false;
	}
	


	public static void main(String[] args) {
		int[][] edges1 = { {1, 3}, {2, 3, 4}, {0}, {}, {2, 5}, {} };
		
		System.out.println(cycleInGraph(edges1));

	}

}
