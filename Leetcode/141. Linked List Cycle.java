class Solution {
  public boolean hasCycle(ListNode head) {
      if (head == null) { return false; }
      
      ListNode slow = head;
      ListNode fast = head.next;
      
      while (slow != null && fast != null && fast.next != null) {
          if (fast == slow) { return true; }
          fast = fast.next.next;
          slow = slow.next;
      }
      return false;
  }
}