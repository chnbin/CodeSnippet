/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// This question is the same as 1038: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
class Solution {
  int sum = 0;
  
  public TreeNode convertBST(TreeNode root) {
      if (root == null) { return null; }
      convertBSTHelper(root);
      return root;
  }
  
  private TreeNode convertBSTHelper(TreeNode node) {
      if (node == null) { return null;}
      convertBSTHelper(node.right);
      sum += node.val;
      node.val = sum;
      convertBSTHelper(node.left);
      return node;
  }
}
