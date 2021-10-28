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
		
		// 1. We sort both ArrayLists in ascending order.
		Collections.sort(redShirtHeights);
		Collections.sort(blueShirtHeights);
		
		// 2. We create variables to get the max value for the red shirt students and the blue shirt students.
		int maxRed = redShirtHeights.get(redShirtHeights.size()-1);
		int maxBlue = blueShirtHeights.get(blueShirtHeights.size()-1);
		
		// 3. We create two ArrayLists that will represent our front row and back row with blue shirts. We don't set them equal to anything initially.
		ArrayList<Integer> frontRow;
		ArrayList<Integer> backRow;
		
		// 4. We create a variable that will hold the highest overall height between red and blue, determined using 'Math.max'.
		int maxOverall = Math.max(maxRed, maxBlue);
		
		// 5. We determine which students ArrayList contains that max value. Based on that information, we assigned red and blue shirts to either the front row or back row.
		if(maxRed == maxOverall) {
			frontRow = blueShirtHeights;
			backRow = redShirtHeights;
		} else {
			frontRow = redShirtHeights;
			backRow = blueShirtHeights;
		}
		
		// 6. We create a 'for' loop to iterate over both ArrayLists in order to compare the heights at the given index.
		for(int i = 0; i < redShirtHeights.size(); i++) {
			
			// 7. If the height in the front row is greater than or equal to the height in the back row...
			if(frontRow.get(i) >= backRow.get(i)) {
				
				// ...then we return false is each student in the back row must be taller than the student directly in front of them in the front row.
				return false;
			}
		}
		
		// 7. If all back row heights are greater than the front row heights, then we return true, satisfying the conditions in the prompt.
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
