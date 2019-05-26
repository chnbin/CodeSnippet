import java.util.Arrays;

class Solution {
  public int heightChecker(int[] heights) {
      int[] tmp = heights.clone();
      int res = 0;

      Arrays.sort(tmp);
      
      for (int i = 0; i < heights.length; i++) {
          if (tmp[i] != heights[i]) { res++; }
      }
      return res;
  }
}