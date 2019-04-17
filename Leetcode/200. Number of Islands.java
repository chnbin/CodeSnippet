class Solution2 {
  public int numIslands(char[][] grid) {
      if (grid == null || grid.length == 0) { return 0; }
      int m = grid.length;
      int n = grid[0].length;
      int ans = 0;
      
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (grid[i][j] == '1') {
                  helper(grid, i, j);
                  ans++;
              }
          }
      }
      return ans;
  }
  
  private void helper(char[][] grid, int row, int col) {
      int m = grid.length;
      int n = grid[0].length;
      if ((0 <= row) && (row < m) && (0 <= col) && (col < n)) {
          if (grid[row][col] == '1') {
              grid[row][col] = '0'; // Visited
              helper(grid, row+1, col);
              helper(grid, row-1, col);
              helper(grid, row, col+1);
              helper(grid, row, col-1);
          }
      }
  }
}