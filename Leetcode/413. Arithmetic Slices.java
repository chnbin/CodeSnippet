class Solution {
  public int numberOfArithmeticSlices(int[] A) {
      // dp[i] is the count of arithmetic slices of i.
      int[] dp = new int[A.length];
      int res = 0;
      
      for (int i = 2; i < A.length; i++) {
          if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
              dp[i] = dp[i-1] + 1;
          }
      }
      
      for (int num: dp) {
          res += num;
      }
      return res;
  }
}