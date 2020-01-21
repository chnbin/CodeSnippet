class Solution {
  public int minimumCost(int N, int[][] connections) {
      int sum = 0;
      
      PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
          return n1.cost - n2.cost;
      });
      
      int[] group = new int[N + 1];
      
      for (int i = 0; i <= N; i++) {
          group[i] = i;
      }
      
      for (int[] conn: connections) {
          pq.offer(new Node(conn[0], conn[1], conn[2]));
      }
      
      while (!pq.isEmpty()) {
          Node node = pq.poll();
          int v1 = node.from;
          int v2 = node.to;
          int pId = group[v1];
          int qId = group[v2];
          
          if (pId == qId) {
              // 
          } else {
              sum += node.cost;
              
              for (int i = 1; i < group.length; i++) {
                  if (group[i] == pId) {
                      group[i] = qId;
                  }
              }
          }
      }
      
      for (int i = 2; i < group.length; i++) {
          if (group[i] != group[i-1]) { return -1; }
      }
      
      return sum;
  }
}

class Node {
  int from;
  int to;
  int cost;
  public Node(int from, int to, int cost) {
      this.from = from;
      this.to = to;
      this.cost = cost;
  }
}