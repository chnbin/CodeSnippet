class Solution {
  public List<Integer> largestDivisibleSubset(int[] nums) {
      if (nums == null || nums.length == 0) {
          return new ArrayList<Integer>();    
      }
      
      int n = nums.length;
      int[] dp = new int[n]; // 結束於nums[i]的最大子集合數
      Arrays.fill(dp, 1); // Every element can be divied by itself
      int[] prev = new int[n];
      Arrays.fill(prev, -1);
      Arrays.sort(nums);
      
      // 很像ＬＩＳ
      // 用1, 2, 3, 4, 6 ,9 ,36 來想
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < i; j++) {
              if (nums[i] % nums[j] == 0) {
                  dp[i] = Math.max(dp[i], dp[j] + 1);
                  
                  // 如果有更新答案
                  if (dp[i] == dp[j] + 1) {
                      prev[i] = j;
                  }
              }
          }
      }
      
      int idx = 0;
      int len = 0;
      for (int i = 0; i < n; i++) {
          if (dp[i] > len) {
              len = Math.max(len, dp[i]);
              idx = i;
          }
          
      }
      List<Integer> res = new ArrayList<>();
      
      while (idx != -1) {
          res.add(0, nums[idx]);
          idx = prev[idx];
      }
      //System.out.print("" + res);
      
      return res;
  }
}
