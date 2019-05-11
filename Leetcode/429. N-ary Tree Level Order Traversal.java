import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  // Using BFS beats 5.75%
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
  // Using DFS beats 100%
  public List<List<Integer>> levelOrder2(Node root) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (root == null) { return res; }
    helper(root, 1, res);
    return res;
  }
  private void helper(Node node, int level, List<List<Integer>> res) {
      if (node == null) { return; }
      if (res.size() < level) {
          res.add(new ArrayList<Integer>());
      }
      res.get(level - 1).add(node.val);
      for (Node n: node.children) {
          if (n != null) { helper(n, level + 1, res); }
      }
  }
}