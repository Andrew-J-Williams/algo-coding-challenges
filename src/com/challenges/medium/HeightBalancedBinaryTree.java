package com.challenges.medium;

/*
 * 
 	Height Balanced Binary Tree
 	
	You're given the root node of a Binary Tree. Write a function that returns 'true' if this Binary Tree is height balanced and 'false' if it isn't.
	
	A Binary Tree is height balanced if for each node in the tree, the difference between the height of its left subtree and the height of its right subtree is at most 1.
	
	Each BinaryTree has an integer value, a left child node, and a right child node. Children nodes can either be BinaryTree nodes themselves or None/null.
	
	Sample Input:
	
		tree =	   1
				 /   \
			    2     3
			   / \     \
			  4   5     6
			     / \  
			    7   8
			    
	Sample Output: 
	true
		 
 * 
 */

public class HeightBalancedBinaryTree {

	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}
	
	static class TreeInfo {
		
		public int height;
		public boolean balanced;
		
		public TreeInfo(int height, boolean balanced) {
			this.height = height;
			this.balanced = balanced;
		}
		
	}

	public static boolean heightBalancedBinaryTree(BinaryTree tree) {
				
		return checkHeight(tree).balanced;
		
	}
	
	public static TreeInfo checkHeight(BinaryTree tree) {
		
		if(tree == null) {
			return new TreeInfo(0, true);
		}
		
		TreeInfo left = checkHeight(tree.left);
		TreeInfo right = checkHeight(tree.right);
		
		int difference = Math.abs(left.height - right.height);
		
		boolean balanced = left.balanced && right.balanced;
		
		if(difference > 1 || !balanced) {
			balanced = false;
		} else {
			balanced = true;
		}
		
		int currentHeight = 1 + (Math.max(left.height, right.height));
		
		return new TreeInfo(currentHeight, balanced);
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
		
		root.left = n1;
		root.right = n2;
		root.left.left = n3;
		root.left.right = n4;
		root.right.right = n5;
		root.left.right.left = n6;
		root.left.right.right = n7;

		
		System.out.println(heightBalancedBinaryTree(root));
	}
}
