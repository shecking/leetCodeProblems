package com.self.leetCodeProblems.easy;

import java.util.Arrays;
import java.util.Hashtable;

/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Elements can be positive, negative, or zero, 2 <= nums.length <= 10000, there is ONE valid answer guaranteed
 * Related topics: Array, Hash Table
 */

public class TwoSum1 {
	
	// thoughts:
	/* brute force would be to compare every number to every other number but that SUCKS and will result in O(n^2) time complexity
	 * plus you're calculating some numbers twice?
	 * we have to track the indices of the numbers so we can't manipulate the array
	 * Related topic is hash table, what could that have to do with this problem?
	 */

	// i was close but had trouble dealing with the assignment of keys/values and had subsequent access/doubling up problems
	// solution listed below
	public int[] twoSum(int[] nums, int target) {
		
		int[] ans = new int[2];
		
		int comp;
		
		// create hash table
		Hashtable<Integer, Integer> hashNums = new Hashtable<>();
		for (int i = 0; i < nums.length; i++) {
			
			comp = target - nums[i];
			
			if (hashNums.containsKey(comp)) {
				ans[0] = i;
				ans[1] = hashNums.get(comp);
				System.out.println(Arrays.toString(ans));
				return ans;
			}
			
			hashNums.put(nums[i], i); 
			// first integer is value, second is position (won't this potentially cause collision?)
		}
		ans[0] = ans[1] = -1;
		System.out.println(Arrays.toString(ans));
		return ans;

		
		// my attempt (incomplete)
		// doesn't work for duplicate keys, outputs the same index for both places
		
//		int[] ans = new int[2];
//        
//      if (nums.length == 2) {
//			ans[0] = 0;
//			ans[1] = 1;
//			return ans;
//		}
//        
//		Hashtable<Integer, Integer> hashNums = new Hashtable<>();
//        
//		for (int i = 0; i < nums.length; i++) {
//			hashNums.put(nums[i], i);
//		}
//		
//		for (int num : nums) {
//			if (hashNums.containsKey(target - num)) {
//				ans[0] = hashNums.get(target - num);
//				ans[1] = hashNums.get(num);
//			}
//		}
//		return ans;
	}
	
	public static void main(String[] args) {
		
		TwoSum1 ts = new TwoSum1();
		// int[] nums = {2, 7, 11, 15};
		int[] nums2 = {3, 2, 3};
		
		// ts.twoSum(nums, 9);
		ts.twoSum(nums2, 6);
		
	}

}
