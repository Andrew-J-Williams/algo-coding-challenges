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
	    
		Arrays.sort(redShirtSpeeds);
		Arrays.sort(blueShirtSpeeds);
		
		int maxSpeed = 0;
		int minSpeed = 0;
		
		int start = 0;
		int end = redShirtSpeeds.length - 1;
		
		while(start <= end) {
	
			if(start == end) {
				if(redShirtSpeeds[end] > blueShirtSpeeds[start]) {
					maxSpeed += redShirtSpeeds[end];
					minSpeed += redShirtSpeeds[end];
				} else {
					maxSpeed += blueShirtSpeeds[start];
					minSpeed += blueShirtSpeeds[start];
				}
			} else {
				if(redShirtSpeeds[end] > blueShirtSpeeds[start]) {
					maxSpeed += redShirtSpeeds[end];
				} else {
					maxSpeed += blueShirtSpeeds[start];
				}
				
				if(blueShirtSpeeds[end] > redShirtSpeeds[start]) {
					maxSpeed += blueShirtSpeeds[end];
				} else {
					maxSpeed += redShirtSpeeds[start];
				}
					
				if(redShirtSpeeds[start] > blueShirtSpeeds[start]) {
					minSpeed += redShirtSpeeds[start];
				} else {
					minSpeed += blueShirtSpeeds[start];
				}
				
				if(redShirtSpeeds[end] > blueShirtSpeeds[end]) {
					minSpeed += redShirtSpeeds[end];
				} else {
					minSpeed += blueShirtSpeeds[end];
				}
			}
			
			start++;
			end--;
		}
		
		if(fastest == true) {
			return maxSpeed;
		} else {
			return minSpeed;
		}
		
	}
	
	public static void reverseArrayInPlace(int[] array) {
		int start = 0;
		int end = array.length - 1;
		
		while(start < end) {
			
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
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
