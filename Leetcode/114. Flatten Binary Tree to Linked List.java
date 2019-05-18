import java.util.LinkedList;

class Solution {
  public void flatten(TreeNode root) {
      if (root == null) { return ; }
      LinkedList<TreeNode> stack = new LinkedList<>();
      stack.push(root);
      
      while (!stack.isEmpty()) {
          TreeNode node = stack.pop();
          if (node.right != null) {
              stack.push(node.right);
          }
          if (node.left != null) {
              stack.push(node.left);
          }
          node.left = null;
          node.right = (!stack.isEmpty()) ? stack.peek() : null;
      }
  }
}