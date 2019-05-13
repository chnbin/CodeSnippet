import java.util.ArrayList;
import java.util.List;

class BSTIterator {
  List<Integer> bstTree = null;
  int index = 0;

  public BSTIterator(TreeNode root) {
      bstTree = new ArrayList<Integer>();
      traveral(bstTree, root);
  }
  
  /** @return the next smallest number */
  public int next() {
      int value = bstTree.get(index);
      index++;
      return value;
  }
  
  /** @return whether we have a next smallest number */
  public boolean hasNext() {
      return index < bstTree.size();
  }
  
  private void traveral(List<Integer> list, TreeNode node) {
      if (node == null) { return; }
      traveral(list, node.left);
      list.add(node.val);
      traveral(list, node.right);
  }
}