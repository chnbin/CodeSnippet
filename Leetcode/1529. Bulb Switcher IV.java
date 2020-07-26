class Solution {
  public int minFlips(String target) {
      char curr = '0';
      int res = 0;
      
      for (int i = 0; i < target.length(); i++) {
          if (target.charAt(i) != curr) {
              res++;
              curr = curr == '0' ? '1' : '0'; 
          }
      }
      
      return res;
  }
}
