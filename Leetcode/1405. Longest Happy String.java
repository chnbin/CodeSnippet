class Solution {
  public String longestDiverseString(int a, int b, int c) {
      StringBuilder sb = new StringBuilder();
      
      PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
          return p2.cnt - p1.cnt;
      });
      
      if (a > 0) { pq.offer(new Pair('a', a));}
      if (b > 0) { pq.offer(new Pair('b', b));}
      if (c > 0) { pq.offer(new Pair('c', c));}
      
      while (!pq.isEmpty()) {
          if (pq.size() == 1) {
              Pair x = pq.poll();
              int cnt = 2;
              if (x.cnt < 2) {
                  cnt = x.cnt;
              }
              
              for (int i = 0; i < cnt; i++) {
                  sb.append(x.c);
              }
              return sb.toString();
          }
          
          
          Pair x = pq.poll();
          Pair y = pq.poll();
          
          int k = Math.min(2, x.cnt - y.cnt + 1);
          
          for (int i = 0; i < k; i++) {
              sb.append(x.c);
          }
          
          sb.append(y.c);
          
          x.cnt -= k;
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
