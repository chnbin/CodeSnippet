/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public TreeNode increasingBST(TreeNode root) {
      if (root == null) { return root; }
      
      List<Integer> tree = new ArrayList<>();
      inOrder(root, tree);
      
      TreeNode res = new TreeNode(tree.get(0));
      TreeNode returnHead = res;
      
      for (int i = 1; i < tree.size(); i++) {
          TreeNode node = new TreeNode(tree.get(i));
          res.right = node;
          res = res.right;
      }
      
      return returnHead;
  }
  
  private void inOrder(TreeNode node, List<Integer> list) {
      if (node == null) { return; }
      inOrder(node.left, list);
      list.add(node.val);
      inOrder(node.right, list);
  }
}
