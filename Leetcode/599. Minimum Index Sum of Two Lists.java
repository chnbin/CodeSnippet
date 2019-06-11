import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public String[] findRestaurant(String[] list1, String[] list2) {
      List<String> res = new ArrayList<>();
      Map<String, Integer> map = new HashMap<>();
      Map<String, Integer> map2 = new HashMap<>();
      int minCount = Integer.MAX_VALUE;
      
      for (int i = 0; i < list1.length; i++) {
          map.put(list1[i], i);
      }
      
      for (int i = 0; i < list2.length; i++) {
          if (map.containsKey(list2[i])) {
              int indexSum = map.get(list2[i]) + i;
              map2.put(list2[i], indexSum);
              minCount = Math.min(minCount, indexSum);
          };
      }
      
      for (String key: map2.keySet()) {
          if (map2.get(key) == minCount) {
              res.add(key);
          }
      }
      return res.toArray(new String[res.size()]);
  }
}