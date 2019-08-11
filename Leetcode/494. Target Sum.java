class Solution {
  public int findTargetSumWays(int[] nums, int S) {
      int[] res = {0, 0};
      helper(nums, 0, S, 0, res);
      return res[0];
  }
  
  private void helper(int[] nums, int pos, int S, int currSum, int[] res) {
      if (pos == nums.length && currSum == S) {
          res[0]++;
      } else {
          if (pos <= nums.length - 1) {
              helper(nums, pos + 1, S, currSum + nums[pos], res);
              helper(nums, pos + 1, S, currSum - nums[pos], res);
          }
      }
  }
}