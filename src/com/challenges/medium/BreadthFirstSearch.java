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
			
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(this);
			
			while(!queue.isEmpty()) {
				Node current = queue.poll();
				array.add(current.name);
				queue.addAll(current.children);
			}
			
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
