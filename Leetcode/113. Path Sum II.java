import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
      List<List<Integer>> res = new LinkedList<List<Integer>>();
      if (root == null) { return res; }
      List<Integer> path = new ArrayList<Integer>();
      pathSumHelper(root, sum, path, res);
      return res;
  }
  
  private void pathSumHelper(TreeNode node, int currSum, List<Integer> path, List<List<Integer>> ans) {
      if (node == null) { return; }
      currSum -= node.val;
      path.add(node.val);
      
      pathSumHelper(node.left, currSum, path, ans);

      pathSumHelper(node.right, currSum, path, ans);
      
      if (node.left == null && node.right == null && currSum == 0) {
          ans.add(new ArrayList(path));
      }
      path.remove(path.size()-1);
  }
}

