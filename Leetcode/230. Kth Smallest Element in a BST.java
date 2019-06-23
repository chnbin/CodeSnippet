import java.util.LinkedList;

class Solution {
  public int kthSmallest(TreeNode root, int k) {
      if (root == null) { return -1; }
      LinkedList<TreeNode> stack = new LinkedList<>();
      
      // Inorder traverse
      while (true) {
          while (root != null) {
              stack.push(root);
              root = root.left;
          }
          
          TreeNode node = stack.pop();
          if (node != null) {
              k--;
              if (k == 0) { return node.val; }
              if (node.right != null) {
                  root = node.right;
              }
          }
      }
  }
}