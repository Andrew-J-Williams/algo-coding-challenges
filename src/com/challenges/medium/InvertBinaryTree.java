package com.challenges.medium;

import com.challenges.medium.BSTTraversal.BST;

/*
 * 
	Invert Binary Tree
	
	Write a function that takes in a Binary Tree and inverts it. In other words, the function should swap every left node in the tree for its corresponding right node.
	
	Each BinaryTree has an integer value, a left child node, and a right child node. Children nodes can either be BinaryTree nodes themselves or None/null.
	
	Sample Input:
	
	  tree =	   1
				 /   \
			    2     3
			   / \   / \
			  4   5 6   7  
			 / \       
			8   9
	
	Sample Output:
	
	        	   1
				 /   \
			    3     2
			   / \   / \
			  7   6 5   4  
			 		   / \       
					  9   8
	
 * 
 */

public class InvertBinaryTree {

	public static void invertBinaryTree(BinaryTree tree) {
		// Write your code here.
	}

	static class BinaryTree {
		public int value;
		public BinaryTree left;
		public BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		BinaryTree n1 = new BinaryTree(2);
		BinaryTree n2 = new BinaryTree(3);
		BinaryTree n3 = new BinaryTree(4);
		BinaryTree n4 = new BinaryTree(5);
		BinaryTree n5 = new BinaryTree(6);
		BinaryTree n6 = new BinaryTree(7);
		BinaryTree n7 = new BinaryTree(8);
		BinaryTree n8 = new BinaryTree(9);
		
		root.left = n1;
		root.right = n2;
		root.left.left = n3;
		root.left.right = n4;
		root.right.left = n5;
		root.right.right = n6;
		root.left.left.left = n7;
		root.left.left.right = n8;
	
		invertBinaryTree(root);
	}

}
