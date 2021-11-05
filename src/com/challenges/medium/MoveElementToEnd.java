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

		// 1. We create 2 pointers and set them equal to the first and last indexes of
		// the ArrayList.
		int p1 = 0;
		int p2 = array.size() - 1;

		// 2. We create a 'while' loop that runs until p1 is greater than p2, touching
		// every value in the ArrayList.
		while (p1 < p2) {

			// 3. We create another 'while' loop that runs if p1 is less than p2 an the
			// value at p2 equals 'toMove'. While these conditions remain true...
			while (p1 < p2 && array.get(p2) == toMove) {

				// ...we decrement p2 by 1 since our target value is currently at the end of the
				// ArrayList, like we want it.
				p2--;
			}

			// 4. After the loop is broken, we check if the value at p1 equal the value of
			// 'toMove'. If it does...
			if (array.get(p1) == toMove) {
				
				// ...we use our helper method 'swap' to switch the values at p1 and p2, effectively moving the target value to the end of the array...
				swap(p1, p2, array);
				
				// ...and then we increment p1 by 1 to check the next value to the right.
				
			}
			
			// 5. Once the swap has been made, we increment p1 by 1 and repeat the while loop until conditions become false.
			p1++;
		}

		// 6. Finally, after we've checked every value and the loop breaks, we return our modified (in-place) array.
		return array;
	}

	// 7. Our helper method 'swap' accepts the pointers and the array as parameters.
	public static void swap(int p1, int p2, List<Integer> array) {
		
		// 8. We create a 'temp' variable to store the value found at p2...
		int temp = array.get(p2);
		
		// ...we then set the value of p2 to be the value found at p1...
		array.set(p2, array.get(p1));
		
		// ...and finally set the value of p1 to be our 'temp' variable, swapping both values without creating a new ArrayList.
		array.set(p1, temp);
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
