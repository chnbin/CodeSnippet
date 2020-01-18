class Solution {
  public int threeSumSmaller(int[] nums, int target) {
      int n = nums.length;
      int res = 0;
      Arrays.sort(nums);
      
      for (int i = 0; i < n - 2; i++) {
          int left = i + 1, right = n - 1;
          while (left < right) {
              int sum = nums[i] + nums[left] + nums[right];
              
              if (sum < target) {
                  res += (right - left);
                  left++;
              } else {
                  right--;
              }
          }
      }
      
      return res;
  }
}