import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean hasGroupsSizeX(int[] deck) {
      if (deck == null || deck.length <= 1) {
          return false;
      }
      Map<Integer, Integer> map = new HashMap<>();
      
      for (int card: deck) {
          map.put(card, map.getOrDefault(card, 0) + 1);
      }
      int min = findMinOfMapValues(map);
          
      for (int i = 2; i <= min; i++) {
          boolean isAllModZero = true;
          for (int num: map.values()) {
              if (num%i != 0) {
                  isAllModZero = false;
              }
          }
          
          if (isAllModZero) { return true; }
      }
      return false;
  }
  
  private int findMinOfMapValues(Map<Integer, Integer> map) {
      int res = Integer.MAX_VALUE;
      
      for (int num: map.values()) {
          res = Math.min(res, num);
      }
      
      return res;
  }
}