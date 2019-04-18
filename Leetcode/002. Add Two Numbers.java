class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode head = new ListNode(0);
      ListNode dummy = head;
      int carry = 0;

      while (l1 != null || l2 != null) {
          int digit = carry;
          
          if (l1 != null) {
              digit += l1.val;
              l1 = l1.next;
          }
          
          if (l2 != null) {
              digit += l2.val;
              l2 = l2.next;
          }
          
          carry = digit / 10;
          digit %= 10;
          
          head.next = new ListNode(digit);
          head = head.next;
      }
      
      if (carry > 0) { head.next = new ListNode(carry); }
      
      return dummy.next;
  }
}