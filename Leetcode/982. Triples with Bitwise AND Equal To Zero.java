import java.util.HashMap;
import java.util.Map;

class Solution {
  public int countTriplets(int[] A) {
      Map<Integer, Integer> map = new HashMap<>();
      int res = 0;
      
      for (int x: A) {
          for (int y: A) {
              int value = x & y;
              map.put(value, map.getOrDefault(value, 0) + 1);
          }
      }
      
      for (int x: A) {
          for (int y: map.keySet()) {
              if ((x & y) == 0) {
                  res += map.get(y);
              }
          }
      }
      return res;
  }
}