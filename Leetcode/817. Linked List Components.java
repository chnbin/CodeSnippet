class Solution {
  public int numComponents(ListNode head, int[] G) {
      Set<Integer> set = new HashSet<>();
      int res = 0;
      int cnt = 0;
      
      for (int g: G) { set.add(g); }
      
      while (head != null) {
          if (set.contains(head.val)) {
              cnt++;
              if (cnt == 1) {
                  res++;
              }
          } else {
              cnt = 0;
          }
          
          head = head.next;
      }
      
      return res;
  }
}