class Solution {
  private int count = 0;
  
  public int totalNQueens(int n) {
      int[] queens = new int[n];
      findNQueens(queens, 0, n);
      return count;
  }
  
  private void findNQueens(int[] queens, int row, int n) {
      if (row == n) {
          count++;
          return;
      }
      
      for (int col = 0; col < n; col++) {
          if (isVaild(queens, row, col)) {
              queens[row] = col;
              findNQueens(queens, row + 1, n);
          }
      }
  }
  
  private boolean isVaild(int[] queens, int row, int col) {
      for (int i = 0; i < row; i++) {
          // 紀錄row
          int pos = queens[i];
          
          // 新加入的row和之前的pos有重複
          if (pos == col) {
              return false;
          }
          
          // 新加入的row, col和之前的反對角線相等
          if ((i - pos) == (row - col)) {
              return false;
          }
          
          // 新加入的row, col和之前的反對角線相等
          if ((i + pos) == (row + col)) {
              return false;
          }
      }
      return true;
  }
}