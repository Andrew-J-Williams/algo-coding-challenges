package com.challenges.medium;

/*
 * 
	BinaryTreeDiameter
	
	Write a function that takes in a Binary Tree and returns its diameter. The diameter of a binary tree is defined as the length of its longest path, even if that path doesn't pass
	through the root of the tree.
	
	A path is a collection of connected nodes in a tree, where no node is connected to more than two other nodes. The length of a path is the number of edges between the path's first
	node and its last node.
	
	Each BinaryTree has an integer value, a left child node, and a right child node. Children nodes can either be BinaryTree nodes themselves or None/null.
	
	Sample Input:
	
	  tree =	   1
				 /   \
			    3     2
			   / \   
			  7   4  
			 /     \  
			8       5
		   /         \
		  9           6    
	
	Sample Output:
	6 // There are 6 edges between the first node and the last node of this tree's longest path.
 * 
 */

public class BinaryTreeDiameter {

	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	public int binaryTreeDiameter(BinaryTree tree) {
		// Write your code here.
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
