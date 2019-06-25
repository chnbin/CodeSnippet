class Solution {
  public int countNodes(TreeNode root) {
      // Because the given tree is a complete tree, count nodes directly.
      if (root == null) { return 0; }
      int result = 1;
      if (root.left != null) {
          result += countNodes(root.left);
      }
      
      if (root.right != null) {
          result += countNodes(root.right);
      }
      return result;
  }
}