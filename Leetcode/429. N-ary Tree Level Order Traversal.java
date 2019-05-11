import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public List<List<Integer>> levelOrder(Node root) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      if (root == null) { return res; }
      Queue<Node> queue = new LinkedList<Node>();
      queue.offer(root);
      
      while (!queue.isEmpty()) {
          int size = queue.size();
          System.out.println(size);
          List<Integer> level = new ArrayList<Integer>();
          
          for (int i = 0; i < size; i++) {
              Node node = queue.poll();
              level.add(node.val);
              for (Node n: node.children) {
                  if (n != null) {
                      queue.offer(n);
                  }
              }
          }
          res.add(level);
      }
      return res;
  }
}