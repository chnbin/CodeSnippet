import java.util.LinkedList;

class Solution {
  public void wallsAndGates(int[][] rooms) {
      if (rooms == null || rooms[0].length == 0) {
          return ;
      }
      int m = rooms.length;
      int n = rooms[0].length;
      LinkedList<Point> queue = new LinkedList<>();
      int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (rooms[i][j] == 0) {
                  queue.offer(new Point(i, j));
              }
          }
      }
      
      while (!queue.isEmpty()) {
          Point curr = queue.poll();
          
          for (int[] direction: directions) {
              int step = rooms[curr.x][curr.y] + 1;
              int dx = curr.x + direction[0];
              int dy = curr.y + direction[1];

              if ((0<=dx)&&(dx<m)&&(0<=dy)&&(dy<n)) {
                  if (rooms[dx][dy] > step) {
                      rooms[dx][dy] = step;
                      queue.offer(new Point(dx, dy));
                  }
              }
          }
      }
  }
}

class Point {
  int x;
  int y;
  public Point() {
      x = 0;
      y = 0;
  }
  
  public Point(int x, int y) {
      this.x = x;
      this.y = y;
  }
}

