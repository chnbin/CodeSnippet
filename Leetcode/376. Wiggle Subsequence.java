class Solution {
  public int wiggleMaxLength(int[] nums) {
      if (nums == null || nums.length == 0) { return 0; }
      int n = nums.length;
      int[] dpRise = new int[n]; // dpDrop[i]: longest wiggle subsequence and now it is rising.
      int[] dpDown = new int[n]; // dpDrop[i]: longest wiggle subsequence and now it is down.
      dpRise[0] = 1;
      dpDown[0] = 1;
      
      for (int i = 1; i < n; i++) {
          if (nums[i] > nums[i - 1]) {
              // Rise
              dpRise[i] = dpRise[i - 1];
              dpDown[i] = dpRise[i - 1] + 1;
          } else if (nums[i] < nums[i - 1]) {
              // Down
              dpRise[i] = dpDown[i - 1] + 1;
              dpDown[i] = dpDown[i - 1];
          } else {
              // two elements are equal
              dpRise[i] = dpRise[i - 1];
              dpDown[i] = dpDown[i - 1];
          }
      }
      return Math.max(dpRise[n - 1], dpDown[n - 1]);
  }
}
