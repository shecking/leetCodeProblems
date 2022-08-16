package com.self.leetCodeProblems.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/* Given an encoded string, return its decoded string.
 * The encoding rule is:
 * 		k[encoded_string], where encoded_string inside the brackets is being repeated exactly k times.
 * 		k is guaranteed to be a positive integer
 * You may assume that the input string is always valid, e.g.:
 * 		There are no white spaces
 * 		Square brackets are always closed/well formed
 * 		etc
 * You may also assume that:
 * 		the original data does not contain any digits, AND
 * 		digits are only for those repeat numbers, k
 * For example, there will not be input like 3a or 2[4].
 * 
 * Related topics: String, Stack, Recursion
 * 
 * Ex.1
 * 	input: s = "3[a]2[bc]"
 * 	output: "aaabcbc" (a repeated 3 times, bc repeated 2 times)
 * Ex.2
 * 	input: s = "3[a2[c]]"
 * 	output: "accaccacc" (a repeated 3 times, c repeated 3(*2) = 6 times)
 * 	this is the weird one
 * Ex.3
 * 	input: s = "2[abc]3[cd]ef"
 * 	output: "abcabccdcdcdef" (abc repeated 2 times, cd repeated 3 times, ef once)
 */

/* Thoughts:
 * Related topics include stack and recursion
 * Stack:
 * 		Operations for stack include push, pop, peek, and search
 * Recursion:
 * 		Each recursive call will be returning a substring comprised of one or more letters
 * 		We are multiplying the thing inside brackets by the number outside them
 * 		How do we know when to call it
 * 		
 * each open bracket and each closed bracket means something
 * 		after every open bracket there's a string that will be repeated by the number before the bracket
 * 		a closed bracket means no more string/the section can be calculated
 *  what if we run 2 stacks, one for numbers and one for strings (of a letter or letters)
 *  	if the character is a number, put it on number stack
 *  	if the character is a letter/series of letters, put it on the string stack 
 *  	I think this will only work if the input string is "flat"/doesn't have brackets in brackets
 *  
 * 		A close bracket marks the end of a string and that we can calculate it, meaning we RETURN something
 * 		Once we hit a closed bracket, take the top things off the stacks, calculate the substring, return it
 * 		We assume every open bracket has a closed bracket, do we even need to track opens?
 *
 */

// attempt 1 (incomplete), VERY messy
// getting an exception on the first test case so no it doesn't work
public class DecodeString394 {

	public String decodeString(String str) {
		
		Stack<Integer> numberStack = new Stack<>(); // stack to hold numbers
		Queue<String> lettersStack = new LinkedList<>(); // stack to hold letter(s) as string(s)
		// if we're going to be calculating the number*letters substring right after the string ends, why do we need letterStack
		
		int pos = 0; // position in the given string in lieu of a for loop
		
		StringBuilder answer = new StringBuilder();
		
		StringBuilder substring = new StringBuilder();
		StringBuilder characters = new StringBuilder();
		
		while (pos < str.length()) { // while loop gives us a stop condition for any recursion
			
			char character = str.charAt(pos);
			
			// if number, add to number stack
			// this only deals with single digit numbers!
			if (Character.isDigit(character)) {
				int number = Character.getNumericValue(character);
				// System.out.println("Number found: " + number);
				numberStack.add(number);
			} 
			// if letter, append string
			else if (Character.isLetter(character)) {
				String letter = Character.toString(character);
				// System.out.println("Letter found: " + letter);
				characters.append(letter);
				// System.out.println("Characters: " + characters);
			} 
			// if closed bracket
			else if (character == ']') {
				
				if (characters.toString() != "") {
					String letters = characters.toString();
					int multiplier = numberStack.pop();
					for (int i = 0; i < multiplier; i++) {
						substring.append(letters);
					}
					// System.out.println("Substring after multiplier: " + substring);
					lettersStack.add(substring.toString());
				}
				substring.setLength(0);
				characters.setLength(0);
			} 
			// if open bracket do nothing?
			else {
				if (characters.toString() != "") {
					String letters = characters.toString();
					lettersStack.add(letters);
					// System.out.println("[");
				}
				substring.setLength(0);
				characters.setLength(0);
			}
			
			pos = pos + 1;
		}
		
		StringBuilder miniString = new StringBuilder();
		
		while (!lettersStack.isEmpty()) {
			String sub = lettersStack.remove();
			miniString.append(sub);
		}
		
		String mini = miniString.toString();
		
		if (!numberStack.isEmpty()) {
			int lastMult = numberStack.pop();
			for (int i = 0; i < lastMult; i++) {
				answer.append(mini);
			}
		} else {
			answer.append(mini);
		}
		answer.append(characters);
		
		System.out.println(answer.toString());
		return answer.toString();
	}

	
	public static void main(String[] args) {
//		DecodeString394 ds = new DecodeString394();
//		ds.decodeString("3[a]2[bc]");
//		ds.decodeString("3[a2[c]]");
//		ds.decodeString("2[abc]3[cd]ef");


	}

}
