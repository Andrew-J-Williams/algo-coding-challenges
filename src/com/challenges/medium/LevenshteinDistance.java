package com.challenges.medium;

/*
 * 
	Levenshtein Distance
	
	Write a function that takes in two strings and returns the minimum number of edit operations that need to be performed on the first string to obtain the second string.
	
	There are 3 different edit operations: insertion of a character, deletion of a character, and the substitution of a character for another.
	
	Sample Input:
	str1 = "abc"
	str2 = "yabd" 
	
	Sample Output:
	2 // insert "y"; substitute "c" for "d"
 * 
 */

public class LevenshteinDistance {

	public static int levenshteinDistance(String str1, String str2) {
		
		// 1. We create two variables: one designed to hold the smaller of our two strings and the other to hold the bigger of the two.
		String small = str1.length() < str2.length() ? str1 : str2;
		String big = str1.length() >= str2.length() ? str1 : str2;
		
		
		
		
		return -1;
	}

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "yabd";
		
		System.out.println(levenshteinDistance(str1, str2));

	}

}
