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

		// 1. We create a variable that will represent the number of elements we have visited in our array, initializing it with a value of 0.
		int n = 0;
		
		// 2. We create another variable that will represent the index value we are currently at, starting at 0 as the first element in the array.
		int i = 0;
		
		// 3. We create a 'while' loop that runs while the value of n is less than the length of our array. Essentially, we are using n to make sure we've visited the same number
		// of elements that are in our array so we can have an idea of whether or not we covered all of them.
		while(n < array.length) {
			
			// 4. We check if 'n' is greater than 0 AND 'i' is equal to 0. If both conditions are true...
			if(n > 0 && i == 0) {
				
				// ...then we return false. The reason why is because with a single cycle, we should only reach the first index value at the end of the cycle since the cycle starts
				// from the first element. So if 'n' is a value greater than 0 and 'i' somehow ends up becoming 0, we know the cycle does not touch every element in the array. Take 
				// our example data below, with the numbers above each value indicating the value of 'n':
				//
				// n =  6  4  1   2   5  3
				//    [ 2, 3, 1, -4, -4, 2 ] = TRUE
				//
				// As you can see from the example, the single cycle is true for this array since the last element equal 6, which is the length of the array, and i == 0. Now let's
				// say our data was a false example, the following would happen:
				//      3 etc.1   2 
				// n =  3     1   2
				//    [ 2, 3, 1, -3, -4, 2 ] = FALSE
				//
				// In this example, the third element we reach (n = 3) is the first element in our array (i == 0). When this happens, we enter a loop where only these 3 elements are
				// counted, missing out completely on the other half the array. This is why the only value of 'n' that can be at i == 0 is 6, a single cycle.
				return false;
			
			// 5. Otherwise, if either condition comes back false...
			} else {
				
				// ...we increment the value of 'n' by 1...
				n++;
				
				// ...and set 'i' equal to the result of our helper method 'getNextI', which returns an integer and is responsible for determining the current index value in the
				// array.
				i = getNextI(i, array);
			}
			
			
		}
		
		// 6. Finally, after the loop has been broken, we do one final check to see if i is equal to 0. If it is, we've come full cycle and reach the first element, equaling a 
		// successful single cycle and returning true. Otherwise, it means that somewhere in the array one value created a loop that resulted in an incomplete cycle, returning
		// false as a final result. 
		//
		// To understand this final point, let's use one small example to demonstrate this:
		// 
		// n =      1,2,3 
		//    [ 2, 2, 2 ]
		//
		// As can be seen above, when the elements in our array equal a value that creates this kind of cycle, 'i' will never reach 0. Because only 1 element is ever touched outside
		// of the starting element, there would not be a single cycle present in this example and the function would ultimately return false.
		return i == 0;
	}
	
	// 7. Our helper method 'gotNextI' takes in two arguments: the current 'i' and our array.
	public static int getNextI(int i, int[] array) {
		
		// 8. We create variable equal to the value found at index 'i' in the array. Using our example data and starting from the beginning, jump = 2.
		int jump = array[i];
		
		// 9. We create another variable that will represent the next value of 'i' that will be reached after the jump. The way this is done is we add the value of 'jump' to 'i'
		// and use the modulo operator to find the remainder of the sum divided by the array's length. We do this because we may have values in our array that exceed the length of
		// the array. For example, if instead of 2 being the first element of the array, what if it was 26? Well, our array is only 6 elements long, and returning i > array.length
		// would result in an error. Instead, we use the modulo to "wrap around" our array and account for these cases.
		int nextI = (i + jump) % array.length;
		
		// 10. We return the result of a conditional: if the next 'i' is greater than or equal to 0, then we return next 'i'. If it is not, then we return next 'i' plus the length
		// of the array. This accounts for another edge case that we may deal with: when next 'i' equals a negative number. Using our example, when we reached i = 3 in our array
		// the value at that index is -4, and following the previous logic 'nextI' would equal -1. Since a negative index will cause an error, we need to add the length of the array
		// to i to get the positive value represented in the wrap around. So in this case 'nextI' would be -1 + 6 = 5.
		return nextI >= 0 ? nextI : nextI + array.length;
	}

	public static void main(String[] args) {
		int[] array = { 2, 3, 1, -4, -4, 2 };
		
		System.out.println(hasSingleCycle(array));
	}

}
