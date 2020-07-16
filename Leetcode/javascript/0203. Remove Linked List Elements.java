/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} val
 * @return {ListNode}
 */
var removeElements = function(head, val) {
  let dummy = new ListNode(-1);
  dummy.next = head;
  head = dummy;

  while (dummy.next !== null) {
      if (dummy.next.val === val) {
          dummy.next = dummy.next.next;
      } else{
          dummy = dummy.next;
      }
  }
  return head.next;
};