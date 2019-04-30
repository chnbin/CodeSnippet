import java.util.LinkedList;

class Point {
  public int x;
  public int y;
  public Point(int x, int y) {
      this.x = x;
      this.y = y;
  }
}

class Solution {
  public int orangesRotting(int[][] grid) {
      int round = 0;
      int freshOranges = 0;
      int[][] directs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
      LinkedList<Point> queue = new LinkedList<Point>();
      
      for (int i = 0; i < grid.length; i++) {
          for (int j =0; j < grid[0].length; j++) {
              if (grid[i][j] == 1) {
                  freshOranges++;
                  continue;
              }
              if (grid[i][j] == 2) {
                  queue.offer(new Point(i, j));
                  continue;
              }
          }
      }
      
      while (!queue.isEmpty()) {
          if (freshOranges == 0) {
              return round;
          }
          int size = queue.size();
          
          for (int i = 0; i < size; i++) {
              Point p = queue.poll();
              int x = p.x;
              int y = p.y;
              for (int j = 0; j < directs.length; j++) {
                  int dx = x + directs[j][0];
                  int dy = y + directs[j][1];
                  
                  if ((0<=dx) && (dx < grid.length) && ((0 <= dy) && (dy < grid[0].length))) {
                      if (grid[dx][dy] == 1) {
                          grid[dx][dy] = 0;
                          freshOranges--;
                          queue.offer(new Point(dx, dy));
                      }
                  }
              }
          }
          round++;
      }
      return (freshOranges == 0) ? round : -1;
  }
  
}