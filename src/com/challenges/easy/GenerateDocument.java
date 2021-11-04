package com.challenges.easy;

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
		// Write your code here.
		return false;
	}

	public static void main(String[] args) {
		String characters1 = "aheaolabbhb";
		String document1 = "hello";
		
		System.out.println(generateDocument(characters1, document1));
	}

}
