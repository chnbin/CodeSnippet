class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      ListNode m = new ListNode(0);
      ListNode n = new ListNode(0);
      m.next = headA;
      n.next = headB;
      int lenA = 0;
      int lenB = 0;
      while (m.next != null) { 
          m = m.next;
          lenA++;
      }
      while (n.next != null) {
          n = n.next;
          lenB++;
      }
      
      m = new ListNode(0);
      n = new ListNode(0);
      m.next = headA;
      n.next = headB;
      
      if (lenA > lenB) {
          int dist = lenA - lenB;
          while (dist > 0) {
              m = m.next;
              dist--;
          }
      }
      
      if (lenA < lenB) {
          int dist = lenB - lenA;
          while (dist > 0) {
              n = n.next;
              dist--;
          }
      }

      while (m != null && n != null) {
          if (m.next == n.next) {
              return m.next;
          }
          m = m.next;
          n = n.next;
      }
      
      return null;
  }
}