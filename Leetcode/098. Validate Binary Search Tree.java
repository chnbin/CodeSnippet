class Solution {
  public boolean isValidBST(TreeNode root) {
      // 沒有點，或是一個點
      if (root == null || (root.left == null && root.right == null)) {
          return true;
      }
      return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
  
  private boolean isValidBSTHelper(TreeNode node, long minValue, long maxValue) {
      if (node == null) { return true; }
      if (node.val >= maxValue || node.val <= minValue) {
          return false;
      }
      
      return (isValidBSTHelper(node.left, minValue, node.val) &&
              isValidBSTHelper(node.right, node.val, maxValue));
  }
}