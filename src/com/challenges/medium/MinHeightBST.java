package com.challenges.medium;

import java.util.*;


/*
 * 
	Min Height BST
	
	Write a function that takes in a non-empty sorted array of distinct integers, construct a BST from the integers, and returns the root of the BST.
	
	The function should minimize the height of the BST.
	
	You've been provided with a BST class that you'll use to construct the BST.
	
	Each BST node has an integer 'value', a 'left' child node, and a 'right' child node. A node is said to be a valid BST node if and only if it satisfies the BST property: its value is 
	strictly greater than the values of every node to its left; its value is less than or equal to the values of every node to its right; and its children nodes are either valid BST
	nodes themselves or None/null. 
	
	A BST is valid if and only if all of its nodes are valid BST nodes.
	
	Note that the BST class has an 'insert' method you can use if you want.
	
	Sample Input:
	array = [ 1, 2, 5, 7, 10, 13, 14, 15, 22 ];
	
	Sample Output:
	
	  tree =	   10
				 /    \
			    2      14
			   /  \   /  \
			  1    5 13   15
			        \      \
			  		 7      22
	  
	  // This is one example of a BST with minimum height that you could create from the input array. You can create other BSTs with minimum height from the same array. 
	
 * 
 */


public class MinHeightBST {

	public static BST minHeightBst(List<Integer> array) {
		
		// 1. Within our main function, we run our helper function 'findMid' that is responsible for returning our min height BST.
		return findMid(array, null, 0, array.size() - 1);
	}
	
	// 2. Our 'findMid' helper function takes in 4 parameters: (1) our ArrayList of values, (2) a BST node, (3) an integer to represent the start of the ArrayList and (4) an integer to
	// represent the end of the ArrayList. 'findMid' is also a recursive function since it will call itself multiple times within its scope.
	public static BST findMid(List<Integer> array, BST bst, int start, int end) {
		
		// 3. We check and see if our ending index is less than the starting index. If it is...
		if(end < start) {
			
			// ...we return null. We do this because as we continually divide by 2, we get closer and closer to 0, and as will be seen in the logic that follows, we will increment the 
			// start and end points by 1, and eventually we will reach a point where the end index value is less than the start, which indicates that we have reach one end of our 
			// ArrayList.
			return null;
		}
		
		// 4. We create a variable that will represent our current midpoint, which is equal to the start index and end index values divided by 2. 
		int mid = (start + end) / 2;
		
		// 5. We create a variable that will represent the value from the ArrayList that is the mid-value. We do this because it will help keep the structure of the BST balanced based
		// on the fact that all values left of the mid-point will always be less and the values to the right will always be greater. We know the mid-value in the sorted order has the
		// same number of smaller values as it has larger values. All the values to the left will end up in the left subtree and all values to the right end up in the right subtree.
		int valueToAdd = array.get(mid);
		
		// 6. We check and see if the current node passed in is null, and if it is...
		if(bst == null) {
			
			// ...we create a new BST node and add the mid-value to it. This process only occurs at the root node of the BST.
			bst = new BST(valueToAdd);
		
		// 7. If we find the current node is not null...	
		} else {
			
			// ...then we use the 'insert' method present in the BST class to add a node to our new BST tree. This 'insert' method will compare the current mid-value to the root node's
			// value, and then from there traverse down either the left or right subtree repeating the process until a suitable child node can be created for it. Given the order of the
			// ArrayList, and the fact we are dividing and conquering, each subtree should have around the same amount of nodes, allowing for a BST with a minimum height. 
			bst.insert(valueToAdd);
		}
		
		// 8. We call our function recursively twice: once on the range of the starting index to the mid index minus one and once on the mid index plus one and the ending index. In doing
		// this, we are performing the same operation we did previously on each half of the array. As a result, we will balance out the values in a way that prevents on branch in the
		// subtree from becoming longer than it needs to be. We continue to do this until our end index is less than the start index.
		findMid(array, bst, start, mid - 1);
		findMid(array, bst, mid + 1, end);
		
		// 9. Finally, we return our BST root node, as the instructions requested.
		return bst;
		
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
			left = null;
			right = null;
		}

		public void insert(int value) {
			if (value < this.value) {
				if (left == null) {
					left = new BST(value);
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					right = new BST(value);
				} else {
					right.insert(value);
				}
			}
		}
	}

	public static void main(String[] args) {
		List<Integer> array1 = new ArrayList<>();
		
		array1.add(1);
		array1.add(2);
		array1.add(5);
		array1.add(7);
		array1.add(10);
		array1.add(13);
		array1.add(14);
		array1.add(15);
		array1.add(22);
		
		System.out.println(minHeightBst(array1));

	}

}
