class Solution {
  public int numMagicSquaresInside(int[][] grid) {
      int res = 0;
      
      for (int i = 1; i < grid.length - 1; i++) {
          for (int j = 1; j < grid[0].length - 1; j++) {
              if (isValid(grid, i, j)) { res++; }
          }
      }
      
      return res;
  }
  
  private boolean isValid(int[][] grid, int x, int y) {
      if (grid[x][y] != 5) { return false; }
      boolean[] visited = new boolean[16];
      
      for (int i = x - 1; i < x + 2; i++) {
          for (int j = y - 1; j < y + 2; j++) {
              visited[grid[i][j]] = true;
          }
      }
      
      for (int i = 1; i <= 9; i++) {
          if (!visited[i]) { return false; }
      }
      
      if (grid[x-1][y-1] + grid[x-1][y] + grid[x-1][y+1] != 15) { return false;}
      if (grid[x][y-1] + grid[x][y] + grid[x][y+1] != 15) { return false;}
      if (grid[x+1][y-1] + grid[x+1][y] + grid[x+1][y+1] != 15) { return false;}
      if (grid[x-1][y-1] + grid[x][y-1] + grid[x+1][y-1] != 15) { return false;}
      if (grid[x-1][y] + grid[x][y] + grid[x+1][y] != 15) { return false;}
      if (grid[x-1][y+1] + grid[x][y+1] + grid[x+1][y+1] != 15) { return false;}
      if (grid[x-1][y-1] + grid[x][y] + grid[x+1][y+1] != 15) { return false;}
      if (grid[x+1][y-1] + grid[x][y] + grid[x-1][y+1] != 15) { return false;}
      
      return true;
  }
}