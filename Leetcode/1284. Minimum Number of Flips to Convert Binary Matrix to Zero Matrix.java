class Solution {
  private static int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  
  public int minFlips(int[][] mat) {
      int res = 0;
      int m = mat.length;
      int n = mat[0].length;
      String ans = buildAnswer(m * n);
      Set<String> visited = new HashSet<>();
      Queue<Board> q = new LinkedList<>();
      
      Board board = new Board(mat);
      q.offer(board);
      
      while (!q.isEmpty()) {
          int size = q.size();
          
          for (int i = 0; i < size; i++) {
              Board b = q.poll();
              visited.add(b.code);
              
              if (b.code.equals(ans)) {
                  return res;
              }
              
              for (int j = 0; j < m; j++) {
                  for (int k = 0; k < n; k++) {
                      Board tmp = copyBoard(b.board);
                      for (int[] dir: DIRS) {
                          int dx = j + dir[0];
                          int dy = k + dir[1];
                          if (dx >= 0 && dx < m && dy >= 0 && dy < n) {
                              tmp.board[dx][dy] = (tmp.board[dx][dy] == 0) ? 1 : 0;
                          }
                      }
                      tmp.board[j][k] = (tmp.board[j][k] == 0) ? 1: 0;
                      
                      Board newBoard = copyBoard(tmp.board);
                      if (!visited.contains(newBoard.code)) {
                          q.offer(newBoard);
                      }
                  }
              }
          }
          res++;
      }
      
      return -1;
  }
  
  private String buildAnswer(int n) {
      StringBuilder sb = new StringBuilder();
      
      for (int i = 0; i < n; i++) {
          sb.append("0");
      }
      
      return sb.toString();
  }
  
  private Board copyBoard(int[][] m) {
      int[][] res = new int[m.length][m[0].length];
      
      for (int i = 0; i < m.length; i++) {
          for (int j = 0; j < m[0].length; j++) {
              res[i][j] = m[i][j];
          }
      }
      
      return new Board(res);
  }
}

class Board {
  int[][] board;
  String code;
  
  public Board(int[][] board) {
      this.board = board;
      this.code = toCodeBoard(board);
  }
  
  private String toCodeBoard(int[][] b) {
      StringBuilder code = new StringBuilder();
      
      for (int i = 0; i < b.length; i++) {
          for (int j = 0; j < b[0].length; j++) {
              code.append("" + b[i][j]);
          }
      }
      
      return code.toString();
  }
}