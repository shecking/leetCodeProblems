package com.self.leetCodeProblems.easy;

/* An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and color. 
 * You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * To perform a flood fill:
 * 		consider the starting pixel, 
 * 		plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, 
 * 		plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. 
 * Replace the color of all of the aforementioned pixels with color.
 * Return the modified image after performing the flood fill.
 */

public class FloodFill733 {

	// go to starting pixel, grab its value, save it to compare
	// check surrounding pixels to see if they have the same value as the starting pixel
		// check for null value
		// if they have the same value as starting, set their values to color and check THEIR surrounding pixels (recursively?)
		// if they don't, do nothing to them
	
	// what happens when we hit the edges of the picture? (e.g. when sr or sc == 0)
	// how do we stop?
	
	// used solution on site to complete
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		
		int baseColor = image[sr][sc]; // hold the original color to compare
		if (baseColor != newColor) {
			filling(image, sr, sc, newColor, baseColor);
		}
		// System.out.println(Arrays.deepToString(image));
		return image;
	}
	
	public void filling(int[][] image, int sr, int sc, int newColor, int baseColor) {

		if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[sr].length || image[sr][sc] != baseColor) {
			return; // this is our base case to return, how to not go out of bounds/not rewrite
		}
		image[sr][sc] = newColor; // set pixel to the new color
		
		// call filling method four times for each cardinal direction
		filling(image, sr + 1, sc, newColor, baseColor);
		filling(image, sr - 1, sc, newColor, baseColor);
		filling(image, sr, sc + 1, newColor, baseColor);
		filling(image, sr, sc - 1, newColor, baseColor);
	}
			
	
	public static void main(String[] args) {
		
		FloodFill733 ff = new FloodFill733();
		
		int[][] image = {{1, 1, 1}, 
						 {1, 1, 0}, 
						 {1, 0, 1}};
		
		ff.floodFill(image, 1, 1, 2);
	}

}
