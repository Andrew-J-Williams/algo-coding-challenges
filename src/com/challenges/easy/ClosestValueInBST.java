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
		
		return findClosestValueInBstHelper(tree, target, tree.value);
	}
	
	public static int findClosestValueInBstHelper(BST tree, int target, int closest) {
		
		if (Math.abs(target - closest) > Math.abs(target - tree.value)){
			closest = tree.value; 
		}
		
		if(target < tree.value && tree.left != null){
			return findClosestValueInBstHelper(tree.left, target, closest);
		} else if (target > tree.value && tree.right != null) {
			return findClosestValueInBstHelper(tree.right, target, closest);
		} else {
			return closest;
		}
		
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
		
		int targetVal = 12;
		
		System.out.println(findClosestValueInBst(root, targetVal));
		
	}

}
