class Solution {
  public int longestIncreasingPath(int[][] matrix) {
      if (matrix == null || matrix.length == 0) {
          return 0;
      }
      int m = matrix.length;
      int n = matrix[0].length;
      // dp[i][j] 從這一格開始之最長遞增路徑，以題目為例:
      // dp[0][0] 為1 只有9
      // dp[0][2] 為2 有[4, 9],[8, 9]
      // dp[2][0] 為3 為[2, 6, 9]
      // 當我們要算dp[2][1]時，從上下左右衍生出去看是否可以更長
      int[][] dp = new int[m][n];
      int res = 0;
      
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (dp[i][j] == 0) {
                  // 投入Integer.MIN_VALUE是因為不管怎麼樣一個dp儲存的數一定少為1
                  dfs(matrix, dp, i, j, Integer.MIN_VALUE);
                  res = Math.max(res, dp[i][j]);
              }
          }
      }
      return res;
  }
  
  private int dfs(int[][] matrix, int[][] dp, int row, int col, int prev) {
      // 檢查有無在邊界，且prev不可以大於dp[row][col]，因爲這樣就不能衍生
      if (!(0 <= row && row < matrix.length && 0 <= col && col < matrix[0].length && prev < matrix[row][col])) {
          return 0;
      }
      
      if (dp[row][col] != 0) { return dp[row][col]; }
      
      int left = dfs(matrix, dp, row - 1, col, matrix[row][col]);
      int right = dfs(matrix, dp, row + 1, col, matrix[row][col]);
      int up = dfs(matrix, dp, row, col - 1, matrix[row][col]);
      int down = dfs(matrix, dp, row, col + 1, matrix[row][col]);
      
      dp[row][col] = Math.max(left, Math.max(right, Math.max(up, down))) + 1;
      
      return dp[row][col];
  }
}