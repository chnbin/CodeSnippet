/*
  先把所有島染色，相同的島同一種顏色。
  [[1, 0],    
  [0, 1]]]
  變成
  [[2, 0],    
  [0, 3]]]

  [[1, 1],    
  [0, 1]]]
  則變成
  [[2, 2],    
  [0, 2]]]
 */
class Solution {
  private static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  
  public int largestIsland(int[][] grid) {
      if (grid == null || grid.length == 0 || grid[0].length == 0) {
          return 0;
      }
      
      int rows = grid.length;
      int cols = grid[0].length;
      int colors = 2;
      Map<Integer, Integer> map = new HashMap<>();
      
      int[][] dp = new int[rows][cols];
      int res = 0;
      
      // 先把所有島染色，並且把該島面積算出來。之後將顏色做Key，面積為value放入map
      for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
              if (grid[i][j] == 1) {
                  int area = countArea(grid, i, j, colors);
                  map.put(colors, area);
                  res = Math.max(res, area); // For single island likes Exmaple 3.
                  colors++;
              }
          }
      }
      
      // 遇到0就上下左右看一下，把不同顏色的面積加起來
      for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
              if (grid[i][j] == 0) {
                  res = Math.max(res, makingLargeIsland(grid, i, j, map));
              }
          }
      }
      
      return res;
  }
  
  private int countArea(int[][] grid, int r, int c, int color) {
      if (r < 0 || r >= (grid.length) || c < 0 || c >= (grid[0].length) || grid[r][c] != 1) {
          return 0;
      }
      grid[r][c] = color;
      int area = 1;
      area += countArea(grid, r - 1, c, color);
      area += countArea(grid, r + 1, c, color);
      area += countArea(grid, r, c - 1, color);
      area += countArea(grid, r, c + 1, color);
      return area;
  }
  
  private int makingLargeIsland(int[][] grid, int r, int c, Map<Integer, Integer> map) {
      Set<Integer> usedColor = new HashSet<>();
      int area = 1;
      for (int[] direction: DIRECTIONS) {
          int dx = r + direction[0];
          int dy = c + direction[1];
          
          if (0 <= dx && dx < grid.length && 0 <= dy && dy < grid[0].length 
              && grid[dx][dy] != 0
              && !usedColor.contains(grid[dx][dy])) {
              usedColor.add(grid[dx][dy]);
              area += map.get(grid[dx][dy]);
          }
      }
      
      return area;
  }
}