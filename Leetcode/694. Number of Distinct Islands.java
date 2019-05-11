import java.util.HashSet;
import java.util.Set;

class Solution {
  final static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
  
  public int numDistinctIslands(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      int res = 0;
      Set<String> set = new HashSet<>();
      
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (grid[i][j] == 1) {
                  StringBuilder sb = new StringBuilder();
                  help(grid, m, n, i, j, 0, 0, sb);
                  if (!set.contains(sb.toString())) {
                      res++;
                      set.add(sb.toString());
                  }
              }
          }
      }
      return res;
  }
  
  private void help(int[][] grid, int m, int n, int r, int c, int dx, int dy, StringBuilder pattern) {
      if (!(0 <= r) || !(r < m) || !(0 <=c) || !(c < n)) { return ;}
      if (grid[r][c] != 1) { return ; }
      grid[r][c] = 0;
      pattern.append(""+dx+dy);
      
      for (int[] dir: this.dirs) {
          help(grid, m, n, r + dir[0], c + dir[1], dx + dir[0], dy + dir[1], pattern);
      }
  }
}