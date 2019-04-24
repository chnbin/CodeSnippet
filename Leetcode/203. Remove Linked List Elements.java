class Solution {
  public ListNode removeElements(ListNode head, int val) {
      ListNode dummy = new ListNode(-1);
      ListNode newHead = dummy;
      dummy.next = head;
      
      while (dummy != null && dummy.next != null) {
          if (dummy.next.val == val) {
              dummy.next = dummy.next.next;
          } else {
              dummy = dummy.next;
          }
      }
      return newHead.next;
  }
}