package com.chnbin.atcode.dpcontest;
import java.util.Scanner;

public class AFrog1 {
	/**
	 * Educational DP Contest / DP まとめコンテスト
	 * Problem A Frog 1
	 * https://atcoder.jp/contests/dp/tasks/dp_a
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] heights = new int[N];
		
		for (int i = 0; i < N; i++) {
			heights[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(frog(heights));
	}
	
	private static int frog(int[] heights) {
		int len = heights.length;
		int[] dp = new int[len];
		dp[0] = 0;
		dp[1] = Math.abs(heights[0] - heights[1]);
		
		for (int i = 2; i < len; i++) {
			dp[i] = Math.abs(Math.min(dp[i-1] + Math.abs(heights[i-1]-heights[i]),
					                  dp[i-2] + Math.abs(heights[i-2]-heights[i])));
		}
		
		return dp[len-1];
	}

}
