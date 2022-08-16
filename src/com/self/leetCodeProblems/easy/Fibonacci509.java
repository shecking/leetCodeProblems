package com.self.leetCodeProblems.easy;

/* The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, 
 * such that each number is the sum of the two preceding ones, starting from 0 and 1. 
 * That is,
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * 
 * Given n, calculate F(n).
 */

public class Fibonacci509 {
	
	public int fibonacci(int n) {
		
		if (n == 0 || n == 1) { // base case
			return n;
		} else { // recursive case
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	public static void main(String[] args) {
		
		Fibonacci509 fib = new Fibonacci509();
		
		System.out.println(fib.fibonacci(7));
	}

}
