class Solution {
  public int removePalindromeSub(String s) {
      /*
          因為只有a與b
          因此如果是回文，那就是1，因為可以一次砍掉。
          如果不是，那就是2，因為先砍a再砍b就好
      */
      if (s == null || s.length() == 0) { return 0; }
      if (s.length() == 1) { return 1; }
      
      if (isPalindrome(s)) {
          return 1;
      }
      return 2;
  }
  
  private boolean isPalindrome(String s) {
      int left = 0;
      int right = s.length() - 1;
      
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
