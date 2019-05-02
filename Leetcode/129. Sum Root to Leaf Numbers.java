class Solution {
  public int sumNumbers(TreeNode root) {
      if (root == null) { return 0; }
      int[] sum = new int[1];
      helper(root, 0, sum);
      return sum[0];
  }
  
  private void helper(TreeNode node, int currSum, int[] sum) {
      if (node == null) { return ; }
      currSum += node.val;

      if (node.left == null && node.right == null) {
          sum[0] += currSum;
      }
      
      helper(node.left, currSum*10, sum);
      helper(node.right, currSum*10, sum);
  }
}