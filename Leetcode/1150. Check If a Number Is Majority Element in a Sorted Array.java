class Solution {
  public boolean isMajorityElement(int[] nums, int target) {
      int n = nums.length;
      return (nums[n/2] == target) && (nums[n/2-1] == target);
  }
}