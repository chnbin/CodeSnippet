/*
這題的思路很像是130. Surrounded regions，根據定義如果是上下左右都被1包圍的叫做Closed island。
因此我們先對四周做DFS把0變成2，標記出不是Closed island。
Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,0], 
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
變成：
Input: grid = [[1,1,1,1,1,1,1],
               [1,2,2,2,2,2,1],
               [1,2,1,1,1,2,1],
               [1,2,1,0,1,2,2],
               [1,2,1,1,1,2,1],
               [1,2,2,2,2,2,1],
               [1,1,1,1,1,1,1]]
接下來就是算number of islands了
*/
class Solution {
  public int closedIsland(int[][] grid) {
      if (grid == null || grid.length <= 2 || grid[0].length <= 2) {
          return 0;
      }
      int res = 0;
      int rows = grid.length;
      int cols = grid[0].length;
      
      // 如果邊界有0，那絕對不是closed island，先標記出來
      for (int c = 0; c < cols; c++) {
          if (grid[0][c] == 0) { makeBarrier(grid, 0, c); }
          if (grid[rows - 1][c] == 0) { makeBarrier(grid, rows - 1, c); }
      }
      
      for (int r = 0; r < rows; r++) {
          if (grid[r][0] == 0) { makeBarrier(grid, r, 0); }
          if (grid[r][cols - 1] == 0) { makeBarrier(grid, r, cols - 1); }
      }
      
      // 看沒有連到外面的聯通元件有幾個
      for (int r = 1; r < rows - 1; r++) {
          for (int c = 1; c < cols - 1; c++) {
              if (grid[r][c] == 0) {
                  makeBarrier(grid, r, c);
                  res++;
              }
          }
      }
      
      return res;
  }
  
  private void makeBarrier(int[][] grid, int r, int c) {
      if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length && grid[r][c] == 0)) {
          return ;
      }
      grid[r][c] = 2;
      
      makeBarrier(grid, r - 1, c);
      makeBarrier(grid, r + 1, c);
      makeBarrier(grid, r, c - 1);
      makeBarrier(grid, r, c + 1);
  }
}