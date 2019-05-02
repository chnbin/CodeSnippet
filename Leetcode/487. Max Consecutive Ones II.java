class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
      if (nums == null || nums.length == 0) { return 0; }
      int pre = 0;
      int flip = 0;
      int pos = 0;
      int maxLen = 0;
      
      for (int num: nums) {
          if (num == 1) {
              pos++;
          } else {
              pre = pos;
              flip = 1;
              pos = 0;
          }
          maxLen = Math.max(maxLen, pre + flip + pos);
      }
      maxLen = Math.max(maxLen, pre + flip + pos);
      return maxLen;
  }
}