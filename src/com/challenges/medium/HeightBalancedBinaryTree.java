package com.challenges.medium;

/*
 * 
 	Height Balanced Binary Tree
 	
	You're given the root node of a Binary Tree. Write a function that returns 'true' if this Binary Tree is height balanced and 'false' if it isn't.
	
	A Binary Tree is height balanced if for each node in the tree, the difference between the height of its left subtree and the height of its right subtree is at most 1.
	
	Each BinaryTree has an integer value, a left child node, and a right child node. Children nodes can either be BinaryTree nodes themselves or None/null.
	
	Sample Input:
	
		tree =	   1
				 /   \
			    2     3
			   / \     \
			  4   5     6
			     / \  
			    7   8
			    
	Sample Output: 
	true
		 
 * 
 */

public class HeightBalancedBinaryTree {

	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}
	
	// 1. We create a class called TreeInfo that will store our running heights and boolean values as we traverse our Binary Tree. 
	static class TreeInfo {
		
		public int height;
		public boolean balanced;
		
		public TreeInfo(int height, boolean balanced) {
			this.height = height;
			this.balanced = balanced;
		}
		
	}

	public static boolean heightBalancedBinaryTree(BinaryTree tree) {

		// 2. We simply return the boolean result of our 'checkHeight' recursive function, which accepts a BinaryTree node and returns a TreeInfo object. Our 'balanced' attribute contains
		// the boolean value.
		return checkHeight(tree).balanced;
		
	}
	
	public static TreeInfo checkHeight(BinaryTree tree) {
	
		// 3. We check if the node is equal to null. If it is, we have reached a base case in our Binary Tree. As a result...
		if(tree == null) {
			
			// ... we return a TreeInfo object with a height of 0 and its balanced attribute set to 'true'. 
			return new TreeInfo(0, true);
		}
		
		// 4. We then create two TreeInfo variables and set them equal to recursive calls of the 'checkHeight' function on the left and right children nodes. This way we can check the
		// the parent nodes at the end of the subtree first and work our way back towards the root node. The check process starts with the left child node, the right child node, and then
		// the parent node for each subtree.
		TreeInfo left = checkHeight(tree.left);
		TreeInfo right = checkHeight(tree.right);
		
		// 5. We create an integer variable that stores the absolute difference between the heights in our left and right TreeInfos. This value will be checked later to determine whether
		// or not the subtrees meet the definition of height balanced described in the prompt.
		int difference = Math.abs(left.height - right.height);
		
		// 6. We create a boolean variable that is equal to the result of an AND logical operator. With an '&&' operator, both left and right values must be true in order to return a
		// true, otherwise it will return false. So in the case of our subtrees, since 'balanced' represents whether or not the current Binary Tree is balanced, both subtrees must
		// continuously return true in order for the entire Binary Tree to be height balanced. If at any point in our Binary Tree is a subtree unbalanced, that false value will traverse
		// all the way up the Binary Tree.
		boolean balanced = left.balanced && right.balanced;
		
		// 7. We check and see if our absolute difference is greater than 1 OR if our 'balanced' value is false. The OR '||' operator will be true if both or either value to the left or
		// right is true and will only return false if both conditions are false. We do this in order to check the two conditions that determine if our Binary Tree is height balanced
		// at every point: the difference in subtree heights is less than 1 OR a previous comparison came back as false. As long as either situation is true...
		if(difference > 1 || !balanced) {
			
			// ...we set balanced to 'false' to indicate the current Binary Tree is not height balanced.
			balanced = false;
		 
		}
		
		// 8. We create another integer variable and set it equal to the max value of the left and right subtree heights plus 1. We do this to represent the upward traversal as we check
		// another node in our Binary Tree, keeping a running count on the height for comparison purposes.
		int currentHeight = 1 + (Math.max(left.height, right.height));
		
		// 9. Finally, we return a new TreeInfo object with the height set to currentHeight and balanced set to balanced. Using our example data, the traversal would look like this:
		// *node 4* L(1, true) -> *node 7* L1(1, true) -> *node 8* R1(1, true) -> *node 5* R1(2, true) -> *node 2* L(3, true) -> *node 6* R(1, true) -> *node 3* R(2, true) ->
		// *node 1* true.
		return new TreeInfo(currentHeight, balanced);
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
		
		root.left = n1;
		root.right = n2;
		root.left.left = n3;
		root.left.right = n4;
		root.right.right = n5;
		root.left.right.left = n6;
		root.left.right.right = n7;

		
		System.out.println(heightBalancedBinaryTree(root));
	}
}
