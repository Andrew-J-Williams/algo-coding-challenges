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
		
		return findMid(array, null, 0, array.size() - 1);
	}
	
	public static BST findMid(List<Integer> array, BST bst, int start, int end) {
		
		if(end < start) {
			return null;
		}
		
		int mid = (start + end) / 2;
		
		int valueToAdd = array.get(mid);
		
		if(bst == null) {
			bst = new BST(valueToAdd);
		} else {
			bst.insert(valueToAdd);
		}
		
		findMid(array, bst, start, mid - 1);
		findMid(array, bst, mid + 1, end);
		
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
