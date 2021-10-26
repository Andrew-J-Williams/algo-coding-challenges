package com.challenges.easy;

import java.util.ArrayList;
import java.util.List;

/*
 * 
	Node Depths
	
	The distance between a node in a Binary Tree and the tree's root is called the node's depth.
	
	Write a function that takes in a Binary Tree and returns the sums of its nodes' depths.
	
	Each BinaryTree has an integer value, a left child node, and a right child node. Children nodes can either be BinaryTree nodes themselves or equal to None/null.
	
	Sample Input:
	
			tree =  1
				 /    \
			    2      3
			   /  \   /  \
			  4    5 6    7
			 / \  
			8   9 
			
	Sample Output:
	16
 * 
 */

public class NodeDepths {

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
	
	// 1. We create a recursive function that will keep track of how many levels down each branch we are and add each node on those levels to an array of node depths.
	public static void calculateNodeDepths(BinaryTree node, int depth, List<Integer> runningSum) {
		
		// 2. We check and see if the node is empty or equal to null. If it is...
		if(node == null) {
			
			// ...we simply return the function, which will mark the end of a branch and update our array of node depths.
			return;
		}
		
		// 3. If it is not null, we add the current depth level to our ArrayList of node depths.
		runningSum.add(depth);
		
		// 4. We increase the value of the depth by 1 since we will be descending deeper along the branches.
		int newDepth = depth + 1;
		
		// 5. We account for this node having children on the left and right by calling our recursive function on both possibilities, repeating the process until we reach all leaf nodes.
		calculateNodeDepths(node.left, newDepth, runningSum);
		calculateNodeDepths(node.right, newDepth, runningSum);
	}

	// 6. In our main function, we take in the root of the BinaryTree as our only argument.
	public static int nodeDepths(BinaryTree root) {
		
		// 7. We define and ArrayList that will hold the depth levels of every node in the BinaryTree. 
		List<Integer> sums = new ArrayList<>();
		
		// 8. We create a variable that will hold the sum of all the node depths in the BinaryTree.
		int sum = 0;
		
		// 9. We call our recursive function, passing in our root, 0 (representing the level of the root), and our sums ArrayList.
		calculateNodeDepths(root, 0, sums);
		
		// 10. After the recursive function finishes its run, we create a 'for' loop to iterate over every value in the ArrayList. For each value...
		for(int x : sums) {
			
			// ... we add it to our running total until we reach the end of the list.
			sum += x;
		}
		
		// 11. Finally, we return the sum of all the node depths.
		return sum;
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

		root.left = n1;
		root.right = n2;
		root.left.left = n3;
		root.left.right = n4;
		root.right.left = n5;
		root.right.right = n6;
		root.left.left.left = n7;
		root.left.left.right = n8;
		
		System.out.println(nodeDepths(root));
	}

}
