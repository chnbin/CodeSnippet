import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
      ArrayList<Integer> ans = new ArrayList<Integer>();
      if (root == null) { return ans; }
      
      LinkedList<TreeNode> stack1 = new LinkedList<TreeNode>();
      LinkedList<Integer> stack2 = new LinkedList<Integer>();
      stack1.add(root);
      
      while (!stack1.isEmpty()) {
          TreeNode node = stack1.pop();
          if (node != null) {
              stack2.push(node.val);
              stack1.push(node.left);
              stack1.push(node.right);
          }
      }
      
      while (!stack2.isEmpty()) {
          ans.add(stack2.pop());
      }
      
      return ans;
  }
}