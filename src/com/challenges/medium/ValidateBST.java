package com.challenges.medium;

/*
 * 
	Validate BST
	
	Write a function that takes in a potentially invalid Binary Search Tree (BST) and returns a boolean representing whether the BST is valid.
	
	Each BST node has an integer value, a left child node, and a right child node. A node is said to be a valid BST node if and only if it satisfies the BST property: its value is 
	strictly greater than the values of every node to its left; its value is less than or equal to the values of every node to its right; and its children nodes are either valid BST
	nodes themselves or None/null.
	
	A BST is valid if and only if all of its nodes are valid BST nodes.
	
	Sample Input: 
	
		tree =	   10
				 /    \
			    5      15
			   /  \   /  \
			  2    5 13   22
			 /        \
			1         14 
			
	Sample Output:
	true
 * 
 */

public class ValidateBST {

	public static boolean validateBst(BST tree) {
		
		// 1. We return the result of our helper function 'validateBstNode', which is a recursive function returning a boolean value.
		return validateBstNode(tree, Integer.MIN_VALUE, Integer.MAX_VALUE); 
		
	}
	
	// 2. Our helper function takes in 3 parameters: our current node, a minimum value, and a maximum value;
	public static boolean validateBstNode(BST tree, int min, int max) {
		
		// 3. We check and see if the value of the current node is either less than the minimum value or greater than or equal to the maximum value. If either is the case, we know that
		// our BST is invalid because given the nature of a valid tree, no node should have a value less than its left child node's value (which the minimum value represents) or greater
		// than or equal to its right child node's value (represented by our maximum value). If either situation is true...
		if(tree.value < min || tree.value >= max) {
			
			// ...we return false, indicating our BST is invalid.
			return false;
		} 
		
		// 4. If our left child node isn't null AND the result of 'validateBstNode' for that left child node returns false, then we also know our BST is invalid. Following the logic
		// previously stated, when we run our function recursively, using our left child node as the new current node, we also replace our previous max value with our current node's
		// value. We do this because given a valid BST, the parent node will ALWAYS be greater than its left child node. If the left child node is greater than its parent, the helper
		// function will promptly return false, satisfying the conditions of the 'if' statement. In the event conditions are true...
		if(tree.left != null && !validateBstNode(tree.left, min, tree.value)) {
			
			// ...we return false.
			return false;
		}
		
		// 5. If our right child node is not null AND the result of 'validateBstNode' for that right child node returns false, then we also know our BST is invalid. Following the same
		// process as our conditional for the left child node, when we call our helper method on the right child node, we set the minimum value equal to the current node's value because
		// in a valid BST the parent's value should always be less than its right child node's value. So if both conditions are true in the 'if' statement...
		if(tree.right != null && !validateBstNode(tree.right, tree.value, max)) {
			
			// ...we return false.
			return false;
		}
		
		// 6. If none of the conditions are true for the previous 3 'if' statements, then we know we have checked the entirety of the BST and found no invalidity. So as a result, we will
		// return 'true' to indicate the entire BST is valid.
		return true;
	}
	

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
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

		
		System.out.println(validateBst(root));
	}

}
