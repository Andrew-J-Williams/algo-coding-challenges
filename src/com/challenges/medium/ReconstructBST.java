package com.challenges.medium;

import java.util.*;

/*
 * 
	Reconstruct BST
	
	The pre-order traversal of a Binary Tree is a traversal technique that starts at the tree's root node and visits nodes in the following order:
		1. Current node
		2. Left node
		3. Right node
	
	Given a non-empty array of integers representing the pre-order traversal of a Binary Search Tree (BST), write a function that creates the relevant BST and returns its root node.
	
	The input array will contain the value of BST nodes in the order in which these nodes would be visited with pre-order traversal.
	
	Each BST node has an integer 'value', a 'left' child node, and a 'right' child node. A node is said to be a valid BST node if and only if it satisfies the BST property: its value is 
	strictly greater than the values of every node to its left; its value is less than or equal to the values of every node to its right; and its children nodes are either valid BST
	nodes themselves or None/null.
	
	Sample Input:
	array = [ 10, 4, 2, 1, 5, 17, 19, 18 ]
	
	Sample Output:
	
				   10
				 /    \
			    4      17
			   / \      \
			  2   5      19
			 /       	 /
			1           18
 * 
 */

public class ReconstructBST {

	static class BST {
		public int value;
		public BST left = null;
		public BST right = null;

		public BST(int value) {
			this.value = value;
		}
	}

	public static BST reconstructBst(List<Integer> preOrderTraversalValues) {
		
		// 1. We check and see if the size of our ArrayList is equal to 0. If it is...
		if(preOrderTraversalValues.size() == 0) {
			
			// ...we return null since there are no values to iterate over.
			return null;
		}
		
		// 2. We create an integer variable that holds the value of the first number in our ArrayList.
		int current = preOrderTraversalValues.get(0);
		
		// 3. We create another integer variable that is equal to the size of our ArrayList.
		int rightSubtreeRootIdx = preOrderTraversalValues.size();
		
		// 4. We create a 'for' loop that starts at the second value of the ArrayList and iterates until 'i' is greater than or equal to the size of the ArrayList. We start at the 
		// second element because we will be comparing every element to the first.
		for(int i = 1; i < preOrderTraversalValues.size(); i++) {
			
			// 5. We create an integer variable that holds the value of the current element at index 'i'.
			int value = preOrderTraversalValues.get(i);
			
			// 6. We check if the value at index 'i' is greater than or equal to the current value. We know that our current value will be the root node's value, so if the value at
			// index 'i' is greater or equal to current, we know it will be its right child node because in a valid BST, all values greater than or equal to the parent node's value
			// will be in the right subtree. If this is the case...
			if(value >= current) {
				
				// ...we set our right subtree's root index equal to index value 'i'.
				rightSubtreeRootIdx = i;
				
				// 7. We break the 'for' loop, stopping any further iteration. We do this because once we've found what the right child node's value is, we know all values that come
				// before it in our ArrayList are less than both the root node's value and the right child node's value. Knowing this, we can split our original ArrayList into 2 new
				// ArrayLists: one for our left subtree and one for our right subtree. 
				break;
			}
		}
		
		// 8. We create a BST node and set it equal to our function. We pass in a subList of our original ArrayList that starts at index 1 and ends at the rightSubtreeRootIdx. Given our
		// test data, this would produce the following list: [ 4, 2, 1, 5 ]. Remember, the ending index value is not captured in the range. Since all these values are less than the 
		// root node (10), they will comprise our left subtree. The logic repeats until the size of our List passed in equals 0, and it eventually will as the List of numbers grows
		// smaller with each recursive call.
		BST leftSubtree = reconstructBst(preOrderTraversalValues.subList(1, rightSubtreeRootIdx));
		
		// 9. We create another BST node and set it equal to our function. We pass in a subList of our original ArrayList that starts at index 1 the rightSubtreeRootIdx and ends at the
		// size of our List. Given our test data, this would produce the following list: [ 17, 19, 18 ].
		BST rightSubtree = reconstructBst(preOrderTraversalValues.subList(rightSubtreeRootIdx, preOrderTraversalValues.size()));
		
		// 10. We create one final BST that will represent our root/parent node and we set the value equal to our current value (the first element from our ArrayList).
		BST bst = new BST(current);
		
		// 11. We set the left and right child nodes equal to our left and right subtrees.
		bst.left = leftSubtree;
		bst.right = rightSubtree;
		
		// 12. Finally, we return our root node.
		return bst;
	}
	

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>();

		array.add(10);
		array.add(4);
		array.add(2);
		array.add(1);
		array.add(5);
		array.add(17);
		array.add(19);
		array.add(18);

		System.out.println(reconstructBst(array));

	}

}
