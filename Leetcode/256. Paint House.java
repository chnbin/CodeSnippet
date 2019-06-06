class Solution {
  public int minCost(int[][] costs) {
      if (costs == null || costs.length == 0 || costs[0].length == 0) {
          return 0;
      }
      int len = costs.length;
      if (len == 1) { return findMinFromArray(costs[0]); }
      
      for (int i = 1; i < len; i++) {
          costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
          costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
          costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
      }
      
      return findMinFromArray(costs[len-1]);
  }
  
  private int findMinFromArray(int[] nums) {
      int min = Integer.MAX_VALUE;
      for (int num: nums) {
          min = Math.min(min, num);
      }
      
      return min;
  }
}