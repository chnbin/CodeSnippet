class Solution {
  public int[] pathsWithMaxScore(List<String> board) {
      int MOD = (int)Math.pow(10, 9.0) + 7;
      int n = board.size();
      
      // dp[i][j] = 到i, j的最大值
      int[][] dp = new int[n + 1][n + 1];
      
      // path[i][j] = 到i, j為最大值且有幾條路徑
      int[][] path = new int[n + 1][n + 1];
      
      // 起點與終點沒有成本，設定為0
      dp[0][0] = 0; dp[n][n] = 0;
      
      // 起點只有一種走法
      path[n][n] = 1;
      
      for (int i = n - 1; i >= 0; i--) {
          for (int j = n - 1; j >= 0; j--) {
              if (board.get(i).charAt(j) == 'X') { continue; }
              int max = Math.max(dp[i + 1][j + 1], Math.max(dp[i + 1][j], dp[i][j + 1]));
              if (board.get(i).charAt(j) == 'S' || board.get(i).charAt(j) == 'E') {
                  dp[i][j] = max;
              } else {
                  dp[i][j] = (board.get(i).charAt(j) - '0') + max;
              }
              
              // 比較一下，看一下從你走過來的路是不是最大值，是的話就把path加進來
              if (dp[i + 1][j + 1] == max) {
                  path[i][j] = (path[i][j] + path[i + 1][j + 1]) % MOD;
              }
              
              if (dp[i + 1][j] == max) {
                  path[i][j] = (path[i][j] + path[i + 1][j]) % MOD;
              }
              
              if (dp[i][j + 1] == max) {
                  path[i][j] = (path[i][j] + path[i][j + 1]) % MOD;
              }
          }
      }
      
      int[] res = new int[2];
      if (path[0][0] != 0) {
          res[0] = dp[0][0];
          res[1] = path[0][0];
      }
      return res;   
  }
}
