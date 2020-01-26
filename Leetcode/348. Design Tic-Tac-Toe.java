class TicTacToe {
  int[] rows;
  int[] cols;
  int pDiag;
  int nDiag;
  int count;
  
  /** Initialize your data structure here. */
  public TicTacToe(int n) {
      rows = new int[n];
      cols = new int[n];
      pDiag = 0;
      nDiag = 0;
      count = n;
  }
  
  /** Player {player} makes a move at ({row}, {col}).
      @param row The row of the board.
      @param col The column of the board.
      @param player The player, can be either 1 or 2.
      @return The current winning condition, can be either:
              0: No one wins.
              1: Player 1 wins.
              2: Player 2 wins. */
  public int move(int row, int col, int player) {
      // A move is guaranteed to be valid and is placed on an empty block.
      // So we do not need to judge move is vallid or not.
      rows[row] = (player == 1) ? rows[row] + 1 : rows[row] - 1;
      cols[col] = (player == 1) ? cols[col] + 1 : cols[col] - 1;
      
      if (row - col == 0) {
          pDiag = (player == 1) ? pDiag + 1: pDiag - 1;
      }
      
      if (row + col == (count - 1)) {
          nDiag = (player == 1) ? nDiag + 1: nDiag - 1;
      }
      
      
      
      if (player == 1 && (pDiag == count || nDiag == count)) {
          return 1;
      }
      
      if (player == 1) {
          for (int i = 0; i < count; i++) {
              if (rows[i] == count || cols[col] == count) { return 1; }
          }
      }
      
      if (player == 2 && (pDiag == -count || nDiag == -count)) {
          return 2;
      }
      
      if (player == 2) {
          for (int i = 0; i < count; i++) {
              if (rows[i] == -count || cols[col] == -count) { return 2; }
          }
      }
      
      return 0;
  }
}

/**
* Your TicTacToe object will be instantiated and called as such:
* TicTacToe obj = new TicTacToe(n);
* int param_1 = obj.move(row,col,player);
*/