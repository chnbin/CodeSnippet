class Solution {
  public int longestPalindromeSubseq(String s) {
      if (s == null || s.length() == 0) { return 0; }
      int m = s.length();
      int[][] dp = new int[m][m];
      
      for (int i = 0; i < m; i++) { dp[i][i] =1; }
      
      for (int i = m - 1; i >= 0; i--) {
          for (int j = i + 1; j < m; j++) {
              if (s.charAt(i) == s.charAt(j)) {
                  dp[i][j] = dp[i+1][j-1] + 2;
              } else {
                  dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
              }
          }
      }
      return dp[0][m-1];
  }
}