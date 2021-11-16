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
		
		
		int[] evenEdits = new int[small.length() + 1];
		int[] oddEdits = new int[small.length() + 1];
		
		for(int i = 0; i < small.length() + 1; i++) {
			evenEdits[i] = i;
		}
		
		int[] currentEdits;
		int[] previousEdits;
		
		for(int i = 1; i < big.length() + 1; i++) {
			
			
			if(i % 2 == 0) {
				currentEdits = oddEdits;
				previousEdits = evenEdits;
			} else {
				currentEdits = evenEdits;
				previousEdits = oddEdits;
			}
			
			
			currentEdits[0] = i;
			
			for(int j = 1; j < small.length() + 1; j++) {
				
				if(big.charAt(i - 1) == small.charAt(j-1)) {
					currentEdits[j] = previousEdits[j - 1];
				} else {
					currentEdits[j] = 1 + Math.min(previousEdits[j -1], Math.min(previousEdits[j], currentEdits[j - 1]));
				}
				
			}
			
			
			
		}
		
		return big.length() % 2 == 0 ? evenEdits[small.length()] : oddEdits[small.length()];
	}

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "yabd";
		
		System.out.println(levenshteinDistance(str1, str2));

	}

}
