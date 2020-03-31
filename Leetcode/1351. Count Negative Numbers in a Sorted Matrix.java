class Solution {
  public int countNegatives(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      int row = 0;
      int col = n - 1;
      int res = 0;
      
      while (row < m && col >= 0) {
          if (grid[row][col] < 0) {
              res += (m - row);
              col--;
          } else {
              row++;
          }
      }
      
      return res;
  }
}