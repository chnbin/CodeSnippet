class Solution {
  public TreeNode bstFromPreorder(int[] preorder) {
      /*
          The first element of the preorder traverse is root.
          Step 1. Choose the first element as a binary search tree's root.
          Step 2. By definition, insert remain elements into this tree from the root.
          Time complexity: O(NlogN) where N is the number of tree nodes.
                           Insert a node into BST is O(logN) and we need to insert N nodes.
          Space complexity: O(1).
      */
      TreeNode root = new TreeNode(preorder[0]);
      
      for (int i = 1; i < preorder.length; i++) {
          TreeNode tmpRoot = root;
          
          while (tmpRoot != null) {
              if (tmpRoot.val > preorder[i]) {
                  // add this node to left if tmpRoot is leaf.
                  if (tmpRoot.left == null) {
                      tmpRoot.left = new TreeNode(preorder[i]);
                      break;
                  } else {
                      tmpRoot = tmpRoot.left;    
                  }                    
              } else {
                  // add this node to right if tmpRoot is leaf.
                  if (tmpRoot.right == null) {
                      tmpRoot.right = new TreeNode(preorder[i]);
                      break;
                  } else {
                      tmpRoot = tmpRoot.right;    
                  }                    
              }
          }
      }
      
      return root;
  }
}
