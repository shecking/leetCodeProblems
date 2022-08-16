package com.self.leetCodeProblems.easy;

/* You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

/* Thoughts:
 * each time you move you have two choices, take 1 step or 2
 * If n is 1, 2, or 3, return n
 * relationship between even and odd value of n?
 * continually branching choices of 1 or 2 sounds like a binary tree
 * create a tree with node values 1 (left) and 2(right) (root node val is 0)
 * find a way to keep track of each path (+ a counter for each successful path)
 * once the sum of a path hits n, stop making new ones?
 * since we only add either 1 or 2 each time, we'll only ever be 1 over n
 */

// so technically this solution does work, but it takes far too long

// defining a node
class Node {
	
	int value;
	int sum;
	Node left;
	Node right;
	
	public Node(int value, int sum) {
		this.value = value;
		this.sum = sum;
		this.left = null;
		this.right = null;
	}
}

public class ClimbingStairs70 {
	
	// MY ORIGINAL SOLUTION WHICH DOES ACTUALLY WORK it just takes too long
	// we are recursively making two calls for every step of n, which takes forever once you get above 20 or so
	
//	int counter = 0;
//
//	public int climbStairs(int numSteps) {
//		
//		Node root = new Node(0, 0); // starting point (0 value, 0 sum)
//		makeNodesRecursively(numSteps, root); // initial call
//		System.out.println(counter);
//		return counter;
//	}
//	
//	public void makeNodesRecursively(int numSteps, Node root) {
//		
//		// if we haven't hit n yet
//		if (root.sum < numSteps) {
//			// recursively make new nodes IF we haven't hit n yet
//			// left nodes are instantiated with value 1 and sum equal to root sum + 1
//			root.left = new Node(1, root.sum + 1);
//			root.right = new Node(2, root.sum + 2);
//			
//			System.out.println("calling left recurse");
//			makeNodesRecursively(numSteps, root.left);
//			System.out.println("calling right recurse");
//			makeNodesRecursively(numSteps, root.right);
//			
//		} else if (root.sum == numSteps) {
//			counter ++;
//		} else {
//			return;
//		}
//	}
	
	// their ITERATIVE solution below (this is basically a fibonacci problem)
	// how can we logically figure out this is a fibonacci problem WITHOUT looking at the brute forced data for the first 3 or 4 steps? can we even do this at all?
	// WHY does the stairs problem use fibonacci?
	
	public int climbStairsBetter(int numSteps) {
		
		if (numSteps <= 0) { return 0; }
		if (numSteps == 1 || numSteps == 2) { return numSteps; }
		
		// fibonacci is the sum of the previous two digits
		// we can do this iteratively with a for loop
		
		// assume we start on step 3, what are the previous steps
		// these are initial conditions for the loop
		int waysToClimb = 0;
		int prevStep= 2;
		int prevPrevStep = 1;
		
		// start on step 3
		for (int i = 3; i <= numSteps; i++) {
													// first time this loops:
			waysToClimb = prevStep + prevPrevStep;  // waysToClimb = 3
			prevPrevStep = prevStep;				// prevPrevStep = 2
			prevStep = waysToClimb;					// prevStep = 3;
		}

		System.out.println(waysToClimb);
		return waysToClimb;
	}
	
	
	
	public static void main(String[] args) {

		ClimbingStairs70 stairs = new ClimbingStairs70();
		
//		stairs.climbStairs(10);
		stairs.climbStairsBetter(10);
		
	}

}
