class Solution {
  public int maxIncreaseKeepingSkyline(int[][] grid) {
      int[] vertical = new int[grid.length];
      int[] horizon = new int[grid[0].length];
      int m = grid.length;
      int res = 0;
      for (int i = 0; i < m ; i++) {
          int h = 0;
          int v = 0;
          for (int j = 0; j < m; j++) {
              h = Math.max(h, grid[i][j]);
              v = Math.max(v, grid[j][i]);
          }
          horizon[i] = v;
          vertical[i] = h;
      }
      // System.out.println(Arrays.toString(horizon));
      // System.out.println(Arrays.toString(vertical));
      
      for (int i = 0; i < m ; i++) {
          for (int j = 0; j < m; j++) {
              res += (Math.min(horizon[i], vertical[j]) - grid[i][j]);  
          }
      }
      
      return res;
  }
}


