package com.challenges.medium;

import java.util.*;

public class ReconstructBST {
	
	static class BST {
	    public int value;
	    public BST left = null;
	    public BST right = null;

	    public BST(int value) {
	      this.value = value;
	    }
	  }

	  public static BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
	    // Write your code here.
	    return null;
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
