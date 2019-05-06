import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Point {
  int r;
  int c;
  public Point(int r, int c) {
      this.r = r;
      this.c = c;
  }
}
class Solution {
  public int swimInWater(int[][] grid) {
      int l = 0;
      int r = grid.length * grid.length -1;
      
      while (l <= r) {
          int m = (l + r) / 2;
          
          if (canReach(grid, m)) {
              r = m - 1;
          } else {
              l = m + 1;
          }
      }

      return l;
  }
  
  private boolean canReach(int[][] grid, int step) {
      boolean isReach = false;
      int m = grid.length;
      int n = grid[0].length;
      int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
      Set<String> visited = new HashSet<String>();
      LinkedList<Point> queue = new LinkedList<>();
      queue.offer(new Point(0, 0));
      
      while (!queue.isEmpty()) {
          Point node = queue.poll();

          if ((node.r == m - 1) && (node.c == n - 1)) { return true; }
          // 防止一開始就在很高的地方
          if (grid[node.r][node.c] > step) { continue; }
          for (int[] direction: directions) {
              int dx = node.r + direction[0];
              int dy = node.c + direction[1];
              String pos = "" + dx + "-" + dy;
              if ((0 <= dx) && (dx < m) && (0 <= dy) && (dy < n)) {
                  if (grid[dx][dy] <= step && !visited.contains(pos)) {
                      queue.offer(new Point(dx, dy));
                      visited.add(pos);
                  }
              }
          }
      }
      
      return isReach;
  }
}