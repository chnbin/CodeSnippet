class Solution {
  public List<List<Integer>> findLeaves(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      
      while (root != null) {
          List<Integer> leaves = new ArrayList<>();
          root = findLeavesHelper(root, leaves);
          res.add(leaves);
      }
      
      return res;
  }
  
  private TreeNode findLeavesHelper(TreeNode node, List<Integer> level) {
      if (node == null) {
          return null;
      }
      
      if (node.left == null && node.right == null) {
          level.add(node.val);
          return null;
      }
      node.left = findLeavesHelper(node.left, level);
      node.right = findLeavesHelper(node.right, level);
      
      return node;
  }
}