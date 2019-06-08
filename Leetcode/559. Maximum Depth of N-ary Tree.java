import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int maxDepth(Node root) {
      if (root == null) { return 0; }
      int res = 0;
      
      Queue<Node> queue = new LinkedList<>();
      queue.offer(root);
      
      while (!queue.isEmpty()) {
          int size = queue.size();
          
          for (int i = 0; i < size; i++) {
              Node node = queue.poll();
              for (Node child: node.children) {
                  queue.offer(child);
              }
          }
          res++;
      }
      return res;
  }
}