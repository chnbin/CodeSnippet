class Solution {
  public TreeNode bstFromPreorder(int[] preorder) {
      TreeNode root = new TreeNode(preorder[0]);
      
      for (int i = 1; i < preorder.length; i++) {
          TreeNode tmp = root;
          
          while (tmp != null) {
              if (preorder[i] < tmp.val) {
                  // To left
                  if (tmp.left == null) {
                      tmp.left = new TreeNode(preorder[i]);
                      break;
                  } else {
                      tmp = tmp.left;
                  }
              } else {
                  // To right
                  if (tmp.right == null) {
                      tmp.right = new TreeNode(preorder[i]);
                      break;
                  } else {
                      tmp = tmp.right;
                  }
              }
          }
      }
      return root;
  }
}