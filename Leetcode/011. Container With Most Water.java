class Solution {
  public int maxArea(int[] height) {
      int l = 0;
      int r = height.length - 1;
      int container = 0;

      while (l < r) {
          container =Math.max(container, Math.min(height[l], height[r]) * (r - l));
          if (height[l] < height[r]) {
              l++;
          } else if (height[l] > height[r]) {
              r--;
          } else {
              l++;
              r--;
          }
      }
      return container;
  }
}