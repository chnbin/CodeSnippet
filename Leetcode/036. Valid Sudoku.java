import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean isValidSudoku(char[][] board) {
      
      for (int i = 0; i < 9; i++) {
          Set<Character> rowSet = new HashSet<>();
          Set<Character> colSet = new HashSet<>();
          Set<Character> blockSet = new HashSet<>();
          
          for (int j = 0; j < 9; j++) {
              // Check row
              if ((board[i][j] != '.') && rowSet.contains(board[i][j])) {
                  return false;
              }
              rowSet.add(board[i][j]);
              
              // Check col
              if ((board[j][i] != '.') && colSet.contains(board[j][i])) {
                  return false;
              }
              colSet.add(board[j][i]);
              
              // Check block
              if ((board[i/3*3 + j/3][i%3*3 + j%3] != '.') && blockSet.contains(board[i/3*3 + j/3][i%3*3 + j%3])) {
                  return false;
              }
              blockSet.add(board[i/3*3 + j/3][i%3*3 + j%3]);
          }
      }
      return true;
  }
}