/*
  30 day leetcoding challenge
  Day 28. First Unique Number
  https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3313/
 */

  class FirstUnique {
    
    private class DLinkedList {
        public ListNode head;
        public ListNode tail;
        
        public DLinkedList() {
            head = new ListNode(-1);
            tail = new ListNode(-1);
            head.next = tail;
            tail.prev = head;
        }
        
        public ListNode getFirstUnique() {
            // System.out.println("getFirstUnique");
            return head.next;
        }
        
        public boolean isEmpty() {
            // System.out.println("isEmpty");
            return head.next == tail;
        }
        
        public void remove(ListNode node) {
            // System.out.println("remove");
            ListNode p = node.prev;
            ListNode n = node.next;
            p.next = n;
            n.prev = p;
        }
        
        public ListNode append(int value) {
            // System.out.println("append");
            ListNode node = new ListNode(value);
            ListNode prev = tail.prev;
            prev.next = node;
            node.next = tail;
            tail.prev = node;
            node.prev = prev;
            return node;
        }
    }
    
    private DLinkedList list;
    private Map<Integer, ListNode> map;
    
    public FirstUnique(int[] nums) {
        list = new DLinkedList();
        map = new HashMap<>();
        
        for (int num: nums) {
            add(num);
        }
    }
    
    public int showFirstUnique() {
        if (list.isEmpty()) { return -1; }
        return list.getFirstUnique().value;
    }
    
    public void add(int value) {
        if (map.containsKey(value)) {
            if (map.get(value) != null) {
                list.remove(map.get(value));
                map.put(value, null);
            }
        } else {
            ListNode node = list.append(value);
            map.put(value, node);
        }
    }
}


public class ListNode {
    public ListNode next;
    public ListNode prev;
    public int value;
    
    public ListNode(int val) {
        value = val;
        next = null;
        prev = null;
    }
}
/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
