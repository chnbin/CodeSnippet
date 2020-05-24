class Solution {
  /*
    Time complexity: O(N) where N is the number of node in the given tree.
    Space complexity : O(1)
    DFS
  */
  int res = 0;
  public int goodNodes(TreeNode root) {
      goodNodesHelper(root, Integer.MIN_VALUE);
      return res;
  }
  
  private void goodNodesHelper(TreeNode node, int currMax) {
      if (node == null) { return; }
      if (node.val >= currMax) {
          res++;
      }
      currMax = Math.max(currMax, node.val);
      goodNodesHelper(node.left, currMax);
      goodNodesHelper(node.right, currMax);
  }
  
}
