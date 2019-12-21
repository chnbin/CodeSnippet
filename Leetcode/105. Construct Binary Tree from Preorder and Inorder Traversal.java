class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
      // 用來對應inorder中，value與index
      // inorder = [3, 9, 20, 15, 7]
      // inorderMap = {{3, 0}, {9, 1}, {20, 2}, {15, 3}, {7, 4}};
      Map<Integer, Integer> inorderMap = new HashMap<>();
      
      for (int i = 0; i < inorder.length; i++) {
          inorderMap.put(inorder[i], i);
      }
      
      return buildTreeHelper(preorder, 0, preorder.length - 1,
                             inorder, 0, inorder.length - 1, inorderMap);
  }
  
  private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                   int[] inorder, int inStart, int inEnd,
                                   Map<Integer, Integer> inorderMap) {
      if (preStart > preEnd || inStart > inEnd) {
          return null;
      }
      
      // Preorder的頭，一定是tree的node
      TreeNode root = new TreeNode(preorder[preStart]);
      int inOrderRootIndex = inorderMap.get(preorder[preStart]);
      // 左子樹的node數
      int numberOfLeftTree = inOrderRootIndex - inStart;
      
      // 故可以推算左右子樹的起點與終點
      root.left = buildTreeHelper(preorder,
                                  preStart + 1, preStart + numberOfLeftTree,
                                  inorder,
                                  inStart, inOrderRootIndex - 1,
                                  inorderMap);
      root.right = buildTreeHelper(preorder,
                                   preStart + numberOfLeftTree + 1, preEnd,
                                   inorder,
                                   inOrderRootIndex + 1, inEnd,
                                   inorderMap);
      return root;
  }
}