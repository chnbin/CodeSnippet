import java.util.ArrayList;
import java.util.List;

class Solution {
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
      List<Integer> seq1 = new ArrayList<>();
      List<Integer> seq2 = new ArrayList<>();
      contructLeafSqu(seq1, root1);
      contructLeafSqu(seq2, root2);
      if (seq1.size() != seq2.size()) { return false; }
      
      for (int i = 0; i < seq1.size(); i++) {
          if (seq1.get(i) != seq2.get(i)) {
              return false;
          }
      }
      
      return true;
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