package com.challenges.easy;

import java.util.ArrayList;
import java.util.List;

/*
 * 
	Depth-first Search
	
	You're given a Node class that has a name and an array of optional children nodes. When put together, nodes form an acyclic tree-like structure.
	
	Implement the depthFirstSearch method on the Node class, which takes in an empty array, traverse the tree using a Depth-first Search approach (specifically navigating the tree from
	left to right), stores all the nodes' names in the input array, and returns it.
	
	Sample Input:
	
			graph = A
			 	 /  |  \
			 	B   C   D
			   / \     / \
			  E   F   G   H
			  	 / \   \
                I   J   K
                
 	Sample Output:
 	[ "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K" ]
 * 
 * 
 */


public class DepthFirstSearch {

	// Do not edit the class below except
	// for the depthFirstSearch method.
	// Feel free to add new properties
	// and methods to the class.
	static class Node {
		String name;
		List<Node> children = new ArrayList<Node>();

		public Node(String name) {
			this.name = name;
		}

		public List<String> depthFirstSearch(List<String> array) {
			array.add(this.name);

			for (int i = 0; i < children.size(); i++) {
				children.get(i).depthFirstSearch(array);
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
		// TODO Auto-generated method stub

	}

}
