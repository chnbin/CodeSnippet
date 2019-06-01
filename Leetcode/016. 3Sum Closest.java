import java.util.Arrays;

class Solution {
  public int threeSumClosest(int[] nums, int target) {
      Arrays.sort(nums);
      int res = 0;
      int dist = Integer.MAX_VALUE;

      for (int i = 0; i < nums.length - 1; i++) {
          int left = i + 1;
          int right = nums.length - 1;
          
          while (left < right) {
              int sum = nums[left] + nums[right] + nums[i];
              if (Math.abs(target - sum) < dist) {
                  dist = Math.abs(target - sum);
                  res = sum;
              }
              if (sum > target) {
                  right--;
              } else if (sum < target) {
                  left++;
              } else {
                  return res;
              }
          }
      }
      return res;
  }
}