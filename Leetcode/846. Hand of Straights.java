class Solution {
  public boolean isNStraightHand(int[] hand, int W) {
      int n = hand.length;
      if (n % W != 0) { return false; }
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      
      for (int card: hand) {
          pq.offer(card);
      }
      
      while (!pq.isEmpty()) {
          int currCard = pq.poll();
          
          for (int i = 1; i < W; i++) {
              if (!pq.remove(currCard + i)) {
                 return false; 
              }
          }
      }
      
      return true;
  }
}