class Solution { 
  public List<List<String>> solveNQueens(int n) {
      List<List<String>> res = new ArrayList<>();
      int[] queens = new int[n];
      
      findNQueen(queens, 0, n, res);
      return res;
  }
  
  private void findNQueen(int[] queens, int row, int n, List<List<String>> res) {
      if (row == n) {
          ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < n; i++) {
      String str = "";
      for (int col = 0; col < n; col++) {
        if (queens[i] == col) {
          str += "Q";
        } else {
          str += ".";
        }
      }
      list.add(str);
    }
    res.add(list);
      }
      
      for (int col = 0; col < n; col++) {
          if (valid(queens, row, col)) {
              queens[row] = col;
              findNQueen(queens, row + 1, n, res);
          }
      }
  }
  
  private boolean valid(int[] queens, int row, int col) {
      for (int i = 0; i < row; i++) {
          int pos = queens[i];
          
          if (pos == col) { return false; } 
          
          if (i + pos == row + col) { return false; }
          
          if (i - pos == row - col) { return false; }
      }
      return true;
  }
}