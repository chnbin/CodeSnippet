class Solution {
  public int[] searchRange(int[] nums, int target) {
      int firstIndex = findFirstPos(nums, target);
      int lastIndex = findLastPos(nums, target);
      
      return new int[]{firstIndex, lastIndex};
  }
  
  // 如果要找最左邊那個target，一但找到target，把index記錄下來，然後把區間縮減至left to mid - 1
  private int findFirstPos(int[] nums, int target) {
      int res = -1;
      int left = 0;
      int right = nums.length - 1;
      
      while (left <= right) {
          int mid = left + (right - left) / 2;
          
          if (nums[mid] == target) {
              res = mid;
              right = mid - 1;
          } else if (nums[mid] > target) {
              right = mid - 1;
          } else {
              left = mid + 1;
          }
      }
      
      return res;
  }
  
  // 如果要找最右邊那個target，一但找到target，把index記錄下來，然後把區間縮減至mid + 1 to right
  private int findLastPos(int[] nums, int target) {
      int res = -1;
      int left = 0;
      int right = nums.length - 1;
      
      while (left <= right) {
          int mid = left + (right - left) / 2;
          
          if (nums[mid] == target) {
              res = mid;
              left = mid + 1;
          } else if (nums[mid] > target) {
              right = mid - 1;
          } else {
              left = mid + 1;
          }
      }
      
      return res;
  }
}