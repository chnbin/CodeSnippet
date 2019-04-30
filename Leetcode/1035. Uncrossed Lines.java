class Solution {
  public int maxUncrossedLinesFaster(int[] A, int[] B) {
    int m = A.length;
    int n = B.length;
    int[][] dp = new int[2][n+1];
    
    for (int i = 0; i < m; i++) {
        for (int j = 1; j < n + 1; j++) {
            if (A[i] == B[j-1]) {
                dp[1][j] = dp[0][j-1] + 1;
            } else {
                dp[1][j] = Math.max(dp[0][j], dp[1][j-1]);
            }
        }
        
        for (int k = 0; k < n + 1; k++) {
            dp[0][k] = dp[1][k];
            dp[1][k] = 0;
            // System.out.print(" " + dp[0][k]);
        }
        // System.out.println("");
    }

    return dp[0][n];
  }

  public int maxUncrossedLines(int[] A, int[] B) {
      int m = A.length;
      int n = B.length;
      int[][] dp = new int[m+1][n+1];
      // Find Longest common subsequence of A and B
      for (int i = 1; i < m + 1; i++) {
          for (int j = 1; j < n + 1; j++) {
              if (A[i-1] == B[j-1]) {
                  dp[i][j] = dp[i-1][j-1] + 1;
              } else {
                  dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
              }
          }
      }
      
      return dp[m][n];
  }
}