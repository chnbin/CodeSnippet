class Solution {
  public int findLengthOfLCIS(int[] nums) {
      if (nums == null || nums.length == 0) {
          return 0;
      }
      int start = 0;
      int end = 0;
      int maxLen = 0;
      
      while (end < nums.length) {
          if (end > 0 && (nums[end] <= nums[end-1])) {
              start = end;
          }
          maxLen = Math.max(maxLen, end - start + 1);
          end++;
      }
      return maxLen;
  }
}