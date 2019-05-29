import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {
      List<Integer> res = new ArrayList<>();
      Map<Integer, Integer> map = new HashMap<>();
      
      for (int num: nums) {
          if (!map.containsKey(num)) {
              map.put(num, 0);
          }
          map.put(num, map.get(num)+1);
      }
      
      PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((a,b)->(b.getValue()-a.getValue()));

      for (Map.Entry pairs: map.entrySet()) {
          maxHeap.offer(pairs);
      }
      
      for (int i = 0; i < k; i++) {
          res.add(maxHeap.poll().getKey());
      }
      return res;
  }
}