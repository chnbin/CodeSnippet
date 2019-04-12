import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
      ArrayList<Integer> ans = new ArrayList<Integer>();
      if (root == null) {
          return ans;
      }
      LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
      
      while (true) {
          while (root != null) {
              stack.push(root);
              root = root.left;
          }
          
          if (stack.isEmpty()) { return ans; }
          
          TreeNode node = stack.pop();
          
          if (node != null) {
              ans.add(node.val);
              root = node.right;
          }
      }
  }
}