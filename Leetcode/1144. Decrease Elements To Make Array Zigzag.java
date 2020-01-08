class Solution {
  public int movesToMakeZigzag(int[] nums) {
      int decrease1 = 0;
      int decrease2 = 0;
      
      int[] tmp1 = Arrays.copyOf(nums, nums.length);
      // A[0] > A[1] < A[2] > A[3] < A[4] > ...
      for (int i = 1; i < tmp1.length; i++) {
          if (i % 2 == 0) {
              if (tmp1[i - 1] >= tmp1[i]) {
                  decrease1 += Math.abs(tmp1[i] - tmp1[i - 1]) + 1;
                  tmp1[i - 1] = tmp1[i] - 1;
              }
          } else {
              if (tmp1[i - 1] <= tmp1[i]) {
                  decrease1 += Math.abs(tmp1[i] - tmp1[i - 1]) + 1;
                  tmp1[i] = tmp1[i - 1] - 1;
              }
          }
      }
      
      // A[0] < A[1] > A[2] < A[3] > A[4] < ...
      for (int i = 1; i < nums.length; i++) {
          if (i % 2 == 0) {
              if (nums[i - 1] <= nums[i]) {
                  decrease2 += Math.abs(nums[i] - nums[i - 1]) + 1;
                  nums[i] = nums[i - 1] - 1;
              }
          } else {
              if (nums[i - 1] >= nums[i]) {
                  decrease2 += Math.abs(nums[i] - nums[i - 1]) + 1;
                  nums[i - 1] = nums[i] - 1;
              }
          }
      }
      
      return Math.min(decrease1, decrease2);
  }
}