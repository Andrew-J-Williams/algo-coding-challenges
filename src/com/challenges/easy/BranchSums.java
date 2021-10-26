package com.challenges.easy;

import java.util.ArrayList;
import java.util.List;

/*
 * 
	Branch Sums
	
	Write a function that takes in a Binary Tree and returns a list of its branch sums ordered from leftmost branch to rightmost branch sum.
	
	A branch sum is the sum of all values in a Binary Tree branch. A Binary Tree branch is a path of nodes in a tree that starts at the root node and ends at any leaf node.
	
	Each 'BinaryTree' node has an integer value, a left child node, and a right child node. Children nodes can either be'BinaryTree' nodes themselves or 'None/null'.
	
	Sample Input:
	
			tree =  1
				 /    \
			    2      3
			   /  \   /  \
			  4    5 6    7
			 / \  /
			8   9 10
			
	Sample Output:
	[15, 16, 18, 10, 11]
 * 
 */

public class BranchSums {

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
	
	// 1. We create our recursive function that will call itself in order to work through all the nodes in the tree. It takes in the current node, the running sum, and an array of sums.
	public static void calculateBranchSums(BinaryTree node, int runningSum, List<Integer> sums) {

		// 2. If the value of the node is null, we simply return the function. This will simply return back our array of sums.
		if (node == null) {
			return;
		}
		
		// 3. We create a variable to hold the value of our running sum plus the value of the current node.
		int newRunningSum = runningSum + node.value;

		// 4. If this node is a leaf node, meaning it is the end of the branch, we add the sum to the sums array and return the function, effectively accounting for that branch sum.
		if (node.left == null && node.right == null) {
			sums.add(newRunningSum);
			return;
		}

		// 5. If there is additional nodes, we account for either a left or right by calling our recursive function on both, repeating the process until all leaf nodes are accounted for.
		calculateBranchSums(node.left, newRunningSum, sums);
		calculateBranchSums(node.right, newRunningSum, sums);
	}

	// 6. Within the main function, we take in the root of a tree...
	public static List<Integer> branchSums(BinaryTree root) {

		// ...define an ArrayList called sums that will store all the branch sums...
		List<Integer> sums = new ArrayList<Integer>();
		
		// ...run our recursive function with our initial values...
		calculateBranchSums(root, 0, sums);

		// ...and finally we return our sums array after the recursive function has finished calculating all the branch sums. 
		return sums;
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
		BinaryTree n9 = new BinaryTree(10);

		root.left = n1;
		root.right = n2;
		root.left.left = n3;
		root.left.right = n4;
		root.right.left = n5;
		root.right.right = n6;
		root.left.left.left = n7;
		root.left.left.right = n8;
		root.left.right.left = n9;

		System.out.println(branchSums(root));
	}

}
