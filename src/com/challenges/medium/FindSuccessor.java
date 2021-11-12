package com.challenges.medium;

import java.util.*;

/*
 * 
	Find Successor
	
	Write a function that takes in a Binary Tree (where nodes have an additional pointer to their parent node) as well as a node contained in the tree and returns the given node's
	successor.
	
	A node's successor is the next node to be visited (immediately after the give node) when traversing its tree using in-order tree-traversal technique. A node has no successor if it's
	the last node to be visited in the in-order traversal.
	
	If a node has no successor, your function should return None/null.
	
	Each BinaryTree has an integer value, a left child node, and a right child node. Children nodes can either be BinaryTree nodes themselves or None/null.
	
	Sample Input:
	
	
	Sample Output:
	1
	// Thi's tree's in-order traversal is: 6 -> 4 -> 2 -> 5 -> 1 -> 3. 1 comes immediately after the 5.
 * 
 */

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
		
		
		List<BinaryTree> results = findSuccessor(tree, node, new ArrayList<BinaryTree>());
		
		int i = results.indexOf(node);
		
		if(i == -1 || i == results.size() - 1) {
			return null;
		} else {
			return results.get(i + 1);
		}
		
	}
	
	public static List<BinaryTree> findSuccessor(BinaryTree tree, BinaryTree node, List<BinaryTree> array){
		
		if(tree.left != null) {
			findSuccessor(tree.left, node, array);
		}
		
		array.add(tree);
	
		if(tree.right != null) {
			findSuccessor(tree.right, node, array);
		}
		
		return array;
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
