import java.util.LinkedList;

class RecentCounter {
  LinkedList<Integer> queue;
  
  public RecentCounter() {
      this.queue = new LinkedList<Integer>();
  }
  
  public int ping(int t) {
      while (queue.size() > 0 && queue.peek() < t) {
          queue.poll();
      }
      queue.offer(t + 3000);
      return queue.size();
  }
}