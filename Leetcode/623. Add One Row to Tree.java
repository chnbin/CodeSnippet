class Solution {
  public TreeNode addOneRow(TreeNode root, int v, int d) {
      addOneRow(root, v, d, 1);
      return root;
  }
  
  private void addOneRow(TreeNode node, int v, int d, int level) {
      if (node == null) { return; }
      
      // Add at row one is special case.
      if (d == 1) {
          TreeNode newRoot = new TreeNode(node.val);
          node.val = v;
          newRoot.left = node.left;
          newRoot.right = node.right;
          node.left = newRoot;
          node.right = null;
          return ;
      }
      
      if (level == d - 1) {
          TreeNode leftNode = new TreeNode(v);
          TreeNode rightNode = new TreeNode(v);
          
          if (node.left != null) {
              leftNode.left = node.left;
          }
          
          if (node.right != null) {
              rightNode.right = node.right;
          }
          
          node.left = leftNode;
          node.right = rightNode;
          return ;
      }
      addOneRow(node.left, v, d, level + 1);
      addOneRow(node.right, v, d, level + 1);
      
  }
}