class Solution {
  public int getMaximumGold(int[][] grid) {
      int n = grid.length;
      int m = grid[0].length;
      int res = Integer.MIN_VALUE;
      
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              if (grid[i][j] == 0) { continue; }
              int maxLen = dfs(i, j, grid, grid[i][j]);
              res = Math.max(res, maxLen);
          }
      }
      return res;
  }
  
  private int dfs(int r, int c, int[][] grid, int sum) {
      int left = sum, right = sum, up = sum, down = sum;
      int tmp = grid[r][c];
      
      // Set as visited
      grid[r][c] = -1;
      
      // Up
      if (r > 0 && grid[r-1][c] > 0) {
          up = dfs(r - 1, c, grid, sum + grid[r-1][c]);
      }
      
      // down
      if (r < grid.length - 1 && grid[r + 1][c] > 0) {
          down = dfs(r + 1, c, grid, sum + grid[r + 1][c]);
      }
      
      // left
      if (c > 0 && grid[r][c - 1] > 0) {
          left = dfs(r, c - 1, grid, sum + grid[r][c - 1]);
      }
      
      // right
      if (c < grid[0].length - 1 && grid[r][c + 1] > 0) {
          right = dfs(r, c + 1, grid, sum + grid[r][c + 1]);
      }
                     
      grid[r][c] = tmp;
      
      return Math.max(left, Math.max(right, Math.max(up, down)));
      
  }
}