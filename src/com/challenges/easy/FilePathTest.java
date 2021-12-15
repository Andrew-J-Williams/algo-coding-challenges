package com.challenges.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.Scanner;

public class FilePathTest {

	public static void main(String[] args){

		Path path = Paths.get("CLI Review.docx"); 
		File text = new File("");
		System.out.println(text);
		
		
			System.out.println("Path Absolute Path: " + path.toAbsolutePath());
			System.out.println("Absolute Path: " + text.getPath());
			System.out.println("File Size: " + text.length());
			System.out.println(" "); 
		
			/*
			FileReader fileStream = new FileReader(text);
			
			BufferedReader buffer = new BufferedReader(fileStream);
			
			String line = null;
			
			
			while(	(line = buffer.readLine()) != null) {
				System.out.println(line);
			}
			*/
			
		

	}

}
