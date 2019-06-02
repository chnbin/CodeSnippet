import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean confusingNumber(int N) {
      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, 0);
      map.put(1, 1);
      map.put(6, 9);
      map.put(8, 8);
      map.put(9, 6);
      int newN = 0;
      int oldN = N;
      while (N > 0) {
          int digit = N % 10;
          
          if (!map.containsKey(digit)) {
              return false;
          }
          
          newN = newN * 10 + map.get(digit);
          N /= 10;
      }
      
      return (newN != oldN) ? true : false;
  }
}