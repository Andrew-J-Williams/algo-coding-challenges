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
		
		// 1. We created a two dimensional array with our 2nd string's length plus 1 representing the rows and our 1st string's length plus 1 representing our columns.
		// We add 1 to account for blank spaces/empty strings.
		int[][] edits = new int[str2.length() + 1][str1.length() + 1];
		
		for(int i = 0; i < str2.length() + 1; i++) {
			for(int j = 0; j < str1.length() + 1; j++) {
				
				edits[i][j] = j;
				
			}
			
			edits[i][0] = i;
		}
		
		
		for(int i = 1; i < str2.length() + 1; i++) {
			for(int j = 1; j < str1.length() + 1; j++) {
				
				if(str2.charAt(i - 1) == str1.charAt(j - 1)) {
					edits[i][j] = edits[i - 1][j - 1];
				} else {
					edits[i][j] = 1 + Math.min(edits[i - 1][j - 1], Math.min(edits[i - 1][j], edits[i][j - 1]));
				}
				
			}
		}
				
		return edits[str2.length()][str1.length()];
	}

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "yabd";
		
		System.out.println(levenshteinDistance(str1, str2));

	}

}
