class Solution {
  int sum = 0;
  public TreeNode bstToGst(TreeNode root) {
      if (root == null) { return null; }
      helper(root);
      return root;
  }
  
  private TreeNode helper(TreeNode node) {
      if (node == null) { return null; }
      helper(node.right);
      sum += node.val;
      node.val = sum;
      helper(node.left);
      return node;
  }
}