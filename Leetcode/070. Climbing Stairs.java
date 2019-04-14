class Solution {
  public int climbStairs(int n) {
      if (n < 0) {return 0; }
      if (n == 1) { return 1; }
      if (n == 2) { return 2; }
      int first = 1;
      int second = 2;
      int allStep = 0;

      for (int i = 2; i < n; i++) {
          allStep = first + second;
          first = second;
          second = allStep;
      }
      
      return allStep;
  }
}