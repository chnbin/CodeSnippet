class Solution {
  public String tictactoe(int[][] moves) {
      int[] rows = new int[3];
      int[] cols = new int[3];
      int pDiag = 0;
      int nDiag = 0;
      
      for (int i = 0; i < moves.length; i++) {
          int row = moves[i][0];
          int col = moves[i][1];
          boolean isA = (i % 2 == 0) ? true: false;
          
          if (row - col == 0) {
              pDiag = (isA) ? pDiag + 1: pDiag - 1;
          }
          
          if (row + col == 2) {
              nDiag = (isA) ? nDiag + 1: nDiag - 1;
          }
          
          if (isA) {
              rows[row] += 1;
              cols[col] += 1;
          } else {
              rows[row] -= 1;
              cols[col] -= 1;
          }
          
          if (isA &&
              (rows[row] == 3 || cols[col] == 3 || pDiag == 3 || nDiag == 3)) {
              return "A";
          }
          
          if (!isA &&
              (rows[row] == -3 || cols[col] == -3 || pDiag == -3 || nDiag == -3)) {
              return "B";
          }
          
          if (i == 8) { return "Draw"; }
      }
      
      return "Pending";
  }
}