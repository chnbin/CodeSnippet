import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
      ArrayList<Integer> ans = new ArrayList<Integer>();
      if (root == null) { return ans; }
      
      LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
      stack.push(root);
      
      while (!stack.isEmpty()) {
          TreeNode node = stack.pop();
          if (node != null) {
              ans.add(node.val);
              stack.push(node.right);
              stack.push(node.left);
          }
      }
      return ans;
  }
}