import java.util.ArrayList;
import java.util.List;

class Solution {
  public boolean isValidBST(TreeNode root) {
      List<Integer> tree = new ArrayList<Integer>();
      inOrder(root, tree);
      
      if (tree.size() == 1) {
          return true;
      }
      
      for (int i = 1; i < tree.size(); i++) {
          if (tree.get(i) <= tree.get(i - 1)) {
              return false;
          }
      }
      
      return true;
  }
  
  public void inOrder(TreeNode node, List<Integer> list) {
      if (node != null) {
          inOrder(node.left, list);
          list.add(node.val);
          inOrder(node.right, list);
      }
  }
}