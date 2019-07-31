class Solution {
  /**
   * 1. + / -
   * 2. not valid number
   * 3. 144axv -> 144
   * 4. Overflow
   */
  public int myAtoi(String str) {
      str = str.trim();
      if (str == null || str.length() == 0) {
          return 0;
      }
      
      char firstChar = str.charAt(0);
      int sign = 1;
      int start = 0;
      long res = 0;
      
      // + or -?
      if (firstChar == '+') {
          start++;
      } else if (firstChar == '-'){
          sign = -1;
          start++;
      }
      
      for (int i = start; i < str.length(); i++) {
          char c = str.charAt(i);
          
          if (!Character.isDigit(c)) {
              return (int)res * sign;
          } else {
              res = res * 10;
              res += (c - '0');
              // Overflow ???
              if (res > Integer.MAX_VALUE) {
                  if (sign > 0) {
                      return Integer.MAX_VALUE;
                  } else {
                      return Integer.MIN_VALUE;
                  }
              }
          }
      }
      
      return (int)res * sign;
  }
}