class Solution {
  public int countNodes(TreeNode root) {
      if (root == null) { return 0; }
      int leftHeight = getLeftHeight(root) + 1;
      int rightHeight = getRightHeight(root) + 1;
      
      if (leftHeight == rightHeight) {
          return (2 << (leftHeight - 1)) - 1;
      } else {
          return 1 + countNodes(root.left) + countNodes(root.right);
      }
  }
  
  private int getLeftHeight(TreeNode node) {
      if (node == null) { return 0; }
      int height = 0;
      
      while (node.left != null) {
          height++;
          node = node.left;
      }
      
      return height;
  }
  
  private int getRightHeight(TreeNode node) {
      if (node == null) { return 0; }
      int height = 0;
      
      while (node.right != null) {
          height++;
          node = node.right;
      }
      
      return height;
  }
}
