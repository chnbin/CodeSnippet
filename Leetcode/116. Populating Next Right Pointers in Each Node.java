import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public Node connect(Node root) {
      if (root == null) { return null; }
      Queue<Node> queue = new LinkedList<>();
      queue.offer(root);
      
      while (!queue.isEmpty()) {
          int size = queue.size();
          for(int i = 0; i < size; i++) {
              Node node = queue.poll();
              node.next = (i == size - 1) ? null : queue.peek();
              if (node.left != null) {
                  queue.offer(node.left);
              }
              if (node.right != null) {
                  queue.offer(node.right);
              }
          }
      }
      return root;
  }
}