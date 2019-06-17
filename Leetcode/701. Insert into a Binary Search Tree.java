class Solution {
  public TreeNode insertIntoBST(TreeNode root, int val) {
      if (root.val < val) {
          if (root.right != null) {
              insertIntoBST(root.right, val);
          } else {
              TreeNode node = new TreeNode(val);
              root.right = node;
          }
      } else {
          if (root.left != null) {
              insertIntoBST(root.left, val);
          } else {
              TreeNode node = new TreeNode(val);
              root.left = node;
          }
      }
      
      return root;
  }
}