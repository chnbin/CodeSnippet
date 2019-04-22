class Solution {
  public TreeNode invertTree(TreeNode root) {
      if (root == null) { return null; }
      invertTreeHelper(root);
      return root;
  }
  
  private void invertTreeHelper(TreeNode node) {
      if (node == null) { return; }
      
      TreeNode tmpNode = node.left;
      node.left = node.right;
      node.right = tmpNode;
      
      invertTreeHelper(node.left);
      invertTreeHelper(node.right);
  }
}