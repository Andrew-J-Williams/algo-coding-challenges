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
		
		// 1. We created a two dimensional array with our 2nd string's length plus 1 representing the rows (i) and our 1st string's length plus 1 representing our columns (j).
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
	
		
		// 5. We create another set of double 'for' loops, but the only difference this time is we set the initial values of 'i' and 'j' to 1 instead of 0. We do this to account
		// for the fact that our 2D array has an index of 0 at edits[0][0] representing an empty string.
		for(int i = 1; i < str2.length() + 1; i++) {
			for(int j = 1; j < str1.length() + 1; j++) {
				
				// 6. If the character at the index of i - 1 in our second string is equal to the index of j - 1 in our first string...
				if(str2.charAt(i - 1) == str1.charAt(j - 1)) {
					
					// ...then we update the value at edits[i][j] to the value found at edits[i - 1][j - 1]. To understand what is happening, lets use our example data to see how
					// this works. At str2.charAt(2 - 1) and str1.charAt(1 - 1), both are equal to 'a'. So for this case, i = 2 and j = 1, so we would take edits[2][1] (whose value
					// is 1) and set its value equal to the value found at edits[1][0], which just so happens to be 1, the same value. Basically, whenever the characters area equal
					// we set edits[i][j] equal to the value at the left diagonal from it.
					edits[i][j] = edits[i - 1][j - 1];
					
				// 7. If the characters are not equal (which happens to be the majority of the time for our example)...	
				} else {
					
					// ...we set edits[i][j]'s value equal to the minimum value of 3 different values plus 1. These 3 different values represent the 3 values that surround the 
					// current value: the value immediately left (edits[i][j - 1], the value at the left diagonal (edits[i - 1][j - 1], and the value immediately above the current
					// value (edits[i - 1][j]). We add 1 because given are algorithm, when keeping track of edits, the number of edits is always equal to the minimum value of the
					// 3 surrounding values plus 1. So given our example data, when i = 4 and j = 1, string 1's char is 'a' and string 2's char is 'd'. As a result, our function
					// checks the 3 values surrounding edits[4][1] (4, 3, 2) and determines that 2 is the minimum overall. It then adds 1 to 2 and makes 3 value the new
					// value of edits[4][1].
					edits[i][j] = 1 + Math.min(edits[i - 1][j - 1], Math.min(edits[i - 1][j], edits[i][j - 1]));
				}
				
			}
		}
			// Below is the resulting matrix after these two 'for' loops finish.
			/*
		 
		  	  j0 j1 j2 j3
		  
	    i0	 [ 0, 1, 2, 3 ]
	    i1	 [ 1, 1, 2, 3 ]
	    i2	 [ 2, 1, 2, 3 ]
	    i3	 [ 3, 2, 1, 2 ]
	    i4	 [ 4, 3, 2, 2 ]
	 
		 */
		
		System.out.println(Arrays.toString(edits[0]));
		System.out.println(Arrays.toString(edits[1]));
		System.out.println(Arrays.toString(edits[2]));
		System.out.println(Arrays.toString(edits[3]));
		System.out.println(Arrays.toString(edits[4]));
		
		
		// 8. Finally, we return the final value in our two dimensional array, which can be found in the last value of the last row.
		return edits[str2.length()][str1.length()];
	}

	public static void main(String[] args) {
		String str1 = "abc"; // j
		String str2 = "yabd"; // i
		
		System.out.println(levenshteinDistance(str1, str2));

	}

}
