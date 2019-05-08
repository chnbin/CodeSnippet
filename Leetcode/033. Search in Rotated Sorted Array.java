class Solution {
  public int search(int[] nums, int target) {
      int l = 0;
      int r = nums.length - 1;
      
      while (l <= r) {
          int m = (l + r) / 2;
          
          if (nums[m] == target) { return m; }
          // Right side sorted already.
          if (nums[m] <= nums[r]) {
              if ((nums[m] < target) && (target <= nums[r])) {
                  l = m + 1;
              } else {
                  r = m - 1;
              }
          }
          // Left side sorted already
          if (nums[l] <= nums[m]) {
              if ((nums[l] <= target) && (target < nums[m])) {
                  r = m - 1;
              } else {
                  l = m + 1;
              }
          }
      }
      return -1;
  }
}