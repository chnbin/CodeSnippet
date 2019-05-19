class Solution {
  private Integer prev = null;
  private int minAbs = Integer.MAX_VALUE;
  
  public int getMinimumDifference(TreeNode root) {
      inorder(root);
      return minAbs;
  }
  
  private void inorder(TreeNode node) {
      if (node == null) { return; }
      inorder(node.left);
      if (prev != null) {
          minAbs = Math.min(minAbs, Math.abs(node.val-prev));
      }
      prev = node.val;
      inorder(node.right);
  }
}