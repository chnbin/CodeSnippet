import java.util.LinkedList;

class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      LinkedList<Integer> stack1 = new LinkedList<>();
      LinkedList<Integer> stack2 = new LinkedList<>();
      
      while (l1 != null) {
          stack1.push(l1.val);
          l1 = l1.next;
      }
      
      while (l2 != null) {
          stack2.push(l2.val);
          l2 = l2.next;
      }
      
      int carry = 0;
      ListNode dummy = new ListNode(0);
      while (!stack1.isEmpty() || !stack2.isEmpty()) {
          int sum = carry;
          if (!stack1.isEmpty()) {
              sum += stack1.pop();
          }
          
          if (!stack2.isEmpty()) {
              sum += stack2.pop();
          }
          
          carry = sum / 10;
          sum = sum % 10;
          
          ListNode node = new ListNode(sum);
          node.next = dummy.next;
          dummy.next = node;
      }
      
      if (carry > 0) {
          ListNode node = new ListNode(carry);
          node.next = dummy.next;
          dummy.next = node;
      }
      
      return dummy.next;
  }
}