package com.self.leetCodeProblems.medium;

import java.util.Hashtable;

/* You write down a secret number and ask your friend to guess what the number is. When a guess is made, you provide a hint with the following info:
 * 		The number of "bulls", which are digits in the guess that are in the correct position.
 * 		The number of "cows", which are digits that are in the secret but in the wrong position.
 * 		(Specifically, the non-bull digits that could be rearranged such that they become bulls)
 * Given the secret and the guess, return the HINT (as a String) for your friend's guess.
 * The hint should be formatted as "xAyB" where: 
 * 		x is the number of bulls
 * 		y is the number of cows
 * Note that both secret and guess may contain duplicate digits.
 * Related Topics: Hash Table, String, Counting
 * 
 * Constraints:
 * 		1 - 1000 length, made of digits only
 * 		secret.length == guess.length
 */

/* Thoughts:
 * A comparison has to be made between two numbers
 * Get bull count DURING comparison, get cow count AFTER comparison
 * Hashtables to store digits and counts of each number
 * 		create two hashtables (secretHash and guessHash) with keys 0-9 and all values 0, those are our only options
 * loop through both numbers
 * 		if the digits match, bullCount++ and continue
 * 		if they don't match, increment hashtable value
 * how to do cowCount
 * 		loop through hashtables
 * 		compare values of keys in both hashtables
 * 		increment cowCount when value in guessHash <= value in secretHash AND guessHash value != 0
 * 			simpler: increment by whatever is lower
 * 			(if the guess has too many of a digit, it wouldn't make sense to add it)
 * 			add the value of guessHash to cowCount
 * 	Once complete and we have a bullCount and a cowCount:
 * 		convert each count to a string, concatenate/StringBuilder to match format xAyB
 * 		return string
 */

public class BullsAndCows299 {

	public String getHint(String secret, String guess) {
		
		Hashtable<String, Integer> secretHash = new Hashtable<>();
		Hashtable<String, Integer> guessHash = new Hashtable<>();
		
		int bullCount = 0;
		int cowCount = 0;

		// filling hashtables with 0-9 keys and 0 values
		// there is probably a better way to do this that doesn't hard code a 10?
		// no need to use hashtable in solution, can simply use two int[10] for secret and guess
		for (int i = 0; i < 10; i++) {
			String stringI = Integer.toString(i);
			secretHash.put(stringI, 0);
			guessHash.put(stringI, 0);
		}
		// using string split to create arrays to iterate 
		// use another structure or method to save on space?
		String[] secretSplit = secret.split("");
		String[] guessSplit = guess.split("");
		
		// secret, guess, secretSplit, and guessSplit are all the same length
		// compare digit strings
		for (int i = 0; i < secret.length(); i++) {
			
			// if the string digits are equal, we found a bull
			if (secretSplit[i].equals(guessSplit[i])) {
				bullCount++;
			} 
			// if the string digits are not equal, we need to increment each digit's value in their hashtable
			else {
				secretHash.replace(secretSplit[i], secretHash.get(secretSplit[i]) + 1);
				guessHash.replace(guessSplit[i], guessHash.get(guessSplit[i]) + 1);
			}
		}
		
		// compare values of hash keys
		for (int i = 0; i < 10; i++) {
			
			String stringI = Integer.toString(i);
			int guessValue = guessHash.get(stringI);
			int secretValue = secretHash.get(stringI);
			
			cowCount += guessValue <= secretValue ? guessValue : secretValue;
		}
		
		// System.out.println(bullCount + "A" + cowCount + "B");
		return bullCount + "A" + cowCount + "B";
	}

	public static void main(String[] args) {

		BullsAndCows299 bac = new BullsAndCows299();
		bac.getHint("1234567890", "0987654321");
	}

}
