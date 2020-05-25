class Solution {
  public int maxDotProduct(int[] nums1, int[] nums2) {
      int m = nums1.length;
      int n = nums2.length;
      int[][] dp = new int[m + 1][n + 1];
      
      for (int i = 0; i <= m; i++) {
          dp[i][0] = -2000;
      }
      
      for (int j = 0; j <= n; j++) {
          dp[0][j] = -2000;
      }
      /*
          dp[i][j] is the maximum dot product of two subsequence starting in the position of num1 and
          poistiton j of nums2.
          dp[i][j] = Max(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1] + curr, curr) where 
          curr is nums1[i - 1] * nums2[j - 1].
      */
      for (int i = 1; i <= m; i++) {
          for (int j = 1; j <= n; j++) {
              int sofarMax = Math.max(dp[i - 1][j], dp[i][j - 1]);
              int curr = nums1[i - 1] * nums2[j - 1];
              int currMax = Math.max(dp[i - 1][j - 1] + curr, curr);
              dp[i][j] = Math.max(sofarMax, currMax);
          }
      }
      
      return dp[m][n];
  }
}
