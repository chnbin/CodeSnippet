import java.util.PriorityQueue;

class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) { return null; }
      ListNode head = new ListNode(-1);
      PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((a, b) -> (a.val - b.val));
      
      ListNode dummy = head;
      
      for (ListNode list: lists) {
          if (list != null) {
              minHeap.offer(list);
          }
      }

      while (!minHeap.isEmpty()) {
          ListNode node = minHeap.poll();
          dummy.next = node;
          if (node.next != null) {
              node = node.next;
              minHeap.offer(node);
          }
          dummy = dummy.next;
      }
      
      return head.next;  
  }
}