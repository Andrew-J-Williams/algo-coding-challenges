package com.challenges.medium;

import java.util.*;

/*
 * 
	Reconstruct BST
	
	The pre-order traversal of a Binary Tree is a traversal technique that starts at the tree's root node and visits nodes in the following order:
		1. Current node
		2. Left node
		3. Right node
	
	Given a non-empty array of integers representing the pre-order traversal of a Binary Search Tree (BST), write a function that creates the relevant BST and returns its root node.
	
	The input array will contain the value of BST nodes in the order in which these nodes would be visited with pre-order traversal.
	
	Each BST node has an integer 'value', a 'left' child node, and a 'right' child node. A node is said to be a valid BST node if and only if it satisfies the BST property: its value is 
	strictly greater than the values of every node to its left; its value is less than or equal to the values of every node to its right; and its children nodes are either valid BST
	nodes themselves or None/null.
	
	Sample Input:
	array = [ 10, 4, 2, 1, 5, 17, 19, 18 ]
	
	Sample Output:
	
				   10
				 /    \
			    4      17
			   / \      \
			  2   5      19
			 /       	 /
			1           18
 * 
 */

public class ReconstructBST {

	static class BST {
		public int value;
		public BST left = null;
		public BST right = null;

		public BST(int value) {
			this.value = value;
		}
	}

	public static BST reconstructBst(List<Integer> preOrderTraversalValues) {
		
		// 1. We check and see if the size of our ArrayList is equal to 0. If it is...
		if(preOrderTraversalValues.size() == 0) {
			
			// ...we return null since there are no values to iterate over.
			return null;
		}
		
		int current = preOrderTraversalValues.get(0);
		int rightSubtreeRootIdx = preOrderTraversalValues.size();
		
		for(int i = 1; i < preOrderTraversalValues.size(); i++) {
			
			int value = preOrderTraversalValues.get(i);
			
			if(value >= current) {
				rightSubtreeRootIdx = i;
				break;
			}
		}
		
		BST leftSubtree = reconstructBst(preOrderTraversalValues.subList(1, rightSubtreeRootIdx));
		
		BST rightSubtree = reconstructBst(preOrderTraversalValues.subList(rightSubtreeRootIdx, preOrderTraversalValues.size()));
		
		BST bst = new BST(current);
		
		bst.left = leftSubtree;
		bst.right = rightSubtree;
		
		return bst;
	}
	

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>();

		array.add(10);
		array.add(4);
		array.add(2);
		array.add(1);
		array.add(5);
		array.add(17);
		array.add(19);
		array.add(18);

		System.out.println(reconstructBst(array));

	}

}
