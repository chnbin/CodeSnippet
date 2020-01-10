/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public TreeNode pruneTree(TreeNode root) {
      pruneTreeHelper(root);
      return root;
  }
  
  private boolean pruneTreeHelper(TreeNode node) {
      if (node == null) { return false; }
      
      boolean left = pruneTreeHelper(node.left);
      if (!left) { node.left = null; }
      
      boolean right = pruneTreeHelper(node.right);
      if (!right) { node.right = null; }
      
      if (node.val == 1) {
          return true;
      }
      
      return left || right;
  }
}