package com.self.leetCodeProblems.easy;

public class IsSubsequence392 {
	
	/*Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
	 * A subsequence of a string is a new string that is formed from the original string by deleting some 
	 * (can be none) of the characters without disturbing the relative positions of the remaining characters. 
	 * 	 	(i.e., "ace" is a subsequence of "abcde" while "aec" is not).
	 */
	
	// used solution on site to complete
	public static boolean isSubSequence(String sub, String big) {
		// try two pointer approach
		// run two pointers, one tracking sub and one tracking big
		// increment big every time, increment sub only when a match is found
		// how to check if done?
			// if we've reached the end of sub, that means we found every character in order within big
		int subPointer = 0;
		int bigPointer = 0;
		
		// while both pointers haven't reached the end of their strings
		while (subPointer < sub.length() && bigPointer < big.length()) {
			if (sub.charAt(subPointer) == big.charAt(bigPointer)) {
				subPointer++;
			}
			bigPointer++;
		}
		
		// this returns true if we've reached the end of sub, meaning we've found all characters
		// System.out.println(subPointer==sub.length());
		return subPointer==sub.length();
	}

	public static void main(String[] args) {
		isSubSequence("abc", "ahbgdc");
		isSubSequence("axc", "ahbgdc");
	}

}
