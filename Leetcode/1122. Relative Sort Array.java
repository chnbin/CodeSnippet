import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
      Map<Integer, Integer> map = new HashMap<>();
      
      for (int num: arr1) {
          if (!map.containsKey(num)) {
              map.put(num, 0);
          }
          map.put(num, map.get(num) + 1);
      }
      // System.out.println(map.toString());
      int[] res = new int[arr1.length];
      int pos = 0;

      for (int i = 0; i < arr2.length; i++) {
          while (map.get(arr2[i]) != 0) {
              res[pos++] = arr2[i];
              map.put(arr2[i], map.get(arr2[i])-1);
          }    
      }
      
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      for (int k: map.keySet()) {
          while (map.get(k) != 0) {
              pq.offer(k);
              map.put(k, map.get(k)-1);
          }
      }
      
      while (!pq.isEmpty()) {
          res[pos++] = pq.poll();
      }
      return res;
  }
}