class Solution {
  public boolean canPartition(int[] nums) {
      if (nums == null || nums.length == 0) {
          return false;
      }
      int sum = getSumOfArray(nums);
      
      if (sum % 2 != 0) { return false; }
      int length = nums.length;
      int target = sum / 2;
      boolean[][] dp = new boolean[length+1][target+1];
      dp[0][0] = true;
      
      for (int i = 1; i <= length; i++) {
          for (int j = 0; j <= target; j++) {
              if (j >= nums[i-1]) {
                  dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
              } else {
                  dp[i][j] = dp[i][j] || dp[i-1][j];
              }
              
              if (j == target && dp[i][j]) {
                  return true;
              }
          }
      }
      return false;
      
  }
  
  private int getSumOfArray(int[] nums) {
      int sum = 0;
      
      for (int num: nums) {
          sum += num;
      }
      
      return sum;
  }
}