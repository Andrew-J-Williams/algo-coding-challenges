package com.challenges.medium;

/*
 * 
	Find Kth Largest Value in BST
	
	Write a function that takes in a Binary Search Tree (BST) and a positive integer 'k' and returns the kth largest integer contained in the BST.
	
	You can assume that there will only be integer values in the BST and that k is less than or equal to the number of nodes in the tree.
	
	Also, for the purpose of this question, duplicate integers will be treated as distinct values. In other words, the second largest value in a BST containing values { 5, 7, 7 } will be
	7 - not 5.
	
	Each BST node has an integer 'value', a 'left' child node, and a 'right' child node. A node is said to be a valid BST node if and only if it satisfies the BST property: its value is 
	strictly greater than the values of every node to its left; its value is less than or equal to the values of every node to its right; and its children nodes are either valid BST
	nodes themselves or None/null.
	
	Sample Input:
	
	  tree =	   10
				 /    \
			    5      15
			   /  \   /  \
			  2    5 17   22
			 / \       
			1   3
			
	  k = 3
	  
	
	Sample Output:
	17
	
 * 
 */

public class KthLargestValueBST {

	static class BST {
		public int value;
		public BST left = null;
		public BST right = null;

		public BST(int value) {
			this.value = value;
		}
	}

	public int findKthLargestValueInBst(BST tree, int k) {
		// Write your code here.
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
