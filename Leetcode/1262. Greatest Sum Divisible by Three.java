class Solution {
  public int maxSumDivThree(int[] nums) {
      // dp[i] = 最大和除三時的餘
      // dp[i] = The Greatest Sum has remainder i when mod by 3
      // dp[(num + i) % 3] = Max(dp[(num + i) % 3], dp[i] + num)
      int[] dp = new int[3];
      
      for (int num: nums) {
          int[] tmp = dp.clone();
          for (int s: tmp) {
              dp[(s + num) % 3] = Math.max(dp[(s + num) % 3], s + num);
          }
      }
      return dp[0];
  }
}