class Solution {
  public int[] sortByBits(int[] arr) {
      // Time complexity: O(Nlog(N)) where N is the length of arr.
      // Space complexity: O(N) where N is the length of arr.
      List<Integer> list = new ArrayList<>();
      int[] res = new int[arr.length];
      
      for (int num: arr) {
          list.add(num);
      }
      
      Collections.sort(list, (a, b) -> {
          int cnt1 = countbits(a);
          int cnt2 = countbits(b);
          
          if (cnt1 == cnt2) {
              return a - b;
          }
          return cnt1 - cnt2;
      });
      
      for (int i = 0; i < list.size(); i++) {
          res[i] = list.get(i);
      }
      
      return res;
  }
  
  private int countbits(int num) {
      int cnt = 0;
      
      while (num > 0) {
          cnt += (num & 1);
          num = num >>> 1;
      }
      
      return cnt;
  }
}
