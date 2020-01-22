class Solution {
  public boolean validPalindrome(String s) {
      /*
        這題允許刪除一個字符，那麼當遇到不匹配的時候，我們到底是刪除左邊的字元，還是右邊的字元呢？
        兩種情況都要算一遍，只要有一種能返回true，那麼結果就返回true。
        以abbca為例：
        abbca
         ^ ^
         1 3 
        當left = 1，right = 3時兩邊不等，
        我們可以把b砍掉也就是left + 1, right，=> bc
                c砍掉     left, right - 1，=> bb
      */
      int left = 0;
      int right = s.length() - 1;
      
      while (left < right) {
          if (s.charAt(left) != s.charAt(right)) {
              return isValid(s, left + 1, right) || isValid(s, left, right - 1);
          }
          left++;
          right--;
      }
      return true;
  }
  
  private boolean isValid(String s, int left, int right) {
      while (left < right) {
          if (s.charAt(left) != s.charAt(right)) {
              return false;
          }
          left++;
          right--;
      }
      
      return true;
  }
}