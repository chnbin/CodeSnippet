import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
      if (s == null || s.length() == 0) { return false; }
      boolean[] dp = new boolean[s.length() + 1];
      dp[0] = true;
      Map<String, Integer> map = new HashMap<>();
      
      for (String word: wordDict) {
          map.put(word, 1);
      }
      for (int i = 1 ; i < dp.length; i++) {
          for (int j = 0; j < i; j++) {
              if (dp[j] && map.containsKey(s.substring(j, i))) {
                  dp[i] = true;
              }
          }
      }
      return dp[dp.length-1];
  }
}