class Solution {
  private int res = 0;
  public int findTilt(TreeNode root) {
      if (root == null) { return 0; }
      return  findTiltHelper(root);
  }
  
  private int findTiltHelper(TreeNode node) {
      if (node == null) {
          return 0;
      }
      
      int leftSum = findTilt(node.left);
      int rightSum = findTilt(node.right);
      return node.val + Math.abs(leftSum - rightSum);
  }
}
