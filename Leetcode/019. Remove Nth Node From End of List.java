/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode fast = new ListNode(0);
      ListNode slow = new ListNode(0);
      fast = head;
      slow = head;
      
      for (int i = 0; i < n; i++) {
          fast = fast.next;
      }
      
      // 如果此時快指標是null，代表剛好把Linked List走完(Linked List長度為n)
      // 因此從尾部倒數過來的第n個元素為由頭部數過來的第一個元素。
      // 1 -> 2 -> 3 -> 4 -> 5, n = 5
      // 其實就是要移掉第一個元素
      // 導致[1], n= 1或是[1,2,3], n = 3過不了的狀態。
      if (fast == null) {
          return head.next;
      }
      
      while (fast.next != null) {
          fast = fast.next;
          slow = slow.next;
      }
      
      slow.next = slow.next.next;
      
      return head;
  }
}