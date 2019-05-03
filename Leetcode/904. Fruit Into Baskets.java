import java.util.HashMap;
import java.util.Map;

class Solution {
  public int totalFruit(int[] tree) {
      int start = 0;
      int end = 0;
      int maxLen = 0;
      int counter = 0;

      Map<Integer, Integer> map = new HashMap<>();
      
      for (int num: tree) {
          if (!map.containsKey(num)) {
              map.put(num, 0);
          }
      }
      
      while (end < tree.length) {
          map.put(tree[end], map.get(tree[end])+1);
          if (map.get(tree[end]) == 1) {
              counter++;
          }
          
          while (counter > 2) {
              maxLen = Math.max(maxLen, end - start);
              map.put(tree[start], map.get(tree[start])-1);
              if (map.get(tree[start]) == 0) {
                  counter--;
              }
              start++;
          }
          end++;
      }
      maxLen = Math.max(maxLen, end - start);
      return maxLen;
  }
}