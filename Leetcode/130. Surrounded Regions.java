class Solution {
  public void solve(char[][] board) {
      if (board == null || board.length == 0) { return; }
      if (board.length <= 2 || board[0].length <= 2) { return; }
      int m = board.length;
      int n = board[0].length;
      
      for (int i = 0; i < n; i++) {
          char target = 'O';
          if (board[0][i] == target) {
              helper(board, 0, i, m, n, target, '@');
          }
          
          if (board[m-1][i] == target) {
              helper(board, m - 1, i, m, n, target, '@');
          }
      }
      
      for (int j = 0; j < m; j++) {
          char target = 'O';
          if (board[j][0] == target) {
              helper(board, j, 0, m, n, target, '@');
          }
          
          if (board[j][n-1] == target) {
              helper(board, j, n-1, m, n, target, '@');
          }
      }
      
      for (int i = 1; i < m - 1; i++) {
          for (int j = 1; j < n - 1; j++) {
              char target = 'O';
              if (board[i][j] == target) {
                  helper(board, i, j, m, n, target, 'X');
              }
          }
      }
      
      for (int i = 0; i < n; i++) {
          char target = '@';
          if (board[0][i] == target) {
              helper(board, 0, i, m, n, target, 'O');
          }
          
          if (board[m-1][i] == target) {
              helper(board, m - 1, i, m, n, target, 'O');
          }
      }
      
      for (int j = 0; j < m; j++) {
          char target = '@';
          if (board[j][0] == target) {
              helper(board, j, 0, m, n, target, 'O');
          }
          
          if (board[j][n-1] == target) {
              helper(board, j, n-1, m, n, target, 'O');
          }
      }
  }
  
  private void helper(char[][] board, int r, int c,
                      int m, int n, int target, char newChar) {
      if ((0 <= r) && (r < m) && (0 <= c) && (c < n)) {
          if (board[r][c] == target) {
              board[r][c] = newChar;
              helper(board, r-1, c, m, n, target, newChar);
              helper(board, r+1, c, m, n, target, newChar);
              helper(board, r, c-1, m, n, target, newChar);
              helper(board, r, c+1, m, n, target, newChar);
          }
      }
  }
}