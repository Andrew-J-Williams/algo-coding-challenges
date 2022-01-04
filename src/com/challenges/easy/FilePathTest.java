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
		String text = "/nmlstage/clmsktp/docroot/doc";
		File textFile = new File("Y:/nmlstage/clmsktp/docroot/doc");
		System.out.println(text.contains("/nmlstage"));
		text = text.replace("/nmlstage", "");
		System.out.println(text);
		System.out.println(text.contains("/nmlstage"));
		
		
			//System.out.println("Path Absolute Path: " + path.toAbsolutePath());
			//System.out.println("Absolute Path: " + text.getPath());
			//System.out.println("File Size: " + text.length());
		
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
