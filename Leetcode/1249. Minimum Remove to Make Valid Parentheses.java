class Solution {
  public String minRemoveToMakeValid(String s) {
      char[] chrs = s.toCharArray();
      int counter = 0;
      
      for (int i = 0; i < chrs.length; i++) {
          if (chrs[i] == ')') {
              if (counter == 0) {
                  chrs[i] = '-';
              } else {
                  counter--;
              }
          } else if (chrs[i] == '(') {
              counter++;
          }
      }
      
      for (int i = chrs.length - 1; i >= 0; i--) {
          if (counter == 0) { break; }
          if (chrs[i] == '(') {
              chrs[i] = '-';
              counter--;
          }
      }
      
      return new String(chrs).replace("-", "");
  }
}