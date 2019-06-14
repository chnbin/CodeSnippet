import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public boolean isCousins(TreeNode root, int x, int y) {
      if (root == null) { return false; }
      Queue<TreeNode> queue = new LinkedList<>();
      TreeNode xParent = new TreeNode(0);
      TreeNode yParent = new TreeNode(0);
      int level = 0;
      int xLevel = -1;
      int yLevel = -1;
      
      queue.offer(root);
      while (!queue.isEmpty()){
          int size = queue.size();
          level++;
          
          for (int i = 0; i < size; i++) {
              TreeNode node = queue.poll();
              if (node.left != null) {
                  if (node.left.val == x) {
                      xParent = node;
                      xLevel = level;
                  }
                  if (node.left.val == y) {
                      yParent = node;
                      yLevel = level;
                  }
                  queue.offer(node.left);
              }
              
              if (node.right != null) {
                  if (node.right.val == x) {
                      xParent = node;
                      xLevel = level;
                  }
                  if (node.right.val == y) {
                      yParent = node;
                      yLevel = level;
                  }
                  queue.offer(node.right);
              }
          }
      }
      
      if (!xParent.equals(yParent) && xLevel == yLevel) {
          return true;
      }
      return false;
  }
}