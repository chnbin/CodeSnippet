class Solution {
  public int maxAreaOfIsland(int[][] grid) {
      if (grid == null || grid[0].length == 0) {
          return 0;
      }
      int m = grid.length;
      int n = grid[0].length;
      int maxArea = 0;
      
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (grid[i][j] == 1) {
                  maxArea = Math.max(maxArea, maxAreaHelper(grid, i, j, m, n));
              }
          }
      }
      return maxArea;
  }
  
  private int maxAreaHelper(int[][] grid, int r, int c, int height, int width) {
      if (!(0 <= r) || !(r < height) || !(0 <= c) || !(c < width)) { return 0; }
      if (grid[r][c] != 1) { return 0; }
      int area = 1;
      grid[r][c] = 0;
      
      area += maxAreaHelper(grid, r + 1, c, height, width);
      area += maxAreaHelper(grid, r - 1, c, height, width);
      area += maxAreaHelper(grid, r, c + 1, height, width);
      area += maxAreaHelper(grid, r, c - 1, height, width);
      return area;
  }
}