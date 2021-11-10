package com.challenges.medium;

import java.util.*;

/*
 * 
	BST Traversal
	
	Write three functions that take in a Binary Search Tree (BST) and an empty array, traverse that BST, add its nodes' values to the input array, and return that array. The three
	functions should traverse the BST using the in-order, pre-order, and post-order tree-traversal techniques, respectively.
	
	Each BST node has an integer 'value', a 'left' child node, and a 'right' child node. A node is said to be a valid BST node if and only if it satisfies the BST property: its value is 
	strictly greater than the values of every node to its left; its value is less than or equal to the values of every node to its right; and its children nodes are either valid BST
	nodes themselves or None/null. 
 * 
 */

public class BSTTraversal {

	public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
		// Write your code here.
		return new ArrayList<Integer>();
	}

	public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
		// Write your code here.
		return new ArrayList<Integer>();
	}

	public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
		// Write your code here.
		return new ArrayList<Integer>();
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
