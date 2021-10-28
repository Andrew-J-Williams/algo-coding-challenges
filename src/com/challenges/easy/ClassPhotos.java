package com.challenges.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * 
	Class Photos
	
	It's photo day at the local school, and you are the photographer assigned to take class photos. The class you'll be photographing has an even number of students, and all these students
	are wearing either red or blue shirts. In fact, exactly half the class is wearing red shirts, and the other half is wearing blue shirts. You're responsible for arranging the students
	in two rows before taking the photo. Each row should contain the same number of students and adhere to the following guidelines:
	
		- All students wearing red shirts should be in the same row.
		- All students wearing blue shirts should be in the same row.
		- Each student in the back row must be strictly taller than the student directly in front of them in the front row.
		
	You're given two input arrays: one containing the heights of all students with red shirts and another containing the heights of all students with blue shirts. These arrays will always
	be the same length, and each height will be a positive integer. Write a function that determines whether or not a class photo that follows the stated guidelines can be taken.
	
	Note: You can assume that each class contains at least 2 students.
	
	Sample Input:
	redShirtHeights = [ 5, 8, 1, 3, 4 ];
	blueShirtHeights = [ 6, 9, 2, 4, 5 ];
	
	Sample Output:
	true
 * 
 */

public class ClassPhotos {

	public static boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
		
		Collections.sort(redShirtHeights);
		Collections.sort(blueShirtHeights);
		
		int maxRed = redShirtHeights.get(redShirtHeights.size()-1);
		int maxBlue = blueShirtHeights.get(blueShirtHeights.size()-1);
		ArrayList<Integer> frontRow;
		ArrayList<Integer> backRow;
		
		System.out.println("Red Max Value: " + maxRed);
		System.out.println("Blue Max Value: " + maxBlue);
		
		int maxOverall = Math.max(maxRed, maxBlue);
		
		if(maxRed == maxOverall) {
			frontRow = blueShirtHeights;
			backRow = redShirtHeights;
		} else {
			frontRow = redShirtHeights;
			backRow = blueShirtHeights;
		}
		
		for(int i = 0; i < redShirtHeights.size(); i++) {
			if(frontRow.get(i) >= backRow.get(i)) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		ArrayList<Integer> redShirts1 = new ArrayList<>();
		ArrayList<Integer> blueShirts1 = new ArrayList<>();
		
		redShirts1.add(5);
		redShirts1.add(8);
		redShirts1.add(1);
		redShirts1.add(3);
		redShirts1.add(4);
		
		blueShirts1.add(6);
		blueShirts1.add(9);
		blueShirts1.add(2);
		blueShirts1.add(4);
		blueShirts1.add(5);
		
		System.out.println(classPhotos(redShirts1, blueShirts1));

	}

}
