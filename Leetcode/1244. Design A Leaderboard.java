class Leaderboard {
  Map<Integer, Integer> map; // map for playerId -> score
  TreeMap<Integer, Integer> sorted; // Sorted map for score -> counts
  
  public Leaderboard() {
      map = new HashMap<>();
      sorted = new TreeMap(Collections.reverseOrder());
  }
  
  // O(long(N))
  public void addScore(int playerId, int score) {
      if (!map.containsKey(playerId)) {
          map.put(playerId, score);
          sorted.put(score, sorted.getOrDefault(score, 0) + 1);
      } else {
          // Player is already existed. So we need to update score.
          int preScore = map.get(playerId);
          sorted.put(preScore, sorted.getOrDefault(preScore, 1) - 1);
          
          if (sorted.get(preScore) == 0) {
              sorted.remove(preScore);
          }
          
          map.put(playerId, preScore + score);
          sorted.put(preScore + score, sorted.getOrDefault(preScore + score, 0) + 1);
      }
  }
  
  // O(Klog(N))
  public int top(int K) {
      int sum = 0;
      int count = 0;
      
      for (int key: sorted.keySet()) {
          int cnt = sorted.get(key);
          
          for (int i = 0; i < cnt; i++) {
              if (K <= 0) {
                  break;
              }
              sum += key;
              K--;
          }
      }
      
      return sum;
  }
  
  // O(long(N))
  public void reset(int playerId) {
      int score = map.get(playerId);

      sorted.put(score, sorted.get(score) - 1);
      if (sorted.get(score) == 0) {
          sorted.remove(score);
      }
      map.remove(playerId);
  }
}

/**
* Your Leaderboard object will be instantiated and called as such:
* Leaderboard obj = new Leaderboard();
* obj.addScore(playerId,score);
* int param_2 = obj.top(K);
* obj.reset(playerId);
*/