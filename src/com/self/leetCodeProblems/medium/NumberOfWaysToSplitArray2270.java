package com.self.leetCodeProblems.medium;

/* You are given a 0-indexed integer array nums of length n.
 * nums contains a valid split at index i if the following are true:
 * 		The sum of the first i + 1 elements is greater than or equal to the sum of the last n - i - 1 elements.
 * 		There is at least one element to the right of i. That is, 0 <= i < n - 1.
 * Return the number of valid splits in nums.
 */

// Thoughts: This seems very similar to the FindPivotIndex problem in the easy section

public class NumberOfWaysToSplitArray2270 {
	
	static int waysToSplitArray(int[] nums) {
		int numberOfSplits = 0;
		
		long firstSum = 0, secondSum = 0;
		
		for (int num : nums) { 
			secondSum += num;
		}
		
		for (int i = 0; i < nums.length - 1; i++) {
			
			firstSum += nums[i];
			secondSum -= nums[i];
			
			if (firstSum >= secondSum) { numberOfSplits++; }
		}
		return numberOfSplits;
	}

	public static void main(String[] args) {
		int[] nums = {10, 4, -8, 7, 2, -15, 20, 1, -4};
		waysToSplitArray(nums);
	}

}
