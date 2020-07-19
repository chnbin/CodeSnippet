/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
  let begin = new ListNode(-1);
  let head = begin;
  let carry = 0;
  
  while (l1 !== null || l2 !== null) {
      let total = carry;
      
      if (l1) {
          total += l1.val;
          l1 = l1.next;
      }
      
      if (l2) {
          total += l2.val;
          l2 = l2.next;
      }
      let node = new ListNode(total % 10);
      head.next = node;
      head = head.next;
      carry = (total > 9) ? 1 : 0;
  }
  
  if (carry > 0) {
      head.next = new ListNode(1);
  }
  
  return begin.next;
};
