class Solution {
  public boolean isBalanced(TreeNode root) {
      return isBalancedHelper(root) != -1;
  }
  
  public int isBalancedHelper(TreeNode node) {
      if (node == null) { return 0; }
      
      int l = isBalancedHelper(node.left);
      int r = isBalancedHelper(node.right);
      
      if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
          return -1;
      }
      
      return Math.max(l, r) + 1;
  }
}