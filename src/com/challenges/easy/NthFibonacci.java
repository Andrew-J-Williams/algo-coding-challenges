package com.challenges.easy;

/*
 * 
	Nth Fibonacci
	
	The Fibonacci sequence is defined as follows: the first number of the sequence (0), the second number of the sequence (1), and the 'nth' number is the sum of (n-1)th and
	(n-2)th numbers. Write a function takes in an integer 'n' and returns the 'nth' fibonacci number.
	
	Important note: the Fibonacci sequence is often defined with its first two numbers as F0 = 0 and F1 = 1. For the purpose of this question, the first Fibonacci number is F0; therefore,
	getNthFib(1) is equal to F0 and getNthFib(2) is equal to F1, and so on.
	
	Sample Input:
	n = 6
	
	Sample Output:
	5 // 0, 1, 1, 2, 3, 5
	
 * 
 */

public class NthFibonacci {

	public static int getNthFib(int n) {
		if (n == 2){
			return 1;
		} else if (n == 1){
			return 0;
		} else {
			return getNthFib(n - 1) + getNthFib(n - 2);
		}
	}

	public static void main(String[] args) {
		int n = 5;
		int n2 = 2;

		System.out.println(getNthFib(n));
		System.out.println(getNthFib(n2));

	}

}
