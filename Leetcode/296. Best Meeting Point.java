import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public int minTotalDistance(int[][] grid) {
      List<Integer> rows = new LinkedList<>();
      List<Integer> cols = new LinkedList<>();
      
      for (int i = 0; i < grid.length; i++) {
          for (int j = 0; j < grid[0].length; j++) {
              if (grid[i][j] == 1) {
                  rows.add(i);
                  cols.add(j);
              }
          }
      }
      
      return minDistance(rows) + minDistance(cols);
  }
  
  private int minDistance(List<Integer> list) {
      int res = 0;
      Collections.sort(list);
      int left = 0;
      int right = list.size() - 1;
      
      while (left < right) {
          res += (list.get(right) - list.get(left));
          right--;
          left++;
      }
      return res;
  }
}