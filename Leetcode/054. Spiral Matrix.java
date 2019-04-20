class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> ans = new ArrayList<Integer>();
      
      if (matrix == null || matrix.length == 0) { return ans; }
      
      int rowStart = 0;
      int rowEnd = matrix.length - 1;
      int colStart = 0;
      int colEnd = matrix[0].length - 1;
      
      while (rowStart <= rowEnd && colStart <= colEnd) {
          // To right
          for (int i = colStart; i <= colEnd; i++) {
              ans.add(matrix[rowStart][i]);
          }
          rowStart++;
          
          // To down
          for (int i = rowStart; i <= rowEnd; i++) {
              ans.add(matrix[i][colEnd]);
          }
          colEnd--;
          
          if (rowStart <= rowEnd) {
              // To left
              for (int i = colEnd; i >= colStart; i--) {
                  ans.add(matrix[rowEnd][i]);
              }                
          }
          rowEnd--;

          if (colStart <= colEnd) {
              // To up
              for (int i = rowEnd; i >= rowStart; i--) {
                  ans.add(matrix[i][colStart]);
              } 
          }

          colStart++;
      }
      return ans;
  }
}