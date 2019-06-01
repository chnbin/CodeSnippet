class Solution {
  public int jump(int[] nums) {
      if (nums == null || nums.length < 2) { return 0; }
      int res = 0;
      int currMax = 0;
      int maxNext = 0;
      
      for (int i = 0; i < nums.length - 1; i++) {
          maxNext = Math.max(maxNext, i + nums[i]);
          if (currMax == i) {
              res++;
              currMax = maxNext;
          }
      }
      return res;
  }
}