package com.challenges.medium;

import java.util.*;

import com.challenges.medium.ValidateBST.BST;

/*
 * 
	BST Traversal
	
	Write three functions that take in a Binary Search Tree (BST) and an empty array, traverse that BST, add its nodes' values to the input array, and return that array. The three
	functions should traverse the BST using the in-order, pre-order, and post-order tree-traversal techniques, respectively.
	
	Each BST node has an integer 'value', a 'left' child node, and a 'right' child node. A node is said to be a valid BST node if and only if it satisfies the BST property: its value is 
	strictly greater than the values of every node to its left; its value is less than or equal to the values of every node to its right; and its children nodes are either valid BST
	nodes themselves or None/null. 
	
	In-Order traversal wants us to traverse the BST in numerical order, just like if we were sorting it in ascending order. We always look at the left node first, the current node, and
	then the right node. When we are at a given node, we want to traverse from left to right. 
	
	A Pre-Order traversal wants us to append the current value to the array, before we traverse the left and the right. For Post-Order Traversal, we traverse up each subtree before
	ending with the root value.
	
	Sample Input:
	
	   tree =	   10
				 /    \
			    5      15
			   /  \      \
			  2    5      22
			 /        
			1     
			
	   array = []
	   
	   
	Sample Output:
	inOrderTraverse: [ 1, 2, 5, 5, 10, 15, 22 ]
	preOrderTraverse: [ 10, 5, 2, 1, 5, 15, 22 ]
	postOrderTraverse: [ 1, 2, 5, 5, 22, 15, 10 ]
	
 * 
 */

public class BSTTraversal {

	
	// 1. Our first method 'inOrderTraverse', like all the methods to follow, takes in a BST node as well as an ArrayList.
	public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {

		// 2. If the left child node is not equal to null, then we know the BST extends further along that subtree. As a result...
		if(tree.left != null) {
			
			// ...we will call our function recursively and pass in the left child node as the parameter along with our ArrayList. In doing this, if we work out way down to the left-most
			// value. Once we reach that point, we execute the code that follows...
			inOrderTraverse(tree.left, array);
		}
		
		// 3. Once our left child node is equal to null, we take our current node and add its value to the ArrayList.
		array.add(tree.value);
		
		// 4. We then check to see if our right child node is not equal to null, and if it isn't...
		if(tree.right != null) {
			
			// ...we call our function recursively again, this time passing in the right child node and ArrayList. So now we perform the same logic that we did on the left side until
			// we reach null. Once we do, following the logic of the recursive function, the right child node's value on the left-most node will get added in. So following this pattern,
			// we add in node values from left node to parent node to right node.
			inOrderTraverse(tree.right, array);
		}
		
		// 5. If both children nodes are null, we simply return the array. In using this function recursively, this would allow us to work back up the BST towards the root. In the case
		// of our example data, the values detected would be as follows: null -> array.add(1) -> null -> return array -> array.add(2) -> null -> return array -> array.add(5) ->
		// null -> array.add(5) -> null -> return array etc. The completion of an 'if' statement results in the return of an array, and from there the logic continues to execute.
		return array;
	}

	// 6. The second method, 'preOrderTraverse', takes in the same arguments as the first method as well as all the same code within it, yet the order of the logic is different! For
	// pre-order traversal, we are wanting to add values starting at the root/parent and then adding all values from the left subtree and finishing with the values in the right subtree,
	// ensuring all parent node values are added first, followed by all left values, and then finished off with all right values.
	public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
		
		// 7. We add the value of the root or parent node to our ArrayList.
		array.add(tree.value);
		
		// 8. If the left child node does not equal null...
		if(tree.left != null) {
			
			// ...we call our function recursively on the left child node along with the ArrayList. This will run until the end of the left branch is reached, adding all left values
			// along the way to the ArrayList. Since the final left child node will have no children, the ArrayList will be returned and the logic continues through the original call
			// of the function.
			preOrderTraverse(tree.left, array);
		}
		
		// 9. Once the previous logic completes, we now check and see if the right child node is not null, and if it isn't...
		if(tree.right != null) {
			
			// ...we call our function recursively on the right child node and ArrayList. 
			preOrderTraverse(tree.right, array);
		}
		
		return array;
	}

	public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
		if(tree.left != null) {
			postOrderTraverse(tree.left, array);
		}
		
		if(tree.right != null) {
			postOrderTraverse(tree.right, array);
		}
		
		array.add(tree.value);
		
		return array;
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
		BST n6 = new BST(22);
		BST n7 = new BST(1);
		
		
		root.left = n1;
		root.right = n2;
		root.left.left = n3;
		root.left.right = n4;
		root.right.right = n6;
		root.left.left.left = n7;
		
		List<Integer> array1 = new ArrayList<>();
		List<Integer> array2 = new ArrayList<>();
		List<Integer> array3 = new ArrayList<>();
		
		System.out.println(inOrderTraverse(root, array1));
		System.out.println(preOrderTraverse(root, array2));
		System.out.println(postOrderTraverse(root, array3));

	}

}
