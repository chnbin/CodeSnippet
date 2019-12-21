class Solution {
  public int numTrees(int n) {
      // dp[i], i 是 i = 0時可以形成Unique BST的個數。
      // dp[0] = 1, 因為Empty tree也是BST。
      // dp[1] 因為左右都是空樹, 因此只有一種
      // dp[2] == dp[0] * dp[1] + // (1 為 root的狀況，左子樹一定0個點;右邊一定1個點）
      //          dp[1] * dp[0]   // (2 為 root的狀況，左子樹一定1個點;右邊一定2個點)
      // dp[3] == dp[0] * dp[2] + // (1 為 root的狀況，左子樹一定0個點;右邊一定2個點）
      //          dp[1] * dp[1] + // (2 為 root的狀況，左子樹一定1個點;右邊一定1個點）
      //          dp[2] * dp[0] + // (3 為 root的狀況，左子樹一定2個點;右邊一定1個點）
      // 這樣可以推到n個點的結果
      
      // 然後你會發現這就是Catalan number
      if (n < 2) { return 1; }
      int[] dp = new int[n + 1];
      dp[0] = 1;
      dp[1] = 1;
      
      for (int i = 2; i < dp.length; i++) {
          for (int j = 0; j < i; j++) {
              dp[i] += (dp[j] * dp[i - 1 -j]);
          }
      }
      return dp[n];
  }
}