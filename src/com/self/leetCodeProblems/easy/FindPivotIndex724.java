package com.self.leetCodeProblems.easy;

import java.util.Arrays;

/* Given an array of integers nums, calculate the pivot index of this array.
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index 
 *    is equal to the sum of all the numbers strictly to the index's right.
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. 
 * This also applies to the right edge of the array.
 * Return the leftmost pivot index. If no such index exists, return -1.
 */
public class FindPivotIndex724 {
	
	// initial version
	public static int pivotIndex(int[] nums) {
		
		int sumOfFrontSide = 0;
		int sumOfBackSide = Arrays.stream(nums).sum() - nums[0];
		
		for (int pivot = 0; pivot < nums.length; pivot ++) {
			if (sumOfFrontSide == sumOfBackSide) {
				System.out.println(pivot);
				return pivot;
			}
			else {
				sumOfFrontSide += nums[pivot];
				if (pivot < nums.length - 1) {
					sumOfBackSide -= nums[pivot + 1];
				} else {
					sumOfBackSide = 0;
				}
			}
		}
		System.out.println(-1);
		return -1;
		
	}

	// driver
	public static void main(String[] args) {
		int[] nums = {2, 1, -1};
		pivotIndex(nums);
	}

}
