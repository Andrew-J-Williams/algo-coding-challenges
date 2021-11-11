package com.challenges.medium;


import java.util.*;

/*
 * 
	Find Kth Largest Value in BST
	
	Write a function that takes in a Binary Search Tree (BST) and a positive integer 'k' and returns the kth largest integer contained in the BST.
	
	You can assume that there will only be integer values in the BST and that k is less than or equal to the number of nodes in the tree.
	
	Also, for the purpose of this question, duplicate integers will be treated as distinct values. In other words, the second largest value in a BST containing values { 5, 7, 7 } will be
	7 - not 5.
	
	Each BST node has an integer 'value', a 'left' child node, and a 'right' child node. A node is said to be a valid BST node if and only if it satisfies the BST property: its value is 
	strictly greater than the values of every node to its left; its value is less than or equal to the values of every node to its right; and its children nodes are either valid BST
	nodes themselves or None/null.
	
	Sample Input:
	
	  tree =	   10
				 /    \
			    5      15
			   /  \   /  \
			  2    5 17   22
			 / \       
			1   3
			
	  k = 3
	  
	
	Sample Output:
	17
	
 * 
 */

public class KthLargestValueBST {

	static class BST {
		public int value;
		public BST left = null;
		public BST right = null;

		public BST(int value) {
			this.value = value;
		}
	}

	public static int findKthLargestValueInBst(BST tree, int k) {

		List<Integer> array = new ArrayList<>();
		
		List<Integer> sorted = searchTree(tree, array, k);
		
		if(sorted.get(k-1) != null) {
			return sorted.get(k-1);
		}
		
		return -1;
	}
	
	public static List<Integer> searchTree(BST tree, List<Integer> array, int k){
		
		if(tree.right != null) {
			searchTree(tree.right, array, k);
		}
		
		array.add(tree.value);
		
		if(tree.left != null) {
			searchTree(tree.left, array, k);
		}
		
		return array;
	}

	public static void main(String[] args) {
		BST root = new BST(15);
		BST n1 = new BST(5);
		BST n2 = new BST(20);
		BST n3 = new BST(2);
		BST n4 = new BST(5);
		BST n5 = new BST(17);
		BST n6 = new BST(22);
		BST n7 = new BST(1);
		BST n8 = new BST(8);
		
		
		root.left = n1;
		root.right = n2;
		root.left.left = n3;
		root.left.right = n4;
		root.right.left = n5;
		root.right.right = n6;
		root.left.left.left = n7;
		root.left.left.right = n8;
		
		System.out.println(findKthLargestValueInBst(root, 3));

	}

}
