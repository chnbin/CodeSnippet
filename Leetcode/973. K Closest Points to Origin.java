import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  public int[][] kClosest(int[][] points, int K) {
      int[][] res = new int[K][2];
      int pos = 0;
      PriorityQueue<Point> minHeap = new PriorityQueue<Point>(
        new Comparator<Point>() {
          public int compare(Point a, Point b) {
              return a.dist - b.dist;
          }
        }
      );
      
      for (int[] point: points) {
          minHeap.offer(new Point(point[0], point[1]));
      }
      
      while (K > 0) {
          Point p = minHeap.poll();
          res[pos] = new int[]{p.x, p.y};
          pos++;
          K--;
      }
      return res;
  }
}

class Point {
  int x;
  int y;
  int dist; // Distance from (0, 0)
  Point(int x, int y) {
      this.x = x;
      this.y = y;
      this.dist = x*x + y*y;
  }
}