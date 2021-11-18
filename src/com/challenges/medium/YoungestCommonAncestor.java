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
		
		// 1. We check and see if either our first or second descendant is equal to the top ancestor. If this is the case, it means that one of the two is the root of the tree and
		// will not have an ancestor beyond them. By default, since the top ancestor is its own ancestor, the common ancestor between the two will be the top ancestor. Thus...
		if(descendantOne == topAncestor || descendantTwo == topAncestor) {
			
			// ...we return our 'topAncestor' as the result.
			return topAncestor;
		}
		
		// 2. If neither descendant is equal to the top ancestor node, we return the result of our helper function 'checkAncestor', which will determine the youngest common 
		// ancestor between the two descendants, returning an AncestralTree as the result.
		return checkAncestor(descendantOne, descendantTwo);
	}
	
	// 3. Our helper function, 'checkAncestor', takes in 2 arguments: two AncenstralTrees that represent our descendants in question. It is also potentially recursive since,
	// given the inputs, can call itself from within its own logic.
	public static AncestralTree checkAncestor(AncestralTree a, AncestralTree b) {
		
		// 4. We check to see if the ancestor of descendant 'a' equals the ancestor of descendant 'b'. If they do, it means we have found the youngest common ancestor, and as a
		// result...
		if(a.ancestor == b.ancestor) {
			
			// ...we return the ancestor (since they are equal, it does not matter if 'a' or 'b's ancestor is returned). In the easiest case, using our ancestral tree above, if
			// one descendant equals 'D' and the other is 'E', both share the ancestor 'B'. Thus 'B' would be returned.
			return a.ancestor;
		}
		
		// 5. We then check to see if descendant 'a' is equal to the ancestor of descendant 'b'. If it is, then we have found the youngest common ancestor, and as a result...
		if(a == b.ancestor){
			
			// ...we return 'a'. An example of this using our ancestral tree above would be if one descendant is 'C' and the other is 'F'. Since the ancestor of 'F' IS 'C', we 
			// would return 'C' since 'C' is it's own ancestor and is therefore the youngest common ancestor between the two.
			return a;
		}
		
		// 6. We then check to see if descendant 'a' is equal to the ancestor of descendant 'b'. If it is, then we have found the youngest common ancestor, and as a result...
		if(b == a.ancestor){
			
			// ...we would return 'b'. Again, this is just inverse of the case above, the same logic would follow. 
			return b;
		}
		
		// 7. If we pass all the previous conditionals, then we know are descendants are distant from each other. Since the 'name' of each descendant is stored as a character,
		// a character has a numeric value in Java. Thus, we can compare the values of these characters to see which character is the larger of the two, first checking to see if
		// a's character value is greater than 'b's. Given our example inputs. since 'I' has a greater value than 'E', being higher in alphabetical order...
		if(a.name > b.name) {
			
			// ...we return the result of our function called recursively, making the 'a's ancestor and 'b' as the two descendants. Our function will run again, but this time
			// the ancestor of 'a' will be compared with 'b' since the ancestor of any descendant will be a character value less than itself. Again using our example, we would 
			// call our function on the ancestor of 'a' which is 'B'. As a result, 'B' would be returned since now both 'D' and 'E' share a common ancestor in 'B'.
			return checkAncestor(a.ancestor, b);
			
		// 8. Otherwise, we check if the opposite is true, and if it is...	
		} else {
			
			// ...we return the result of our function called recursively, only this time 'a' is one parameter and 'b's ancestor is the other parameter.
			return checkAncestor(a, b.ancestor);
		}
	
	}

// After finding this solution, I came to the realization that if these AncestralTree nodes accepted a name that wasn't a char, say instead a String, then this solution above will
// not work. As a result, while I will leave the solution above as the main solution, below is the alternative solution provided by AlgoExpert:
	
/*
 * 
	public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
	 
		int depth1 = getDescendantDepth(descendantOne, topAncestor);
		int depth2 = getDescendantDepth(descendantTwo, topAncestor);
	
		if(depth1 > depth2){
		
			return backtrackAncestralTree(descendantOne, descendantTwo, depth1 - depth2);
		 
		} else {
		
			return backtrackAncestralTree(descendantTwo, descendantOne, depth2 - depth1);
		 
		}
	
	}
	
	public static int getDescendantDepth(AncestralTree descendant, AncestralTree topAncestor){
	
		int depth = 0;
		
		while(descendant != topAncestor){
			depth++;
			descendant = descendant.ancestor;
		}
	
		return depth;
		
	}

 	public static AncestralTree backtrackAncestralTree(AncestralTree lowerDescendant, AncestralTree higherDescendant, int diff){
 	
 		while(diff > 0) {
 		
 			lowerDescendant = lowerDescendant.ancestor;
 			diff--;
 		
 		}
 		
 		while(lowerDescendant != higherDescendant) {
 		
 			lowerDescendant = lowerDescendant.ancestor;
 			higherDescendant = higherDescendant.ancestor;
 		
 		}
 		
 		return lowerDescendant;
 	
 	}
 
 * 	
 */

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
