package com.challenges.medium;

/*
 * 
	BST Construction
	
	Write a BST class for a Binary Search Tree. The class should support:
		� Inserting values with an 'insert' method
		� Removing values with the 'remove' method: this method should only remove the first instance of a given value
		� Searching for values with the 'contains' method
		
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

			if (value < this.value) {
				if (left == null) {
					BST newBST = new BST(value);
					left = newBST;
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					BST newBST = new BST(value);
					right = newBST;
				} else {
					right.insert(value);
				}
			}
			
			return this;
		}

		public boolean contains(int value) {

			if (value < this.value) {
				if (left == null) {
					return false;
				} else {
					return left.contains(value);
				}
			} else if (value > this.value) {
				if (right == null) {
					return false;
				} else {
					return right.contains(value);
				}
			} else {
				return true;
			}

		}

		public BST remove(int value) {
			remove(value, null);
			return this;
		}

		public void remove(int value, BST parent) {

			if (value < this.value) {
				if (left != null) {
					left.remove(value, this);
				}
			} else if (value > this.value) {
				if (right != null) {
					right.remove(value, this);
				}
			} else {
				if (left != null && right != null) {
					this.value = right.getMinValue();
					right.remove(this.value, this);
				} else if (parent == null) {
					if (left != null) {
						this.value = left.value;
						right = left.right;
						left = left.left;
					} else if (right != null) {
						this.value = right.value;
						right = right.right;
						left = right.left;
					} else {

					}
				} else if (parent.left == this) {
					parent.left = left != null ? left : right;
				} else if (parent.right == this) {
					parent.right = left != null ? left : right;
				}
			}
		}

		public int getMinValue() {
			if (left == null) {
				return this.value;
			} else {
				return left.getMinValue();
			}
		}
	}

}
