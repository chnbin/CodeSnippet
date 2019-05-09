class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
          return false;
      }
      int col = matrix[0].length;
      int l = 0;
      int r = (matrix.length) * (matrix[0].length) - 1;
      
      while (l <= r) {
          int m = (l + r) >> 1;
          
          if (matrix[m / col][m % col] == target) {
              return true;
          } else if (matrix[m / col][m % col] < target) {
              l = m + 1;
          } else {
              r = m - 1;
          }
      }
      
      return false;
  }
}