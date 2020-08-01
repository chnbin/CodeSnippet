class Solution {
  public String strWithout3a3b(int A, int B) {
      /*
          把字元與頻率放入優先對列，根據頻率大到小排序。
          每次都把兩個字元取出，如果兩者頻率都一樣，那就每種字元都放一個。
          如果不同，則把頻率大的放兩個，小的放一個。
      */
      StringBuilder sb = new StringBuilder();
      
      // 頻率高的放前面
      PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
          return p2.cnt - p1.cnt;
      });
      
      pq.offer(new Pair(A, 'a'));
      pq.offer(new Pair(B, 'b'));
      
      while(!pq.isEmpty()) {
          if (pq.size() == 1) {
              Pair x = pq.poll();
              
              if (x.cnt > 2) {
                  return "";
              } else {
                  for (int i = 0; i < x.cnt; i++) {
                      sb.append(x.c);
                  }
                  return sb.toString();
              }
          }
          
          
          Pair x = pq.poll();
          Pair y = pq.poll();
          
          int k = Math.min(1 + x.cnt - y.cnt, 2);
          
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
  int cnt;
  char c;
  public Pair(int cnt, char c) {
      this.cnt = cnt;
      this.c = c;
  }
}
