class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
      if (nums == null || nums.length == 0) { return 0; }
      int res = 0;
      
      int pos = 0;
      for (int num: nums) {
          if (num == 1) {
              pos++;
          } else {
              res = Math.max(res, pos);
              pos = 0;
          }
      }
      
      res = Math.max(res, pos);
      return res;
  }
}