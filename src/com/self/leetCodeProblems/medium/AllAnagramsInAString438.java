package com.self.leetCodeProblems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Given two strings s and p, return an array of all the start indices of p's anagrams in s.
// You may return the answer in any order.
// Constraints: lengths <= 30000, all lowercase letters

// An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

// Hints: Hash Table, Sliding Window
/* what should we be hashing to access later, characters in str or characters in sub?
 * if we hash sub characters, we can take the length of sub and run a SLIDING WINDOW along str of length sub
 * check if characters are keys in hash
 * log if we find a successful index 
 */


// this ALMOST works
// because of the loop, we are missing what happens at the very end
// we need an end condition OR some way of rewriting to satisfy the conditions
public class AllAnagramsInAString438 {
	
	public List<Integer> findAnagrams(String main, String sub) {
		
		List<Integer> indexes = new ArrayList<>();
		
		Map<Character, Integer> hashSub = new HashMap<>();
		
		// creating a hashmap of character counts in substring
		for (char letter : sub.toCharArray()) {
			hashSub.put(letter, hashSub.containsKey(letter) ? (hashSub.get(letter) + 1) : 1);
		}

		// traverse over main string, easiest might be to use char array
		char[] mainChars = main.toCharArray();
		
		// used to bump forward window
		int startPointer = 0; // this marks the beginning of the substring of main we're currently looking at
		int pointer = 0; // this marks the moving end of the substring
		
		// what is the relationships between the two pointers and the indexes?
		
		// a running arraylist of size sub.length that holds the window's letters, adding next letter and removing first letter
		List<Character> runningWindow = new ArrayList<>();
		
		// pointer is the index of where we are in mainChars
		while (pointer < mainChars.length) {
			
			System.out.println("startPointer at start: " + startPointer);
			System.out.println("pointer at start: " + pointer);
			System.out.println(hashSub);
			
			// this means we've found a valid word
			if (runningWindow.size() == sub.length()) {
				hashSub.replace(runningWindow.get(0), hashSub.get(runningWindow.get(0)) + 1); // add value back to map
				runningWindow.remove(0);
				indexes.add(startPointer); // add index to list
				startPointer++;
			}
			
			// if it exists in hashSub and value is valid
			if (hashSub.containsKey(mainChars[pointer]) && hashSub.get(mainChars[pointer]) >= 1) { 
				runningWindow.add(mainChars[pointer]); // add to running window
				hashSub.replace(mainChars[pointer], hashSub.get(mainChars[pointer]) - 1); // decrement hash value by 1
				pointer++;

			} else if (startPointer == pointer) {
				startPointer++;
				pointer++;
			}
			// if not valid, clear runningWindow and add values back to keys in hashtable
			// then restart from next valid index (use pointer)
			else {
				System.out.println("else ran");
				for (char c : runningWindow) {
					hashSub.replace(c, hashSub.get(c) + 1);
				}
				startPointer = startPointer + runningWindow.size();
				pointer = startPointer;
				runningWindow.clear();
			}

			
		System.out.println(runningWindow.toString());
		System.out.println();
			
		}
		
		
		System.out.println(indexes);
		return indexes;
	}

	public static void main(String[] args) {
		
		AllAnagramsInAString438 anagrams = new AllAnagramsInAString438();
		anagrams.findAnagrams("abab", "ab");
		
	}

}
