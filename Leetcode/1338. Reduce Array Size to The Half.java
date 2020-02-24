class Solution {
  public int minSetSize(int[] arr) {
      int res = 0;
      int n = arr.length;
      
      // Key is num, value is frequence.
      Map<Integer, Integer> map = new HashMap<>();
      
      
      // Max Heap
      PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) ->{
          return b.getValue() - a.getValue();
      });
      
      for (int num: arr) {
          map.put(num, map.getOrDefault(num, 0) + 1);
      }
      
      pq.addAll(map.entrySet());
      
      int cnt = 0;
      while (pq.size() != 0) {
          cnt += pq.poll().getValue();
          res++;
          if (cnt >= (n / 2)) {
              return res;
          }
      }
      
      return res;
  }
}