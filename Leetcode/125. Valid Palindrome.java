class Solution {
  public boolean isPalindrome(String s) {
      if (s == null || s.length() == 0) { return true; }
      int len = s.length();
      int left = 0;
      int right = len - 1;
      
      while (left < right) {
          while (left < right &&
                 !Character.isLetter(s.charAt(left))&&
                 !Character.isDigit(s.charAt(left))) { left++; }
          while (left < right &&
                 !Character.isLetter(s.charAt(right)) &&
                 !Character.isDigit(s.charAt(right))) { right--; }
                 
          if (Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right))) {
              return false;
          }
          left++;
          right--;
      }
      return true;
  }
}