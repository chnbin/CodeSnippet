class Solution {
  public int compareVersion(String version1, String version2) {
      // v1 = 1.0.1, v2 = 1, 用split切開，建立成list
      // l1 = 1 -> 0 -> 1, size = 3
      // l2 = 1          , size = 1
      // 如果兩個list不等長，我們就把短的list補0，補到等長。
      // l2 = 1 -> 0 -> 0
      // 之後由第一位開始比較
      
      //當用到特殊字元時，如".", "|", "$"，此時要在特殊字元前面加上"\\"，才會得到正確的結果。
      String[] c1 = version1.split("\\.");
      String[] c2 = version2.split("\\.");
      List<Integer> l1 = createListByCharArray(c1);
      List<Integer> l2 = createListByCharArray(c2);
      
      int m = l1.size();
      int n = l2.size();

      if (m > n) {
          for (int i = m - n; i > 0; i--) {
              l2.add(0);
          }
      }
      
      if (n > m) {
          for (int i = n - m; i > 0; i--) {
              l1.add(0);
          }
      }
      
      for (int i = 0; i < l1.size(); i++) {
          if (l1.get(i) > l2.get(i)) { return 1; }
          if (l1.get(i) < l2.get(i)) { return -1; }
      }
      return 0;
  }
  
  private List<Integer> createListByCharArray(String[] strs) {
      List<Integer> list = new ArrayList<>();
      
      for (String str: strs) {
          list.add(Integer.parseInt(str));
      }
      return list;
  }
}