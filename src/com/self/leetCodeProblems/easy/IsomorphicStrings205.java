package com.self.leetCodeProblems.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings205 {
	
/* Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
 * No two characters may map to the same character, but a character may map to itself.
 */
	
	public static boolean isIsomorphic(String s, String t) {
		
		// if not the same length
//		if (s.length() != t.length()) {
//			System.out.println("Strings of different lengths");
//			return false;
//		}
		
		Map<Character, Character> characters = new HashMap<>();
		
		// loop through string s
		for (int i = 0; i < s.length(); i++) {
			// if the map does not contain the key or the value
			if (!characters.containsKey(s.charAt(i)) && !characters.containsValue(t.charAt(i))) {
				characters.put(s.charAt(i), t.charAt(i));
				System.out.println("Adding " + s.charAt(i) + " as key and " + t.charAt(i) + " as value");
			// if the map contains this specific key AND value pair
			} else if (characters.containsKey(s.charAt(i)) && characters.get(s.charAt(i)) == t.charAt(i)) {
				System.out.println("Previously seen key value pair");
			// else we have a duplicate key OR value somewhere
			} else {
				return false;
			}
		}
		System.out.println("Isomorphic!");
		return true;
	}
	

	public static void main(String[] args) {
		
		isIsomorphic("bbbaaaba", "aaabbbba");

	}

}
