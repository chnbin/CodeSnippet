class Solution {
  public List<String> topKFrequent(String[] words, int k) {
      List<String> res = new ArrayList<>();
      // Key 是字串， value是頻率
      Map<String, Integer> map = new HashMap<>();
      
      PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
      (m1, m2) -> {
          // 如果2個字串頻率是相等的，回傳字母順序大的
          if (m1.getValue() == m2.getValue()) {
              return m2.getKey().compareTo(m1.getKey());
          } else {
              // 否則回傳頻率小的
              return m1.getValue() - m2.getValue();
          }
      });
      
      // 建造字串對頻率
      for (String word: words) {
          map.put(word, map.getOrDefault(word, 0) + 1);
      }
      
      // 放到pq中
      for (Map.Entry<String, Integer> m: map.entrySet()) {
          pq.offer(m);
          
          // 因為只關心k個，所以變成k+1個時我們就丟掉一個，被丟掉這個是
          // 頻率最小的，或是頻率相同但是字母順序大的，故不影響答案
          if (pq.size() > k) { pq.poll(); }
      }
      
      // 取k個
      while (!pq.isEmpty()) {
          res.add(0, pq.poll().getKey());
      }
      return res;
  }
}