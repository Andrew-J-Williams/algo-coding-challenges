package com.challenges.easy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FilePathTest {

	public static void main(String[] args) throws FileNotFoundException {

		File text = new File("");
		System.out.println("Absolute Path: ");
		
		Scanner scnr = new Scanner(text);
		
		int lineNumber = 1;
		
		while(scnr.hasNextLine()) {
			String line = scnr.nextLine();
			System.out.println("line " + lineNumber + ":" + line);
			lineNumber++;
		}

	}

}
