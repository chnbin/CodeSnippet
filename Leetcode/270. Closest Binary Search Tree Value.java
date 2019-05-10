class Solution {
  public int closestValue(TreeNode root, double target) {
      double value = Double.MAX_VALUE + 1;
      int ans = 0;
      while (root != null) {
          if (Math.abs(root.val - target) < value) {
              ans = root.val;
              value = Math.abs(root.val - target);
          }
          
          root = (root.val > target) ? root.left : root.right;
      }
      return ans;
  }
}