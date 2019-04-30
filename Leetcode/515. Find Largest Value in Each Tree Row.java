import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<Integer> largestValues(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      if (root == null) { return res; }
      LinkedList<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      
      while (!queue.isEmpty()) {
          int size = queue.size();
          int maxValue = Integer.MIN_VALUE;
          
          for (int i = 0; i < size; i++) {
              TreeNode node = queue.poll();
              maxValue = Math.max(maxValue, node.val);
              if (node.left != null) { queue.offer(node.left); }
              if (node.right != null) { queue.offer(node.right); }
          }
          res.add(maxValue);
      }
      
      return res;
  }
}