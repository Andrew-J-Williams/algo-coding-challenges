package com.challenges.medium;

/*
 * 
	Longest Peak
	
	Write a function that takes in an array of integers and returns the length of the longest peak in the array.
	
	A peak is defined as adjacent integers in the array that are strictly increasing until they reach a tip (the highest value in the peak), at which point they become strictly
	decreasing. At least 3 integers are required to form a peak.
	
	For example, the integers 1, 4, 10, 2 form a peak, but the integers 4, 0, 10 don't and neither do the integers 1, 2, 2, 0. Similarly, the integers 1, 2, 3 don't form a peak
	because they are not strictly decreasing integers after the 3.
	
	Sample Input:
	array = [ 1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3 ]
	
	Sample Output:
	6 // 0, 10, 6, 5, -1, -3
 * 
 */

public class LongestPeak {

	public static int longestPeak(int[] array) {
		
		// 1. We create a variable that represents the longest peak length we have, initializing it to 0 to start.
		int longestPeakLength = 0;
		
		// 2. We create a variable to represent in the index of our array. We set it at 1 for comparison purposes as we iterate over the array.
		int i = 1;
		
		// 3. We create a 'while' loop that runs until i is greater than the length of the array minus 1. We says minus 1 because if we are looking for peaks, a peaks has numbers to
		// both the right and left of it that are less in value then itself. Since we will be checking the value right of it, we need to make sure that value is within the bounds of
		// our array, otherwise our program will return an error.
		while(i < array.length - 1) {
		
			// 4. We create a boolean variable that holds the true/false value of whether or not the values to the left and right of i are less than i. This boolean checks to see if
			// the value at 'i' is a peak.
			boolean isPeak = array[i - 1] < array[i] && array[i] > array[i + 1];
			
			// 5. We use a conditional to check whether or not 'isPeak' is false, meaning we do not have a peak value at index 'i'. If it is false...
			if(!isPeak) {
				
				// ...we increment 'i' by 1, moving to the next value in the array, and continuing the 'while' loop, restarting the logic all over again.
				i += 1;
				continue;
			}
			
			// 6. If 'isPeak' equals true, then we know the left and right values are less than i's value. In that case, we create a variable to represent our left index and set it equal
			// to i minus 2. We do this because we already know i minus 1 is less than i, so now we need to go further and check beyond it to the left to see how long our peak length is.
			int leftIndex = i - 2;
			
			// 7. We create another 'while' loop that runs while the left index value is greater than or equal to 0 (basically doesn't exceed the left bound of the array) and the value at
			// the left index is strictly less than the value at the left index plus 1. If this is true, we know that the numbers on the left side are decreasing in value.
			while(leftIndex >= 0 && array[leftIndex] < array[leftIndex + 1]) {
				
				// 8. Until the values at the leftIndex are not decreasing, we decrease the value of the left index by 1.
				leftIndex -= 1;
			}
			
			// 7. We repeat the same process for the right side, but this time we take i plus 2.
			int rightIndex = i + 2;
			
			// 8. We create another 'while' loop that runs while the right index is less than the length of the array and the value of the right index is strictly less than the value of
			// the index that came before it (i - 1). This does the same thing for the right side of the peak that the left 'while' loop did.
			while(rightIndex < array.length && array[rightIndex] < array[rightIndex - 1]) {
				
				// 9. While the conditions hold, we add 1 to the right index.
				rightIndex += 1;
			}
			
			// 10. After both our 'while' loops complete, we compute the current peak length by subtracting the left and right index from each other minus 1. We add minus 1 to account for the
			// value of the peak, since the left and right index variables both included the peak in their calculation.
			int currentPeakLength = rightIndex - leftIndex - 1;
			
			// 11. We set a conditional to check if the current peak length is greater than the longest peak length. If it is...
			if(currentPeakLength > longestPeakLength) {
				
				// ...we set the longest peak length equal to the current peak length.
				longestPeakLength = currentPeakLength;
			}
			
			// 12. Regardless of whether or not the longest peak length changed, we set 'i' equal to the right index. We do this because the end of the right peak length indicates the
			// potential start of a new one.
			i = rightIndex;
			
		}
		
		// 13. After our main 'while' loop completes or breaks, we return the longest peak length.
	    return longestPeakLength;
	  }
	
	public static void main(String[] args) {
		
		int[] array1 = { 1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3 };
		int[] array2 = { 1, 3, 2 };
		
		System.out.println(longestPeak(array1));

	}

}
