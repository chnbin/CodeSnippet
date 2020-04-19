class Solution {
  public int[][] matrixBlockSum(int[][] mat, int K) {
      int m = mat.length;
      int n = mat[0].length;
      int[][] res = new int[m][n];
      
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              int rStart = i - K;
              int rEnd = i + K;
              int cStart = j - K;
              int cEnd = j + K;
              int sum = 0;
              for (int k = rStart; k <= rEnd; k++) {
                  for (int l = cStart; l <= cEnd; l++) {
                      if (k >= 0 && k < m && l >= 0 && l < n) {
                          sum += mat[k][l];
                      }
                  }
              }
              res[i][j] = sum;
          }
      }
      
      return res;
  }
}
