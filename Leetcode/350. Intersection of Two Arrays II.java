import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
      Map<Integer, Integer> map = new HashMap<>();
      List<Integer> res = new List<>();

      for (int num: nums1) {
          if (!map.containsKey(num)) {
              map.put(num, 0);
          }
          map.put(num, map.get(num) + 1);
      }
      
      for (int num: nums2) {
          if (!map.containsKey(num)) { continue; }
          if (map.get(num) > 0) {
              res.add(num);
              map.put(num, map.get(num) - 1);
          }
      }
      
      int[] ans = new int[res.size()];
      
      for (int i = 0; i < res.size(); i++) {
          ans[i] = res.get(i);
      }
      return ans;
  }
}