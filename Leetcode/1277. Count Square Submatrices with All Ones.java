class Solution {
  public int countSquares(int[][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
          return 0;
      }
      
      int res = 0;
      int m = matrix.length;
      int n = matrix[0].length;
      
      // dp[i][j] = 由i, j 衍生出去可以組成正方形的邊長
      int[][] dp = new int[m][n];
      
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (i == 0 || j == 0) {
                  dp[i][j] = matrix[i][j];
              } else if (matrix[i][j] == 1) {
                  dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
              }
              res += dp[i][j];
          }
      }
      
      return res;
  }
}