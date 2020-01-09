class Solution {
  public int countBattleships(char[][] board) {
      int res = 0;
      
      for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[0].length; j++) {
              if (board[i][j] == 'X') {
                  if (countBattleshipsHelper(board, i, j) > 0) {
                      res++;
                  }
              }
          }
      }
      
      return res;
  }
  
  private int countBattleshipsHelper(char[][] board, int r, int c) {
      if (!(r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 'X')) {
          return 0;
      }
      int area = 1;
      board[r][c] = '.';

      area += countBattleshipsHelper(board, r - 1, c);
      area += countBattleshipsHelper(board, r + 1, c);
      area += countBattleshipsHelper(board, r, c - 1);
      area += countBattleshipsHelper(board, r, c + 1);
      
      return area;
  }
}