package com.self.leetCodeProblems.easy;

import java.util.HashMap;
import java.util.Map;

/* Given a string s which consists of lowercase or uppercase letters, 
 * return the length of the longest palindrome that can be built with those letters.
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 */

public class LongestPalindrome409 {

	public static int longestPalindrome(String str) {
		
		if (str == null || str.length() == 0) {
			return 0;
		}
		
		Map<Character, Integer> characterMap = new HashMap<>(); // array for letter counts
		
		// creating map of characters and counts
		for (char letter : str.toCharArray()) {
			if (!characterMap.containsKey(letter)) { // if letter is not in map
				characterMap.put(letter, 1);
			} else { // if letter is in map
				characterMap.put(letter, characterMap.get(letter) + 1);
			}
		}
		
		int maxLength = 0;
		boolean foundCenter = false;
		
		// loop through map, get value(count) of each key(letter), update maxLength
		for (Map.Entry<Character, Integer> m : characterMap.entrySet()) {
			int count = m.getValue();
			
			if (count == 1) { // if count is 1
				if (!foundCenter) {
					maxLength++;
					foundCenter = true;
				}
			} else if (count % 2 == 1) { // if count is odd
				if (!foundCenter) {
					maxLength += count;
					foundCenter = true;
				} else {
					maxLength += count - 1;
				}
			} else {
				maxLength += count;
			}
		}
		
		System.out.println("LP result: " + maxLength);
		return maxLength;
	}
	
	
	public static int longestPalindromeBetter(String str) {
		
		int[] count = new int[128]; // makes array of 128 0s
		for (char c : str.toCharArray()) {
			count[c]++;
			// this is confusing but we ARE allowed to do this (use a char as an index)
			// automatically converts the character to a numerical ASCII value
			// when we increment, we increase the value at the index matching the ASCII value, thus keeping a "count" based on index
		}
		
		int ans = 0; //
		for (int value : count) {
			ans += value / 2 * 2; // java rounds down for integers (5 / 2 * 2 will be 4), this will always add an even number
			if (ans % 2 == 0 && value % 2 == 1) { // this checks for the one odd letter we're allowed at the center of a palindrome
			// if our maxLength is even AND if our value is odd, we haven't added a center yet and it's a candidate to be added
				ans++; // length increased by 1
			} 
		}
		
		System.out.println("LPBetter result: " + ans);
		return ans;
	}
	
	public static void main(String[] args) {

		longestPalindrome("abcccdd");
		longestPalindromeBetter("abcccdd");
	}

}
