class Solution {
  public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
      
      Map<String, Integer> map = new TreeMap<>();
      Queue<Integer> q = new LinkedList<>();
      boolean[] visited = new boolean[friends.length];
      
      q.offer(id);
      visited[id] = true;
      int step = 0;
      
      while (!q.isEmpty()) {
          int size = q.size();
          step++;
          
          for (int i = 0; i < size; i++) {
              int currId = q.poll();
              // System.out.println(currId);
              for (int j = 0; j < friends[currId].length; j++) {
                  int friend = friends[currId][j];
                  if (visited[friend]) { continue; }
                  q.offer(friend);
                  visited[friend] = true;
                  if (step == level) {
                      for (int k = 0; k < watchedVideos.get(friend).size(); k++) {
                          String video = watchedVideos.get(friend).get(k);
                          // System.out.println(video);
                          map.put(video, map.getOrDefault(video, 0) + 1);
                      }
                  }
              }
          }
      }
      
      List<String> res = new ArrayList<>(map.keySet());
      Collections.sort(res, (String a, String b) -> {
          int freqA = map.get(a);
          int freqB = map.get(b);

          if (freqA == freqB) {
              a.compareTo(b);
          }
          return freqA - freqB;
      });
      
      return res;
  }
}