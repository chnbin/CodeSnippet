class Solution {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
      PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> {
          if (a.dist == b.dist) {
              return a.pos - b.pos;
          }
          
          return a.dist - b.dist;
      });
      
      for (int num: arr) {
          pq.offer(new Element(num, Math.abs(num - x)));
      }
      
      List<Integer> res = new ArrayList<>();
      
      while (k > 0) {
          res.add(0, pq.poll().pos);
          k--;
      }
      
      Collections.sort(res);
      
      return res;
  }
}

class Element {
  public int pos;
  public int dist;
  public Element(int pos, int dist) {
      this.pos = pos;
      this.dist = dist;
  }
}