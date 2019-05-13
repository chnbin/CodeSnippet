import java.util.Arrays;

class Solution {
  public int minMoves2(int[] nums) {
      if (nums == null || nums.length == 0) {
          return 0;
      }
      int len = nums.length;
      Arrays.sort(nums);
      int median = 0;
      if (len % 2 == 0) {
          median = (nums[len/2-1] + nums[len/2])/2;
      } else {
          median = nums[len/2];
      }
      int res = 0;
      
      for (int num: nums) {
          res += Math.abs(num - median);
      }
      return res;
  }
}