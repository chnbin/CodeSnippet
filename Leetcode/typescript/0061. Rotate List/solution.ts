/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function rotateRight(head: ListNode | null, k: number): ListNode | null {
    if (head === null) { return head; }
    let node = new ListNode(-1);
    let fast = new ListNode(-1);
    let slow = new ListNode(-1);
    node.next = head;
    fast.next = head;
    slow.next = head;
    
    let n: number = 0;
    
    while (node.next) {
        node = node.next;
        n++;
    }
    
    k %= n;
    
    if (k === 0) { return head; }
    
    while (k > 0 && fast.next) {
        if (fast)
        fast = fast.next;
        k--;
    }
    
    while (fast.next && slow.next) {
        fast = fast.next;
        slow = slow.next;
    }
    
    fast.next = head;
    head = slow.next;
    slow.next = null;
    
    return head;
};


