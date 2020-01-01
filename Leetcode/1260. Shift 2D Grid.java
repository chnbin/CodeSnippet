class Solution {
  public List<List<Integer>> shiftGrid(int[][] grid, int k) {
      List<List<Integer>> res = new ArrayList<>();
      int m = grid.length;
      int n = grid[0].length;
      k = k % (n*m);
      
      reverseGrid(grid, 0, m*n - 1, n);
      reverseGrid(grid, 0, k - 1, n);
      reverseGrid(grid, k, m*n - 1, n);
      
      for (int i = 0; i < m; i++) {
          res.add(new ArrayList<Integer>());
          for (int j = 0; j < n; j++) {
              res.get(i).add(grid[i][j]);
          }
      }
      
      return res;
  }
  
  private void reverseGrid(int[][] grid, int start, int end, int cols) {
      while (start < end) {
          int tmp = grid[end/cols][end%cols];
          grid[end/cols][end%cols] = grid[start/cols][start%cols];
          grid[start/cols][start%cols] = tmp;
          start++;
          end--;
      }
  }
}