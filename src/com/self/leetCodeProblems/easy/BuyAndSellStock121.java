package com.self.leetCodeProblems.easy;

/* You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by:
 * 		choosing a single day to buy one stock, and
 * 		choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. 
 * If you cannot achieve any profit, return 0.
 */

// used solution on site to complete
public class BuyAndSellStock121 {
	
	public static int maxProfit(int[] prices) {
		
		// supposed to use dynamic programming?
		// storing the answers to sub problems so we can access and use them later
		// what are the sub problems for this array
		// but we aren't summing anything, multiplying anything, etc, only looking for the max value
		
		if (prices == null || prices.length <= 0) {
			return 0;
		}
		
		int profit = 0; // the value we will return
		int minimumPrice = Integer.MAX_VALUE; // initializes at 2147483647, nothing can be bigger than this in Java
		
		// loop through prices
		for (int price : prices) {
			minimumPrice = Math.min(price, minimumPrice); // tracks the smallest value
			profit = Math.max(profit, price - minimumPrice); // compares current profit and profit of next item, yields the larger value
		}
		
		return profit;
	}

	public static void main(String[] args) {

		int[] prices = {7, 1, 5, 3, 6, 4};
		maxProfit(prices);

	}

}
