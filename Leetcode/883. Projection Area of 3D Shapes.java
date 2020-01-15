class Solution {
  public int projectionArea(int[][] grid) {
      int res = 0;
      int m = grid.length;
      int n = grid[0].length;

      // yz-plane
      for (int i = 0; i < m; i++) {
          int max = Integer.MIN_VALUE;
          for (int j = 0; j < n; j++) {
              max = Math.max(max, grid[i][j]);
              // xy-plane
              if (grid[i][j] > 0) {
                  res++;
              }
          }
          res += max;
      }
      
      // xz-plane
      for (int i = 0; i < n; i++) {
          int max = Integer.MIN_VALUE;
          for (int j = 0; j < m; j++) {
              max = Math.max(max, grid[j][i]);
          }
          res += max;
      }
      return res;
  }
}