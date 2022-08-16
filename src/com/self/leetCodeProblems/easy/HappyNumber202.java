package com.self.leetCodeProblems.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber202 {

	// this doesn't really work/it's a copout using an arbitrary timeout
//	public static boolean isHappy(int num) {
//		
//		int n = num;
//		int sum;
//		int digit;
//		
//		if (n < 0) {
//			System.out.println("Negative number");
//			return false;
//		}
//		
//		long startTime = System.currentTimeMillis();
//		
//		// while n is not 1 (not happy yet)
//		while (n != 1 && (System.currentTimeMillis()-startTime)<5000) {
//			sum = 0;
//			
//			int nLength = String.valueOf(n).length();
//			
//			for (int i = 0; i < nLength; i++) {
//				// get individual digit
//				digit = n % 10;
//				// square the digit
//				int digitSquared = digit * digit;
//				// fix the n value
//				n = n / 10;
//				// add the digitSquared value to the sum
//				sum += digitSquared;
//			}
//			System.out.println("sum: " + sum);
//			
//			if (sum == 1) {
//				System.out.println("true");
//				return true;
//			} else {
//				n = sum;
//			}
//		}
//		System.out.println("false");
//		return false;
//	}
	
	// used solution on site to complete
	private static int getNext(int n) {
		int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
	}
	public static boolean isHappySolution(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        System.out.println(n == 1);
        return n == 1;
    }
	
	// main method
	public static void main(String[] args) {
		// isHappy(2);
		isHappySolution(19);
	}

}
