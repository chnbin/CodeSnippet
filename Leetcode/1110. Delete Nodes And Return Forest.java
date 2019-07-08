import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
      List<TreeNode> res = new LinkedList<>();
      Queue<TreeNode> queue = new LinkedList<>();
      res.add(root);
      queue.offer(root);
      Set<Integer> set = new HashSet<>();
      
      for (int num: to_delete) { set.add(num); }
      
      while (!queue.isEmpty()) {
          TreeNode node = queue.poll();
          if (set.contains(node.val)) {
              res.remove(node);
              if (node.left != null) { res.add(node.left); }
              if (node.right != null) { res.add(node.right); }
          }
          
          if (node.left != null) {
              queue.offer(node.left);
              if (set.contains(node.left.val)) {
                  node.left = null;
              }
          }
          
          if (node.right != null) {
              queue.offer(node.right);
              if (set.contains(node.right.val)) {
                  node.right = null;
              }
          } 
      }
      return res;
  }
}