package com.challenges.medium;

import com.challenges.medium.BinaryTreeDiameter.BinaryTree;

public class FindSuccessor {

	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;
		public BinaryTree parent = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	public static BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
		// Write your code here.
		return null;
	}

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		BinaryTree n1 = new BinaryTree(2);
		BinaryTree n2 = new BinaryTree(3);
		BinaryTree n3 = new BinaryTree(4);
		BinaryTree n4 = new BinaryTree(5);
		BinaryTree n5 = new BinaryTree(6);
		
		root.left = n1;
		root.right = n2;
		root.left.left = n3;
		root.left.right = n4;
		root.left.left.left = n5;
		
		System.out.println(findSuccessor(root, n4));

	}

}
