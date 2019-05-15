class Solution {
  public int distinctSubseqII(String s) {
      int[] dp = new int[s.length()];
      for(int i = 0; i < s.length(); ++i) {
          dp[i] = 1;
          for(int j = 0; j < i; ++j) {
              if(s.charAt(i) != s.charAt(j)) {
                  dp[i] += dp[j];    
                  dp[i] %= 1_000_000_007;
              }                
          }
      }
      int sum = 0;
      for(int i = 0;i < dp.length; ++i) {
          sum += dp[i];
          sum %= 1_000_000_007;
      }
      return sum;
  }
}