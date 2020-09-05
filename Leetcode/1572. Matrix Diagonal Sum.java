class Solution {
  public int diagonalSum(int[][] mat) {
      int res = 0;
      int overlap = 0;
      int n = mat.length;
      if ((n % 2) == 1) { overlap = mat[n/2][n/2]; }
      
      int i = 0;
      int j = 0;
      
      while (i < n && j < n) {
          res += mat[i][j];
          res += mat[i][n - 1 - i];
          i++;
          j++;
      }
      
      
      return res - overlap;
  }
}
