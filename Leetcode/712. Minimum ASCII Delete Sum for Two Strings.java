class Solution {
  public int minimumDeleteSum(String s1, String s2) {
      int m = s1.length();
      int n = s2.length();
      int s1Cost = 0;
      int s2Cost = 0;
      int[][] dp = new int[m+1][n+1];
      
      for (int i = 1; i < m + 1; i++) {
          for (int j = 1; j < n + 1; j++) {
              if (s1.charAt(i-1) == s2.charAt(j-1)) {
                  dp[i][j] = dp[i-1][j-1] + (int)(s1.charAt(i-1));
              } else {
                  dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
              }
              
              if (i == 1) { s2Cost += (int)(s2.charAt(j-1)); }
          }    
          
          s1Cost += (int)(s1.charAt(i-1));
      }
      
      int commonCharCost = dp[m][n];
      return (s1Cost - commonCharCost) + (s2Cost - commonCharCost);
  }
}