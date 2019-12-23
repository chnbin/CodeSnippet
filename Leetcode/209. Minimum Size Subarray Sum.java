class Solution {
  public int minSubArrayLen(int s, int[] nums) {
      if (nums == null || nums.length == 0) { return 0; }
      int res = Integer.MAX_VALUE;
      int begin = 0, end = 0, currSum = 0;
      int n = nums.length;
      
      while (end < n) {;
          currSum += nums[end];
          
          while (currSum >= s) {
              res = Math.min(res, end - begin + 1);
              currSum -= nums[begin];
              begin++;
          }
          
          end++;
      }
      
      return (res == Integer.MAX_VALUE) ? 0 : res;
  }
}