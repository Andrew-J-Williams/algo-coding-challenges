package com.challenges.medium;

/*
 * 
	BST Construction
	
	Write a BST class for a Binary Search Tree. The class should support:
		• Inserting values with an 'insert' method
		• Removing values with the 'remove' method: this method should only remove the first instance of a given value
		• Searching for values with the 'contains' method
		
	Note that you can't remove values from a single-node tree. In other words, calling the remove method on a single-node tree should simply not do anything.
	
	Each BST node has an integer 'value', a 'left' child node, and a 'right' child node. A node is said to be a valid BST node if and only if it satisfies the BST property: its value
	is strictly greater than the values of every node to its left, its value is less than or equal to the values of every node to its right; and its children nodes are either valid BST
	nodes themselves or None/null.
	
	Sample Usage:
	
	// Assume the following BST has already been created:
		
				   10
				 /    \
			    5      15
			   /  \   /  \
			  2    5 13   22
			 /        \
			1         14
	
	// All operations below are performed sequentially.
	
	insert(12):    10
				 /    \
			    5      15
			   /  \   /  \
			  2    5 13   22
			 /      /  \
			1      12  14
			
	remove(10):    12
				 /    \
			    5      15
			   /  \   /  \
			  2    5 13   22
			 /        \
			1         14
			
	contains(15): true

 * 
 */

