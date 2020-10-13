/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode sortList(ListNode head) {
      if (head == null || head.next == null) {
          return head;
      }
      
      ListNode p1 = head;
      ListNode middle = findMiddle(head);
      ListNode p2 = middle.next;
      middle.next = null;
      
      p1 = sortList(p1);
      p2 = sortList(p2);
      
      return merge(p1, p2);
  }
  
  private ListNode findMiddle(ListNode node) {
      ListNode p1 = node;
      ListNode p2 = node;
      
      while(p1!=null && p2!=null){
          if(p2.next==null||p2.next.next==null){
              return p1;
          }

          p1 = p1.next;
          p2 = p2.next.next;
      }
      
      return node;
  }
  
  private ListNode merge(ListNode n1, ListNode n2){
      ListNode head = new ListNode(0);
      ListNode p = head;
      ListNode p1 = n1;
      ListNode p2 = n2; 
      while(p1!=null && p2!=null){
          if(p1.val<p2.val){
              p.next = p1;
              p1 = p1.next;
          }else{
              p.next = p2;
              p2 = p2.next;
          }

          p = p.next;
      }

      if(p1!=null){
          p.next = p1;
      }

      if(p2!=null){
          p.next = p2;
      }

      return head.next;
  }
}
