class Solution {
  public int islandPerimeter(int[][] grid) {
      if (grid == null || grid[0].length == 0) { return 0; }
      int perimeter = 0;
      int m = grid.length;
      int n = grid[0].length;
      
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (grid[i][j] == 1) {
                  perimeter += helper(grid, i + 1, j, m, n);
                  perimeter += helper(grid, i - 1, j, m, n);
                  perimeter += helper(grid, i, j + 1, m, n);
                  perimeter += helper(grid, i, j - 1, m, n);
              }
          }
      }
      return perimeter;
  }
  
  private int helper(int[][] grid, int r, int c, int height, int width) {
      if (!(0 <= r) || !(r < height) || !(0 <= c) || !(c < width)) { return 1; }
      if (grid[r][c] == 0) { return 1; }
      return 0;
  }
}