package com.challenges.medium;

import java.util.*;

/*
 * 
	Move Element To End
	
	You're given an array of integers and an integer. Write a function that moves all instances of that integer in the array to the end of the array and returns the array.
	
	The function should perform in place (i.e., it should mutate the input array) and doesn't need to maintain the order of the other integers.
 * 
 */

public class MoveElementToEnd {

	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
		
		if(array.size() == 0) {
			return new ArrayList<Integer>();
		}
		
		int p1 = 0;
		int p2 = array.size() - 1;
		
		while(p1 < p2) {
			if(array.get(p1) == toMove && array.get(p2) == toMove) {
				p2--;
			} else if(array.get(p1) == toMove && array.get(p2) != toMove) {
				int temp = array.get(p2);
				array.set(p2, array.get(p1));
				array.set(p1, temp);
				p1++;
			} else {
				p1++;
			}
		}
		
		
		return array;
	}

	public static void main(String[] args) {
		List<Integer> array1 = new ArrayList<>();
		
		array1.add(2);
		array1.add(1);
		array1.add(2);
		array1.add(2);
		array1.add(2);
		array1.add(3);
		array1.add(4);
		array1.add(2);
		
		int move1 = 2;
		
		System.out.println(moveElementToEnd(array1, move1));
		

	}

}
