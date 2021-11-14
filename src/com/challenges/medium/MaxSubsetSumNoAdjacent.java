package com.challenges.medium;

/*
 * 
	Max Subset Sum No Adjacent
	
	Write a function that takes in an array of positive integers and returns the maximum sum of non-adjacent elements in the array.
	
	If the input array is empty, the function should return 0.
	
	
	Sample Input:
	array = [ 75, 105, 120, 75, 90, 135 ]
	
	Sample Output:
	330
 * 
 */

public class MaxSubsetSumNoAdjacent {

	public static int maxSubsetSumNoAdjacent(int[] array) {
		
		// 1. We check to see if our array is empty, which is the case if the length equals 0, if it is...
		if(array.length == 0) {
			
			// ...we return 0 following the instructions of the prompt.
			return 0;
		
		// 2. If the array only has only element, meaning its length is equal to 1...	
		} else if(array.length == 1) {
			
			// ...we return the first and only element of that array.
			return array[0];
		}
		
		// 3. If we pass the first 2 conditionals, we know our array is at least 2 values long. Thus we create a variable called 'second' that will ironically hold the first element
		// of our array at index 0. Using our example data, second = 4.
		int second = array[0];
		
		// 4. We create another variable called 'first' that will be equal to the maximum value between the first and second element of our array. Using our example data,
		// first = Math.max(4, 3) = 4.
		int first = Math.max(array[0], array[1]);
		
		// 5. We create a 'for' loop that starts at the 3rd element in our array and runs until 'i' is greater than or equal to the array's length. We start at the 3rd element because
		// we need to check the next non-adjacent value per the prompt's requirements.
		for(int i = 2; i < array.length; i++) {
			
			// 6. We create a variable called 'current' that is equal to the maximum values between the value of our 'first' variable and the value of our 'second'variable plus the
			// value at index 'i'. Using our example data, current = Math.max(4, 4 + 5) = Math.max(4, 9) = 9.
			int current = Math.max(first, second + array[i]);
			
			// 7. We set 'second' equal to the value of 'first'. In this case second = 4.
			second = first;
			
			// 8. We then set 'first' equal to the current value, which in this example is 9.
			first = current;
			
			// Breaking down the logic from Step 3 onward: (1) we check and see if the first or second value of the array is the greatest value, (2)
		}
		
		return first;
	}

	public static void main(String[] args) {
		int[] array = { 4, 3, 5, 200, 5, 3 };
		
		System.out.println(maxSubsetSumNoAdjacent(array));

	}

}
