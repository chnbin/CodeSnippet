import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
  public int shortestPathBinaryMatrix(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      
      if (grid[0][0] == 1 || grid[m-1][n-1] == 1) { return -1; }
      
      Queue<Loc> queue = new LinkedList<>();
      Set<String> visited = new HashSet<>();
      int step = 0;
      int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1},
                            {0, -1}, {0, 1},
                            {1, -1}, {1, 0}, {1, 1}};
      queue.offer(new Loc(0, 0));
      
      while (!queue.isEmpty()) {
          int size = queue.size();
          
          for (int i = 0; i < size; i++) {
              Loc currLoc = queue.poll();
              int x = currLoc.x;
              int y = currLoc.y;
              if (x == m - 1 && y == n - 1) {
                  return step + 1;
              }
              
              for (int[] dir: directions) {
                  int dx = x + dir[0];
                  int dy = y + dir[1];
                  
                  if (((0 <= dx) && (dx < m)) && ((0 <= dy) && (dy < n)) &&
                      (!visited.contains(dx+"-"+dy))) {
                      if (grid[dx][dy] == 0) {
                          queue.offer(new Loc(dx, dy));
                          visited.add(dx + "-" + dy);
                      }
                  }
              }
          }
          step++;
      }
      
      return -1;
  }
}

class Loc {
  int x;
  int y;
  public Loc(int x, int y) {
      this.x = x;
      this.y = y;
  }
}