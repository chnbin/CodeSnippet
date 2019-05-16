import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
      List<List<Integer>> res = new LinkedList<List<Integer>>();
      if (root == null) { return res; }
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      queue.offer(root);
      
      while (!queue.isEmpty()) {
          int size = queue.size();
          List<Integer> level = new ArrayList<Integer>();
          
          for (int i = 0; i < size; i++) {
              TreeNode node = queue.poll();
              level.add(node.val);
              if (node.left != null) { queue.offer(node.left); }
              if (node.right != null) { queue.offer(node.right); }
          }
          res.add(0, level);
      }
      
      return res;
  }
}