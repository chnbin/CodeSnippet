class Solution {
  // Need to refactor
  public int numRookCaptures(char[][] board) {
      int[] rook = new int[2];
      int res = 0;
      
      for (int i = 0; i< 8; i++) {
          for (int j = 0; j < 8; j++) {
              if (board[i][j] == 'R') {
                  rook = new int[]{i, j};
              }
          }
      }
      
      for (int i = rook[0]; i < 8; i++) {
          if (board[i][rook[1]] == 'B') {
              break;
          }
          if (board[i][rook[1]] == 'p') {
              res++;
              break;
          }
      }
      
      for (int i = rook[0]; i >= 0; i--) {
          if (board[i][rook[1]] == 'B') {
              break;
          }
          if (board[i][rook[1]] == 'p') {
              res++;
              break;
          }
      }
      
      for (int j = rook[1]; j < 8; j++) {
          if (board[rook[0]][j] == 'B') {
              break;
          }
          if (board[rook[0]][j] == 'p') {
              res++;
              break;
          }
      }
      
      for (int j = rook[1]; j >= 0; j--) {
          if (board[rook[0]][j] == 'B') {
              break;
          }
          if (board[rook[0]][j] == 'p') {
              res++;
              break;
          }
      }
      return res;
  }
}