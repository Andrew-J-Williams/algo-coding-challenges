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
	
			tree = 10
				 /    \
			    5      15
			   /  \   /  \
			  2    5 13   22
			 /        \
			1         14
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

	public static List<Integer> branchSums(BinaryTree root) {
		// Write your code here.
		// Comment!
		return new ArrayList<Integer>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree root = new BinaryTree(1);
	}

}
