package com.challenges.easy;

/*
 * 
	Find Closest Value in BST
	
	Write a function that takes in a Binary Search Tree (BST) and a target integer value and returns the closest value to that target value contained in the BST.
	
	You can assume that there will only be one closest value.
	
	Each BST node has an integer value, a left child node, and a right child node. A node is said to be a valid BST node if and only if it satisfies the BST property: its
	value is strictly greater than the values of every node to its left; its value is less than or equal to the values of every node to its right; and its children nodes are
	either valid BST nodes
	
	Sample Input:
	
			tree = 10
				 /    \
			    5      15
			   /  \   /  \
			  2    5 13   22
			 /        \
			1         14
			
		target = 12
		
	
	Sample Output:
	13
 * 
 */

public class ClosestValueInBST {

	public static int findClosestValueInBst(BST tree, int target) {
		// Write your code here.
		return -1;
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}
		
		public void printBST() {
			System.out.println(value);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BST root = new BST(10);
		BST n1 = new BST(5);
	}

}
