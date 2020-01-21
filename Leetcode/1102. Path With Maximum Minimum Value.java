class Solution {
  private int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  public int maximumMinimumPath(int[][] A) {
      int res = Integer.MAX_VALUE;
      boolean[][] visited = new boolean[A.length][A[0].length];
      PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
          return n2.cost - n1.cost;
      });
      
      pq.offer(new Node(0, 0, A[0][0]));
      
      while (!pq.isEmpty()) {
          Node node = pq.poll();
          int x = node.x;
          int y = node.y;
          res = Math.min(res, A[x][y]);
          visited[x][y] = true;
          if (x == A.length - 1 && y == A[0].length - 1) {
              return res;
          }
          
          for (int[] dir: DIRS) {
              int dx = x + dir[0];
              int dy = y + dir[1];
              
              if (dx >= 0 && dx < A.length && dy >= 0 && dy < A[0].length && !visited[dx][dy]) {
                  pq.offer(new Node(dx, dy, A[dx][dy]));
              }
          }
      }
      
      return res;
  }
}

class Node {
  public int x;
  public int y;
  public int cost;
  public Node(int x, int y, int cost) {
      this.x = x;
      this.y = y;
      this.cost = cost;
  }
}