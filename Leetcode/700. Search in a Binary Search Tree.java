class Solution {
  public TreeNode searchBST(TreeNode root, int val) {
      if (root == null) { return null; }
      
      while (root != null) {
          if (root.val == val) { return root; }
          root = (root.val > val) ? root.left : root.right;
      }
      return null;
  }
}