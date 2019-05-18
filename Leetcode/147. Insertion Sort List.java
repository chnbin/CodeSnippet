class Solution {
  public ListNode insertionSortList(ListNode head) {
      if (head == null || head.next == null) { return head; }
      ListNode dummy = new ListNode(-1);
      ListNode p = head;
      dummy.next = head;
      
      while (p.next != null) {
          if (p.val < p.next.val) {
              p = p.next;
          } else {
              ListNode tmp = p.next;
              p.next = p.next.next;
              ListNode q = dummy;
              while (q.next.val < tmp.val) {
                  q = q.next;
              }
              tmp.next = q.next;
              q.next = tmp;
          }
      }
      return dummy.next;
  }
}