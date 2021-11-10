package com.challenges.medium;

import java.util.*;

import com.challenges.medium.ValidateBST.BST;

/*
 * 
	BST Traversal
	
	Write three functions that take in a Binary Search Tree (BST) and an empty array, traverse that BST, add its nodes' values to the input array, and return that array. The three
	functions should traverse the BST using the in-order, pre-order, and post-order tree-traversal techniques, respectively.
	
	Each BST node has an integer 'value', a 'left' child node, and a 'right' child node. A node is said to be a valid BST node if and only if it satisfies the BST property: its value is 
	strictly greater than the values of every node to its left; its value is less than or equal to the values of every node to its right; and its children nodes are either valid BST
	nodes themselves or None/null. 
	
	In-Order traversal wants us to traverse the BST in numerical order, just like if we were sorting it in ascending order. We always look at the left node first, the current node, and
	then the right node. When we are at a given node, we want to traverse from left to right. 
	
	A Pre-Order traversal 
	
	Sample Input:
	
	   tree =	   10
				 /    \
			    5      15
			   /  \      \
			  2    5      22
			 /        
			1     
			
	   array = []
	   
	   
	Sample Output:
	inOrderTraverse: [ 1, 2, 5, 5, 10, 15, 22 ]
	preOrderTraverse: [ 10, 5, 2, 1, 5, 15, 22 ]
	postOrderTraverse: [ 1, 2, 5, 5, 22, 15, 10 ]
	
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
		BST root = new BST(10);
		BST n1 = new BST(5);
		BST n2 = new BST(15);
		BST n3 = new BST(2);
		BST n4 = new BST(5);
		BST n6 = new BST(22);
		BST n7 = new BST(1);
		
		
		root.left = n1;
		root.right = n2;
		root.left.left = n3;
		root.left.right = n4;
		root.right.right = n6;
		root.left.left.left = n7;

	}

}
