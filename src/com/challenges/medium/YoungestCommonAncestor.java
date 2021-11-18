package com.challenges.medium;

/*
 * 
	Youngest Common Ancestor
	
	You're given three inputs, all of which are instances of an 'AncestralTree' class that have an 'ancestor' property pointing to their youngest ancestor. The first input is the
	top ancestor in an ancestral tree (i.e. the only instance that has no ancestor - its ancestor property points to None/null, and the other two inputs are descendants in the 
	ancestral tree.
	
	Write a function that returns the youngest common ancestor to the two descendants.
	
	Note that a descendant is considered its own ancestor. So in the simple ancestral tree below, the youngest common ancestor to nodes A and B is node A.
	
	 		A
	 	   /
	 	  B
	 	  
	Sample Input:
	topAncestor = node A
	descendantOne = node E
	descendantTwo = node I
	
			A
		  /   \	
		 B     C
		/ \   / \
	   D   E F   G
	  / \
	 H   I
	 
	Sample Output:
	node B
 * 
 */

public class YoungestCommonAncestor {

	public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
		// Write your code here.
		return topAncestor; // Replace this line
	}

	static class AncestralTree {
		public char name;
		public AncestralTree ancestor;

		AncestralTree(char name) {
			this.name = name;
			this.ancestor = null;
		}

		// This method is for testing only.
		void addAsAncestor(AncestralTree[] descendants) {
			for (AncestralTree descendant : descendants) {
				descendant.ancestor = this;
			}
		}
	}

	public static void main(String[] args) {
		AncestralTree topAncestor = new AncestralTree('A');
		AncestralTree descendantOne = new AncestralTree('E');
		AncestralTree descendantTwo = new AncestralTree('I');
		
		AncestralTree d1 = new AncestralTree('B');
		AncestralTree d2 = new AncestralTree('C');
		AncestralTree d3 = new AncestralTree('D');
		AncestralTree d4 = new AncestralTree('F');
		AncestralTree d5 = new AncestralTree('G');
		AncestralTree d6 = new AncestralTree('H');
		AncestralTree d7 = new AncestralTree('I');
		
		d1.ancestor = topAncestor;
		d2.ancestor = topAncestor;
		d3.ancestor = d1;
		descendantOne.ancestor = d1;
		d4.ancestor = d2;
		d5.ancestor = d2;
		d6.ancestor = d3;
		descendantTwo.ancestor = d3; 
		
		
		System.out.println(getYoungestCommonAncestor(topAncestor, descendantOne, descendantTwo));
	}

}
