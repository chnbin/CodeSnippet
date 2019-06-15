class Solution {
  public int[] numMovesStones(int a, int b, int c) {
      int[] res = new int[2];
      // Sort a, b, c then x < y < z
      int x = Math.min(Math.min(a, b) ,c); // Min of a,b,c
      int z = Math.max(Math.max(a, b) ,c); // Max of a,b,c
      int y = (a + b + c) - x - z;
      int minStep = 0;
      int maxStep = 0;
      
      // Find min step
      if (x == y - 1 && y == z - 1) {
          minStep = 0;
      } else if (y -x <= 2 || z - y <= 2) {
          minStep = 1;
      } else {
          minStep = 2;
      }
      
      // Find max step
      maxStep = (y - x - 1) + (z - y -1);
      res[0] = minStep;
      res[1] = maxStep;
      return res;
  }
}