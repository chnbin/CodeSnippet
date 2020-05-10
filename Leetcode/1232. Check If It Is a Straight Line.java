class Solution {
  public boolean checkStraightLine(int[][] coordinates) {
      
      if (coordinates.length == 2) { return true; }
      int diffX = coordinates[1][0] - coordinates[0][0];
      int diffY = coordinates[1][1] - coordinates[0][1];
      
      float slope = (diffY == 0) ? Float.MAX_VALUE : (float)(diffX / diffY);
      
      for (int i = 2; i < coordinates.length; i++) {
          int[] currPoint = coordinates[i];
          int[] prePoint = coordinates[i - 1];
          
          int curDiffX = currPoint[0] - prePoint[0];
          int curDiffY = currPoint[1] - prePoint[1];
          
          float currSlope = (curDiffY == 0) ? Float.MAX_VALUE : (float)(curDiffX / curDiffY);
          
          if (slope != currSlope) { return false; }
      }
      
      return true;
  }
}
