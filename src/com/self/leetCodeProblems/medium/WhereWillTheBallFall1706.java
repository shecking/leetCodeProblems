package com.self.leetCodeProblems.medium;

import java.util.Arrays;

/* You have a 2-D grid of size m x n representing a box, and n balls. The box is open on the top and bottom.
 * Each cell in the box has a diagonal board spanning two corners of the cell that can redirect a ball to the right or left.
 * 		A board(cell) that redirects the ball to the right spans the top-left corner to the bottom-right corner and is represented as 1.
 * 		A board(cell) that redirects the ball to the left spans the top-right corner to the bottom-left corner and is represented as -1.
 * We drop one ball at the top of each column of the box. Each ball can get stuck in the box or fall out of the bottom.
 * A ball gets stuck if it hits a V shaped pattern between two boards or if a board redirects the ball into either wall of the box.
 *  
 * Return an array answer of size n, where: 
 * 		answer[i] is the column that the ball falls out of at the bottom after dropping the ball from the ith column at the top, OR
 * 		-1 if the ball gets stuck in the box
 */

// thoughts:
// Related topics: Array, Dynamic Programming, Depth-First Search, Matrix, Simulation
// each ball starts in first row, column i
// at each level (this seems very brute force-y):
/* 		what is the ball's current cell? this will determine what direction it's going
 * 			if it's going left, value is -1;
 * 				if the ball is in the leftmost column, ball gets stuck
 * 				if the next cell is 1, ball gets stuck
 * 					answer[i] is -1 (stuck ball), continue
 *				if the next cell (left from current) is -1, valid and ball can pass through/drop
 * 			if it's going right, value is 1;
 * 				if the ball is in the rightmost column, ball gets stuck
 * 				if the next cell is -1, ball gets stuck
 * 					answer[i] is -1 (stuck ball), continue
 * 				if the next cell is 1, valid and ball can pass through/drop
 * 		if the next left/right cell is valid and the ball is in the bottom row, we've reached the bottom
 * 			answer[i] is the column the ball ended in
 */

public class WhereWillTheBallFall1706 {

	public int[] findBall(int[][] grid) {
		
		int[] ans = new int[grid[0].length];
		
		if (grid == null || grid.length == 0) return new int[0];
		
		// this loop happens once for EACH ball (i.e. 5 balls, 5 loops)
		for (int i = 0; i < grid[0].length; i++) {
			
			System.out.println("NEW BALL IS DROPPED");
			// starting position of ball
			int ballRow = 0;
			int ballColumn = i;
	
			// while the ball is still in the grid
			while (ballRow < grid.length) {
				
				// get the ball position value (INSIDE WHILE LOOP)
				int ballPositionValue = grid[ballRow][ballColumn];
				
				if (ballPositionValue == -1) { // ball is going left
					
					System.out.println("ball is in row " + ballRow + " column " + ballColumn + " (value " + ballPositionValue + ") before moving");
					
					// if we hit the left wall OR get stuck in a V
					if (ballColumn == 0 || grid[ballRow][ballColumn - 1] == 1) {
						ans[i] = -1;
						System.out.println("ball " + i + " got stuck going left");
						break;
					} 
					// else
					else {
						// if we're at the bottom
						if (ballRow == grid.length - 1) {
							ans[i] = ballColumn - 1;
							System.out.println("ball " + i + " in last row made it through");
							break;
						} 
						// move the ball's position left one and down one
						else {
							ballColumn --;
							ballRow++;
							System.out.println("ball " + i + " moved left and down to row " + ballRow + " column " + ballColumn);
						}
					}
				}
				else { // ball is going right
					
					System.out.println("ball is in row " + ballRow + " column " + ballColumn + " (value " + ballPositionValue + ") before moving");
					
					// if we hit the right wall OR get stuck in a V
					if (ballColumn == grid[0].length - 1 || grid[ballRow][ballColumn + 1] == -1) {
						ans[i] = -1;
						System.out.println("ball " + i + " got stuck going right");
						break;
					}
					// else
					else {
						// if we're at the bottom
						if (ballRow == grid.length - 1) {
							ans[i] = ballColumn + 1;
							System.out.println("ball " + i + " in last row made it through");
							break;
						} else {
							ballColumn++;
							ballRow++;
							System.out.println("ball " + i + " moved right and down to row " + ballRow + " column " + ballColumn);
						}
					}
 				}
			}
		}
		
		System.out.println("ANSWER: " + Arrays.toString(ans));
		return ans;
	}
	
	
	
	public int[] findBallBetter(int[][] grid) {
		
		if (grid == null || grid.length == 0) return new int[0]; // return empty int array if null or length 0 (edge case)
		
		int[] result = new int[grid[0].length];
		
		for (int i = 0; i < grid[0].length; i++) {
			int currRow = 0, currCol = i; // same as my ballRow, ballColumn
			
			while (currRow < grid.length) { // same
				
				// the following is essentially the same as my attempt, but cleaner
				int currValue = grid[currRow][currCol];
				
				// if value is 1 AND we haven't hit the right wall AND the thing to the right is also 1
				if (currValue == 1 && currCol + 1 < grid[0].length && grid[currRow][currCol + 1] == 1) {
					currCol++;
					currRow++;
				}
				// if value is -1 AND we haven't hit the left wall AND the thing to the left is also -1
				else if (currValue == -1 && currCol - 1 >= 0 && grid[currRow][currCol - 1] == -1) {
					currCol--;
					currRow++;
				} 
				// this is the catchall: very specific conditions to continue
				// if ANY of our conditions aren't met, the ball is stuck, immediately break and insert -1
				else {
					break; // break while loop, go to next for loop
				}
			}
			// if we've reached the bottom, store the column number; if not, store -1
			// simpler with ternary operator
			result[i] = currRow == grid.length ? currCol : -1;
		}
		System.out.println(Arrays.toString(result));
		return result;
	}
	

	public static void main(String[] args) {

		WhereWillTheBallFall1706 wwtbf = new WhereWillTheBallFall1706();
		
		int[][] grid = {{ 1,  1,  1, -1, -1}, 
						{ 1,  1,  1, -1, -1}, 
						{-1, -1, -1,  1,  1}, 
						{ 1,  1,  1,  1, -1}, 
						{-1, -1, -1, -1, -1}};
		
		int[][] grid2 = {{ 1,  1,  1,  1,  1,  1}, 
						 {-1, -1, -1, -1, -1, -1}, 
						 { 1,  1,  1,  1,  1,  1}, 
						 {-1, -1, -1, -1, -1, -1}};
		
//		wwtbf.findBall(grid);
//		wwtbf.findBall(grid2);
		
		wwtbf.findBallBetter(grid);
		wwtbf.findBallBetter(grid2);
	}

}