class Solution {
  private int res = 0;
  
  public int diameterOfBinaryTree(TreeNode root) {
      if (root == null) { return 0; }
      diameterOfBinaryTreeHelper(root);
      return res;
  }
  
  private int diameterOfBinaryTreeHelper(TreeNode node) {
      if (node == null) { return 0; }
      int left = diameterOfBinaryTreeHelper(node.left);
      int right = diameterOfBinaryTreeHelper(node.right);
      res = Math.max(res, left + right);
      return 1 + Math.max(left, right);
  }
}