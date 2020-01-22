class Solution {
  public ListNode plusOne(ListNode head) {
      if (head == null) { return head; }
      int carry = plusOneHelper(head);
      ListNode newHead;
      if (carry > 0) {
          newHead = new ListNode(carry);
          newHead.next = head;
          return newHead;
      }
      return head;
  }
  
  private int plusOneHelper(ListNode node) {
      if (node == null) { return 1; }
      int carry = plusOneHelper(node.next);
      int value = node.val;
      node.val = (carry + value) % 10;
      return (carry + value) / 10;
  }
}