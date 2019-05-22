class Solution {
  public ListNode rotateRight(ListNode head, int k) {
      if (k == 0 || head == null) { return head; }

      ListNode dummy = head;
      
      // Compute length of given list.
      int length = 0;
      while (dummy != null) {
          length++;
          dummy = dummy.next;
      }
      
      // If k is very large, we don't need to computer so much.
      k = k % length;

      if (k == 0) { return head; }
      
      ListNode fast = head;
      int pos = 0;
      
      // Fast runs k steps first.
      while (pos < k) {
          fast = fast.next;
          pos++;
      }
      
      ListNode slow = head;
      // Run together until fast.next is null.
      while (fast.next != null) {
          fast = fast.next;
          slow = slow.next;
      }
      
      // When two nodes stop, slow.next is the head of target linkedlist.
      ListNode newHead = slow.next;
      dummy = slow.next;
      slow.next = null;
      
      while (dummy.next != null) {
          dummy = dummy.next;
      }
      dummy.next = head;
      
      return newHead;
  }
}