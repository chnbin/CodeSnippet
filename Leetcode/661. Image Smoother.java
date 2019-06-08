class Solution {
  public int[][] imageSmoother(int[][] M) {
      int r = M.length;
      int c = M[0].length;
      int[][] res = new int[r][c];
      int[][] directions = {{-1, -1} , {-1, 0}, {-1, 1},
                            {0, -1}, {0, 0}, {0, 1},
                            {1, -1}, {1, 0}, {1, 1}};
      
      for (int i = 0; i < r; i++) {
          for (int j = 0; j < c; j++) {
              int count = 0;
              int sum = 0;
              
              for (int[] direction: directions) {
                  int dx = i + direction[0];
                  int dy = j + direction[1];
                  if (isInImage(dx, dy, r, c)) {
                      count++;
                      sum += M[dx][dy];
                  }
              }
              res[i][j] = (sum/count);
          }
      }
      return res;
  }
      
  private boolean isInImage(int x, int y, int r, int c) {
      if ((0 <= x) && (x < r) && (0 <= y) && (y < c)) {
          return true;
      }
      return false;
  }
  
}