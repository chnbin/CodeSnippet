import java.util.Arrays;

class Solution {
  public int arrayPairSum(int[] nums) {
      if (nums == null || nums.length == 0) { return 0; }
      int res = 0;
      Arrays.sort(nums);
      
      for (int i = 1; i < nums.length; i += 2) {
          res += Math.min(nums[i], nums[i-1]);
      }
      return res;
  }
}