class Solution {
  public ListNode middleNode(ListNode head) {
      ListNode fast = new ListNode(0);
      ListNode slow = new ListNode(0);
      fast.next = head;
      slow.next = head;
      
      while (fast.next != null && fast.next.next != null) {
          fast = fast.next.next;
          slow = slow.next;
      }
      
      return slow.next;
  }
}