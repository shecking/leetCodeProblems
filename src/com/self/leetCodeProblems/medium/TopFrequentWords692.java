package com.self.leetCodeProblems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* Given an array of strings words and an integer k, return the k most frequent strings.
 * 
 * Return the answer sorted by the frequency from highest to lowest.
 * Sort the words with the same frequency by their lexicographical order (alphabetical order).
 * 
 * words[i] consists of lowercase letters, k is in range [1, number of unique words[i]]
 * 
 * Can this be done in O(n log(k)) time and O(n) extra space?
 * 
 * Related topics: Hash Table, String, Trie(??), Sorting, Heap(Priority Queue), Bucket Sort, Counting
 * 
 * Thoughts: 
 * Get the frequencies first, then worry about alphabetical order
 * Frequencies can probably be done in a hash table, which will give us all unique words and their frequencies
 * We have frequencies, now how to deal with them
 * We need to return k items
 * 
 * What about sorting the array in place? This groups all the words together
 */

public class TopFrequentWords692 {

	public List<String> topKFrequentWords(String[] words, int k) {
		
		Hashtable<String, Integer> frequencies = new Hashtable<>();
		
		// get frequencies of words
		for (String word : words) {
			if (!frequencies.containsKey(word)) {
				frequencies.put(word, 1);
			} else {
				frequencies.replace(word, frequencies.get(word) + 1);
			}
		}
		
		// get everything from hashtable and put in a list, sort it by descending value
		List<Map.Entry<String, Integer>> freqList = new ArrayList<Entry<String, Integer>>(frequencies.entrySet());
		
		Collections.sort(freqList, new Comparator<Map.Entry<String, Integer>>() { 
			
			// overriding compare method built into Comparator
			// <Map.Entry<String, Integer> is only used to access the objects in the map, nothing more
			public int compare(Map.Entry<String, Integer> freq1, Map.Entry<String, Integer> freq2) {
				int val = freq2.getValue().compareTo(freq1.getValue());
				// if the values ARE NOT the same
				if (val != 0) {
					return val;
				} 
				// if values ARE the same
				else {
					return freq1.getKey().compareTo(freq2.getKey());
				}
			}
		});
		
		List<String> topWords = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			topWords.add(freqList.get(i).getKey());
		}

		System.out.println(topWords);
		return topWords;
	}
	
	
	public static void main(String[] args) {
		TopFrequentWords692 tfw = new TopFrequentWords692();
		
		String[] words = {"i","love","leetcode","i","love","coding"};
		String[] words2 = {"the","day","is","sunny","the","the","the","sunny","is","is"};

		tfw.topKFrequentWords(words, 2);
		tfw.topKFrequentWords(words2, 4);
	}

}
