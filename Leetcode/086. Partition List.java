class Solution {
  public ListNode partition(ListNode head, int x) {
      ListNode lessNodes = new ListNode(0);
      ListNode moreNodes = new ListNode(0);
      ListNode lessNodesDummy = lessNodes;
      ListNode moreNodesDummy = moreNodes;
      
      while (head != null) {
          if (head.val < x) {
              lessNodesDummy.next = head;
              lessNodesDummy = lessNodesDummy.next;
          } else {
              moreNodesDummy.next = head;
              moreNodesDummy = moreNodesDummy.next;
          }
          head = head.next;
      }
      
      lessNodesDummy.next = moreNodes.next;
      moreNodesDummy.next = null;
      
      return lessNodes.next;
  }
}