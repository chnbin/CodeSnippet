import java.util.HashMap;

class ListNode {
  public int key;
  public int value;
  public ListNode prev;
  public ListNode next;
  
  public ListNode(int k, int v) {
      key = k;
      value = v;
      prev = null;
      next = null;
  }
}

class LRUCache {
  private int size;
  private HashMap<Integer, ListNode> dict;
  private ListNode head;
  private ListNode tail;

  public LRUCache(int capacity) {
      size = capacity;
      dict = new HashMap<Integer, ListNode>();
      head = new ListNode(0, 0);
      tail = new ListNode(0, 0);
      head.next = tail;
      tail.prev = head;
  }
  
  public int get(int key) {
      if (this.dict.containsKey(key)) {
          ListNode node = this.dict.get(key);
          delete(node);
          add(node);
          return node.value;
      }
      return -1;
  }
  
  public void put(int key, int value) {
      if (this.dict.containsKey(key)) {
          delete(this.dict.get(key));
      }
      
      ListNode node = new ListNode(key, value);
      add(node);
      this.dict.put(key, node);
      
      if (this.dict.size() > this.size) {
          evicts();
      }
  }
  
  private void add(ListNode node) {
      ListNode pNode = this.tail.prev;
      pNode.next = node;
      node.prev = pNode;
      node.next = this.tail;
      this.tail.prev = node;
  }
  
  private void delete(ListNode node) {
      ListNode pNode = node.prev;
      ListNode nNode = node.next;
      pNode.next = nNode;
      nNode.prev = pNode;
  }
  
  private void evicts() {
      ListNode node = this.head.next;
      delete(node);
      this.dict.remove(node.key);
  }
}