public class BSTConstruction {

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}

		
		// 1. Our 'insert' method takes in the argument of the value we are wanting to insert in our Binary Search Tree. For this method, and the ones that follow, each one will act
		// recursively, meaning these methods will call themselves repeatedly within their own code, allowing us to repeat the given operation until the desired effect is achieved.
		public BST insert(int value) {

			// 2. We check and see if the insert value is less than the tree's current value. Given the nature of a BST, we know that all values less than the current node's value will
			// branch out to the left while all the values that are greater will branch out to the right. If the value we want to insert is less than the node's value...
			if (value < this.value) {
				
				// 3. We then check if the value of the left child node is equal to null. If it is, this indicates there isn't a child node present on the left side, meaning we can 
				// create a node that will hold the inserted value. So if this is the case...
				if (left == null) {
					
					// ...we create a new BST, passing in our inserted value as its value, and set our left node equal to our newly created child node. 
					BST newBST = new BST(value);
					left = newBST;
				// 4. Otherwise, if our left side does have a child node with a value...
				} else {
					
					// ...we call our 'insert' method on that node and pass the value we want to insert as the argument.
					left.insert(value);
				}
			
			// 5. If the inserted value is greater than the node's value, we checked the right side of our binary search tree.	
			} else {
				
				// 6. If the node on the right branch is null...
				if (right == null) {
					
					// ...we create a new BST, passing in our inserted value as its value, and set our right node equal to our newly created child node. 
					BST newBST = new BST(value);
					right = newBST;
				
				// 7. Otherwise, if our right side does have a child node with a value... 
				} else {
					
					// ...we call our 'insert' method on that node and pass the value we want to insert as the argument.
					right.insert(value);
				}
			}
			
			// After we've gone through the logic, we finally return our BST.
			return this;
		}

		// 8. Our 'contains' method also accepts a value as an argument.
		public boolean contains(int value) {

			// 9. If the value is less than the value of the current node...
			if (value < this.value) {
				
				// 10. We check if the left child node is equal to null. If it is...
				if (left == null) {
					
					// ...we return false, because we have reached the end of the branch and have no where left to go.
					return false;
				
				// 11. Otherwise, if there is a node present on the left branch...
				} else {
					
					// ...we return the result of calling our contains method on the left node, passing in our original value again, repeating the logic.
					return left.contains(value);
				}
			// 12. If the value is greater than the value of the current node... 	
			} else if (value > this.value) {
				
				// 13. We check if the right child node is equal to null. If it is...
				if (right == null) {
					
					// ...we return false since the value we were searching for was not present.
					return false;
					
				// 14. Otherwise, if there is a node present on the right branch...	
				} else {
					
					// ......we return the result of calling our contains method on the right node, passing in our original value again, repeating the logic.
					return right.contains(value);
				}
				
			// 15. Otherwise, we have found a value that equals the value that was passed in...	
			} else {
				
				// ...as a result, we return true.
				return true;
			}

		}

		
		// 16. Our final method, 'remove', accepts the argument of a value as well.
		public BST remove(int value) {
			
			// 17. We call a helper method called 'remove' and pass in our value as well as 'null' to represent the parent of the tree.
			remove(value, null);
			
			// 18. We return the BST after the helper methods finish. 
			return this;
		}

		// 19. Our first helper method, 'remove', takes in two arguments: the value we are looking to remove and the BST parent node.
		public void remove(int value, BST parent) {

			// 20. If the value is less than the value of the parent node...
			if (value < this.value) {
				
				// 21. We check if the node on the left branch is NOT equal to 'null'. If it isn't...
				if (left != null) {
					
					// ...we call our 'remove' method on the left child node and pass in the value we want to remove along with the current node.
					left.remove(value, this);
				}
			
			// 21. If the value is greater than the value of the parent node...	
			} else if (value > this.value) {
				
				// 22. We check if the right child node is NOT equal to null. If it isn't...
				if (right != null) {
					
					// ......we call our 'remove' method on the right child node and pass in the value we want to remove along with the current node.
					right.remove(value, this);
				}
				
			// 23. If our value is equal to the value of the parent node...	
			} else {
				
				// 24. We check if the left and right child nodes are NOT equal to null. If they aren't...
				if (left != null && right != null) {
					
					// ...we set the value of the parent node equal to the result of calling our 2nd helper method, 'getMinValue', on the right child node. What this helper is doing is
					// checking to see what the smallest value is on the right side of the binary search tree. We do this because if we are removing the value from the current node we
					// need to replace it with another value that is greater than the value of the parent node yet less than the right child node of the parent node. In doing this,
					// we ultimately will remove the leftmost value on the right side of our tree. Once the value has been updated...
					this.value = right.getMinValue();
					
					// ...we call the remove method again on the right child node, passing in the value we just updated as well as the parent node, repeating the logic again. We do this
					// in order to remove the leftmost value in our BST, so we don't have the same value present in two different places. We already removed our desired value, replaced
					// it, and now need to again remove the node where our replacement value originated. This can be seen in the prompt example above.
					right.remove(this.value, this);
					
				// 25. If the parent is equal to 'null', then we have to make sure it holds some type of value in order for our BST to remain valid.	
				} else if (parent == null) {
					
					// 26. We would then check if our left child node is NOT equal to 'null', and if it isn't
					if (left != null) {
						
						// ... we set our current node's value equal to the left node's value, and set the left and right children's nodes equal to those of the left node. This essentially
						// is shifting the branches on the tree in order to account for a node that has been removed.
						this.value = left.value;
						right = left.right;
						left = left.left;
					
					// 27. If our right node is NOT equal to 'null', we apply the same logic that we would use on the left side... 
					} else if (right != null) {
						
						// ... we set our current node's value equal to the right node's value, and set the left and right children's nodes equal to those of the right node. 
						this.value = right.value;
						right = right.right;
						left = right.left;
					
					// 28. If both the right and left child nodes are equal to null, then we have a situation where the tree is a single node, and in that case...
					} else {
						// ...we simply do nothing, since there is nothing to remove at this point.
					}
					
				// 29. If the left node of the parent is equal to the current node...	
				} else if (parent.left == this) {
					parent.left = left != null ? left : right;
				} else if (parent.right == this) {
					parent.right = left != null ? left : right;
				}
			}
		}

		public int getMinValue() {
			if (left == null) {
				return this.value;
			} else {
				return left.getMinValue();
			}
		}
	}

}
