import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<Integer> postorder(Node root) {
      List<Integer> res = new ArrayList<>();
      if (root == null) { return res; }
      LinkedList<Node> stack1 = new LinkedList<>();
      LinkedList<Node> stack2 = new LinkedList<>();
      stack1.push(root);
      
      while (!stack1.isEmpty()) {
          Node node = stack1.pop();
          stack2.push(node);
          for (Node child: node.children) {
              stack1.push(child);
          }
      }
      while (!stack2.isEmpty()) {
          res.add(stack2.pop().val);
      }
      
      return res;
  }
}