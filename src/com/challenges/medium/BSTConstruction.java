package com.challenges.medium;

public class BSTConstruction {

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}

		public BST insert(int value) {
			// Write your code here.
			// Do not edit the return statement of this method.
			return this;
		}

		public boolean contains(int value) {
			// Write your code here.
			return false;
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
