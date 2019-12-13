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
  public List<List<String>> printTree(TreeNode root) {
      List<List<String>> res = new ArrayList<>();
      int height = findTreeHeight(root);
      int width = (int)Math.pow(2, height) - 1;
      
      for (int i = 0; i < height; i++) {
          List<String> level = new ArrayList<>();
          for (int j = 0; j < width; j++) {
              level.add("");
          }
          res.add(level);
      }
      
      build(res, root, 0, 0, width - 1);
      
      return res;
  }
  
  private void build(List<List<String>> res, TreeNode node, int level, int low, int high) {
      if (node == null) { return; }
      int mid = (low + high) / 2;
      res.get(level).set(mid, node.val + "");
      build(res, node.left, level + 1, low, mid - 1);
      build(res, node.right, level + 1, mid + 1, high);
  }
  
  private int findTreeHeight(TreeNode node) {
      if (node == null) { return 0; }
      return Math.max(findTreeHeight(node.left), findTreeHeight(node.right)) + 1;
  }
}