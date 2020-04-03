class Solution {
  public int maxSubArray(int[] nums) {
      return findMax(nums, 0, nums.length - 1);
  }
  
  private int findMax(int[] nums, int left, int right) {
      if (left >= right) { return nums[left]; }
      
      int mid = left + (right - left) / 2;
      int lMax = findMax(nums, left, mid - 1);
      int rMax = findMax(nums, mid + 1, right);
      int mMax = nums[mid];
      int tmp = nums[mid];
      
      for (int i = mid - 1; i >= left; i--) {
          tmp += nums[i];
          mMax = Math.max(mMax, tmp);
      }
      
      tmp = mMax;
      
      for (int i = mid + 1; i <= right; i++) {
          tmp += nums[i];
          mMax = Math.max(mMax, tmp);
      }
      
      return Math.max(mMax, Math.max(lMax, rMax));
  }
}