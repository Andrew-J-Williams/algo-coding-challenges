package com.challenges.medium;

import java.util.Arrays;

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
		int[][] edits = new int[str2.length() + 1][str1.length() + 1];
		
		// 2. We run two 'for' loops, the first runs the length of our 2nd string plus 1 and the second runs the length of our first string plus 1.
		for(int i = 0; i < str2.length() + 1; i++) {
			for(int j = 0; j < str1.length() + 1; j++) {
				
				// 3. Within our 2nd 'for' loop, we are setting the current column equal to the value of 'j'. We repeat this for each row 'i'.
				edits[i][j] = j;
				
			}
			
			// 4. After each row is created with the values of 'j' representing the column, we set the first value of each row equal to i. As a result, given our test data,
			// the following matrix would be created:
			/*
			 
			  c1 c2 c3 c4
			  
		r1	 [ 0, 1, 2, 3 ]
		r2	 [ 1, 1, 2, 3 ]
		r3	 [ 2, 1, 2, 3 ]
		r4	 [ 3, 1, 2, 3 ]
		r5	 [ 4, 1, 2, 3 ]
		 
			 */
			 // NOTE: the first value of each row becomes the current value of 'i' as the loop iterates.
			edits[i][0] = i;
		}
	
		
		// 5. We create another set of double 'for' loops, but the only difference this time is we set the initial values of 'i' and 'j' to 1 instead of 0.
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
