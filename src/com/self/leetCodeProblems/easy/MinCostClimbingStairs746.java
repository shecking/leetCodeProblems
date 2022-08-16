package com.self.leetCodeProblems.easy;

/* You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0 or the step with index 1.
 * Return the minimum cost to reach the top of the floo
 */

/* Thoughts:
 * we know the number of steps based on the size of the cost array 
 */

public class MinCostClimbingStairs746 {
	
	// approach 1 did not work (incomplete)
	public int minCostClimbStairs(int[] cost) {
		
		// run two for loops individually, one starting at step 0 and one starting at step 1
		// do we have to do this? can checking for step 1 start be a part of checking for step 0 start?
		
		// starting at step 0
//		int step = 0;
//		int costForStep0 = 0;
//		int costForStep1 = 0;
		
		// how to handle the end of the array?
		// array with length 10 has indexes 0-9

//		while (step < cost.length) {
//			// the FIRST TIME this runs, if step 1 is less than step 2, all else after this will be the same
//			if (cost[step + 1] <= cost[step + 2]) { // if the first step is less costly
//				costForStep0 += cost[step + 1];
//				step++;
//				// add something here to add to costForStep1
//			} else { // if the second step is less costly
//				costForStep0 += cost[step + 2];
//				step += 2;
//			}
//		}
//		
//		if (costForStep0 <= costForStep1) {
//			return costForStep0;
//		} else {
//			return costForStep1;
//		}
		return 0;
		
	}
	
	
	
	// approach 2: have to think about this backwards
	// having trouble getting to the end of the array, writing unnecessary code
	// instead of adding, get the values for indexes by starting at a later i in the loop and subtracting
	public int minCostClimbStairsBetter(int[] cost) {
		
		// getting the length of the array to make a new one?
		int n = cost.length;
				
		// using memoization (storing previous values in an array for later use)
		// why are we making the size n + 1? 
		// 	we are accounting for cost.length = 10, making an array of size 11 so we can 
		int[] additiveCost = new int[n + 1];

		additiveCost[0] = 0;
		additiveCost[1] = 0; // not strictly needed but here for clarity
				
		// loop until we've reached the length of the original cost array
		// we are looping through every single step
		for (int i = 2; i <= n; i++) {
			// finding the smaller value between
			// additiveCost[i - 2] + cost[i - 2], and...
			// additiveCost[i - 1] + cost[i - 1]
					
			// i.e. the first time this runs:
			// looking at the first two things in cost array...
			// adding the first two things from the additiveCost array to them respectively (WHY?)...
			// finding the smaller of the two and setting that value in the additiveCost array at index i
					
			additiveCost[i] = Math.min(additiveCost[i - 2] + cost[i - 2], additiveCost[i - 1] + cost[i - 1]);
			// we DO go over each value twice (exception being the first and last)
		}
		return additiveCost[n]; // this returns the final thing in the new array we made
	}

	public static void main(String[] args) {
		
		MinCostClimbingStairs746 minCost = new MinCostClimbingStairs746();
		
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		// int[] cost2 = {10, 15, 20};
		
		// minCost.minCostClimbStairs(cost);
		minCost.minCostClimbStairsBetter(cost);

	}

}
