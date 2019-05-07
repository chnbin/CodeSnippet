class Solution {
  public int trap(int[] height) {
      if (height == null || height.length == 0) { return 0; }
      int len = height.length;
      int[] prefix = new int[len];
      int[] postfix = new int[len];
      int prev = 0;
      int res = 0;

      for (int i = 0; i < len; i++) {
          prefix[i] = prev;
          if (height[i] > prev) {
              prev = height[i];
          }
      }
      prev = 0;
      for (int i = len - 1; i >= 0; i--) {
          postfix[i] = prev;
          if (height[i] > prev) {
              prev = height[i];
          }
      }
      
      for (int i = 0; i < len; i++) {
          int trap = Math.min(prefix[i], postfix[i]) - height[i];
          if (trap > 0) { res += trap; }
      }
      return res;
  }
}