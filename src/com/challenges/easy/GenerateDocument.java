package com.challenges.easy;

import java.util.*;

/*
 * 
	Generate Document
	
	You're given a string of available characters and a string representing a document that you need to generate. Write a function that determines if you can generate
	the document using the available characters. If you can generate the document, your function should return true; otherwise, it should return false.
	
	You're only able to generate the document if the frequency of unique characters in the characters string is greater than or equal to the frequency of unique
	characters in the document string. For example, if you're given characters = "abcac" and document = "aabbccc" you cannot generate the document because you're
	missing one 'c'.
	
	The document that you need to create may contain any characters, including special characters, capital letters, numbers, and spaces.
	
	Note: you can always generate the empty string ("").
	
	Sample Input:
	characters = "Bste!hetsi ogEAxpelrt x "
	document = "AlgoExpert is the Best!"
	
	Sample Output:
	true 
 * 
 */

public class GenerateDocument {

	public static boolean generateDocument(String characters, String document) {

		// 1. We create a 'for' loop that will iterate through the length of our document String.
		for(int i = 0; i < document.length(); i++) {
			
			// 2. We create a variable that will hold the individual character of each index in our document String as we iterate through it, allowing us to check each character.
			char character = document.charAt(i);
			
			// 3. We create two variables equal to the result of our 'count' helper method, which will be the frequency of the character in the value of an integer.
			int documentFrequency = count(character, document);
			int charactersFrequency = count(character, characters);
			
			// 4. We check to see if the character's frequency within the document is greater than its frequency in our string of characters. If it is...
			if(documentFrequency > charactersFrequency) {
				
				// ...we return false, since our characters String MUST have the exact amount of characters and spaces that are present in the document String in order to match.
				return false;
			}
		}
		
		// 5. If the loop completes and the frequency of characters is less than or equal between the document and the character String, we know all characters are accounted for
		// and we can return true.
		return true;
	}
	
	// 6. Our helper method 'count' accepts two parameters: the specific character we are checking, as well as the target String we are searching for it in.
	public static int count(char character, String target) {
		
		// 7. We create a variable that will hold the number of times the character in question appears in the target String.
		int frequency = 0;
		
		// 8. We create a 'for' loop that will iterate over the target String.
		for(int i = 0; i < target.length(); i++) {
			
			// 9. We create a variable that holds the character at index 'i' in the String. This way we can check each individual character.
			char c = target.charAt(i);
			
			// 10. If the character we are checking is equal to the character at the given index 'i'...
			if(c == character) {
				
				// ...we increment our frequency variable by one.
				frequency += 1;
			}
		}
		
		// 11. Once all characters in the String have been checked, we return our final frequency value, representing all the instances of that given character in the target String.
		return frequency;
	}

	public static void main(String[] args) {
		String characters1 = "aheaolabbhb";
		String document1 = "hello";
		
		System.out.println(generateDocument(characters1, document1));
	}

}
