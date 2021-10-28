package com.challenges.easy;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 
	Tandem Bicycle
	
	A tandem bicycle is a bicycle operated by 2 people: person A and person B. Both people pedal the bicycle, but the person who pedals faster determines the speed of the bicycle. So if
	person A pedals at a speed of '5' and person B pedals at a speed of '4', the tandem bicycle moves at a speed of 5.
	
	You're given two lists of positive integers: one that contains the speeds of the riders wearing red shirts and another that contains the speeds of riders wearing blue shirts. Each rider
	is represented by a single, positive integer, which is the speed they pedal the tandem bike at. Both lists are the same length, meaning there are just as many red shirt riders as there
	are blue shirt riders. Your goal is to pair every rider wearing a red shirt with a rider wearing a blue shirt to operate the tandem bicycle.
	
	Write a function that determines the maximum total speed or the minimum possible total speed of all the tandem bicycles being ridden based on an input parameter, 'fastest'. If 
	'fastest = true', then your function should return the maximum possible total speed; otherwise it should return the minimum total speed.
	
	"Total speed" is defined as the sum of all the tandem bicycles being ridden. 
	
	Sample Input:
	redShirtSpeeds = [ 5, 5, 3, 9, 2 ]
	blueShirtSpeeds = [ 3, 6, 7, 2, 1 ]
	fastest = true
	
	Sample Output:
	32
 * 
 */


public class TandemBicycle {

	public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
	    
		// 1. We sort both arrays in ascending order. 
		Arrays.sort(redShirtSpeeds);
		Arrays.sort(blueShirtSpeeds);
		
		
		// 2. We check and see if 'fastest' is set to 'false', if so...
		if(!fastest) {
			
			// ...we run our helper method that reverses the order of the redShirtSpeeds array (see logic for helper below).
			// If we are trying to find the minimum, we directly compare each index value in both arrays to get the greater of the two.
			reverseArrayInPlace(redShirtSpeeds);
		}
		
		// 3. We create a variable for our total speed and set it equal to 0.
		int speedSum = 0;
		
		// 4. We create a 'for' loop to iterate over every element in both the red and blue rider arrays.
		for(int i = 0; i < redShirtSpeeds.length; i++) {
			
			// 5. We create variables to hold the value of of the red rider and one for the blue rider. Each acts as a pointer, each moving closer to each other.
			int redRider = redShirtSpeeds[i];
			int blueRider = blueShirtSpeeds[blueShirtSpeeds.length - i - 1];
			
			// 6. We compare the rider's speeds and add the max of the two to our sum.
			speedSum += Math.max(redRider, blueRider);
			
		}
		
		// 7. Once the loop has completed, we return our final speed sum.
		return speedSum;
	}
	
	// 8. In our helper method, we accept the parameter of an integer array.
	public static void reverseArrayInPlace(int[] array) {
		
		// 9. We define variables for the start and ending indexes of the array.
		int start = 0;
		int end = array.length - 1;
		
		// 10. While the start index is less than the end index...
		while(start < end) {
			
			// ...we define a variable to store the start index value...
			int temp = array[start];
			
			// ...we set a new value our start index equal to our end index value...
			array[start] = array[end];
			
			// ...and set our end index value equal to the original start index value stored in 'temp'.
			array[end] = temp;
			
			// 11. Finally, we increment start by 1 and decrement end by 1.
			start++;
			end--;
			
		}
	}
	
	public static void main(String[] args) {
		int[] redShirts1 = { 1, 1, 1, 1, 3, 3, 3, 3, 5, 7 };
		int[] blueShirts1 = { 1, 1, 1, 1, 2, 2, 2, 2, 9, 11 };
		

		System.out.println(tandemBicycle(redShirts1, blueShirts1, true));
		
	}

}
