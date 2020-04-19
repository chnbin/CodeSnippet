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
  public TreeNode removeLeafNodes(TreeNode root, int target) {
      return removeLeafNodesHelper(root, target);
  }
  
  private TreeNode removeLeafNodesHelper(TreeNode node, int target) {
      if (node == null) { return null; }
      node.left = removeLeafNodesHelper(node.left, target);
      node.right = removeLeafNodesHelper(node.right, target);
      
      if (node.left == null && node.right == null && node.val == target) {
          return null;
      }
      return node;
  }
}
