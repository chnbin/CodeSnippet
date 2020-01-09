class Solution {
  public int minimumSwap(String s1, String s2) {
      /*
        基本上，以xxyyxyxyxx與xyyxyxxxyx為例：
        xxyyxyxyxx
        xyyxyxxxyx
         ^ ^^^ ^^
        其實仔細分析比較一下，就會發現，已經對好的部分其實是可以不用管他。
        要管的部分其實就是：
        Xyxyyx
        Yxyxxy
        值得注意的是，如果不同的數量只有奇數組，這是沒有答案的。
        而要交換的pattern，其實題目的範例已經為我們準備好。
        xx yy -> 一次
        Xy yx -> 二次
        因此就是要把
        Xyxyyx
        Yxyxxy 變成xx yy這種組合最多的方式，才會得到最小。
        一開始在這邊想了很久，但是之後發現，其實不管怎樣，上面的xy與下面的xy一定是相同個數，
        因此此上面字串由小到大排序，下面的字串由大到小排：
        Xxxyyy
        Yyyxxx
        就會達到我們要的目的。
      */
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