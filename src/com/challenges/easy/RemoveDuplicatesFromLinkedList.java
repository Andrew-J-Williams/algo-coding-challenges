package com.challenges.easy;

public class RemoveDuplicatesFromLinkedList {

	public static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
	}

	public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
		
		// 1. First, we create a variable and set it equal to the head of our LinkedList.
		LinkedList current = linkedList;

		// 2. We create a 'while' loop to iterate over our entire list until reaching the final node, which will equal 'null'. 
		while (current != null) {
			
			// 3. We create a variable and set it equal to the next node in the LinkedList.
			LinkedList nextNode = current.next;

			// 4. We create a 2nd 'while' loop that runs while the node doesn't equal 'null' and the next Node's value is equal to the previous node's value.  
			while (nextNode != null && nextNode.value == current.value) {
				
				// 5. We then set the next node equal to the node after that until the value is no longer equal to the current node's value.
				nextNode = nextNode.next;
			}

			// 6. After the loop breaks, we set the value of the next node equal to the nextNode variable. Basically our current node points to the next node that is not a repeat. 
			current.next = nextNode;
			
			// 7. We then adjust current to equal the next node in the LinkedList and the process repeats until the first loop is broken.
			current = nextNode;
		}
		
		// 8. Finally, once the loop finishes iterating over every node, we return our updated LinkedList, now with no duplicate values.
		return linkedList;
	}

	public static void main(String[] args) {
		LinkedList n1 = new LinkedList(1);
		LinkedList n2 = new LinkedList(1);
		LinkedList n3 = new LinkedList(1);
		LinkedList n4 = new LinkedList(3);
		LinkedList n5 = new LinkedList(4);
		LinkedList n6 = new LinkedList(4);
		LinkedList n7 = new LinkedList(4);
		LinkedList n8 = new LinkedList(5);
		LinkedList n9 = new LinkedList(6);
		LinkedList n10 = new LinkedList(6);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;

		System.out.println(removeDuplicatesFromLinkedList(n1));

	}

}
