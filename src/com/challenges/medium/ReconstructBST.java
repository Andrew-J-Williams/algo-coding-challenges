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

	  public static BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
	    // Write your code here.
	    return null;
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
