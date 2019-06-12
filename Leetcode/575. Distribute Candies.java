import java.util.HashMap;
import java.util.Map;

class Solution {
  public int distributeCandies(int[] candies) {
      int limit = candies.length/2;
      int res = 0;
      Map<Integer, Integer> map = new HashMap<>();
      
      for (int candy: candies) {
          map.put(candy, map.getOrDefault(candy, 0) + 1);
      }
      
      for (int key: map.keySet()) {
          if (limit > 0) {
              map.put(key, map.get(key) - 1);
              res++;
              limit--;
          }
      }
      return res;
  }
}