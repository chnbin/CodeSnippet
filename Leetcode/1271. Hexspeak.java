class Solution {
  private String[] table = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
  public String toHexspeak(String num) {
      long number = 0;
      
      for (int i = 0; i < num.length(); i++) {
          number *= 10;
          number += (num.charAt(i) - '0');
      }
      
      String hex = "";
      
      while (number > 0) {
          hex = table[(int)(number % 16)] + hex;
          number /= 16;
      }
      
      StringBuilder sb = new StringBuilder();
      
      for (int i = 0; i < hex.length(); i++) {
          char c = hex.charAt(i);
          
          if (c == '0') {
              sb.append("O");
          } else if (c == '1') {
              sb.append("I");
          } else if ("ABCDEF".contains("" + c)) {
              sb.append(c);
          } else {
              return "ERROR";
          }
      }
      
      return sb.toString();
  }
}