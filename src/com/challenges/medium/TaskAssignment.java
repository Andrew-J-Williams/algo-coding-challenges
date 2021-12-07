package com.challenges.medium;

import java.util.*;

/*
 * 
	Task Assignment
	
	Sample Input:
	
	Sample Output: 
	
	
	I promise to start this back up.
 * 
 */

public class TaskAssignment {

	public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
		// Write your code here.
		return new ArrayList<ArrayList<Integer>>();
	}

	public static void main(String[] args) {
		int k = 3;
		ArrayList<Integer> tasks = new ArrayList<>(); 
		tasks.add(1);
		tasks.add(3);
		tasks.add(5);
		tasks.add(3);
		tasks.add(1);
		tasks.add(4);
		
		System.out.println(taskAssignment(k, tasks));
	}

}
