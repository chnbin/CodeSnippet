class Solution {
  private int maxHeight = 0;
  private int sum = 0;
  
  public int deepestLeavesSum(TreeNode root) {
      if (root == null) { return 0; }
      findHeightOfTree(root, 0);
      findDeepestNodeSum(root, 0);
      return sum;
  }
  
  private void findHeightOfTree(TreeNode node, int level) {
      if (node == null) { return ;}
      if (node.left == null && node.right == null) {
          maxHeight = Math.max(maxHeight, level);
      }
      findHeightOfTree(node.left, level + 1);
      findHeightOfTree(node.right, level + 1);
  }
  
  private void findDeepestNodeSum(TreeNode node, int level) {
      if (node == null) { return ; }
      if (node.left == null && node.right == null && level == maxHeight) {
          sum += node.val;
      }
      findDeepestNodeSum(node.left, level + 1);
      findDeepestNodeSum(node.right, level + 1);
  }
}
