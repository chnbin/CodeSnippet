class Solution {
  public int rob(int[] nums) {
      if (nums == null || nums.length == 0) { return 0; }
      if (nums.length == 1) { return nums[0]; }
      if (nums.length == 2) { return Math.max(nums[0], nums[1]); }
      int len = nums.length;
      
      // Steal first house or not.
      return Math.max(maxMoney(0, len-2, nums), maxMoney(1, len-1, nums));
  }
  /**
   * Return the max money which robber can get in nums from index start to end.
   * @param start
   * @param end
   * @param nums
   * @return
   */
  private int maxMoney(int start, int end, int[] nums) {
      int[] dp = new int[nums.length];
      dp[start] = nums[start];
      dp[start+1] = Math.max(nums[start], nums[start+1]);
      
      /**
       * dp[i] is the max money in the i-th location.
       * In i-th location, thive can choose steal i-th location or not.
       * If he decides to steal i-th location, dp[i] = nums[i] + dp[i-2].
       * If he decides to pass i-th location, dp[i] = dp[i-1];
       */
      for (int i = start + 2; i <= end; i++) {
          dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
      }
      return dp[end];
  }
}