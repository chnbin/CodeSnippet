class Solution {
  public List<Integer> luckyNumbers (int[][] matrix) {
      List<Integer> res = new ArrayList<>();
      Set<Integer> rowMin = new HashSet<>();
      int m = matrix.length;
      int n = matrix[0].length;
      
      // Find minimal value of each row
      for (int i = 0; i < m; i++) {
          int minimal = Integer.MAX_VALUE;
          
          for (int j = 0; j < n; j++) {
              minimal = Math.min(minimal, matrix[i][j]);
          }
          
          rowMin.add(minimal);
      }
      
      // Find maximal value of each column and see if the maximal value is also the minimum value of row.
      for (int i = 0; i < n; i++) {
          int maximal = Integer.MIN_VALUE;
          
          for (int j = 0; j < m; j++) {
              maximal = Math.max(maximal, matrix[j][i]);
          }
          
          if (rowMin.contains(maximal)) {
              res.add(maximal);
          }
      }
      
      return res;
  }
}
