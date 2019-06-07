class Solution {
  public void setZeroes(int[][] matrix) {
      if (matrix == null || matrix[0].length == 0) {
          return ;
      }
      int m = matrix.length;
      int n = matrix[0].length;
      int row0 = matrix[0][0];
      int col0 = matrix[0][0];
      
      // Check row0
      for (int c = 0; c < n; c++) {
          if (matrix[0][c] == 0) {
              row0 = 0;
              break;
          }
      }
      
      for (int r = 0; r < m; r++) {
          if (matrix[r][0] == 0) {
              col0 = 0;
              break;
          }
      }
      
      for (int r = 1; r < m; r++) {
          for (int c = 1; c < n; c++) {
              if (matrix[r][c] == 0) {
                  matrix[r][0] = 0;
                  matrix[0][c] = 0;
              }
          }
      }
      
      for (int c = 1; c < n; c++) {
          if (matrix[0][c] == 0) {
              for (int r = 1; r < m;r++) {
                  matrix[r][c] = 0;
              }
          }
      }
      
      for (int r = 1; r < m; r++) {
          if (matrix[r][0] == 0) {
              for (int c = 1; c < n; c++) {
                  matrix[r][c] = 0;
              }
          }
      }
      
      if (row0 == 0) {
          matrix[0][0] = 0;
          for (int c = 0; c < n; c++) {
              matrix[0][c] = 0;
          }
      }
      
      if (col0 == 0) {
          matrix[0][0] = 0;
          for (int r = 0; r < m; r++) {
              matrix[r][0] = 0;
          }
      }
  }
}