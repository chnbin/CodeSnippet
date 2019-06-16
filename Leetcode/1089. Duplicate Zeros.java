import java.util.HashMap;
import java.util.Map;

class Solution {
  public void duplicateZeros(int[] arr) {
      if (arr.length == 1) { return; }
      int len = arr.length;
      int diff = 0;
      Map<Integer, Integer> map = new HashMap<>();
      
      for (int i = 0; i < len; i++) {
          if (arr[i] == 0) {
              map.put(i + diff, arr[i]);
              map.put(i + diff + 1, 0);
              diff++;
          } else {
              map.put(i + diff, arr[i]);
          }
      }
      
      for (int i = 0; i < len; i++) {
          arr[i] = map.get(i);
      }
  }
}