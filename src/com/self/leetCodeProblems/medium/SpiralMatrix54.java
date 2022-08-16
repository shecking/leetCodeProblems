package com.self.leetCodeProblems.medium;

import java.util.ArrayList;
import java.util.List;

// Given an m x n matrix, return all elements of the matrix in spiral order

/* Thoughts:
 * Hold variables for each boundary (top row, bottom row, leftmost column, rightmost column) so we don't double count
 * While loop since we don't know how large (or do we?) the matrix is
 * How are we handling edge cases (a matrix with only one row or one column, or both)?
 */

public class SpiralMatrix54 {
	
	// first [] refers to row, second [] refers to column
	public List<Integer> spiralOrder(int[][] matrix) {
		
		List<Integer> ans = new ArrayList<>();

		int top = 0;
		int left = 0;
		int right = matrix[0].length; // is there a better way to code this?
		int bottom = matrix.length;
		
		// checking for null or 0 lengths
		if (matrix == null || right == 0 || bottom == 0) return ans;
		
		while (top != bottom && left != right) {
			
			// going forward
			for (int i = left; i < right; i++) {
				ans.add(matrix[top][i]);
			}
			top++;
			
			// going down
			for (int i = top; i < bottom; i++) {
				ans.add(matrix[i][right - 1]);
			}
			right--;
			
			if (top == bottom || left == right) break; // IMPORTANT LINE
			
			// going back
			for (int i = right - 1; i >= left; i--) {
				ans.add(matrix[bottom - 1][i]);
			}
			bottom--;
			
			// going up
			for (int i = bottom - 1; i >= top; i--) {
				ans.add(matrix[i][left]);
			}
			left++;
		}
			
		System.out.println(ans);
		return ans;
	}

	public static void main(String[] args) {

		SpiralMatrix54 spm = new SpiralMatrix54();
//		int[][] matrix = {{1}, {2}, {3}, {4}, {5}};
//		int[][] matrix2 = {{1, 2, 3, 4, 5}};
//		int[][] matrix3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//		int[][] matrix4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

		int[][] matrix5 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
		
		// spm.spiralOrder(matrix);
		spm.spiralOrder(matrix5);

	}

}
