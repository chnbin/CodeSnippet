class Solution {
  public int[] sumZero(int n) {
      int[] res = new int[n];
      List<Integer> list = new ArrayList<>();
      int len = (n % 2 == 0) ? n / 2 :  (n/2) + 1;
      for (int i = 0; i < (n/2) + 1; i++) {
          if (i == 0) {
              if (n % 2 != 0) {
                  list.add(i);
              } else {
                  list.add(-(n/2));
              }
              
          } else {
              list.add(i);
              list.add(-i);
          }
      }
      
      for (int i = 0; i < n; i++) {
          res[i] = list.get(i);
      }
      
      return res;
  }
}