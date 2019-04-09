class Solution {
  public int searchInsert(int[] nums, int target) {
      int length = nums.length;
      for(int i = 0; i < length; i++) {
          if (target <= nums[i]) { return i; }
      }
      return length;
  }
}