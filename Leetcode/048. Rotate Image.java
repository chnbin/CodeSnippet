class Solution {
  public void rotate(int[][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
          return;
      }
      
      int start = 0;
      int end = matrix.length - 1;
      int n = matrix.length;
      
      // Reserve rows.
      while (start < end) {
          int[] tmpRow = matrix[start];
          matrix[start] = matrix[end];
          matrix[end] = tmpRow;
          start++;
          end--;
      }
      
      for (int i = 0; i < n; i++) {
          for (int j = i + 1; j < n; j++) {
              int tmp = matrix[i][j];
              matrix[i][j] = matrix[j][i];
              matrix[j][i] =tmp;
          }
      }
  }
}