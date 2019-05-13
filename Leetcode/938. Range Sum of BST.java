class Solution {
  public int rangeSumBST(TreeNode root, int L, int R) {
      if (root == null) { return 0; }
      return rangeSumBSTHelper(root, L, R);
  }
  
  private int rangeSumBSTHelper(TreeNode node, int L, int R) {
      if (node == null) { return 0; }
      int total = 0;
      
      if ((L <= node.val) && (node.val <= R)) {
          total += node.val;
          total += rangeSumBSTHelper(node.left, L, R);
          total += rangeSumBSTHelper(node.right, L, R);
      } else if (node.val > R) {
          total += rangeSumBSTHelper(node.left, L, R);
      } else {
          total += rangeSumBSTHelper(node.right, L, R);
      }
      return total;
  }
}