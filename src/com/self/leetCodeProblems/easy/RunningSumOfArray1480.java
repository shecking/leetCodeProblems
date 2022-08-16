package com.self.leetCodeProblems.easy;

import java.util.Arrays;

public class RunningSumOfArray1480 {

	// initial version
	public static int[] runningSum(int[] nums) {
		int sum = 0;
		int[] runningSumArray = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			runningSumArray[i] = sum;
		}
		System.out.println(Arrays.toString(runningSumArray));
		return runningSumArray;
	}
	
	// better version
	public static int[] runningSumInPlace(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i-1] + nums[i];
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
	
	// driver
	public static void main(String[] args) {
		int[] nums = {3, 1, 2, 10, 1};
		runningSum(nums);
		runningSumInPlace(nums);
	}

}
