import java.util.ArrayList;
import java.util.List;

class Solution {
  public int minDiffInBST(TreeNode root) {
      List<Integer> inorderResult = new ArrayList<>();
      int res = Integer.MAX_VALUE;
      
      inorder(root, inorderResult);
      
      for (int i = 1; i < inorderResult.size(); i++) {
          res = Math.min(res, Math.abs(inorderResult.get(i) - inorderResult.get(i-1)));
      }
      return res;
  }
  
  private void inorder(TreeNode node, List<Integer> treeNodes) {
      if (node != null) {
          inorder(node.left, treeNodes);
          treeNodes.add(node.val);
          inorder(node.right, treeNodes);
      }
  }
}