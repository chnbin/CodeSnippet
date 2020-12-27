class Solution {
  public boolean halvesAreAlike(String s) {
      int n = s.length();
      int vCnt1 = 0;
      int vCnt2 = 0;
      
      for (int i = 0; i < (n / 2); i++) {
          vCnt1 += isVowel(s.charAt(i));
          vCnt2 += isVowel(s.charAt((i + (n / 2))));
      }
      
      return vCnt1 == vCnt2;
  }
  
  private int isVowel(char c) {
      String s = "aeiouAEIOU";
      if (s.indexOf(c) != -1) {
          return 1;
      }
      return 0;
  }
}
