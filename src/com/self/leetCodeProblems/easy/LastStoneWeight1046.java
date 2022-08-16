package com.self.leetCodeProblems.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

/* You are given an array of integers stones where stones[i] is the weight of the ith stone.
 * Game: Each turn, we choose the heaviest two stones and smash them together. The heaviest stones have weights x and y with x <= y.
 * The result is:
 * 		If x == y, both stones are destroyed.
 * 		If x != y, the stones of weight x is destroyed, and the stone of weight y has new weight y-x.
 * At the end of the game, there is at most one stone left.
 * 
 * Return the weight of the last remaining stone. If there are no stones left, return 0.
 * 
 * Related topics: Array, Heap(Priority Queue)
 * 
 * thoughts:
 * PriorityQueue does NOT automatically sort, it's meant for immutable elements
 * 		Then WHY would they hint at this?
 * Resorting array means we'd have no use for the priority queue
 */

public class LastStoneWeight1046 {
	
	public int lastStoneWeight(int[] stones) {
		
		// Alternate code: PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		// Alternate way: PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			public int compare(Integer i1, Integer i2) {
				if (i1 < i2) { return 1; }
				if (i1 > i2) { return -1; }
				else         { return 0; }
			}
		});
		
		for (int stone : stones) {
			queue.add(stone);
		}
		
		// while we have more than one thing in the queue
		while (queue.size() > 1) {		
			// REMOVE the items
			int stone1 = queue.poll();
			int stone2 = queue.poll();
			
			// add a new one 
			// this looks messy
			if (stone1 < stone2) {
				int stoneResult = stone2 - stone1;
				queue.add(stoneResult);
			} else if (stone1 > stone2) {
				int stoneResult = stone1 - stone2;
				queue.add(stoneResult);
			}
			
		}

		if (!queue.isEmpty()) {
			return queue.peek();
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		LastStoneWeight1046 lsw = new LastStoneWeight1046();
		int[] stones = {2, 7, 4, 1, 8, 1};
		lsw.lastStoneWeight(stones);

	}

}
