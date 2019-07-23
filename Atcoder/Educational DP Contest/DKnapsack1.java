package com.chnbin.atcode.dpcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DKnapsack1 {
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
	public static void main(String[] args) {
		/**
		 * Educational DP Contest / DP まとめコンテスト
		 * Problem D Knapsack 1
		 * https://atcoder.jp/contests/dp/tasks/dp_a
		 * @param args
		 */
		FastReader sc = new FastReader();
		
		int n = sc.nextInt();
		int w = sc.nextInt();
		int[] weights = new int[n];
		int[] values = new int[n];
		long[][] dp = new long[n+1][w+1];
		
		for (int i = 0; i < n; i++) {
			weights[i] = sc.nextInt();
			values[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				if (j >= weights[i-1]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weights[i-1]] + values[i-1]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[n][w]);

	}

}
