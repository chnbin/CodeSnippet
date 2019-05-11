class Solution {
  public int countSubstrings(String s) {
      if (s == null || s.length() == 0) { return 0; }
      int m = s.length();
      int res = 0;
      boolean[][] dp = new boolean[m][m];
      
      for (int i = 0; i < m; i++) {
          dp[i][i] = true;
      }
      
      for (int i = m - 1; i >= 0; i--) {
          for (int j = i; j < m; j++) {
              if (j == i + 1) {
                  dp[i][j] = (s.charAt(i) == s.charAt(j));
              }
              if (j >= i + 2) {
                  dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
              }
              if (dp[i][j]) { res++; }
          }
      }
      return res;
  }
}