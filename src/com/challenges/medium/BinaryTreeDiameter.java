package com.challenges.medium;

import java.util.*;

/*
 * 
	BinaryTreeDiameter
	
	Write a function that takes in a Binary Tree and returns its diameter. The diameter of a binary tree is defined as the length of its longest path, even if that path doesn't pass
	through the root of the tree.
	
	A path is a collection of connected nodes in a tree, where no node is connected to more than two other nodes. The length of a path is the number of edges between the path's first
	node and its last node.
	
	Each BinaryTree has an integer value, a left child node, and a right child node. Children nodes can either be BinaryTree nodes themselves or None/null.
	
	Sample Input:
	
	  tree =	   1
				 /   \
			    3     2
			   / \   
			  7   4  
			 /     \  
			8       5
		   /         \
		  9           6    
	
	Sample Output:
	6 // There are 6 edges between the first node and the last node of this tree's longest path.
 * 
 */

public class BinaryTreeDiameter {

	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}
	
	// 1. We create a class known as 'TreeInfo' that will act as the return type for our recursive function 'getTreeInfo'. It will have height and diameter as attributes. Having a 
	// returnable object will allow us to store and access multiple values. 
	static class TreeInfo {
		public int diameter;
		public int height;
		
		public TreeInfo(int diameter, int height) {
			this.diameter = diameter;
			this.height = height;
		}
	}

	public static int binaryTreeDiameter(BinaryTree tree) {
		
		// 2. We return the diameter value of our result of our 'getTreeInfo' function, which is returning a TreeInfo object.
		return getTreeInfo(tree).diameter;
		
	}
	
	// 3. We create our recursive function 'getTreeInfo' that as previously stated has the return type of a TreeInfo object and takes in the argument of a BinaryTree.
	public static TreeInfo getTreeInfo(BinaryTree tree) {
		
		// 4. We check and see if our current node is equal to null, and if it is...
		if(tree == null) {
			
			// ...we return a new instance of TreeInfo with a diameter and height of 0. The reason we do this is because null indicates we have reached a base case in our Binary Tree.
			return new TreeInfo(0, 0);
		}
		
		// 5. We call our function recursively on the left child node and the right child node. In doing this, our function acts in a Depth First Search manner and traverses all the way
		// down the left branch of our subtree until it hits a base case (null). When it does, it either works its way back up (if there is no right child node) or if there IS a right
		// child node it traverse down the right branch of the subtree until reaching the base case on that side, then working its way back up to the root/parent node.
		TreeInfo leftTree = getTreeInfo(tree.left);
		TreeInfo rightTree = getTreeInfo(tree.right);
		
		// 6. We create a variable that will hold the value of the longest path through the root node, which is equal to the height of our left tree and the height of our right tree. 
		// Using our example data, starting with the base node, the height of our longest path would be 0 given L(0, 0) and R(0, 0), L.height + R.Height = 0.
		int longestPath = leftTree.height + rightTree.height;
		
		// 7. We create another variable that will hold the max diameter running over the course of these recursive calls. This is calculated by using 'Math.max' to determine if either
		// the left tree's diameter is greater than or less than the right tree's diameter. Whichever is greater is what 'maxDiameter's' value becomes. Again using our example data,
		// since L(0, 0) and R(0, 0), Math.max(0, 0) = 0.
		int maxDiameter = Math.max(leftTree.diameter, rightTree.diameter);
		
		// 8. We create yet another variable that will represent the current diameter of our subtree. This is calculated by using 'Math.max' again to see whether or not the longestPath's
		// value is greater than or less than the maxDiameter's value. The greater value will be stored. Using the example data, Math.max(0, 0) = 0.
		int currentDiameter = Math.max(longestPath, maxDiameter);
		
		// 9. We create one final variable that keeps track of the current height, which once again uses 'Math.max' to find the greater value between our left tree's height and our right
		// tree's height. Using our example data, 1 + Math.max(0, 0) = 1.
		int currentHeight = 1 + Math.max(leftTree.height, rightTree.height);
		
		// 10. Finally, we return a new TreeInfo object with our current diameter and current height as its parameters. Using our example data, it would be TreeInfo(0, 1) for our left
		// subtree and TreeInfo(0, 0) for our right subtree. So starting from the beginning on the left base node: L(0, 0), R(0, 0), L(0, 1), R(0, 0), L(1, 2), R(0, 0), L(2, 3) (left
		// subtree finished, starting right subtree at base node), L1(0, 0), R1(0, 0), L1(0, 0), R1(0, 1), L1(0, 0), R1(1, 2), L(2, 3), R1(2, 3). At the root node, our object becomes
		// TreeInfo(6, 4) since longestPath = L.height (3) + R1.height (3) = 6, maxDiameter = Math.max(L.diameter(2), R1.diameter(2)) = 2, currentDiameter = Math.max(6, 2) = 6, and
		// currentHeight = 1 + (Math.max(L.height(3), R.height(3)) => 1 + (3) = 4. Thus, we return new TreeInfo(6, 4).  
		return new TreeInfo(currentDiameter, currentHeight);
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
		BinaryTree n8 = new BinaryTree(9);
		
		root.left = n2;
		root.right = n1;
		root.left.left = n6;
		root.left.right = n3;
		root.left.left.left = n7;
		root.left.right.right = n4;
		root.left.left.left.left = n8;
		root.left.right.right.right = n5;
		
		System.out.println(binaryTreeDiameter(root));
	}

}
