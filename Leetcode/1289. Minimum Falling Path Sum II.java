class Solution {
  public int minFallingPathSum(int[][] arr) {
      int m = arr.length;
      int n = arr[0].length;

      // dp[i][j] = Minimum cost to (i, j).
      int[][] dp = new int[m][n];
      
      for (int i = 0; i < m; i++) {
          dp[0][i] = arr[0][i];
      }
      
      for (int i = 1; i < m; i++) {
          for (int j = 0; j < n; j++) {
              int currValue = arr[i][j];
              int cost = Integer.MAX_VALUE;

              // Choose the minimum cost except col j.
              for (int k = 0; k < n; k++) {
                  if (j != k) {
                      cost = Math.min(cost, dp[i-1][k]);
                  }
              }
              dp[i][j] = currValue + cost;
          }
      }
      
      int res = Integer.MAX_VALUE;
      
      for (int i = 0; i < n; i++) {
          res = Math.min(res, dp[m - 1][i]);
      }
      
      return res;
  }
}