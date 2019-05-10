class Solution {
  public int findLength(int[] A, int[] B) {
      int m = A.length+1;
      int n = B.length+1;
      int maxLen = 0;
      int[][] dp = new int[m][n];
      
      for (int i = 1; i < m; i++) {
          for (int j = 1; j < n; j++) {
              if (A[i-1] == B[j-1]) {
                  dp[i][j] = dp[i-1][j-1] + 1;
                  maxLen = Math.max(maxLen, dp[i][j]);
              } 
          }
      }
      return maxLen;
  }
}