package com.self.leetCodeProblems.easy;

/* You are a product manager and currently leading a team to develop a new product. 
 * Unfortunately, the latest version of your product fails the quality check. 
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which returns whether version is bad. 
 * Implement a function to find the first bad version. 
 * You should minimize the number of calls to the API.
 * 
 * (return the first bad version number, an int)
 */

// n = number of versions
// bad = the first bad version

class VersionControl {
	
	private final int bad = 2; // hard coded bad version, don't access
	
	boolean isBadVersion(int version) {
		if (version >= bad) {
			return true;
		}
		return false;
	}
}

public class FirstBadVersion278 extends VersionControl {
	
	// n must be >= bad
	public int firstBadVersion(int n) {
		
		// working with numbers, not an array
		int left = 1;
		int right = n;
		int result = -1;
		// do not define pivot here
		// defining a new pivot on every while loop worked instead of defining it outside the loop
		
		while (left <= right) {
			// pivot = (left + right) / 2
			// ^ THIS CAN OVERFLOW if left + right exceeds 2147483647 (INT_MAX)
			// use the below line instead
			int pivot = left + (right - left) / 2;
			
			if (isBadVersion(pivot)) { // if pivot is a bad version, first bad is somewhere to the left
				result = pivot;
				right = pivot - 1;
			} else { // if pivot is a good version, first bad is somewhere to the right
				left = pivot + 1;
			}
		}
		System.out.println(result);
		return result;
	}
	

	public static void main(String[] args) {
		
		FirstBadVersion278 firstBadVersion = new FirstBadVersion278();
		
		firstBadVersion.firstBadVersion(2);

	}

}
