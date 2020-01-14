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
  private int res = Integer.MIN_VALUE;
  
  public int maxPathSum(TreeNode root) {
      if (root == null) { return 0;}
      maxPathSumHelper(root);
      return res;
  }
  
  private int maxPathSumHelper(TreeNode node) {
      if (node == null) { return 0; }
      
      // node.left path sum max
      int pLeftMax = maxPathSumHelper(node.left);
      
      // node.left path sum max
      int pRightMax = maxPathSumHelper(node.right);
      
      int value = node.val;
      
      // The path must contain at least one node
      res = Math.max(res, value + pLeftMax + pRightMax);
      
      // If the path sum is negtive, we don't need count this path
      if (value + pLeftMax + pRightMax < 0) {
          return 0;
      }
      
      return value + Math.max(pLeftMax, pRightMax);
  }
}