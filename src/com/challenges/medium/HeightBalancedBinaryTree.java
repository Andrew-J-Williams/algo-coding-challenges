package com.challenges.medium;

public class HeightBalancedBinaryTree {

	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	public static boolean heightBalancedBinaryTree(BinaryTree tree) {
		// Write your code here.
		return false;
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
