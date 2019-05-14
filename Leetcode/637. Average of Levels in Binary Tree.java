import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public List<Double> averageOfLevels(TreeNode root) {
      if (root == null) { return null; }
      List<Double> res = new ArrayList<>();
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      
      while (!queue.isEmpty()) {
          double size = queue.size();
          double sum = 0.0;
          double count = 0.0;
          for (int i = 0; i < size; i++) {
              TreeNode node = queue.poll();
              if (node != null) {
                  count += 1.0;
                  sum += node.val;
              }
              if (node.left != null) { queue.offer(node.left); }
              if (node.right != null ) { queue.offer(node.right); }
          }
          res.add(sum/count);
      }
      return res;
  }
}