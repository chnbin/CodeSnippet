class Solution {
  public int sumRootToLeaf(TreeNode root) {
      int ans = helper(root, 0);
      return ans;
  }
  
  public int helper(TreeNode node, int curr) {
      if (node == null) { return 0 ;}
      curr = curr * 2 + node.val;
      if (node.left == null && node.right == null) {
          return curr;
      }
      return helper(node.left, curr) + helper(node.right, curr);
      
  }
}