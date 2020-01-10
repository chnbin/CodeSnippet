class Solution {
  public int maximalSquare(char[][] matrix) {
      // Next... 1227
      // https://leetcode.com/problems/count-square-submatrices-with-all-ones/
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
          return 0;
      }
      
      int m = matrix.length;
      int n = matrix[0].length;
      int res = 0;
      
      // dp[i][j] = 在i, j這格，可以衍生出最大長方形的邊長
      int[][] dp = new int[m][n];
      
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (i == 0 || j == 0) {
                  dp[i][j] = matrix[i][j] - '0';
              } else if (matrix[i][j] == '1') {
                  dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i -1][j], dp[i][j - 1])) + 1;
              }
              res = Math.max(res, dp[i][j]);
          }
      }
      
      return res * res;
  }
}