package com.self.leetCodeProblems.easy;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/* Given two strings, return true if they are equal when both are typed into empty text editors.
 * '#' means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 * Strings only contain lowercase letters and # characters, and do not have to be the same length.
 * 
 * Related topics: Two Pointers, String, Stack
 */

public class BackspaceStringCompare844 {
	
	public String translate(String str) {
		
		StringBuilder sb = new StringBuilder();

		CharacterIterator it = new StringCharacterIterator(str);
		
		while (it.current() != CharacterIterator.DONE) {
			
			if (it.current() == '#' && sb.length() != 0) {
				sb.deleteCharAt(sb.length() - 1);
			} else if (it.current() != '#'){
				sb.append(it.current());
			} // else do nothing
			it.next();
		}
		return sb.toString();
		
	}
	
	public boolean backspaceCompare(String s, String t) {
		
		String str1 = translate(s);
		String str2 = translate(t);
		
//		System.out.println(str1);
//		System.out.println(str2);
//		System.out.println(str1.equals(str2) ? true : false);
		return str1.equals(str2) ? true : false;
	}
	

	public static void main(String[] args) {

		BackspaceStringCompare844 bsc = new BackspaceStringCompare844();
		
		bsc.backspaceCompare("abc##gg", "ahi##gg#");
		
	}

}
