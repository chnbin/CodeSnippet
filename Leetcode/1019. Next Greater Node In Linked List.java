import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
  public int[] nextLargerNodes(ListNode head) {
      if (head == null) { return new int[0]; }
      int length = 0;
      LinkedList<ListNode> stack = new LinkedList<>();
      Map<ListNode, Integer> map = new HashMap<>();
      ListNode dummy = head;
      
      while (dummy != null) {
          while (!stack.isEmpty() && dummy.val > stack.peek().val) {
              map.put(stack.pop(), dummy.val);
          }
          stack.push(dummy);
          length++;
          dummy = dummy.next;
      }
      
      int[] res = new int[length];
      int pos = 0;
      
      while (head != null) {
          if (map.containsKey(head)) {
              res[pos] = map.get(head);
          } else {
              res[pos] = 0;
          }
          pos++;
          head = head.next;
      }
      return res;
  }
}