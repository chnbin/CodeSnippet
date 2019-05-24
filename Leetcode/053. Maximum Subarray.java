class Solution {
  public int maxSubArray(int[] nums) {
      if (nums == null || nums.length == 0) { return 0; }
      int[] dp = new int[nums.length + 1];
      int res = Integer.MIN_VALUE;
      for (int i = 1; i <= nums.length; i++) {
          dp[i] = nums[i-1];
          if ((dp[i-1]) > 0) {
              dp[i] += dp[i-1];
          }
      }
      for (int i = 1; i < dp.length; i++) {
          res = Math.max(res, dp[i]);
      }
      return res;
  }
}