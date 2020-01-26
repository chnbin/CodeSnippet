class Solution {
  public String breakPalindrome(String palindrome) {
      if (palindrome == null || palindrome.length() == 0 || palindrome.length() == 1) {
          return "";
      }
      
      String res = "";
      List<String> ans = new ArrayList<>();
      int left = 0;
      int right = palindrome.length() - 1;
      
      while (left < right) {
          char lChar = palindrome.charAt(left);
          char rChar = palindrome.charAt(right);
          ans.add(palindrome.substring(0, left) + (char)(((int)lChar -'a' - 1 + 26) % 26 + 'a') + palindrome.substring(left +1));
          ans.add(palindrome.substring(0, left) + (char)(((int)lChar -'a' + 1 + 26) % 26 + 'a') + palindrome.substring(left +1));

          ans.add(palindrome.substring(0, right) + (char)(((int)rChar -'a' - 1 + 26) % 26 + 'a') + palindrome.substring(right +1));
          ans.add(palindrome.substring(0, right) + (char)(((int)rChar -'a' + 1 + 26) % 26 + 'a') + palindrome.substring(right +1));
          if (lChar != 'a' && rChar != 'a') {
              ans.add(palindrome.substring(0, left) + 'a' + palindrome.substring(left +1));
              ans.add(palindrome.substring(0, right) + 'a' + palindrome.substring(right +1));
          }
          
          left++;
          right--;
      }
      
      Collections.sort(ans);
      
      return ans.get(0);
  }

}