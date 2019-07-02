import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
  public void recoverTree(TreeNode root) {
      if (root == null) { return; }
      List<TreeNode> nodes = new ArrayList<>();
      List<Integer> values = new ArrayList<>();
      inOrderTraversal(root, nodes, values);
      
      Collections.sort(values);
      
      for (int i = 0; i < nodes.size(); i++) {
          nodes.get(i).val = values.get(i);
      }
  }
  
  private void inOrderTraversal(TreeNode node, List<TreeNode> nodes, List<Integer> values) {
      if (node != null) {
          inOrderTraversal(node.left, nodes, values);
          nodes.add(node);
          values.add(node.val);
          inOrderTraversal(node.right, nodes, values);
      }
      
  }
}