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
		
		// 1. We check and see if n is equal to 2, if it is...
		if (n == 2){
			
			// ...we return 1 since it's the 2nd number in the fibonacci sequence.
			return 1;
			
		// 2. Otherwise, if n is equal to 1...	
		} else if (n == 1){
			
			// ...then we return 0 since it is the first number in the fibonacci sequence.
			return 0;
		
		// 3. If n is equal to any other number...
		} else {
			
			// ...we return the sum of getNthFib n - 1 and n - 2. This will get the two previous fibonacci numbers before n in the sequence and add them together (brilliant!).
			// So for example, if n = 6, then we will find fib(6 - 1) + fib(6 - 2) = fib(5) + fib(4) = 3 + 2 = 5!
			return getNthFib(n - 1) + getNthFib(n - 2);
		}
	}

	public static void main(String[] args) {
		int n = 6;
		int n2 = 2;

		System.out.println(getNthFib(n));
		System.out.println(getNthFib(n2));

	}

}
