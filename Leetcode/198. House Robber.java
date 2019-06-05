class Solution {
  public int rob(int[] nums) {
      if (nums == null || nums.length == 0) { return 0; }
      if (nums.length == 1) { return nums[0]; }
      if (nums.length == 2) { return Math.max(nums[0], nums[1]); }
      
      int len = nums.length;
      int[] dp = new int[len];
      dp[0] = nums[0];
      dp[1] = Math.max(nums[0], nums[1]);
      
      for (int i = 2; i < len; i++) {
          /**
           * dp[i] is the max money in the i-th location.
           * In i-th location, thive can choose steal i-th location or not.
           * If he decides to steal i-th location, dp[i] = nums[i] + dp[i-2].
           * If he decides to pass i-th location, dp[i] = dp[i-1];
           */
          dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
      }
      return dp[len-1];
  }
}