class Solution {
  public int minStartValue(int[] nums) {
      int res = 0;
      // using prefix sum and find minimal value
      for (int i = 0; i < nums.length; i++) {
          if (i > 0) {
              nums[i] += nums[i - 1];
          }
          res = Math.min(res, nums[i]);
      }
      
      return Math.abs(res) + 1;
  }
}