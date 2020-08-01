class Solution {
  public String reorganizeString(String S) {
      /*
          用984的方法，對於每個出現的字符計數，把他們放到優先隊列，根據頻率由大到小排列。
          每次取兩個最大的出來，各取一個字元加入答案。
      */
      StringBuilder sb = new StringBuilder();
      int[] table = new int[26];
      for (char c: S.toCharArray()) {
          table[c - 'a']++;
      }
      
      PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
          return p2.cnt - p1.cnt;
      });
      
      for (int i = 0; i < 26; i++) {
          if (table[i] > 0) {
              pq.offer(new Pair((char)(i + 'a'), table[i]));
          }
      }
      
      while (!pq.isEmpty()) {
          if (pq.size() == 1) {
              Pair p = pq.poll();
              if (p.cnt > 1) {
                  return "";
              } else {
                  sb.append(p.c);
                  return sb.toString();
              }
          }
          
          Pair x = pq.poll();
          Pair y = pq.poll();
          
          sb.append(x.c);
          sb.append(y.c);
          
          x.cnt -= 1;
          y.cnt -= 1;
          
          if (x.cnt > 0) {
              pq.offer(x);
          }
          
          if (y.cnt > 0) {
              pq.offer(y);
          }
      }
      
      return sb.toString();
  }
}

class Pair {
  char c;
  int cnt;
  public Pair(char c, int cnt) {
      this.c = c;
      this.cnt = cnt;
  }
}
