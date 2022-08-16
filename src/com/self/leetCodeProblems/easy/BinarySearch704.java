package com.self.leetCodeProblems.easy;

// Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
// If target exists, then return its index. Otherwirse, return -1;
// You MUST write an algorithm with O(log n) runtime complexity.

/* thoughts:
 * what I understand the concept of Binary Search to mean:
 * split the SORTED array in half (no need for ACTUAL splitting and using more memory)
 * use each half to look for the target
 * if target is smaller than pivot, search to the left; if target is larger than pivot, search to the right
 */

public class BinarySearch704 {

	public int search(int[] nums, int target) {
		
		// more difficult way using two pointers
		int leftPointer = 0; // leftmost index
		int rightPointer = nums.length - 1; // rightmost index
		int pivot = 0; // pivot has to move based on where we are in the array, we can't hard code a value
		
		// why do we loop while left <= right?
		// this stops the loop 
		while (leftPointer <= rightPointer) {
			pivot = leftPointer + (rightPointer - leftPointer) / 2; // this yields an integer index based on how java does division
			if (nums[pivot] == target) {
				System.out.println(pivot);
				return pivot;
			}
			if (target < nums[pivot]) {
				rightPointer = pivot - 1;
			} else {
				leftPointer = pivot + 1;
			}
		}
		System.out.println(-1);
		return -1;
		
		// easy way using built in binarySearch method in java.util.Arrays
//		int index = Arrays.binarySearch(nums, target); // returns index of the target if found, returns -1 otherwise
//		System.out.println((index < 0) ? -1 : index);
//		return (index < 0) ? -1 : index;
	}
	
	
	public static void main(String[] args) {
		
		int[] nums = {-1, 0, 1, 4, 5, 9, 12};
	
		BinarySearch704 binarySearch = new BinarySearch704();
		
		binarySearch.search(nums, 4); // should return 3 (the index of value 4)
	}

}
