package com.challenges.easy;

/*
 * 
	Binary Search
	
	Write a function that takes in a sorted array of integers as well as a target integer. The function should use the Binary Search algorithm to determine if the
	target integer is contained in the array and should return its index if it is, otherwise -1.
	
	Binary search involves breaking down our set of values continuously in half until we find the value we are searching for. Take the example of a college professor
	searching through a stack of tests, all arranged in alphabetical order by first name. If the name we are looking for is "Jenny", we know if we open the stack to
	the middle all tests to the right can be eliminated. We continue the process until finding the paper.
	
	Sample Input:
	array = [ 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 ]
	target = 33
	
	Sample Output:
	3
 * 
 */


public class BinarySearch {

	// 1. We have our main function that accepts the array and the target value, returning the integer result of our recursive function.
	public static int binarySearch(int[] array, int target) {
		
		return binaryCheck(array, target, 0, array.length - 1);
		
	}
	
	// 2. Our recursive function accepts the array, the target, a left pointer and a right pointer, indicating opposite ends of the array.
	public static int binaryCheck(int[] array, int target, int left, int right) {
		
		// 3. If our left pointer is greater than the right...
		if(left > right) {
			
			// ...we know that our target value was not found, so we return -1. 
			return -1;
			
		}
		
		// 4. Otherwise, we create a variable 'm' and set it equal to the middle value of our left and right values.
		int m = (left + right) / 2;
		
		// 5. We create a variable to equal the index value of 'm'.
		int match = array[m];
		
		// 6. If our match is equal to the target value...
		if(target == match) {
			
			// ...then we simply return 'm', representing the index of the target value.
			return m;
		// 7. Otherwise, if the target is less than the match, we know that all values to the right of 'm' are greater than the target, eliminating half the array...	
		} else if(target < match) {
			
			// ...so we return our recursive function with our right pointer's value minus 1, shrinking the search area.
			return binaryCheck(array, target, left, m - 1);
			
		// 8. Finally, if the target value is greater than match, it means the opposite: all values to the left of 'm' are less than the target value...	
		} else {
			
			// ... so we simply return our recursive function with our left pointer plus 1.
			return binaryCheck(array, target, m + 1, right);
		}
		
		
	}

	public static void main(String[] args) {
		int[] array1 = { 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 };
		int target1 = 33;

		System.out.println(binarySearch(array1, target1));
	}

}
