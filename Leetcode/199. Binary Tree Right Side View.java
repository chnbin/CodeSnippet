import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<Integer> rightSideView(TreeNode root) {
      List<Integer> ans = new ArrayList<Integer>();
      if (root == null) { return ans; }
      LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
      queue.add(root);

      while (!queue.isEmpty()) {
          int len = queue.size();
          
          for (int i = 0; i < len; i++) {
              TreeNode curr = queue.poll();
              if (curr.left != null) { queue.offer(curr.left); }
              if (curr.right != null) { queue.offer(curr.right); }
              if (i == len - 1) { ans.add(curr.val); }
          }
      }
      return ans;
  }
}