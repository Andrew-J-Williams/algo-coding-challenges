package com.challenges.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * 
	Minimum Waiting Time
	
	You're given a non-empty array of positive integers representing the amounts of time that specific queries take to execute. Only one query can be executed at a time, but the queries
	can be executed in any order.
	
	A query's 'waiting time' is defined as the amount of time it must wait before its execution can start. In other words, if a query is executed second, then its waiting time is the
	duration of the first query; if a query is executed third, then its waiting time is the sum of the durations of the first two queries.
	
	Write a function that returns the minimum amount of total waiting time for all the queries.
	
	Sample Input:
	[ 3, 2, 1, 2, 6 ]
	
	Sample Output:
	17
	
 * 
 */

public class MinimumWaitingTime {

	public static int minimumWaitingTime(int[] queries) {
		Arrays.sort(queries);

		int previousVal = 0;
		int sum = 0;

		for (int i = 0; i < queries.length - 1; i++) {
			previousVal += queries[i];
			sum += previousVal;
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] data1 = { 3, 2, 1, 2, 6 };
		int[] data2 = { 5, 1, 4 };

		System.out.println(minimumWaitingTime(data1));
	}

}
