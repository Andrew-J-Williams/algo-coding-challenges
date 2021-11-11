package com.challenges.medium;

import java.util.*;



public class MinHeightBST {

	public static BST minHeightBst(List<Integer> array) {
		// Write your code here.
		return null;
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
