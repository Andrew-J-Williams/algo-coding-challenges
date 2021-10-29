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
		LinkedList current = linkedList;

		while (current != null) {
			LinkedList nextNode = current.next;

			while (nextNode != null && nextNode.value == current.value) {
				nextNode = nextNode.next;
			}

			current.next = nextNode;
			current = nextNode;
		}
		
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
