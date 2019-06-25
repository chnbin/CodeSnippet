import java.util.ArrayList;
import java.util.List;
class Solution {
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
      List<Integer> seq1 = new ArrayList<>();
      List<Integer> seq2 = new ArrayList<>();
      contructLeafSqu(seq1, root1);
      contructLeafSqu(seq2, root2);
      
      return seq1.equals(seq2);
  }
  
  private void contructLeafSqu(List<Integer> list, TreeNode node) {
      if (node == null) { return; }
      
      contructLeafSqu(list, node.left);
      if (node.left == null && node.right == null) {
          list.add(node.val);
      }
      contructLeafSqu(list, node.right);
  }
}