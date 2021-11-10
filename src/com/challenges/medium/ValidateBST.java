package com.challenges.medium;

/*
 * 
	Validate BST
	
	Write a function that takes in a potentially invalid Binary Search Tree (BST) and returns a boolean representing whether the BST is valid.
	
	Each BST node has an integer value, a left child node, and a right child node. A node is said to be a valid BST node if and only if it satisfies the BST property: its value is 
	strictly greater than the values of every node to its left; its value is less than or equal to the values of every node to its right; and its children nodes are either valid BST
	nodes themselves or None/null.
	
	A BST is valid if and only if all of its nodes are valid BST nodes.
	
	Sample Input: 
	
		tree =	   10
				 /    \
			    5      15
			   /  \   /  \
			  2    5 13   22
			 /        \
			1         14 
			
	Sample Output:
	true
 * 
 */

public class ValidateBST {

	public static boolean validateBst(BST tree) {

		return validateBstNode(tree, Integer.MIN_VALUE, Integer.MAX_VALUE); 
		
	}
	
	public static boolean validateBstNode(BST tree, int min, int max) {
		
		if(tree.value < min || tree.value >= max) {
			return false;
		} 
		
		if(tree.left != null && !validateBstNode(tree.left, min, tree.value)) {
			return false;
		}
		
		if(tree.right != null && !validateBstNode(tree.right, tree.value, max)) {
			return false;
		}
		
		return true;
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
		BST n5 = new BST(13);
		BST n6 = new BST(22);
		BST n7 = new BST(1);
		BST n8 = new BST(14);
		
		root.left = n1;
		root.right = n2;
		root.left.left = n3;
		root.left.right = n4;
		root.right.left = n5;
		root.right.right = n6;
		root.left.left.left = n7;
		root.right.left.right = n8;

		
		System.out.println(validateBst(root));
	}

}
