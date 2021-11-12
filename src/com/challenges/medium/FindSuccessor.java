package com.challenges.medium;

import java.util.*;

/*
 * 
	Find Successor
	
	Write a function that takes in a Binary Tree (where nodes have an additional pointer to their parent node) as well as a node contained in the tree and returns the given node's
	successor.
	
	A node's successor is the next node to be visited (immediately after the give node) when traversing its tree using in-order tree-traversal technique. A node has no successor if it's
	the last node to be visited in the in-order traversal.
	
	If a node has no successor, your function should return None/null.
	
	Each BinaryTree has an integer value, a left child node, and a right child node. Children nodes can either be BinaryTree nodes themselves or None/null.
	
	Sample Input:
	
	  tree =	   1
				 /   \
			    2     3
			   / \   
			  4   5  
			 /       
			6       
	
	  node = 5
		
	Sample Output:
	1
	// Thi's tree's in-order traversal is: 6 -> 4 -> 2 -> 5 -> 1 -> 3. 1 comes immediately after the 5.
 * 
 */

public class FindSuccessor {

	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;
		public BinaryTree parent = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	
	public static BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
		
		// 1. We create a variable that will hold the returned ArrayList from our helper function, which takes in our BinaryTree as well as an ArrayList. The helper function
		// performs an in-order traversal (first seen in the BSTTraversal class), adding all the nodes to the ArrayList in the expected order for this traversal method.
		List<BinaryTree> results = findSuccessor(tree, new ArrayList<BinaryTree>());
		
		// 2. We create a variable that will hold the index of where our node is in the ArrayList (if it is not present in the List, the index value will be -1).
		int i = results.indexOf(node);
		
		// 3. We check if i is equal to -1 or i is equal to the last index value in the ArrayList, and if either is true...
		if(i == -1 || i == results.size() - 1) {
			
			// ...we return null since the node is either not present in our ArrayList or the node in question is the final node in the ArrayList and would not have a successor.
			return null;
		
		// 4. Otherwise, if our 'i' is a valid value and isn't the last element... 
		} else {
			
			// ...we return the node directly after it in the ArrayList. We do this because we know that given the nodes in our ArrayList are correctly sorted according to in-order
			// traversal, the successor of our node will be the element directly to its right in the ArrayList.
			return results.get(i + 1);
		}
		
	}
	
	// 5. Check out the 'BSTTraversal' class to get a refresher on how this recursive function works.
	public static List<BinaryTree> findSuccessor(BinaryTree tree, List<BinaryTree> array){
		
		if(tree.left != null) {
			findSuccessor(tree.left, array);
		}
		
		array.add(tree);
	
		if(tree.right != null) {
			findSuccessor(tree.right, array);
		}
		
		return array;
	}

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		BinaryTree n1 = new BinaryTree(2);
		BinaryTree n2 = new BinaryTree(3);
		BinaryTree n3 = new BinaryTree(4);
		BinaryTree n4 = new BinaryTree(5);
		BinaryTree n5 = new BinaryTree(6);
		
		root.left = n1;
		root.right = n2;
		root.left.left = n3;
		root.left.right = n4;
		root.left.left.left = n5;
		
		System.out.println(findSuccessor(root, n4));

	}

}
