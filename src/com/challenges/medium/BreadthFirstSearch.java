package com.challenges.medium;

import java.util.*;

/*
 * 
	Breadth-first Search
	
	You're given a Node class that has a name and an array of optional children. When put together, nodes form an acyclic tree-like structure.
	
	Implement the breadthFirstSearch method on the Node class, which takes in an empty array, traverses the tree using the Breadth-first Search approach (specifically navigating
	the tree from left to right), stores all of the nodes' names in the input array, and returns it.
	
	Sample Input:
	
		graph = A
			  / | \	
		     B  C  D
		    / \   / \
		   E   F G   H
		      / \ \
		     I   J K
	
	Sample Output:
	[ "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K" ]
 * 
 */

public class BreadthFirstSearch {

	static class Node {
		String name;
		List<Node> children = new ArrayList<Node>();

		public Node(String name) {
			this.name = name;
		}

		public List<String> breadthFirstSearch(List<String> array) {
			
			// 1. We create a queue that will hold various number of nodes as we traverse through our graph.
			Queue<Node> queue = new LinkedList<Node>();
			
			// 2. We add the first node in our graph ("A") to the queue, making it non-empty.
			queue.add(this);
			
			// 3. We create a 'while' loop that runs as long as our queue is not empty. Given the fact that our tree should always have a root node, this loop will execute at least
			// once.
			while(!queue.isEmpty()) {
				
				// 4. We create a node and set it equal to the first element we pull from the top of our queue. In the case of our example data, we would be removing "A".
				Node current = queue.poll();
				
				// 5. We then add the name of this node to our ArrayList. Thus, with our example the ArrayList would look like: [ "A" ]. The queue would look like: [ ]. If our
				// current node doesn't have any children, then nothing is added.
				array.add(current.name);
				
				// 6. We add all the children from the current node (which would be an ArrayList of nodes) to our queue, preventing our queue from being empty and keeping the loop
				// running until we reach the end of our graph. So before the next loop, our ArrayList would look like [ "A" ] and our queue would look like [ "B", "C", "D" ].
				queue.addAll(current.children);
			}
			
			// 7. Once our queue is empty, indicating all nodes in the graph have been traversed, we return our ArrayList of node names.
			return array;
		}

		public Node addChild(String name) {
			Node child = new Node(name);
			children.add(child);
			return this;
		}
	}

	public static void main(String[] args) {
		// See AlgoExpert
	}

}
