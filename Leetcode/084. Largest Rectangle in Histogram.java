class Solution {
  public int largestRectangleArea(int[] heights) {
      if (heights == null || heights.length == 0) { return 0; }
      // 暴力法
      // 以每一個index為例，先算該index的面積。在算由左右衍生出去每一個面積。
      // 以index 2, height = 5為例：一開始算到5*1
      // 往左第一格,index 1, height = 1，故index2 到 index 1圍出來的面積是1*2
      // 往左第二格,index 0, height = 2，故index2 到 index 0圍出來的面積是1*3
      // 這樣是O(n^2)
      int res = Integer.MIN_VALUE;
      
      for (int i = 0; i < heights.length; i++) {
          int currHeight = heights[i];
          res = Math.max(res, currHeight * 1);
          
          // To left
          if (i > 0) {
              for (int j = i - 1; j >= 0; j--) {
                  currHeight = Math.min(currHeight, heights[j]);
                  res = Math.max(res, currHeight * (i - j + 1));
              }
          }
          
          // To right
          currHeight = heights[i];
          if (i < heights.length - 1) {
              for (int k = i + 1; k < heights.length; k++) {
                  currHeight = Math.min(currHeight, heights[k]);
                  res = Math.max(res, currHeight * (k - i + 1));
              }
          }
      }
      
      return res;
  }
}