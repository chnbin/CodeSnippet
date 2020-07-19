/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
  if (head === null) { return head; }
  let begin = new ListNode(-1);
  let fast = new ListNode(-1);
  let slow = new ListNode(-1);
  fast = begin;
  slow = begin;
  fast.next = head;
  slow.next = head;
  
  while (n > 0) {
      fast = fast.next;
      n--;
  }
  
  while (fast.next !== null) {
      fast = fast.next;
      slow = slow.next;
  }
  
  slow.next = slow.next.next;
  
  return begin.next;
};
