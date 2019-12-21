/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
      Map<Integer, Integer> inMap = new HashMap<>();
      
      for (int i = 0; i < inorder.length; i++) {
          inMap.put(inorder[i], i);
      }
      
      return buildTreeHelper(inorder, 0, inorder.length - 1,
                             postorder, 0, postorder.length - 1,
                             inMap);
  }
  
  private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd,
                             int[] postorder, int postStart, int postEnd,
                             Map<Integer, Integer> inMap) {
      if (inStart > inEnd || postStart > postEnd) {
          return null;
      }
      
      // postorder的最後一個點，一定是這棵樹的root
      TreeNode root = new TreeNode(postorder[postEnd]);
      int indexOfInorderRoot = inMap.get(postorder[postEnd]);
      
      // 左子樹的個數
      int numberOfLeftTree = indexOfInorderRoot - inStart;
      
      // 故可以推算左右子樹的起點與終點
      root.left = buildTreeHelper(inorder, 
                                  inStart, indexOfInorderRoot - 1,
                                  postorder,
                                  postStart, postStart + numberOfLeftTree - 1,
                                  inMap);
      root.right = buildTreeHelper(inorder,
                                   indexOfInorderRoot + 1, inEnd,
                                   postorder,
                                   postStart + numberOfLeftTree, postEnd - 1,
                                   inMap);
      return root;
  }
}