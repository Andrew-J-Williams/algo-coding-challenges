package com.challenges.easy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FilePathTest {

	public static void main(String[] args){

		try {
			File text = new File("test.txt");
			System.out.println("Absolute Path: " + text.getAbsolutePath());
			System.out.println("File Size: " + text.length());
			System.out.println(" "); 
		
			Scanner scnr = new Scanner(text);
		
			int lineNumber = 1;
		
			while(scnr.hasNextLine()) {
				String line = scnr.nextLine();
				System.out.println("line " + lineNumber + ":" + line);
				lineNumber++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

}
