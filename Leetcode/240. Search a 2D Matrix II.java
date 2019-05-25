class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
          return false;
      }
      int m = matrix.length, n = matrix[0].length;
      int row = 0, col = n - 1;
      
      while (row < m && col >= 0) {
          int num = matrix[row][col];
          
          if (num == target) {
              return true;
          } else if (num > target) {
              col--;
          } else {
              row++;
          }
      }
      return false;
  }
}