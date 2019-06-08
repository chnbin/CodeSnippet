import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<Integer> preorder(Node root) {
      List<Integer> res = new ArrayList<>();
      if (root == null) {
          return res;
      }
      LinkedList<Node> stack = new LinkedList<>();
      stack.push(root);
      
      while (!stack.isEmpty()) {
          Node node = stack.pop();
          res.add(node.val);
          for (int i = node.children.size() - 1; i >= 0; i--) {
              stack.push(node.children.get(i));
          }
      }
      return res;
  }
}