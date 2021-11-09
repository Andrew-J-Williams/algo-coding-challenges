package com.challenges.medium;

/*
 * 
	BST Construction
	
	Write a BST class for a Binary Search Tree. The class should support:
		• Inserting values with an 'insert' method
		• Removing values with the 'remove' method: this method should only remove the first instance of a given value
		• Searching for values with the 'contains' method
		
	Note that you can't remove values from a single-node tree. In other words, calling the remove method on a single-node tree should simply not do anything.
	
	Each BST node has an integer 'value', a 'left' child node, and a 'right' child node. A node is said to be a valid BST node if and only if it satisfies the BST property: its value
	is strictly greater than the values of every node to its left, its value is less than or equal to the values of every node to its right; and its children nodes are either valid BST
	nodes themselves or None/null.
	
	Sample Usage:
	
	// Assume the following BST has already been created:
		
				   10
				 /    \
			    5      15
			   /  \   /  \
			  2    5 13   22
			 /        \
			1         14
	
	// All operations below are performed sequentially.
	
	insert(12):    10
				 /    \
			    5      15
			   /  \   /  \
			  2    5 13   22
			 /      /  \
			1      12  14
			
	insert(10):    12
				 /    \
			    5      15
			   /  \   /  \
			  2    5 13   22
			 /        \
			1         14
			
	contains(15): true

 * 
 */

public class BSTConstruction {

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}

		public BST insert(int value) {

			if(value < this.value){
				if(left == null){
					BST newBST = new BST(value);
					left = newBST;
				} else {
					left.insert(value);
				}
			} else {
				if(right == null){
					BST newBST = new BST(value);
					right = newBST;
				} else {
					right.insert(value);
				}
			}
			
			// Do not edit the return statement of this method.
			return this;
		}

		public boolean contains(int value) {

			if(value < this.value){
				if(left == null){
					return false;
				} else {
					return left.contains(value);
				}
			} else if (value > this.value){
				if(right == null){
					return false;
				} else {
					return right.contains(value);
				}
			} else {
				return true;
			}
			
		}

		public BST remove(int value) {
			// Write your code here.
			// Do not edit the return statement of this method.
			return this;
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

	}

}
