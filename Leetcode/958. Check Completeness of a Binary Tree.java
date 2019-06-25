import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public boolean isCompleteTree(TreeNode root) {
      if (root == null) { return false; }
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      boolean isNullAppear = false;
      
      while (!queue.isEmpty()) {
          TreeNode node = queue.poll();
          
          if (node == null) {
                  isNullAppear = true;
          } else if (isNullAppear) {
              return false;
          } else {
              queue.offer(node.left);
              queue.offer(node.right);
          }
      }
      
      return true;
  }
}