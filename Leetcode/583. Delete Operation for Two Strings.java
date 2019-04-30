class Solution {
  public int minDistance(String word1, String word2) {
      int m = word1.length();
      int n = word2.length();
      int[][] dp = new int[2][n+1];
      
      // Find Longest Common Subsequence of word1 and word2
      for (int i = 0; i < m; i++) {
          for (int j = 1; j < n + 1; j++) {
              if (word1.charAt(i) == word2.charAt(j-1)) {
                  dp[1][j] = dp[0][j-1] + 1;
              } else {
                  dp[1][j] = Math.max(dp[0][j], dp[1][j-1]);
              }
          }
          
          for (int k = 0; k < n + 1; k++) {
              dp[0][k] = dp[1][k];
              dp[1][k] = 0;
          }
      }
      return (m - dp[0][n]) + (n - dp[0][n]);
  }
}