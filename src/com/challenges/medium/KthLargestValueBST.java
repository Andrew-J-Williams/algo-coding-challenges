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

		// 1. We define an ArrayList that will hold our node values in the BST.
		List<Integer> array = new ArrayList<>();
		
		// 2. We call our helper method 'searchTree', which is designed to traverse our BST is descending order and add each node value to the ArrayList. As a result, our array will
		// become populated.
		searchTree(tree, array);
		
		// 3. We return the value of our ArrayList at the index of k-1, since the ArrayList begins with an index of 0.
		return array.get(k-1);
	}
	
	// 4. Our helper method, 'searchTree', takes in a BST node as well as an ArrayList of Integers. This method is also recursive since it calls itself within its own code.
	public static void searchTree(BST tree, List<Integer> array){
	
		// 5. We check and see if the current node is equal to null. If it is, we know that we have reached the end of a branch on the subtree. As a result, we simply use return to 
		// exit the function.
		if(tree == null) return;
		
		// 6. We call our 'searchTree' method on the right child node and the ArrayList. In doing this, if we are starting from the root, the function will work its way down to the
		// right-most child node on the right subtree. Once the children node of that parent node come back as null, the logic advances.
		searchTree(tree.right, array);
		
		// 7. We add the value of the current node to our ArrayList.
		array.add(tree.value);
		
		// 8. Finally, we call the method again on the left child node and the ArrayList. If the left child node isn't null, we repeat the previous logic and check for the values of the
		// right and parent nodes. But once the left and right child node equals null, we know we've reached the end of that branch in the subtree and add its value to the ArrayList. 
		// The program is essentially the inverse of in-order traversal (learned in a previous challenge), so we the order of node values added is as follows: right -> parent -> left.
		searchTree(tree.left, array);
		
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
