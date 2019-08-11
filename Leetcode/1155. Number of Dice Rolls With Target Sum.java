class Solution {
  public int numRollsToTarget(int d, int f, int target) {
    long[][] dp = new long[d][target+1];
  
    int end = Math.min(f, target);
    for (int i = 1; i <= end; i++) {
      dp[0][i] = 1; 
    }
      
      // 未來取mod一定要用這招，這次這裡卡好久
    int mod = (int) Math.pow(10, 9) + 7;
        
    for (int i = 1; i < dp.length; i++) {
      for (int j = i + 1; j < dp[0].length; j++) {
        int start = Math.max(1, j - f);
        for (int k = start; k < j; k++) {
          dp[i][j] += dp[i-1][k];
          dp[i][j] %= mod;
        }
      }
    }
    
    return (int)dp[d-1][target];
    }
}