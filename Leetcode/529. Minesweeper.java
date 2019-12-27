class Solution {
  private static final int[][] DIRS = {{-1, -1}, {-1, 0}, {-1, 1},
                                       {0, -1},           {0, 1},
                                       {1, -1}, {1, 0}, {1, 1}};
  
  public char[][] updateBoard(char[][] board, int[] click) {
      if (board == null || click == null) { return board; }
      // 開始就中炸彈
      if (board[click[0]][click[1]] == 'M') {
          board[click[0]][click[1]] = 'X';
          return board;
      }
      
      Queue<Location> q = new LinkedList<>();
      int m = board.length;
      int n = board[0].length;
      boolean[][] visited = new boolean[m][n];
      
      q.add(new Location(click[0], click[1]));
      visited[click[0]][click[1]] = true;
      
      while (!q.isEmpty()) {
          int size = q.size();
          
          for (int i = 0; i < size; i++) {
              Location loc = q.poll();
              int x = loc.x;
              int y = loc.y;
              visited[x][y] = true;
              
              
              if (board[x][y] == 'E') {
                  int bomb = 0;
                  for (int[] dir: DIRS) {
                      int dx = x + dir[0];
                      int dy = y + dir[1];
                      if (dx >= 0 && dx < m && dy >= 0 && dy < n) {
                          if (board[dx][dy] == 'M') {
                              bomb++;
                          }
                      }
                  }

                  if (bomb != 0) {
                      board[x][y] = (char)(bomb + '0');
                  } else {
                      board[x][y] = 'B';
                      for (int[] dirs: DIRS) {
                          int dx1 = x + dirs[0];
                          int dy1 = y + dirs[1];

                          if (dx1 >= 0 && dx1 < m && dy1 >= 0 && dy1 < n && !visited[dx1][dy1]) {
                              q.offer(new Location(dx1, dy1));
                          }
                      }
                  }
              }
          }
      }
      
      return board;
  }
}

class Location {
  public int x;
  public int y;
  Location(int x, int y) {
      this.x = x;
      this.y = y;
  }
}