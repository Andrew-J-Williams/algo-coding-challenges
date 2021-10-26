package com.challenges.easy;

/*
 * 
	Node Depths
	
	The distance between a node in a Binary Tree and the tree's root is called the node's depth.
	
	Write a function that takes in a Binary Tree and returns the sums of its nodes' depths.
	
	Each BinaryTree has an integer value, a left child node, and a right child node. Children nodes can either be BinaryTree nodes themselves or equal to None/null.
 * 
 */

public class NodeDepths {

	public static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		BinaryTree(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	public static int nodeDepths(BinaryTree root) {
		// Write your code here.
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		System.out.println(nodeDepths(root));
	}

}
