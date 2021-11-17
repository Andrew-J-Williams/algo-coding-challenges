package com.challenges.medium;

/*
 * 
	Single Cycle Check
	
	You're given an array of integers where each represents a jump of its value in the array. For instance, the integer 2 represents a jump of two indices forward in the array; the
	integer -3 represents a jump of three indices backward in the array.
	
	If a jump spills past the array's bounds, it wraps over to the other side. For instance, a jump of -1 at index 0 brings us to the last index of the array. Similarly, a jump of
	1 at the last index of the array brings us to index 0.
	
	Write a function that returns a boolean representing whether the jumps in the array form a single cycle. A single cycle occurs if, starting at any index in the array and
	following the jumps, every element in the array is visited exactly once before landing back on the starting index.
	
	Sample Input:
	array = [ 2, 3, 1, -4, -4, 2 ]
	
	Sample Output:
	true
 * 
 */

public class SingleCycleCheck {

	public static boolean hasSingleCycle(int[] array) {

		int n = 0;
		int i = 0;
		
		while(n < array.length) {
			
			if(n > 0 && i == 0) {
				return false;
			} else {
				n++;
				i = getNextI(i, array);
			}
			
			
		}
		
		return i == 0;
	}
	
	public static int getNextI(int i, int[] array) {
		
		int jump = array[i];
		int nextI = (i + jump) % array.length;
		
		return nextI >= 0 ? nextI : nextI + array.length;
	}

	public static void main(String[] args) {
		int[] array = { 2, 3, 1, -4, -4, 2 };
		
		System.out.println(hasSingleCycle(array));
	}

}
