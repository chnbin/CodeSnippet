class Solution {
  public int mincostTickets(int[] days, int[] costs) {
      boolean[] isTravel = new boolean[366];
      int maxDay = 0;
      
      for (int i = 0; i < days.length; i++) {
          isTravel[days[i]] = true;
          maxDay = days[i];
      }
      
      int[] dp = new int[maxDay + 1];
      
      for (int i = 1; i <= maxDay; i++) {
          if (isTravel[i]) {
              int day7 = (i - 7 >= 0) ? i - 7 : 0;
              int day30 = (i - 30 >= 0) ? i - 30 : 0;
          
              dp[i] = Math.min(dp[i-1] + costs[0], Math.min(dp[day7] + costs[1], dp[day30] + costs[2]));
          } else {
              dp[i] = dp[i-1];
          }
      }
      
      return dp[maxDay];
  }
}