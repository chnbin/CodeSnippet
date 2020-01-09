class Solution {
  public int minimumSwap(String s1, String s2) {
      int res = 0;
      List<Character> same1 = new ArrayList<>();
      List<Character> same2 = new ArrayList<>();
      
      for (int i = 0; i < s1.length(); i++) {
          if (s1.charAt(i) != s2.charAt(i)) {
              same1.add(s1.charAt(i));
              same2.add(s2.charAt(i));
          }
      }
      
      if (same1.size() % 2 == 1) { return -1; }
      
      Collections.sort(same1);
      Collections.sort(same2, (a, b) -> {
          return b.toString().compareTo(a.toString());
      });
      
      for (int i = 1; i < same1.size(); i = i + 2) {
          String str1 = "" + same1.get(i-1) + same1.get(i);
          String str2 = "" + same2.get(i-1) + same2.get(i);
          
          if ((str1.equals("xx") && str2.equals("yy")) ||
              (str1.equals("yy") && str2.equals("xx"))) {
              res += 1;
          } else if ((str1.equals("xy") && str2.equals("yx")) ||
                     (str1.equals("xy") && str2.equals("yx"))) {
              res += 2; 
          }
      }
      
      return res;
  }
}