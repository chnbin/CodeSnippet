class Solution {
  public ListNode swapPairs(ListNode head) {
      ListNode dummy = new ListNode(-1);
      ListNode newHead = dummy;
      dummy.next = head;
      
      while (dummy.next != null && dummy.next.next != null) {
          ListNode newStart = dummy.next.next; 
          dummy.next.next = newStart.next;
          newStart.next = dummy.next;
          dummy.next = newStart;
          
          dummy = newStart.next;
      }
      return newHead.next;
  }
}