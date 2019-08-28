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
  public int countUnivalSubtrees(TreeNode root) {
      if (root == null) { return 0; }
      
      int[] res = {0, 0};
      preOrder(root, res);
      return res[0];
  }
  
  private void preOrder(TreeNode node, int[] res) {
      if (node == null) { return; }
      
      boolean isUni = isUnival(node, node.val);
      if (isUni) { res[0]++; }
      
      preOrder(node.left, res);
      preOrder(node.right, res);
  }
  
  private boolean isUnival(TreeNode node, int value) {
      if (node == null) {
          return true;
      }
      
      boolean isLeftUnival = isUnival(node.left, value);
      boolean isRightUnival = isUnival(node.right, value);
      
      return (node.val == value) && isLeftUnival && isRightUnival;
  }
}