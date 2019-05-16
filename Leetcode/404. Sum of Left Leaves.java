class Solution {
  public int sumOfLeftLeaves(TreeNode root) {
      return helper(root, 0);
  }
  
  private int helper(TreeNode node, int location) {
      if (node == null) { return 0; }
      if (node.left == null && node.right == null) {
          return (location % 2) == 0 ? 0 : node.val;
      }
      int sum = 0;
      if (node.left != null) { 
          sum += helper(node.left, 2*location + 1); 
      }
      if (node.right != null) {
          sum += helper(node.right, 2*location + 2);
      }
      return sum;
  }
}