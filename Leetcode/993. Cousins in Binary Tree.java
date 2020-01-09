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

  public boolean isCousinsDFS(TreeNode root, int x, int y) {
    // [0] is level; [1] is parent
    int[] xInfo = new int[2];
    int[] yInfo = new int[2];
    isCousinsHelper(root, xInfo, x, 0, 0);
    isCousinsHelper(root, yInfo, y, 0, 0);
    return ((xInfo[0] == yInfo[0]) && (xInfo[1] != yInfo[1]));
  }

  private void isCousinsHelper(TreeNode node, int[] info, int target, int parent, int level) {
    if (node == null) { return ; }
    if (node.val == target) {
        info[0] = level;
        info[1] = parent;
        return;
    }
    isCousinsHelper(node.left, info, target, node.val, level + 1);
    isCousinsHelper(node.right, info, target, node.val, level + 1);
  } 
}