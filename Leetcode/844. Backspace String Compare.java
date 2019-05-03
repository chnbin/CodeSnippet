class Solution {
  public boolean backspaceCompare(String S, String T) {
      return getBackspaceString(S).equals(getBackspaceString(T));
  }
  
  private String getBackspaceString(String str) {
      String res = "";
      int counter = 0;
      
      for (int i = str.length() - 1; i >= 0; i--) {
          if (str.charAt(i) == '#') {
              counter++;
          } else {
              if (counter == 0) {
                  res += str.charAt(i);
              } else {
                  counter--;
              }
          }
      }
      return res;
  }
}